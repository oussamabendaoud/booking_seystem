package com.Booking_seystem.Booking_seystem.service;


import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.ConfirmationRappel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public abstract class GestionConfirmationRappel implements IGestionConfirmationRappel{
    EntityManager em;

    public GestionConfirmationRappel() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_Reservation");
        em = emf.createEntityManager();
    }

    public void ajouterConfirmationRappel(ConfirmationRappel confirmationRappel) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(confirmationRappel);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void modifierConfirmationRappel(int idConfirmationRappel, ConfirmationRappel nouvelleConfirmationRappel) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            ConfirmationRappel confirmationRappelAModifier = em.find(ConfirmationRappel.class, idConfirmationRappel);
            if (confirmationRappelAModifier != null) {
                confirmationRappelAModifier.setType(nouvelleConfirmationRappel.getType());
                confirmationRappelAModifier.setDate_envoi(nouvelleConfirmationRappel.getDate_envoi());
                confirmationRappelAModifier.setStatut(nouvelleConfirmationRappel.getStatut());
                em.merge(confirmationRappelAModifier);
                tr.commit();
            } else {
                System.out.println("La confirmation/rappel avec l'ID " + idConfirmationRappel + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void supprimerConfirmationRappel(int idConfirmationRappel) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            ConfirmationRappel confirmationRappelASupprimer = em.find(ConfirmationRappel.class, idConfirmationRappel);
            if (confirmationRappelASupprimer != null) {
                em.remove(confirmationRappelASupprimer);
                tr.commit();
            } else {
                System.out.println("La confirmation/rappel avec l'ID " + idConfirmationRappel + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public ConfirmationRappel chercherParId(int idConfirmationRappel) {
        try {
            return em.find(ConfirmationRappel.class, idConfirmationRappel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ConfirmationRappel> lister() {
        try {
            Query query = em.createQuery("SELECT cr FROM ConfirmationRappel cr");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
