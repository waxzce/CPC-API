/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.PreuvePresence;
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

@XmlRootElement(name = "preuvePresence")
public class PreuvePresenceConverter {
    private PreuvePresence entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PreuvePresenceConverter */
    public PreuvePresenceConverter() {
        entity = new PreuvePresence();
    }

    /**
     * Creates a new instance of PreuvePresenceConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public PreuvePresenceConverter(PreuvePresence entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of PreuvePresenceConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PreuvePresenceConverter(PreuvePresence entity, URI uri, int expandLevel) {
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
     * Getter for presenceId.
     *
     * @return value for presenceId
     */
    @XmlElement
    public BigInteger getPresenceId() {
        return (expandLevel > 0) ? entity.getPresenceId() : null;
    }

    /**
     * Setter for presenceId.
     *
     * @param value the value to set
     */
    public void setPresenceId(BigInteger value) {
        entity.setPresenceId(value);
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
     * Returns the PreuvePresence entity.
     *
     * @return an entity
     */
    @XmlTransient
    public PreuvePresence getEntity() {
        if (entity.getId() == null) {
            PreuvePresenceConverter converter = UriResolver.getInstance().resolve(PreuvePresenceConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved PreuvePresence entity.
     *
     * @return an resolved entity
     */
    public PreuvePresence resolveEntity(EntityManager em) {
        return entity;
    }
}
