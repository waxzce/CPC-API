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
@Table(name = "parlementaire")
@NamedQueries({
    @NamedQuery(name = "Parlementaire.findAll", query = "SELECT p FROM Parlementaire p"),
    @NamedQuery(name = "Parlementaire.findById", query = "SELECT p FROM Parlementaire p WHERE p.id = :id"),
    @NamedQuery(name = "Parlementaire.findByNbCommentaires", query = "SELECT p FROM Parlementaire p WHERE p.nbCommentaires = :nbCommentaires"),
    @NamedQuery(name = "Parlementaire.findByNom", query = "SELECT p FROM Parlementaire p WHERE p.nom = :nom"),
    @NamedQuery(name = "Parlementaire.findByNomDeFamille", query = "SELECT p FROM Parlementaire p WHERE p.nomDeFamille = :nomDeFamille"),
    @NamedQuery(name = "Parlementaire.findBySexe", query = "SELECT p FROM Parlementaire p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Parlementaire.findByNomCirco", query = "SELECT p FROM Parlementaire p WHERE p.nomCirco = :nomCirco"),
    @NamedQuery(name = "Parlementaire.findByNumCirco", query = "SELECT p FROM Parlementaire p WHERE p.numCirco = :numCirco"),
    @NamedQuery(name = "Parlementaire.findBySiteWeb", query = "SELECT p FROM Parlementaire p WHERE p.siteWeb = :siteWeb"),
    @NamedQuery(name = "Parlementaire.findByDebutMandat", query = "SELECT p FROM Parlementaire p WHERE p.debutMandat = :debutMandat"),
    @NamedQuery(name = "Parlementaire.findByFinMandat", query = "SELECT p FROM Parlementaire p WHERE p.finMandat = :finMandat"),
    @NamedQuery(name = "Parlementaire.findByPlaceHemicycle", query = "SELECT p FROM Parlementaire p WHERE p.placeHemicycle = :placeHemicycle"),
    @NamedQuery(name = "Parlementaire.findByUrlAn", query = "SELECT p FROM Parlementaire p WHERE p.urlAn = :urlAn"),
    @NamedQuery(name = "Parlementaire.findByProfession", query = "SELECT p FROM Parlementaire p WHERE p.profession = :profession"),
    @NamedQuery(name = "Parlementaire.findByAutoflip", query = "SELECT p FROM Parlementaire p WHERE p.autoflip = :autoflip"),
    @NamedQuery(name = "Parlementaire.findByIdAn", query = "SELECT p FROM Parlementaire p WHERE p.idAn = :idAn"),
    @NamedQuery(name = "Parlementaire.findByType", query = "SELECT p FROM Parlementaire p WHERE p.type = :type"),
    @NamedQuery(name = "Parlementaire.findByGroupeAcronyme", query = "SELECT p FROM Parlementaire p WHERE p.groupeAcronyme = :groupeAcronyme"),
    @NamedQuery(name = "Parlementaire.findByCreatedAt", query = "SELECT p FROM Parlementaire p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Parlementaire.findByUpdatedAt", query = "SELECT p FROM Parlementaire p WHERE p.updatedAt = :updatedAt"),
    @NamedQuery(name = "Parlementaire.findBySlug", query = "SELECT p FROM Parlementaire p WHERE p.slug = :slug")})
public class Parlementaire implements Serializable {
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
    @Column(name = "nom_circo")
    private String nomCirco;
    @Column(name = "num_circo")
    private BigInteger numCirco;
    @Column(name = "site_web")
    private String siteWeb;
    @Column(name = "debut_mandat")
    @Temporal(TemporalType.DATE)
    private Date debutMandat;
    @Column(name = "fin_mandat")
    @Temporal(TemporalType.DATE)
    private Date finMandat;
    @Column(name = "place_hemicycle")
    private BigInteger placeHemicycle;
    @Column(name = "url_an")
    private String urlAn;
    @Column(name = "profession")
    private String profession;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "autoflip")
    private Boolean autoflip;
    @Column(name = "id_an")
    private BigInteger idAn;
    @Column(name = "type")
    private String type;
    @Column(name = "groupe_acronyme")
    private String groupeAcronyme;
    @Lob
    @Column(name = "adresses")
    private String adresses;
    @Lob
    @Column(name = "autres_mandats")
    private String autresMandats;
    @Lob
    @Column(name = "mails")
    private String mails;
    @Lob
    @Column(name = "top")
    private String top;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "slug")
    private String slug;

    public Parlementaire() {
    }

    public Parlementaire(Long id) {
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

    public String getNomCirco() {
        return nomCirco;
    }

    public void setNomCirco(String nomCirco) {
        this.nomCirco = nomCirco;
    }

    public BigInteger getNumCirco() {
        return numCirco;
    }

    public void setNumCirco(BigInteger numCirco) {
        this.numCirco = numCirco;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public Date getDebutMandat() {
        return debutMandat;
    }

    public void setDebutMandat(Date debutMandat) {
        this.debutMandat = debutMandat;
    }

    public Date getFinMandat() {
        return finMandat;
    }

    public void setFinMandat(Date finMandat) {
        this.finMandat = finMandat;
    }

    public BigInteger getPlaceHemicycle() {
        return placeHemicycle;
    }

    public void setPlaceHemicycle(BigInteger placeHemicycle) {
        this.placeHemicycle = placeHemicycle;
    }

    public String getUrlAn() {
        return urlAn;
    }

    public void setUrlAn(String urlAn) {
        this.urlAn = urlAn;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Boolean getAutoflip() {
        return autoflip;
    }

    public void setAutoflip(Boolean autoflip) {
        this.autoflip = autoflip;
    }

    public BigInteger getIdAn() {
        return idAn;
    }

    public void setIdAn(BigInteger idAn) {
        this.idAn = idAn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroupeAcronyme() {
        return groupeAcronyme;
    }

    public void setGroupeAcronyme(String groupeAcronyme) {
        this.groupeAcronyme = groupeAcronyme;
    }

    public String getAdresses() {
        return adresses;
    }

    public void setAdresses(String adresses) {
        this.adresses = adresses;
    }

    public String getAutresMandats() {
        return autresMandats;
    }

    public void setAutresMandats(String autresMandats) {
        this.autresMandats = autresMandats;
    }

    public String getMails() {
        return mails;
    }

    public void setMails(String mails) {
        this.mails = mails;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
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
        if (!(object instanceof Parlementaire)) {
            return false;
        }
        Parlementaire other = (Parlementaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.Parlementaire[id=" + id + "]";
    }

}
