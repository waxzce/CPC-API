/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.Organisme;
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

@XmlRootElement(name = "organisme")
public class OrganismeConverter {
    private Organisme entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of OrganismeConverter */
    public OrganismeConverter() {
        entity = new Organisme();
    }

    /**
     * Creates a new instance of OrganismeConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public OrganismeConverter(Organisme entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of OrganismeConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public OrganismeConverter(Organisme entity, URI uri, int expandLevel) {
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
     * Returns the Organisme entity.
     *
     * @return an entity
     */
    @XmlTransient
    public Organisme getEntity() {
        if (entity.getId() == null) {
            OrganismeConverter converter = UriResolver.getInstance().resolve(OrganismeConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved Organisme entity.
     *
     * @return an resolved entity
     */
    public Organisme resolveEntity(EntityManager em) {
        return entity;
    }
}
