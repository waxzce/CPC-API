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
@Table(name = "intervention")
@NamedQueries({
    @NamedQuery(name = "Intervention.findAll", query = "SELECT i FROM Intervention i"),
    @NamedQuery(name = "Intervention.findById", query = "SELECT i FROM Intervention i WHERE i.id = :id"),
    @NamedQuery(name = "Intervention.findByNbCommentaires", query = "SELECT i FROM Intervention i WHERE i.nbCommentaires = :nbCommentaires"),
    @NamedQuery(name = "Intervention.findByNbMots", query = "SELECT i FROM Intervention i WHERE i.nbMots = :nbMots"),
    @NamedQuery(name = "Intervention.findByMd5", query = "SELECT i FROM Intervention i WHERE i.md5 = :md5"),
    @NamedQuery(name = "Intervention.findByTimestamp", query = "SELECT i FROM Intervention i WHERE i.timestamp = :timestamp"),
    @NamedQuery(name = "Intervention.findBySource", query = "SELECT i FROM Intervention i WHERE i.source = :source"),
    @NamedQuery(name = "Intervention.findBySeanceId", query = "SELECT i FROM Intervention i WHERE i.seanceId = :seanceId"),
    @NamedQuery(name = "Intervention.findBySectionId", query = "SELECT i FROM Intervention i WHERE i.sectionId = :sectionId"),
    @NamedQuery(name = "Intervention.findByType", query = "SELECT i FROM Intervention i WHERE i.type = :type"),
    @NamedQuery(name = "Intervention.findByDate", query = "SELECT i FROM Intervention i WHERE i.date = :date"),
    @NamedQuery(name = "Intervention.findByPersonnaliteId", query = "SELECT i FROM Intervention i WHERE i.personnaliteId = :personnaliteId"),
    @NamedQuery(name = "Intervention.findByParlementaireId", query = "SELECT i FROM Intervention i WHERE i.parlementaireId = :parlementaireId"),
    @NamedQuery(name = "Intervention.findByCreatedAt", query = "SELECT i FROM Intervention i WHERE i.createdAt = :createdAt"),
    @NamedQuery(name = "Intervention.findByUpdatedAt", query = "SELECT i FROM Intervention i WHERE i.updatedAt = :updatedAt")})
public class Intervention implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nb_commentaires")
    private BigInteger nbCommentaires;
    @Column(name = "nb_mots")
    private BigInteger nbMots;
    @Column(name = "md5")
    private String md5;
    @Lob
    @Column(name = "intervention")
    private String intervention;
    @Column(name = "timestamp")
    private BigInteger timestamp;
    @Column(name = "source")
    private String source;
    @Column(name = "seance_id")
    private BigInteger seanceId;
    @Column(name = "section_id")
    private BigInteger sectionId;
    @Column(name = "type")
    private String type;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "personnalite_id")
    private BigInteger personnaliteId;
    @Column(name = "parlementaire_id")
    private BigInteger parlementaireId;
    @Lob
    @Column(name = "fonction")
    private String fonction;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Intervention() {
    }

    public Intervention(Long id) {
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

    public BigInteger getNbMots() {
        return nbMots;
    }

    public void setNbMots(BigInteger nbMots) {
        this.nbMots = nbMots;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getIntervention() {
        return intervention;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigInteger getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(BigInteger seanceId) {
        this.seanceId = seanceId;
    }

    public BigInteger getSectionId() {
        return sectionId;
    }

    public void setSectionId(BigInteger sectionId) {
        this.sectionId = sectionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigInteger getPersonnaliteId() {
        return personnaliteId;
    }

    public void setPersonnaliteId(BigInteger personnaliteId) {
        this.personnaliteId = personnaliteId;
    }

    public BigInteger getParlementaireId() {
        return parlementaireId;
    }

    public void setParlementaireId(BigInteger parlementaireId) {
        this.parlementaireId = parlementaireId;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
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
        if (!(object instanceof Intervention)) {
            return false;
        }
        Intervention other = (Intervention) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.Intervention[id=" + id + "]";
    }

}
