/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "femme")

public class Femme extends Personne {

    public Femme() {
    }
    

    public Femme(String nom, String prenom, Date dateDeNaissance) {
        super(nom, prenom, dateDeNaissance);
    }
    public String toString() {
        return "Femme{" + "id=" + getId() + ", nom=" + getNom() + ", prenom=" + getPrenom() + ", dateDeNaissance=" + getDateDeNaissance() + '}';
    
    
    }
    
}
