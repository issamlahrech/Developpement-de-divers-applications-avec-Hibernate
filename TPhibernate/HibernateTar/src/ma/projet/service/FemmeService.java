/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ma.projet.beans.Femme;
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
public class FemmeService implements IDao<Femme> {

    

    @Override
    public boolean create(Femme o) {
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
    public List<Femme> getAll() {
        List <Femme> femmes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.createQuery("from Femme ").list();
            tx.commit();
            return femmes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return femmes;
        } finally {
            if(session != null)
                session.close();
        }
    }
    @Override
    public Femme getById(int id) {
       Femme femme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femme = (Femme) session.get(Femme.class, id);
            tx.commit();
            return femme;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return femme;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public Femme getFemmeLaPlusAgee() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Femme ORDER BY dateDeNaissance ASC";
            Query query = session.createQuery(hql);
            query.setMaxResults(1); // Pour obtenir la première femme (la plus âgée) de la liste
            return (Femme) query.uniqueResult();
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
    



    


