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
@Table(name = "section")
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s"),
    @NamedQuery(name = "Section.findById", query = "SELECT s FROM Section s WHERE s.id = :id"),
    @NamedQuery(name = "Section.findByNbCommentaires", query = "SELECT s FROM Section s WHERE s.nbCommentaires = :nbCommentaires"),
    @NamedQuery(name = "Section.findByMd5", query = "SELECT s FROM Section s WHERE s.md5 = :md5"),
    @NamedQuery(name = "Section.findBySectionId", query = "SELECT s FROM Section s WHERE s.sectionId = :sectionId"),
    @NamedQuery(name = "Section.findByMinDate", query = "SELECT s FROM Section s WHERE s.minDate = :minDate"),
    @NamedQuery(name = "Section.findByTimestamp", query = "SELECT s FROM Section s WHERE s.timestamp = :timestamp"),
    @NamedQuery(name = "Section.findByNbInterventions", query = "SELECT s FROM Section s WHERE s.nbInterventions = :nbInterventions"),
    @NamedQuery(name = "Section.findByCreatedAt", query = "SELECT s FROM Section s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "Section.findByUpdatedAt", query = "SELECT s FROM Section s WHERE s.updatedAt = :updatedAt")})
public class Section implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nb_commentaires")
    private BigInteger nbCommentaires;
    @Column(name = "md5")
    private String md5;
    @Lob
    @Column(name = "titre")
    private String titre;
    @Lob
    @Column(name = "titre_complet")
    private String titreComplet;
    @Column(name = "section_id")
    private BigInteger sectionId;
    @Column(name = "min_date")
    private String minDate;
    @Column(name = "timestamp")
    private BigInteger timestamp;
    @Column(name = "nb_interventions")
    private BigInteger nbInterventions;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Section() {
    }

    public Section(Long id) {
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

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitreComplet() {
        return titreComplet;
    }

    public void setTitreComplet(String titreComplet) {
        this.titreComplet = titreComplet;
    }

    public BigInteger getSectionId() {
        return sectionId;
    }

    public void setSectionId(BigInteger sectionId) {
        this.sectionId = sectionId;
    }

    public String getMinDate() {
        return minDate;
    }

    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    public BigInteger getNbInterventions() {
        return nbInterventions;
    }

    public void setNbInterventions(BigInteger nbInterventions) {
        this.nbInterventions = nbInterventions;
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
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.Section[id=" + id + "]";
    }

}
