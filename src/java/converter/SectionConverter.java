/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.Section;
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

@XmlRootElement(name = "section")
public class SectionConverter {
    private Section entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SectionConverter */
    public SectionConverter() {
        entity = new Section();
    }

    /**
     * Creates a new instance of SectionConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public SectionConverter(Section entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of SectionConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SectionConverter(Section entity, URI uri, int expandLevel) {
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
     * Getter for titre.
     *
     * @return value for titre
     */
    @XmlElement
    public String getTitre() {
        return (expandLevel > 0) ? entity.getTitre() : null;
    }

    /**
     * Setter for titre.
     *
     * @param value the value to set
     */
    public void setTitre(String value) {
        entity.setTitre(value);
    }

    /**
     * Getter for titreComplet.
     *
     * @return value for titreComplet
     */
    @XmlElement
    public String getTitreComplet() {
        return (expandLevel > 0) ? entity.getTitreComplet() : null;
    }

    /**
     * Setter for titreComplet.
     *
     * @param value the value to set
     */
    public void setTitreComplet(String value) {
        entity.setTitreComplet(value);
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
     * Getter for minDate.
     *
     * @return value for minDate
     */
    @XmlElement
    public String getMinDate() {
        return (expandLevel > 0) ? entity.getMinDate() : null;
    }

    /**
     * Setter for minDate.
     *
     * @param value the value to set
     */
    public void setMinDate(String value) {
        entity.setMinDate(value);
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
     * Getter for nbInterventions.
     *
     * @return value for nbInterventions
     */
    @XmlElement
    public BigInteger getNbInterventions() {
        return (expandLevel > 0) ? entity.getNbInterventions() : null;
    }

    /**
     * Setter for nbInterventions.
     *
     * @param value the value to set
     */
    public void setNbInterventions(BigInteger value) {
        entity.setNbInterventions(value);
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
     * Returns the Section entity.
     *
     * @return an entity
     */
    @XmlTransient
    public Section getEntity() {
        if (entity.getId() == null) {
            SectionConverter converter = UriResolver.getInstance().resolve(SectionConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved Section entity.
     *
     * @return an resolved entity
     */
    public Section resolveEntity(EntityManager em) {
        return entity;
    }
}
