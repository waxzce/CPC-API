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
@Table(name = "question_ecrite")
@NamedQueries({
    @NamedQuery(name = "QuestionEcrite.findAll", query = "SELECT q FROM QuestionEcrite q"),
    @NamedQuery(name = "QuestionEcrite.findById", query = "SELECT q FROM QuestionEcrite q WHERE q.id = :id"),
    @NamedQuery(name = "QuestionEcrite.findByNbCommentaires", query = "SELECT q FROM QuestionEcrite q WHERE q.nbCommentaires = :nbCommentaires"),
    @NamedQuery(name = "QuestionEcrite.findBySource", query = "SELECT q FROM QuestionEcrite q WHERE q.source = :source"),
    @NamedQuery(name = "QuestionEcrite.findByLegislature", query = "SELECT q FROM QuestionEcrite q WHERE q.legislature = :legislature"),
    @NamedQuery(name = "QuestionEcrite.findByNumero", query = "SELECT q FROM QuestionEcrite q WHERE q.numero = :numero"),
    @NamedQuery(name = "QuestionEcrite.findByDate", query = "SELECT q FROM QuestionEcrite q WHERE q.date = :date"),
    @NamedQuery(name = "QuestionEcrite.findByDateCloture", query = "SELECT q FROM QuestionEcrite q WHERE q.dateCloture = :dateCloture"),
    @NamedQuery(name = "QuestionEcrite.findByContentMd5", query = "SELECT q FROM QuestionEcrite q WHERE q.contentMd5 = :contentMd5"),
    @NamedQuery(name = "QuestionEcrite.findByParlementaireId", query = "SELECT q FROM QuestionEcrite q WHERE q.parlementaireId = :parlementaireId"),
    @NamedQuery(name = "QuestionEcrite.findByCreatedAt", query = "SELECT q FROM QuestionEcrite q WHERE q.createdAt = :createdAt"),
    @NamedQuery(name = "QuestionEcrite.findByUpdatedAt", query = "SELECT q FROM QuestionEcrite q WHERE q.updatedAt = :updatedAt")})
public class QuestionEcrite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nb_commentaires")
    private BigInteger nbCommentaires;
    @Column(name = "source")
    private String source;
    @Column(name = "legislature")
    private BigInteger legislature;
    @Column(name = "numero")
    private BigInteger numero;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "date_cloture")
    @Temporal(TemporalType.DATE)
    private Date dateCloture;
    @Lob
    @Column(name = "ministere")
    private String ministere;
    @Lob
    @Column(name = "themes")
    private String themes;
    @Lob
    @Column(name = "question")
    private String question;
    @Lob
    @Column(name = "reponse")
    private String reponse;
    @Lob
    @Column(name = "motif_retrait")
    private String motifRetrait;
    @Column(name = "content_md5")
    private String contentMd5;
    @Column(name = "parlementaire_id")
    private BigInteger parlementaireId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public QuestionEcrite() {
    }

    public QuestionEcrite(Long id) {
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigInteger getLegislature() {
        return legislature;
    }

    public void setLegislature(BigInteger legislature) {
        this.legislature = legislature;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }

    public String getMinistere() {
        return ministere;
    }

    public void setMinistere(String ministere) {
        this.ministere = ministere;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getMotifRetrait() {
        return motifRetrait;
    }

    public void setMotifRetrait(String motifRetrait) {
        this.motifRetrait = motifRetrait;
    }

    public String getContentMd5() {
        return contentMd5;
    }

    public void setContentMd5(String contentMd5) {
        this.contentMd5 = contentMd5;
    }

    public BigInteger getParlementaireId() {
        return parlementaireId;
    }

    public void setParlementaireId(BigInteger parlementaireId) {
        this.parlementaireId = parlementaireId;
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
        if (!(object instanceof QuestionEcrite)) {
            return false;
        }
        QuestionEcrite other = (QuestionEcrite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.QuestionEcrite[id=" + id + "]";
    }

}
