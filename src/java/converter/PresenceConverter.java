/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.Presence;
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

@XmlRootElement(name = "presence")
public class PresenceConverter {
    private Presence entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PresenceConverter */
    public PresenceConverter() {
        entity = new Presence();
    }

    /**
     * Creates a new instance of PresenceConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public PresenceConverter(Presence entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of PresenceConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PresenceConverter(Presence entity, URI uri, int expandLevel) {
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
     * Getter for nbPreuves.
     *
     * @return value for nbPreuves
     */
    @XmlElement
    public BigInteger getNbPreuves() {
        return (expandLevel > 0) ? entity.getNbPreuves() : null;
    }

    /**
     * Setter for nbPreuves.
     *
     * @param value the value to set
     */
    public void setNbPreuves(BigInteger value) {
        entity.setNbPreuves(value);
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
     * Returns the Presence entity.
     *
     * @return an entity
     */
    @XmlTransient
    public Presence getEntity() {
        if (entity.getId() == null) {
            PresenceConverter converter = UriResolver.getInstance().resolve(PresenceConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved Presence entity.
     *
     * @return an resolved entity
     */
    public Presence resolveEntity(EntityManager em) {
        return entity;
    }
}
