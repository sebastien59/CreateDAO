/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "INFORMATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Information.findAll", query = "SELECT i FROM Information i"),
    @NamedQuery(name = "Information.findById", query = "SELECT i FROM Information i WHERE i.id = :id"),
    @NamedQuery(name = "Information.findByDateparution", query = "SELECT i FROM Information i WHERE i.dateparution = :dateparution"),
    @NamedQuery(name = "Information.findByTitre", query = "SELECT i FROM Information i WHERE i.titre = :titre"),
    @NamedQuery(name = "Information.findByNbvues", query = "SELECT i FROM Information i WHERE i.nbvues = :nbvues"),
    @NamedQuery(name = "Information.findByInfotype", query = "SELECT i FROM Information i WHERE i.infotype = :infotype")})
public class Information implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEPARUTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateparution;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TITRE")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NBVUES")
    private int nbvues;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INFOTYPE")
    private int infotype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ninfo")
    private Collection<Paragraphe> paragrapheCollection;
    @JoinColumn(name = "NAUTEUR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Auteur nauteur;
    @JoinColumn(name = "NCATEGORIE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categorie ncategorie;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "information")
    private Infosecondaire infosecondaire;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "information")
    private Infoprincipale infoprincipale;

    public Information() {
    }

    public Information(Integer id) {
        this.id = id;
    }

    public Information(Integer id, Date dateparution, String titre, int nbvues, int infotype) {
        this.id = id;
        this.dateparution = dateparution;
        this.titre = titre;
        this.nbvues = nbvues;
        this.infotype = infotype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateparution() {
        return dateparution;
    }

    public void setDateparution(Date dateparution) {
        this.dateparution = dateparution;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbvues() {
        return nbvues;
    }

    public void setNbvues(int nbvues) {
        this.nbvues = nbvues;
    }

    public int getInfotype() {
        return infotype;
    }

    public void setInfotype(int infotype) {
        this.infotype = infotype;
    }

    @XmlTransient
    public Collection<Paragraphe> getParagrapheCollection() {
        return paragrapheCollection;
    }

    public void setParagrapheCollection(Collection<Paragraphe> paragrapheCollection) {
        this.paragrapheCollection = paragrapheCollection;
    }

    public Auteur getNauteur() {
        return nauteur;
    }

    public void setNauteur(Auteur nauteur) {
        this.nauteur = nauteur;
    }

    public Categorie getNcategorie() {
        return ncategorie;
    }

    public void setNcategorie(Categorie ncategorie) {
        this.ncategorie = ncategorie;
    }

    public Infosecondaire getInfosecondaire() {
        return infosecondaire;
    }

    public void setInfosecondaire(Infosecondaire infosecondaire) {
        this.infosecondaire = infosecondaire;
    }

    public Infoprincipale getInfoprincipale() {
        return infoprincipale;
    }

    public void setInfoprincipale(Infoprincipale infoprincipale) {
        this.infoprincipale = infoprincipale;
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
        if (!(object instanceof Information)) {
            return false;
        }
        Information other = (Information) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Information[ id=" + id + " ]";
    }
    
}
