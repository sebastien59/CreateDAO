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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "INFOPRINCIPALE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infoprincipale.findAll", query = "SELECT i FROM Infoprincipale i"),
    @NamedQuery(name = "Infoprincipale.findById", query = "SELECT i FROM Infoprincipale i WHERE i.id = :id"),
    @NamedQuery(name = "Infoprincipale.findByResume", query = "SELECT i FROM Infoprincipale i WHERE i.resume = :resume")})
public class Infoprincipale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "RESUME")
    private String resume;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Information information;

    public Infoprincipale() {
    }

    public Infoprincipale(Integer id) {
        this.id = id;
    }

    public Infoprincipale(Integer id, String resume) {
        this.id = id;
        this.resume = resume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
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
        if (!(object instanceof Infoprincipale)) {
            return false;
        }
        Infoprincipale other = (Infoprincipale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Infoprincipale[ id=" + id + " ]";
    }
    
}
