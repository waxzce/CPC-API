/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.Parlementaire;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "parlementaire")
public class ParlementaireConverter {
    private Parlementaire entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ParlementaireConverter */
    public ParlementaireConverter() {
        entity = new Parlementaire();
    }

    /**
     * Creates a new instance of ParlementaireConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public ParlementaireConverter(Parlementaire entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of ParlementaireConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ParlementaireConverter(Parlementaire entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for id.
     *
     * @return value for id
     */
    @XmlElement
    public Long getId() {
        return (expandLevel > 0) ? entity.getId() : null;
    }

    /**
     * Setter for id.
     *
     * @param value the value to set
     */
    public void setId(Long value) {
        entity.setId(value);
    }

    /**
     * Getter for nbCommentaires.
     *
     * @return value for nbCommentaires
     */
    @XmlElement
    public BigInteger getNbCommentaires() {
        return (expandLevel > 0) ? entity.getNbCommentaires() : null;
    }

    /**
     * Setter for nbCommentaires.
     *
     * @param value the value to set
     */
    public void setNbCommentaires(BigInteger value) {
        entity.setNbCommentaires(value);
    }

    /**
     * Getter for nom.
     *
     * @return value for nom
     */
    @XmlElement
    public String getNom() {
        return (expandLevel > 0) ? entity.getNom() : null;
    }

    /**
     * Setter for nom.
     *
     * @param value the value to set
     */
    public void setNom(String value) {
        entity.setNom(value);
    }

    /**
     * Getter for nomDeFamille.
     *
     * @return value for nomDeFamille
     */
    @XmlElement
    public String getNomDeFamille() {
        return (expandLevel > 0) ? entity.getNomDeFamille() : null;
    }

    /**
     * Setter for nomDeFamille.
     *
     * @param value the value to set
     */
    public void setNomDeFamille(String value) {
        entity.setNomDeFamille(value);
    }

    /**
     * Getter for sexe.
     *
     * @return value for sexe
     */
    @XmlElement
    public String getSexe() {
        return (expandLevel > 0) ? entity.getSexe() : null;
    }

    /**
     * Setter for sexe.
     *
     * @param value the value to set
     */
    public void setSexe(String value) {
        entity.setSexe(value);
    }

    /**
     * Getter for nomCirco.
     *
     * @return value for nomCirco
     */
    @XmlElement
    public String getNomCirco() {
        return (expandLevel > 0) ? entity.getNomCirco() : null;
    }

    /**
     * Setter for nomCirco.
     *
     * @param value the value to set
     */
    public void setNomCirco(String value) {
        entity.setNomCirco(value);
    }

    /**
     * Getter for numCirco.
     *
     * @return value for numCirco
     */
    @XmlElement
    public BigInteger getNumCirco() {
        return (expandLevel > 0) ? entity.getNumCirco() : null;
    }

    /**
     * Setter for numCirco.
     *
     * @param value the value to set
     */
    public void setNumCirco(BigInteger value) {
        entity.setNumCirco(value);
    }

    /**
     * Getter for siteWeb.
     *
     * @return value for siteWeb
     */
    @XmlElement
    public String getSiteWeb() {
        return (expandLevel > 0) ? entity.getSiteWeb() : null;
    }

    /**
     * Setter for siteWeb.
     *
     * @param value the value to set
     */
    public void setSiteWeb(String value) {
        entity.setSiteWeb(value);
    }

    /**
     * Getter for debutMandat.
     *
     * @return value for debutMandat
     */
    @XmlElement
    public Date getDebutMandat() {
        return (expandLevel > 0) ? entity.getDebutMandat() : null;
    }

    /**
     * Setter for debutMandat.
     *
     * @param value the value to set
     */
    public void setDebutMandat(Date value) {
        entity.setDebutMandat(value);
    }

    /**
     * Getter for finMandat.
     *
     * @return value for finMandat
     */
    @XmlElement
    public Date getFinMandat() {
        return (expandLevel > 0) ? entity.getFinMandat() : null;
    }

    /**
     * Setter for finMandat.
     *
     * @param value the value to set
     */
    public void setFinMandat(Date value) {
        entity.setFinMandat(value);
    }

    /**
     * Getter for placeHemicycle.
     *
     * @return value for placeHemicycle
     */
    @XmlElement
    public BigInteger getPlaceHemicycle() {
        return (expandLevel > 0) ? entity.getPlaceHemicycle() : null;
    }

    /**
     * Setter for placeHemicycle.
     *
     * @param value the value to set
     */
    public void setPlaceHemicycle(BigInteger value) {
        entity.setPlaceHemicycle(value);
    }

    /**
     * Getter for urlAn.
     *
     * @return value for urlAn
     */
    @XmlElement
    public String getUrlAn() {
        return (expandLevel > 0) ? entity.getUrlAn() : null;
    }

    /**
     * Setter for urlAn.
     *
     * @param value the value to set
     */
    public void setUrlAn(String value) {
        entity.setUrlAn(value);
    }

    /**
     * Getter for profession.
     *
     * @return value for profession
     */
    @XmlElement
    public String getProfession() {
        return (expandLevel > 0) ? entity.getProfession() : null;
    }

