/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.regardscitoyen.cpcapi;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
@Table(name = "parlementaire_organisme")
@NamedQueries({
    @NamedQuery(name = "ParlementaireOrganisme.findAll", query = "SELECT p FROM ParlementaireOrganisme p"),
    @NamedQuery(name = "ParlementaireOrganisme.findByImportance", query = "SELECT p FROM ParlementaireOrganisme p WHERE p.importance = :importance"),
    @NamedQuery(name = "ParlementaireOrganisme.findByDebutFonction", query = "SELECT p FROM ParlementaireOrganisme p WHERE p.debutFonction = :debutFonction"),
    @NamedQuery(name = "ParlementaireOrganisme.findByOrganismeId", query = "SELECT p FROM ParlementaireOrganisme p WHERE p.parlementaireOrganismePK.organismeId = :organismeId"),
    @NamedQuery(name = "ParlementaireOrganisme.findByParlementaireId", query = "SELECT p FROM ParlementaireOrganisme p WHERE p.parlementaireOrganismePK.parlementaireId = :parlementaireId")})
public class ParlementaireOrganisme implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParlementaireOrganismePK parlementaireOrganismePK;
    @Lob
    @Column(name = "fonction")
    private String fonction;
    @Column(name = "importance")
    private BigInteger importance;
    @Column(name = "debut_fonction")
    @Temporal(TemporalType.DATE)
    private Date debutFonction;

    public ParlementaireOrganisme() {
    }

    public ParlementaireOrganisme(ParlementaireOrganismePK parlementaireOrganismePK) {
        this.parlementaireOrganismePK = parlementaireOrganismePK;
    }

    public ParlementaireOrganisme(long organismeId, long parlementaireId) {
        this.parlementaireOrganismePK = new ParlementaireOrganismePK(organismeId, parlementaireId);
    }

    public ParlementaireOrganismePK getParlementaireOrganismePK() {
        return parlementaireOrganismePK;
    }

    public void setParlementaireOrganismePK(ParlementaireOrganismePK parlementaireOrganismePK) {
        this.parlementaireOrganismePK = parlementaireOrganismePK;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public BigInteger getImportance() {
        return importance;
    }

    public void setImportance(BigInteger importance) {
        this.importance = importance;
    }

    public Date getDebutFonction() {
        return debutFonction;
    }

    public void setDebutFonction(Date debutFonction) {
        this.debutFonction = debutFonction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parlementaireOrganismePK != null ? parlementaireOrganismePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParlementaireOrganisme)) {
            return false;
        }
        ParlementaireOrganisme other = (ParlementaireOrganisme) object;
        if ((this.parlementaireOrganismePK == null && other.parlementaireOrganismePK != null) || (this.parlementaireOrganismePK != null && !this.parlementaireOrganismePK.equals(other.parlementaireOrganismePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.ParlementaireOrganisme[parlementaireOrganismePK=" + parlementaireOrganismePK + "]";
    }

}
