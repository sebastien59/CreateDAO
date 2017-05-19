/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "AUTEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auteur.findAll", query = "SELECT a FROM Auteur a"),
    @NamedQuery(name = "Auteur.findById", query = "SELECT a FROM Auteur a WHERE a.id = :id"),
    @NamedQuery(name = "Auteur.findByNom", query = "SELECT a FROM Auteur a WHERE a.nom = :nom"),
    @NamedQuery(name = "Auteur.findByPrenom", query = "SELECT a FROM Auteur a WHERE a.prenom = :prenom"),
    @NamedQuery(name = "Auteur.findByPseudo", query = "SELECT a FROM Auteur a WHERE a.pseudo = :pseudo"),
    @NamedQuery(name = "Auteur.findByEmail", query = "SELECT a FROM Auteur a WHERE a.email = :email")})
public class Auteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 25)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 25)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PSEUDO")
    private String pseudo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nauteur")
    private Collection<Information> informationCollection;

    public Auteur() {
    }

    public Auteur(Integer id) {
        this.id = id;
    }

    public Auteur(Integer id, String pseudo, String email) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Information> getInformationCollection() {
        return informationCollection;
    }

    public void setInformationCollection(Collection<Information> informationCollection) {
        this.informationCollection = informationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Auteur[ id=" + id + " ]";
    }
    
}
