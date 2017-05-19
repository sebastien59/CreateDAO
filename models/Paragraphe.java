/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "PARAGRAPHE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paragraphe.findAll", query = "SELECT p FROM Paragraphe p"),
    @NamedQuery(name = "Paragraphe.findById", query = "SELECT p FROM Paragraphe p WHERE p.id = :id"),
    @NamedQuery(name = "Paragraphe.findByTitre", query = "SELECT p FROM Paragraphe p WHERE p.titre = :titre"),
    @NamedQuery(name = "Paragraphe.findByTexte", query = "SELECT p FROM Paragraphe p WHERE p.texte = :texte")})
public class Paragraphe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "TITRE")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "TEXTE")
    private String texte;
    @JoinColumn(name = "NINFO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Information ninfo;

    public Paragraphe() {
    }

    public Paragraphe(Integer id) {
        this.id = id;
    }

    public Paragraphe(Integer id, String texte) {
        this.id = id;
        this.texte = texte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Information getNinfo() {
        return ninfo;
    }

    public void setNinfo(Information ninfo) {
        this.ninfo = ninfo;
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
        if (!(object instanceof Paragraphe)) {
            return false;
        }
        Paragraphe other = (Paragraphe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Paragraphe[ id=" + id + " ]";
    }
    
}
