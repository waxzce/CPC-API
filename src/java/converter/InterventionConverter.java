/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.Intervention;
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

@XmlRootElement(name = "intervention")
public class InterventionConverter {
    private Intervention entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of InterventionConverter */
    public InterventionConverter() {
        entity = new Intervention();
    }

    /**
     * Creates a new instance of InterventionConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public InterventionConverter(Intervention entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of InterventionConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public InterventionConverter(Intervention entity, URI uri, int expandLevel) {
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
     * Getter for nbMots.
     *
     * @return value for nbMots
     */
    @XmlElement
    public BigInteger getNbMots() {
        return (expandLevel > 0) ? entity.getNbMots() : null;
    }

    /**
     * Setter for nbMots.
     *
     * @param value the value to set
     */
    public void setNbMots(BigInteger value) {
        entity.setNbMots(value);
    }

    /**
     * Getter for md5.
     *
     * @return value for md5
     */
    @XmlElement
    public String getMd5() {
        return (expandLevel > 0) ? entity.getMd5() : null;
    }

    /**
     * Setter for md5.
     *
     * @param value the value to set
     */
    public void setMd5(String value) {
        entity.setMd5(value);
    }

    /**
     * Getter for intervention.
     *
     * @return value for intervention
     */
    @XmlElement
    public String getIntervention() {
        return (expandLevel > 0) ? entity.getIntervention() : null;
    }

    /**
     * Setter for intervention.
     *
     * @param value the value to set
     */
    public void setIntervention(String value) {
        entity.setIntervention(value);
    }

    /**
     * Getter for timestamp.
     *
     * @return value for timestamp
     */
    @XmlElement
    public BigInteger getTimestamp() {
        return (expandLevel > 0) ? entity.getTimestamp() : null;
    }

    /**
     * Setter for timestamp.
     *
     * @param value the value to set
     */
    public void setTimestamp(BigInteger value) {
        entity.setTimestamp(value);
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
     * Getter for seanceId.
     *
     * @return value for seanceId
     */
    @XmlElement
    public BigInteger getSeanceId() {
        return (expandLevel > 0) ? entity.getSeanceId() : null;
    }

    /**
     * Setter for seanceId.
     *
     * @param value the value to set
     */
    public void setSeanceId(BigInteger value) {
        entity.setSeanceId(value);
    }

    /**
     * Getter for sectionId.
     *
     * @return value for sectionId
     */
    @XmlElement
    public BigInteger getSectionId() {
        return (expandLevel > 0) ? entity.getSectionId() : null;
    }

    /**
     * Setter for sectionId.
     *
     * @param value the value to set
     */
    public void setSectionId(BigInteger value) {
        entity.setSectionId(value);
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
     * Getter for personnaliteId.
     *
     * @return value for personnaliteId
     */
    @XmlElement
    public BigInteger getPersonnaliteId() {
        return (expandLevel > 0) ? entity.getPersonnaliteId() : null;
    }

    /**
     * Setter for personnaliteId.
     *
     * @param value the value to set
     */
    public void setPersonnaliteId(BigInteger value) {
        entity.setPersonnaliteId(value);
    }

    /**
     * Getter for parlementaireId.
     *
     * @return value for parlementaireId
     */
    @XmlElement
    public BigInteger getParlementaireId() {
        return (expandLevel > 0) ? entity.getParlementaireId() : null;
    }

    /**
     * Setter for parlementaireId.
     *
     * @param value the value to set
     */
    public void setParlementaireId(BigInteger value) {
        entity.setParlementaireId(value);
    }

    /**
     * Getter for fonction.
     *
     * @return value for fonction
     */
    @XmlElement
    public String getFonction() {
        return (expandLevel > 0) ? entity.getFonction() : null;
    }

    /**
     * Setter for fonction.
     *
     * @param value the value to set
     */
    public void setFonction(String value) {
        entity.setFonction(value);
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
     * Returns the Intervention entity.
     *
     * @return an entity
     */
    @XmlTransient
    public Intervention getEntity() {
        if (entity.getId() == null) {
            InterventionConverter converter = UriResolver.getInstance().resolve(InterventionConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved Intervention entity.
     *
     * @return an resolved entity
     */
    public Intervention resolveEntity(EntityManager em) {
        return entity;
    }
}
