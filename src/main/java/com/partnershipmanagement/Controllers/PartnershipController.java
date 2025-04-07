package com.partnershipmanagement.Controllers;

import com.partnershipmanagement.Entities.Partnership;
import com.partnershipmanagement.Repositories.PartnershipRepository;
import com.partnershipmanagement.Services.PartnershipService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partnerships")
public class PartnershipController {

    @Autowired
    private PartnershipRepository partnershipRepository;
    @Autowired
    private PartnershipService partnershipService;

    @GetMapping("/all")
    public List<Partnership> getAllPartnerships() {
        return partnershipRepository.findAll();
    }

    @PostMapping("/applyForPartnership")
    public Partnership applyForPartnership(@RequestParam int entrepriseId, @RequestParam int proposalId) {
        return partnershipService.applyForPartnership(entrepriseId, proposalId);
    }
    @PostMapping("/accept/{partnershipId}/{entrepriseId}")
    public String acceptPartnership(@PathVariable int partnershipId, @PathVariable int entrepriseId) {
        partnershipService.acceptPartnership(partnershipId, entrepriseId);
        return "Partnership accepted successfully.";
    }
    @GetMapping("/partnerships/{id}/pdf")
    public ResponseEntity<?> generatePartnershipPdf(@PathVariable int id) {
        try {
            Partnership partnership = partnershipService.getPartnershipById(id);
            byte[] pdfBytes = partnershipService.generatePdfForPartnership(partnership);

            ByteArrayResource resource = new ByteArrayResource(pdfBytes);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=partnership_" + id + ".pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .contentLength(pdfBytes.length)
                    .body(resource);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Partnership not found");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to generate PDF: " + e.getMessage());
        }
    }
}