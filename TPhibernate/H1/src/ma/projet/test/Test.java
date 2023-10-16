/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import org.hibernate.Hibernate;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author ACER
 */
public class Test {
     public static void main(String[] args) {
         ProduitService ps = new ProduitService();
         /*ps.create(new Produit("Ad","A1",new Date(2023-10-12),20.5,"des"));
         ps.create(new Produit("Nk","N1",new Date(2023-10-30),55,"des2"));
         ps.create(new Produit("PP","P1",new Date(2023-05-12),32.5,"des3"));
         ps.create(new Produit("BC","B1",new Date(2022-11-10),205,"des4"));
         ps.create(new Produit("CODM","M1",new Date(1962-10-12),2,"des5"));*/
         ps.create(new Produit("KCM","MKSH",new Date(2021/02/12),2,"des5"));
         for(Produit p : ps.findAll())
            System.out.println(p.toString());
         //System.out.println(ps.findById(3).toString());
         //ps.delete(ps.findById(3));
         Produit p1 = ps.findById(1);
         p1.setMarque("KAPPA");
         ps.update(p1);
         for(Produit p : ps.findAll())
             if(p.getPrix()>100)
            System.out.println(p.toString());
         for (Produit p : ps.findAll()) {
                if (p.getDateAchat().after(new Date(2022-01-01)) && p.getDateAchat().before(new Date(2024-01-24))) {
                    System.out.println(p.toString());
                }
         
     }
     }
}
    

