/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.regardscitoyen.cpcapi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author waxzce
 */
@Embeddable
public class ParlementaireOrganismePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "organisme_id")
    private long organismeId;
    @Basic(optional = false)
    @Column(name = "parlementaire_id")
    private long parlementaireId;

    public ParlementaireOrganismePK() {
    }

    public ParlementaireOrganismePK(long organismeId, long parlementaireId) {
        this.organismeId = organismeId;
        this.parlementaireId = parlementaireId;
    }

    public long getOrganismeId() {
        return organismeId;
    }

    public void setOrganismeId(long organismeId) {
        this.organismeId = organismeId;
    }

    public long getParlementaireId() {
        return parlementaireId;
    }

    public void setParlementaireId(long parlementaireId) {
        this.parlementaireId = parlementaireId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) organismeId;
        hash += (int) parlementaireId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParlementaireOrganismePK)) {
            return false;
        }
        ParlementaireOrganismePK other = (ParlementaireOrganismePK) object;
        if (this.organismeId != other.organismeId) {
            return false;
        }
        if (this.parlementaireId != other.parlementaireId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.ParlementaireOrganismePK[organismeId=" + organismeId + ", parlementaireId=" + parlementaireId + "]";
    }

}