    /**
     * Setter for profession.
     *
     * @param value the value to set
     */
    public void setProfession(String value) {
        entity.setProfession(value);
    }

    /**
     * Getter for photo.
     *
     * @return value for photo
     */
    @XmlElement
    public byte[] getPhoto() {
        return (expandLevel > 0) ? entity.getPhoto() : null;
    }

    /**
     * Setter for photo.
     *
     * @param value the value to set
     */
    public void setPhoto(byte[] value) {
        entity.setPhoto(value);
    }

    /**
     * Getter for autoflip.
     *
     * @return value for autoflip
     */
    @XmlElement
    public Boolean getAutoflip() {
        return (expandLevel > 0) ? entity.getAutoflip() : null;
    }

    /**
     * Setter for autoflip.
     *
     * @param value the value to set
     */
    public void setAutoflip(Boolean value) {
        entity.setAutoflip(value);
    }

    /**
     * Getter for idAn.
     *
     * @return value for idAn
     */
    @XmlElement
    public BigInteger getIdAn() {
        return (expandLevel > 0) ? entity.getIdAn() : null;
    }

    /**
     * Setter for idAn.
     *
     * @param value the value to set
     */
    public void setIdAn(BigInteger value) {
        entity.setIdAn(value);
    }

    /**
     * Getter for type.
     *
     * @return value for type
     */
    @XmlElement
    public String getType() {
        return (expandLevel > 0) ? entity.getType() : null;
    }

    /**
     * Setter for type.
     *
     * @param value the value to set
     */
    public void setType(String value) {
        entity.setType(value);
    }

    /**
     * Getter for groupeAcronyme.
     *
     * @return value for groupeAcronyme
     */
    @XmlElement
    public String getGroupeAcronyme() {
        return (expandLevel > 0) ? entity.getGroupeAcronyme() : null;
    }

    /**
     * Setter for groupeAcronyme.
     *
     * @param value the value to set
     */
    public void setGroupeAcronyme(String value) {
        entity.setGroupeAcronyme(value);
    }

    /**
     * Getter for adresses.
     *
     * @return value for adresses
     */
    @XmlElement
    public String getAdresses() {
        return (expandLevel > 0) ? entity.getAdresses() : null;
    }

    /**
     * Setter for adresses.
     *
     * @param value the value to set
     */
    public void setAdresses(String value) {
        entity.setAdresses(value);
    }

    /**
     * Getter for autresMandats.
     *
     * @return value for autresMandats
     */
    @XmlElement
    public String getAutresMandats() {
        return (expandLevel > 0) ? entity.getAutresMandats() : null;
    }

    /**
     * Setter for autresMandats.
     *
     * @param value the value to set
     */
    public void setAutresMandats(String value) {
        entity.setAutresMandats(value);
    }

    /**
     * Getter for mails.
     *
     * @return value for mails
     */
    @XmlElement
    public String getMails() {
        return (expandLevel > 0) ? entity.getMails() : null;
    }

    /**
     * Setter for mails.
     *
     * @param value the value to set
     */
    public void setMails(String value) {
        entity.setMails(value);
    }

    /**
     * Getter for top.
     *
     * @return value for top
     */
    @XmlElement
    public String getTop() {
        return (expandLevel > 0) ? entity.getTop() : null;
    }

    /**
     * Setter for top.
     *
     * @param value the value to set
     */
    public void setTop(String value) {
        entity.setTop(value);
    }

    /**
     * Getter for createdAt.
     *
     * @return value for createdAt
     */
    @XmlElement
    public Date getCreatedAt() {
        return (expandLevel > 0) ? entity.getCreatedAt() : null;
    }

    /**
     * Setter for createdAt.
     *
     * @param value the value to set
     */
    public void setCreatedAt(Date value) {
        entity.setCreatedAt(value);
    }

    /**
     * Getter for updatedAt.
     *
     * @return value for updatedAt
     */
    @XmlElement
    public Date getUpdatedAt() {
        return (expandLevel > 0) ? entity.getUpdatedAt() : null;
    }

    /**
     * Setter for updatedAt.
     *
     * @param value the value to set
     */
    public void setUpdatedAt(Date value) {
        entity.setUpdatedAt(value);
    }

    /**
     * Getter for slug.
     *
     * @return value for slug
     */
    @XmlElement
    public String getSlug() {
        return (expandLevel > 0) ? entity.getSlug() : null;
    }

    /**
     * Setter for slug.
     *
     * @param value the value to set
     */
    public void setSlug(String value) {
        entity.setSlug(value);
    }

    /**
     * Returns the URI associated with this converter.
     *
     * @return the uri
     */
    @XmlAttribute
    public URI getUri() {
        return uri;
    }

    /**
     * Sets the URI for this reference converter.
     *
     */
    public void setUri(URI uri) {
        this.uri = uri;
    }

    /**
     * Returns the Parlementaire entity.
     *
     * @return an entity
     */
    @XmlTransient
    public Parlementaire getEntity() {
        if (entity.getId() == null) {
            ParlementaireConverter converter = UriResolver.getInstance().resolve(ParlementaireConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved Parlementaire entity.
     *
     * @return an resolved entity
     */
    public Parlementaire resolveEntity(EntityManager em) {
        return entity;
    }
}
