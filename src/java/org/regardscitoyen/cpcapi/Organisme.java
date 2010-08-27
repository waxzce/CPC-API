/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.regardscitoyen.cpcapi;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author waxzce
 */
@Entity
@Table(name = "organisme")
@NamedQueries({
    @NamedQuery(name = "Organisme.findAll", query = "SELECT o FROM Organisme o"),
    @NamedQuery(name = "Organisme.findById", query = "SELECT o FROM Organisme o WHERE o.id = :id"),
    @NamedQuery(name = "Organisme.findByNom", query = "SELECT o FROM Organisme o WHERE o.nom = :nom"),
    @NamedQuery(name = "Organisme.findByType", query = "SELECT o FROM Organisme o WHERE o.type = :type"),
    @NamedQuery(name = "Organisme.findByCreatedAt", query = "SELECT o FROM Organisme o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "Organisme.findByUpdatedAt", query = "SELECT o FROM Organisme o WHERE o.updatedAt = :updatedAt"),
    @NamedQuery(name = "Organisme.findBySlug", query = "SELECT o FROM Organisme o WHERE o.slug = :slug")})
public class Organisme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "type")
    private String type;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "slug")
    private String slug;

    public Organisme() {
    }

    public Organisme(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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
        if (!(object instanceof Organisme)) {
            return false;
        }
        Organisme other = (Organisme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.Organisme[id=" + id + "]";
    }

}
