package com.partnershipmanagement.Repositories;

import com.partnershipmanagement.Entities.Partnership;
import com.partnershipmanagement.Entities.PartnershipStatus;
import com.partnershipmanagement.Entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PartnershipRepository extends JpaRepository<Partnership, Integer> {
   // List<Partnership> findByEndDateAfter(Date currentDate); // Find partnerships with endDate > currentDate
   // List<Partnership> findByEndDateBefore(Date currentDate); // Find partnerships with endDate < currentDate
   boolean existsByProposalIdProposalAndPartnershipStatus(int idProposal, PartnershipStatus status);
   List<Partnership> findByProposal(Proposal proposal);

}