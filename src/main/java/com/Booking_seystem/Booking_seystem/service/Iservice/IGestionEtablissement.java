package com.Booking_seystem.Booking_seystem.service.Iservice;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.entities.Etablissement;

public interface IGestionEtablissement {
    void ajouterEtablissement(Etablissement etablissement);
    void modifierEtablissement(int idEtablissement, Etablissement nouveauEtablissement);
    void supprimerEtablissement(int idEtablissement);
    Etablissement chercherParId(int idEtablissement);
    List<Etablissement> lister();
}
