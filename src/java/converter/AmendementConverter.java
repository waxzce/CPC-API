/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.Amendement;
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

@XmlRootElement(name = "amendement")
public class AmendementConverter {
    private Amendement entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of AmendementConverter */
    public AmendementConverter() {
        entity = new Amendement();
    }

    /**
     * Creates a new instance of AmendementConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public AmendementConverter(Amendement entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of AmendementConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public AmendementConverter(Amendement entity, URI uri, int expandLevel) {
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
     * Getter for source.
     *
     * @return value for source
     */
    @XmlElement
    public String getSource() {
        return (expandLevel > 0) ? entity.getSource() : null;
    }

    /**
     * Setter for source.
     *
     * @param value the value to set
     */
    public void setSource(String value) {
        entity.setSource(value);
    }

    /**
     * Getter for legislature.
     *
     * @return value for legislature
     */
    @XmlElement
    public BigInteger getLegislature() {
        return (expandLevel > 0) ? entity.getLegislature() : null;
    }

    /**
     * Setter for legislature.
     *
     * @param value the value to set
     */
    public void setLegislature(BigInteger value) {
        entity.setLegislature(value);
    }

    /**
     * Getter for texteloiId.
     *
     * @return value for texteloiId
     */
    @XmlElement
    public String getTexteloiId() {
        return (expandLevel > 0) ? entity.getTexteloiId() : null;
    }

    /**
     * Setter for texteloiId.
     *
     * @param value the value to set
     */
    public void setTexteloiId(String value) {
        entity.setTexteloiId(value);
    }

    /**
     * Getter for numero.
     *
     * @return value for numero
     */
    @XmlElement
    public String getNumero() {
        return (expandLevel > 0) ? entity.getNumero() : null;
    }

    /**
     * Setter for numero.
     *
     * @param value the value to set
     */
    public void setNumero(String value) {
        entity.setNumero(value);
    }

    /**
     * Getter for rectif.
     *
     * @return value for rectif
     */
    @XmlElement
    public BigInteger getRectif() {
        return (expandLevel > 0) ? entity.getRectif() : null;
    }

    /**
     * Setter for rectif.
     *
     * @param value the value to set
     */
    public void setRectif(BigInteger value) {
        entity.setRectif(value);
    }

    /**
     * Getter for sujet.
     *
     * @return value for sujet
     */
    @XmlElement
    public String getSujet() {
        return (expandLevel > 0) ? entity.getSujet() : null;
    }

    /**
     * Setter for sujet.
     *
     * @param value the value to set
     */
    public void setSujet(String value) {
        entity.setSujet(value);
    }

    /**
     * Getter for sort.
     *
     * @return value for sort
     */
    @XmlElement
    public String getSort() {
        return (expandLevel > 0) ? entity.getSort() : null;
    }

    /**
     * Setter for sort.
     *
     * @param value the value to set
     */
    public void setSort(String value) {
        entity.setSort(value);
    }

    /**
     * Getter for date.
     *
     * @return value for date
     */
    @XmlElement
    public Date getDate() {
        return (expandLevel > 0) ? entity.getDate() : null;
    }

    /**
     * Setter for date.
     *
     * @param value the value to set
     */
    public void setDate(Date value) {
        entity.setDate(value);
    }

    /**
     * Getter for signataires.
     *
     * @return value for signataires
     */
    @XmlElement
    public String getSignataires() {
        return (expandLevel > 0) ? entity.getSignataires() : null;
    }

    /**
     * Setter for signataires.
     *
     * @param value the value to set
     */
    public void setSignataires(String value) {
        entity.setSignataires(value);
    }

    /**
     * Getter for texte.
     *
     * @return value for texte
     */
    @XmlElement
    public String getTexte() {
        return (expandLevel > 0) ? entity.getTexte() : null;
    }

    /**
     * Setter for texte.
     *
     * @param value the value to set
     */
    public void setTexte(String value) {
        entity.setTexte(value);
    }

    /**
     * Getter for expose.
     *
     * @return value for expose
     */
    @XmlElement
    public String getExpose() {
        return (expandLevel > 0) ? entity.getExpose() : null;
    }

    /**
     * Setter for expose.
     *
     * @param value the value to set
     */
    public void setExpose(String value) {
        entity.setExpose(value);
    }

    /**
     * Getter for contentMd5.
     *
     * @return value for contentMd5
     */
    @XmlElement
    public String getContentMd5() {
        return (expandLevel > 0) ? entity.getContentMd5() : null;
    }

    /**
     * Setter for contentMd5.
     *
     * @param value the value to set
     */
    public void setContentMd5(String value) {
        entity.setContentMd5(value);
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
     * Returns the Amendement entity.
     *
     * @return an entity
     */
    @XmlTransient
    public Amendement getEntity() {
        if (entity.getId() == null) {
            AmendementConverter converter = UriResolver.getInstance().resolve(AmendementConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved Amendement entity.
     *
     * @return an resolved entity
     */
    public Amendement resolveEntity(EntityManager em) {
        return entity;
    }
}
