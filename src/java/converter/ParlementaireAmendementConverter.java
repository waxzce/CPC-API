/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.ParlementaireAmendement;
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

@XmlRootElement(name = "parlementaireAmendement")
public class ParlementaireAmendementConverter {
    private ParlementaireAmendement entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ParlementaireAmendementConverter */
    public ParlementaireAmendementConverter() {
        entity = new ParlementaireAmendement();
    }

    /**
     * Creates a new instance of ParlementaireAmendementConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public ParlementaireAmendementConverter(ParlementaireAmendement entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of ParlementaireAmendementConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ParlementaireAmendementConverter(ParlementaireAmendement entity, URI uri, int expandLevel) {
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
     * Getter for amendementId.
     *
     * @return value for amendementId
     */
    @XmlElement
    public String getAmendementId() {
        return (expandLevel > 0) ? entity.getAmendementId() : null;
    }

    /**
     * Setter for amendementId.
     *
     * @param value the value to set
     */
    public void setAmendementId(String value) {
        entity.setAmendementId(value);
    }

    /**
     * Getter for numeroSignataire.
     *
     * @return value for numeroSignataire
     */
    @XmlElement
    public BigInteger getNumeroSignataire() {
        return (expandLevel > 0) ? entity.getNumeroSignataire() : null;
    }

    /**
     * Setter for numeroSignataire.
     *
     * @param value the value to set
     */
    public void setNumeroSignataire(BigInteger value) {
        entity.setNumeroSignataire(value);
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
     * Returns the ParlementaireAmendement entity.
     *
     * @return an entity
     */
    @XmlTransient
    public ParlementaireAmendement getEntity() {
        if (entity.getId() == null) {
            ParlementaireAmendementConverter converter = UriResolver.getInstance().resolve(ParlementaireAmendementConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved ParlementaireAmendement entity.
     *
     * @return an resolved entity
     */
    public ParlementaireAmendement resolveEntity(EntityManager em) {
        return entity;
    }
}
