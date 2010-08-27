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
@Table(name = "parlementaire_amendement")
@NamedQueries({
    @NamedQuery(name = "ParlementaireAmendement.findAll", query = "SELECT p FROM ParlementaireAmendement p"),
    @NamedQuery(name = "ParlementaireAmendement.findById", query = "SELECT p FROM ParlementaireAmendement p WHERE p.id = :id"),
    @NamedQuery(name = "ParlementaireAmendement.findByParlementaireId", query = "SELECT p FROM ParlementaireAmendement p WHERE p.parlementaireId = :parlementaireId"),
    @NamedQuery(name = "ParlementaireAmendement.findByAmendementId", query = "SELECT p FROM ParlementaireAmendement p WHERE p.amendementId = :amendementId"),
    @NamedQuery(name = "ParlementaireAmendement.findByNumeroSignataire", query = "SELECT p FROM ParlementaireAmendement p WHERE p.numeroSignataire = :numeroSignataire"),
    @NamedQuery(name = "ParlementaireAmendement.findByCreatedAt", query = "SELECT p FROM ParlementaireAmendement p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "ParlementaireAmendement.findByUpdatedAt", query = "SELECT p FROM ParlementaireAmendement p WHERE p.updatedAt = :updatedAt")})
public class ParlementaireAmendement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "parlementaire_id")
    private BigInteger parlementaireId;
    @Column(name = "amendement_id")
    private String amendementId;
    @Column(name = "numero_signataire")
    private BigInteger numeroSignataire;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public ParlementaireAmendement() {
    }

    public ParlementaireAmendement(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getParlementaireId() {
        return parlementaireId;
    }

    public void setParlementaireId(BigInteger parlementaireId) {
        this.parlementaireId = parlementaireId;
    }

    public String getAmendementId() {
        return amendementId;
    }

    public void setAmendementId(String amendementId) {
        this.amendementId = amendementId;
    }

    public BigInteger getNumeroSignataire() {
        return numeroSignataire;
    }

    public void setNumeroSignataire(BigInteger numeroSignataire) {
        this.numeroSignataire = numeroSignataire;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParlementaireAmendement)) {
            return false;
        }
        ParlementaireAmendement other = (ParlementaireAmendement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.ParlementaireAmendement[id=" + id + "]";
    }

}
