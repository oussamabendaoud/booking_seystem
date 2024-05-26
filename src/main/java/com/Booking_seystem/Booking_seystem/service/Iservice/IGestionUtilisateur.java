package com.Booking_seystem.Booking_seystem.service.Iservice;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.entities.Utilisateur;

public interface IGestionUtilisateur {
    void ajouterUtilisateur(Utilisateur utilisateur);
    void modifierUtilisateur(int idUtilisateur, Utilisateur nouveauUtilisateur);
    void supprimerUtilisateur(int idUtilisateur);
    Utilisateur chercherParId(int idUtilisateur);
    List<Utilisateur> lister();
}
