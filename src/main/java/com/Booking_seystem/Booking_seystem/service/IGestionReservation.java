package com.Booking_seystem.Booking_seystem.service;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.Reservation;

public interface IGestionReservation {
    void ajouterReservation(Reservation reservation);
    void modifierReservation(int idReservation, Reservation nouvelleReservation);
    void supprimerReservation(int idReservation);
    Reservation chercherParId(int idReservation);
    List<Reservation> lister();
}
