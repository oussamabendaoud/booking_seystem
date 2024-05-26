package com.Booking_seystem.Booking_seystem.service.Iservice;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.entities.Reservation;

public interface IGestionReservation {
    void ajouterReservation(Reservation reservation);
    void modifierReservation(int idReservation, Reservation nouvelleReservation);
    void supprimerReservation(int idReservation);
    Reservation chercherParId(int idReservation);
    List<Reservation> lister();
}
