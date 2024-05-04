package com.Booking_seystem.Booking_seystem.service;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.Disponibilite;

public interface IGestionDisponibilite {
    void ajouterDisponibilite(Disponibilite disponibilite);
    void modifierDisponibilite(int idDisponibilite, Disponibilite nouvelleDisponibilite);
    void supprimerDisponibilite(int idDisponibilite);
    Disponibilite chercherParId(int idDisponibilite);
    List<Disponibilite> lister();
}
