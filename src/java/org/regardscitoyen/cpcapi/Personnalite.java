/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.regardscitoyen.cpcapi;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "personnalite")
@NamedQueries({
    @NamedQuery(name = "Personnalite.findAll", query = "SELECT p FROM Personnalite p"),
    @NamedQuery(name = "Personnalite.findById", query = "SELECT p FROM Personnalite p WHERE p.id = :id"),
    @NamedQuery(name = "Personnalite.findByNbCommentaires", query = "SELECT p FROM Personnalite p WHERE p.nbCommentaires = :nbCommentaires"),
    @NamedQuery(name = "Personnalite.findByNom", query = "SELECT p FROM Personnalite p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personnalite.findByNomDeFamille", query = "SELECT p FROM Personnalite p WHERE p.nomDeFamille = :nomDeFamille"),
    @NamedQuery(name = "Personnalite.findBySexe", query = "SELECT p FROM Personnalite p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Personnalite.findByCreatedAt", query = "SELECT p FROM Personnalite p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Personnalite.findByUpdatedAt", query = "SELECT p FROM Personnalite p WHERE p.updatedAt = :updatedAt"),
    @NamedQuery(name = "Personnalite.findBySlug", query = "SELECT p FROM Personnalite p WHERE p.slug = :slug")})
public class Personnalite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nb_commentaires")
    private BigInteger nbCommentaires;
    @Column(name = "nom")
    private String nom;
    @Column(name = "nom_de_famille")
    private String nomDeFamille;
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "slug")
    private String slug;

    public Personnalite() {
    }

    public Personnalite(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getNbCommentaires() {
        return nbCommentaires;
    }

    public void setNbCommentaires(BigInteger nbCommentaires) {
        this.nbCommentaires = nbCommentaires;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomDeFamille() {
        return nomDeFamille;
    }

    public void setNomDeFamille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
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
        if (!(object instanceof Personnalite)) {
            return false;
        }
        Personnalite other = (Personnalite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.Personnalite[id=" + id + "]";
    }

}
