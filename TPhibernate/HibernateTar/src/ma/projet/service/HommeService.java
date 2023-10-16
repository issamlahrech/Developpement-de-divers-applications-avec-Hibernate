/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author ACER
 */
public class HommeService implements IDao<Homme>{
    @Override
    public boolean create(Homme o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit(); 
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return false;
        }finally{
            if(session != null)
                session.close();
        }
    }

    @Override
    public List<Homme> getAll() {
        List <Homme> hommes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            hommes = session.createQuery("from Homme ").list();
            tx.commit();
            return hommes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return hommes;
        } finally {
            if(session != null)
                session.close();
        }
    }
    @Override
    public Homme getById(int id) {
       Homme homme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            homme = (Homme) session.get(Homme.class, id);
            tx.commit();
            return homme;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return homme;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    

   

   public List<Femme> getEpousesEntreDates(Homme homme, Date dateDebut, Date dateFin) {
        Session session = null;
        List<Femme> epouses = new ArrayList<Femme>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String hql = "SELECT f FROM Femme f " +
                         "WHERE f.homme = :homme " +
                         "AND f.dateDebut >= :dateDebut " +
                         "AND f.dateDebut <= :dateFin";

            Query query = session.createQuery(hql)
                .setParameter("homme", homme)
                .setParameter("dateDebut", dateDebut)
                .setParameter("dateFin", dateFin);

            epouses = query.list();

        } catch (HibernateException ex) {
            // Gérer les exceptions si nécessaire
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return epouses;
    }
}






  

  
