package com.Booking_seystem.Booking_seystem.service;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.Paiement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public abstract class GestionPaiement implements IGestionPaiement{
    EntityManager em;

    public GestionPaiement() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_Reservation");
        em = emf.createEntityManager();
    }

    public void ajouterPaiement(Paiement paiement) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(paiement);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void modifierPaiement(int idPaiement, Paiement nouveauPaiement) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Paiement paiementAModifier = em.find(Paiement.class, idPaiement);
            if (paiementAModifier != null) {
                paiementAModifier.setMontant(nouveauPaiement.getMontant());
                paiementAModifier.setDate_paiement(nouveauPaiement.getDate_paiement());
                paiementAModifier.setStatut(nouveauPaiement.getStatut());
                em.merge(paiementAModifier);
                tr.commit();
            } else {
                System.out.println("Le paiement avec l'ID " + idPaiement + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void supprimerPaiement(int idPaiement) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Paiement paiementASupprimer = em.find(Paiement.class, idPaiement);
            if (paiementASupprimer != null) {
                em.remove(paiementASupprimer);
                tr.commit();
            } else {
                System.out.println("Le paiement avec l'ID " + idPaiement + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public Paiement chercherParId(int idPaiement) {
        try {
            return em.find(Paiement.class, idPaiement);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Paiement> lister() {
        try {
            Query query = em.createQuery("SELECT p FROM Paiement p");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
