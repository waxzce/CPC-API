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
@Table(name = "amendement")
@NamedQueries({
    @NamedQuery(name = "Amendement.findAll", query = "SELECT a FROM Amendement a"),
    @NamedQuery(name = "Amendement.findById", query = "SELECT a FROM Amendement a WHERE a.id = :id"),
    @NamedQuery(name = "Amendement.findByNbCommentaires", query = "SELECT a FROM Amendement a WHERE a.nbCommentaires = :nbCommentaires"),
    @NamedQuery(name = "Amendement.findBySource", query = "SELECT a FROM Amendement a WHERE a.source = :source"),
    @NamedQuery(name = "Amendement.findByLegislature", query = "SELECT a FROM Amendement a WHERE a.legislature = :legislature"),
    @NamedQuery(name = "Amendement.findByTexteloiId", query = "SELECT a FROM Amendement a WHERE a.texteloiId = :texteloiId"),
    @NamedQuery(name = "Amendement.findByNumero", query = "SELECT a FROM Amendement a WHERE a.numero = :numero"),
    @NamedQuery(name = "Amendement.findByRectif", query = "SELECT a FROM Amendement a WHERE a.rectif = :rectif"),
    @NamedQuery(name = "Amendement.findBySujet", query = "SELECT a FROM Amendement a WHERE a.sujet = :sujet"),
    @NamedQuery(name = "Amendement.findBySort", query = "SELECT a FROM Amendement a WHERE a.sort = :sort"),
    @NamedQuery(name = "Amendement.findByDate", query = "SELECT a FROM Amendement a WHERE a.date = :date"),
    @NamedQuery(name = "Amendement.findByContentMd5", query = "SELECT a FROM Amendement a WHERE a.contentMd5 = :contentMd5"),
    @NamedQuery(name = "Amendement.findByCreatedAt", query = "SELECT a FROM Amendement a WHERE a.createdAt = :createdAt"),
    @NamedQuery(name = "Amendement.findByUpdatedAt", query = "SELECT a FROM Amendement a WHERE a.updatedAt = :updatedAt")})
public class Amendement implements Serializable {
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
    @Column(name = "texteloi_id")
    private String texteloiId;
    @Column(name = "numero")
    private String numero;
    @Column(name = "rectif")
    private BigInteger rectif;
    @Column(name = "sujet")
    private String sujet;
    @Column(name = "sort")
    private String sort;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Column(name = "signataires")
    private String signataires;
    @Lob
    @Column(name = "texte")
    private String texte;
    @Lob
    @Column(name = "expose")
    private String expose;
    @Column(name = "content_md5")
    private String contentMd5;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Amendement() {
    }

    public Amendement(Long id) {
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

    public String getTexteloiId() {
        return texteloiId;
    }

    public void setTexteloiId(String texteloiId) {
        this.texteloiId = texteloiId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigInteger getRectif() {
        return rectif;
    }

    public void setRectif(BigInteger rectif) {
        this.rectif = rectif;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSignataires() {
        return signataires;
    }

    public void setSignataires(String signataires) {
        this.signataires = signataires;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getExpose() {
        return expose;
    }

    public void setExpose(String expose) {
        this.expose = expose;
    }

    public String getContentMd5() {
        return contentMd5;
    }

    public void setContentMd5(String contentMd5) {
        this.contentMd5 = contentMd5;
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
        if (!(object instanceof Amendement)) {
            return false;
        }
        Amendement other = (Amendement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.Amendement[id=" + id + "]";
    }

}
