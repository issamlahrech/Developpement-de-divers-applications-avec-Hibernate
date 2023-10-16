/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "homme")
public class Homme extends Personne {

    public Homme() {
    }

    public Homme(String nom, String prenom, Date dateDeNaissance) {
        super(nom, prenom, dateDeNaissance);
    }
    
    @Override
    public String toString() {
        return "Homme{" + "id=" + getId() + ", nom=" + getNom() + ", prenom=" + getPrenom() + ", dateDeNaissance=" + getDateDeNaissance() + '}';
    
}
}
