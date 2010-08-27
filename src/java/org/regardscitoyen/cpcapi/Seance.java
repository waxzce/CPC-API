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
@Table(name = "seance")
@NamedQueries({
    @NamedQuery(name = "Seance.findAll", query = "SELECT s FROM Seance s"),
    @NamedQuery(name = "Seance.findById", query = "SELECT s FROM Seance s WHERE s.id = :id"),
    @NamedQuery(name = "Seance.findByNbCommentaires", query = "SELECT s FROM Seance s WHERE s.nbCommentaires = :nbCommentaires"),
    @NamedQuery(name = "Seance.findByDate", query = "SELECT s FROM Seance s WHERE s.date = :date"),
    @NamedQuery(name = "Seance.findByNumeroSemaine", query = "SELECT s FROM Seance s WHERE s.numeroSemaine = :numeroSemaine"),
    @NamedQuery(name = "Seance.findByAnnee", query = "SELECT s FROM Seance s WHERE s.annee = :annee"),
    @NamedQuery(name = "Seance.findByType", query = "SELECT s FROM Seance s WHERE s.type = :type"),
    @NamedQuery(name = "Seance.findByMoment", query = "SELECT s FROM Seance s WHERE s.moment = :moment"),
    @NamedQuery(name = "Seance.findByOrganismeId", query = "SELECT s FROM Seance s WHERE s.organismeId = :organismeId"),
    @NamedQuery(name = "Seance.findByTagged", query = "SELECT s FROM Seance s WHERE s.tagged = :tagged"),
    @NamedQuery(name = "Seance.findBySession", query = "SELECT s FROM Seance s WHERE s.session = :session"),
    @NamedQuery(name = "Seance.findByCreatedAt", query = "SELECT s FROM Seance s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "Seance.findByUpdatedAt", query = "SELECT s FROM Seance s WHERE s.updatedAt = :updatedAt")})
public class Seance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nb_commentaires")
    private BigInteger nbCommentaires;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "numero_semaine")
    private BigInteger numeroSemaine;
    @Column(name = "annee")
    private BigInteger annee;
    @Column(name = "type")
    private String type;
    @Column(name = "moment")
    private String moment;
    @Column(name = "organisme_id")
    private BigInteger organismeId;
    @Column(name = "tagged")
    private Boolean tagged;
    @Column(name = "session")
    private String session;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Seance() {
    }

    public Seance(Long id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigInteger getNumeroSemaine() {
        return numeroSemaine;
    }

    public void setNumeroSemaine(BigInteger numeroSemaine) {
        this.numeroSemaine = numeroSemaine;
    }

    public BigInteger getAnnee() {
        return annee;
    }

    public void setAnnee(BigInteger annee) {
        this.annee = annee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public BigInteger getOrganismeId() {
        return organismeId;
    }

    public void setOrganismeId(BigInteger organismeId) {
        this.organismeId = organismeId;
    }

    public Boolean getTagged() {
        return tagged;
    }

    public void setTagged(Boolean tagged) {
        this.tagged = tagged;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
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
        if (!(object instanceof Seance)) {
            return false;
        }
        Seance other = (Seance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.Seance[id=" + id + "]";
    }

}
