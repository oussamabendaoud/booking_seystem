package com.Booking_seystem.Booking_seystem.service;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.Paiement;

public interface IGestionPaiement {
    void ajouterPaiement(Paiement paiement);
    void modifierPaiement(int idPaiement, Paiement nouveauPaiement);
    void supprimerPaiement(int idPaiement);
    Paiement chercherParId(int idPaiement);
    List<Paiement> lister();
}
