package com.Booking_seystem.Booking_seystem.service.Iservice;

import java.util.List;

import com.Booking_seystem.Booking_seystem.dao.entities.Etablissement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public abstract class GestionEtablissement implements IGestionEtablissement{
    EntityManager em;

    public GestionEtablissement() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_Reservation");
        em = emf.createEntityManager();
    }

    public void ajouterEtablissement(Etablissement etablissement) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(etablissement);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void modifierEtablissement(int idEtablissement, Etablissement nouveauEtablissement) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Etablissement etablissementAModifier = em.find(Etablissement.class, idEtablissement);
            if (etablissementAModifier != null) {
                etablissementAModifier.setNom(nouveauEtablissement.getNom());
                etablissementAModifier.setType(nouveauEtablissement.getType());
                etablissementAModifier.setAdresse(nouveauEtablissement.getAdresse());
                etablissementAModifier.setDescription(nouveauEtablissement.getDescription());
                etablissementAModifier.setContact(nouveauEtablissement.getContact());
                etablissementAModifier.setAutres_informations(nouveauEtablissement.getAutres_informations());
                em.merge(etablissementAModifier);
                tr.commit();
            } else {
                System.out.println("L'établissement avec l'ID " + idEtablissement + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void supprimerEtablissement(int idEtablissement) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Etablissement etablissementASupprimer = em.find(Etablissement.class, idEtablissement);
            if (etablissementASupprimer != null) {
                em.remove(etablissementASupprimer);
                tr.commit();
            } else {
                System.out.println("L'établissement avec l'ID " + idEtablissement + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public Etablissement chercherParId(int idEtablissement) {
        try {
            return em.find(Etablissement.class, idEtablissement);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Etablissement> lister() {
        try {
            Query query = em.createQuery("SELECT e FROM Etablissement e");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
