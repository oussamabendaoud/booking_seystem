package com.Booking_seystem.Booking_seystem.service.Iservice;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.entities.Disponibilite;

public interface IGestionDisponibilite {
    void ajouterDisponibilite(Disponibilite disponibilite);
    void modifierDisponibilite(int idDisponibilite, Disponibilite nouvelleDisponibilite);
    void supprimerDisponibilite(int idDisponibilite);
    Disponibilite chercherParId(int idDisponibilite);
    List<Disponibilite> lister();
}
