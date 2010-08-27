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
@Table(name = "presence")
@NamedQueries({
    @NamedQuery(name = "Presence.findAll", query = "SELECT p FROM Presence p"),
    @NamedQuery(name = "Presence.findById", query = "SELECT p FROM Presence p WHERE p.id = :id"),
    @NamedQuery(name = "Presence.findByParlementaireId", query = "SELECT p FROM Presence p WHERE p.parlementaireId = :parlementaireId"),
    @NamedQuery(name = "Presence.findBySeanceId", query = "SELECT p FROM Presence p WHERE p.seanceId = :seanceId"),
    @NamedQuery(name = "Presence.findByNbPreuves", query = "SELECT p FROM Presence p WHERE p.nbPreuves = :nbPreuves"),
    @NamedQuery(name = "Presence.findByDate", query = "SELECT p FROM Presence p WHERE p.date = :date"),
    @NamedQuery(name = "Presence.findByCreatedAt", query = "SELECT p FROM Presence p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Presence.findByUpdatedAt", query = "SELECT p FROM Presence p WHERE p.updatedAt = :updatedAt")})
public class Presence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "parlementaire_id")
    private BigInteger parlementaireId;
    @Column(name = "seance_id")
    private BigInteger seanceId;
    @Column(name = "nb_preuves")
    private BigInteger nbPreuves;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Presence() {
    }

    public Presence(Long id) {
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

    public BigInteger getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(BigInteger seanceId) {
        this.seanceId = seanceId;
    }

    public BigInteger getNbPreuves() {
        return nbPreuves;
    }

    public void setNbPreuves(BigInteger nbPreuves) {
        this.nbPreuves = nbPreuves;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        if (!(object instanceof Presence)) {
            return false;
        }
        Presence other = (Presence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.Presence[id=" + id + "]";
    }

}
