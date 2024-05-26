package com.Booking_seystem.Booking_seystem.service.Iservice;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.entities.Reservation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public abstract class GestionReservation implements IGestionReservation {
    EntityManager em;

    public GestionReservation() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_Reservation");
        em = emf.createEntityManager();
    }

    public void ajouterReservation(Reservation reservation) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(reservation);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void modifierReservation(int idReservation, Reservation nouvelleReservation) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Reservation reservationAModifier = em.find(Reservation.class, idReservation);
            if (reservationAModifier != null) {
                reservationAModifier.setDate_reservation(nouvelleReservation.getDate_reservation());
                reservationAModifier.setEtat(nouvelleReservation.getEtat());
                em.merge(reservationAModifier);
                tr.commit();
            } else {
                System.out.println("La réservation avec l'ID " + idReservation + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void supprimerReservation(int idReservation) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Reservation reservationASupprimer = em.find(Reservation.class, idReservation);
            if (reservationASupprimer != null) {
                em.remove(reservationASupprimer);
                tr.commit();
            } else {
                System.out.println("La réservation avec l'ID " + idReservation + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public Reservation chercherParId(int idReservation) {
        try {
            return em.find(Reservation.class, idReservation);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Reservation> lister() {
        try {
            Query query = em.createQuery("SELECT r FROM Reservation r");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
