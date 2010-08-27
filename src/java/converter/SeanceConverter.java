/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.Seance;
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

@XmlRootElement(name = "seance")
public class SeanceConverter {
    private Seance entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SeanceConverter */
    public SeanceConverter() {
        entity = new Seance();
    }

    /**
     * Creates a new instance of SeanceConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public SeanceConverter(Seance entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of SeanceConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SeanceConverter(Seance entity, URI uri, int expandLevel) {
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
     * Getter for numeroSemaine.
     *
     * @return value for numeroSemaine
     */
    @XmlElement
    public BigInteger getNumeroSemaine() {
        return (expandLevel > 0) ? entity.getNumeroSemaine() : null;
    }

    /**
     * Setter for numeroSemaine.
     *
     * @param value the value to set
     */
    public void setNumeroSemaine(BigInteger value) {
        entity.setNumeroSemaine(value);
    }

    /**
     * Getter for annee.
     *
     * @return value for annee
     */
    @XmlElement
    public BigInteger getAnnee() {
        return (expandLevel > 0) ? entity.getAnnee() : null;
    }

    /**
     * Setter for annee.
     *
     * @param value the value to set
     */
    public void setAnnee(BigInteger value) {
        entity.setAnnee(value);
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
     * Getter for moment.
     *
     * @return value for moment
     */
    @XmlElement
    public String getMoment() {
        return (expandLevel > 0) ? entity.getMoment() : null;
    }

    /**
     * Setter for moment.
     *
     * @param value the value to set
     */
    public void setMoment(String value) {
        entity.setMoment(value);
    }

    /**
     * Getter for organismeId.
     *
     * @return value for organismeId
     */
    @XmlElement
    public BigInteger getOrganismeId() {
        return (expandLevel > 0) ? entity.getOrganismeId() : null;
    }

    /**
     * Setter for organismeId.
     *
     * @param value the value to set
     */
    public void setOrganismeId(BigInteger value) {
        entity.setOrganismeId(value);
    }

    /**
     * Getter for tagged.
     *
     * @return value for tagged
     */
    @XmlElement
    public Boolean getTagged() {
        return (expandLevel > 0) ? entity.getTagged() : null;
    }

    /**
     * Setter for tagged.
     *
     * @param value the value to set
     */
    public void setTagged(Boolean value) {
        entity.setTagged(value);
    }

    /**
     * Getter for session.
     *
     * @return value for session
     */
    @XmlElement
    public String getSession() {
        return (expandLevel > 0) ? entity.getSession() : null;
    }

    /**
     * Setter for session.
     *
     * @param value the value to set
     */
    public void setSession(String value) {
        entity.setSession(value);
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
     * Returns the Seance entity.
     *
     * @return an entity
     */
    @XmlTransient
    public Seance getEntity() {
        if (entity.getId() == null) {
            SeanceConverter converter = UriResolver.getInstance().resolve(SeanceConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved Seance entity.
     *
     * @return an resolved entity
     */
    public Seance resolveEntity(EntityManager em) {
        return entity;
    }
}
