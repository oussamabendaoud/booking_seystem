package com.Booking_seystem.Booking_seystem.service.Iservice;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.entities.ConfirmationRappel;

public interface IGestionConfirmationRappel {
    void ajouterConfirmationRappel(ConfirmationRappel confirmationRappel);
    void modifierConfirmationRappel(int idConfirmationRappel, ConfirmationRappel nouvelleConfirmationRappel);
    void supprimerConfirmationRappel(int idConfirmationRappel);
    ConfirmationRappel chercherParId(int idConfirmationRappel);
    List<ConfirmationRappel> lister();
}
