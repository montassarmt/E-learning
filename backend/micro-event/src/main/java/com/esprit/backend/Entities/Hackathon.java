package com.esprit.backend.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Hackathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom; // ✅ Nouveau champ pour le titre du hackathon
    private String theme;
    private String description;
    private LocalDateTime dateDebut; // ✅ Ajout de la date de début
    private LocalDateTime dateFin;// ✅ Ajout de la date de fin
    private String googleCalendarEventId;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String probleme;
    // énoncé ou sujet
    @OneToMany(mappedBy = "hackathon", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Participation> participations;


    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }

    public Hackathon() {
    }

    public Hackathon(String nom, String theme, String description, LocalDateTime dateDebut, LocalDateTime dateFin, String googleCalendarEventId) {
        this.nom = nom;
        this.theme = theme;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.googleCalendarEventId = googleCalendarEventId;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public String getGoogleCalendarEventId() {
        return googleCalendarEventId;
    }

    public void setGoogleCalendarEventId(String googleCalendarEventId) {
        this.googleCalendarEventId = googleCalendarEventId;
    }
}
