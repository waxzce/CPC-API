/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.ParlementaireOrganisme;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import org.regardscitoyen.cpcapi.ParlementaireOrganismePK;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "parlementaireOrganisme")
public class ParlementaireOrganismeConverter {
    private ParlementaireOrganisme entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ParlementaireOrganismeConverter */
    public ParlementaireOrganismeConverter() {
        entity = new ParlementaireOrganisme();
    }

    /**
     * Creates a new instance of ParlementaireOrganismeConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public ParlementaireOrganismeConverter(ParlementaireOrganisme entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getParlementaireOrganismePK().getOrganismeId() + "," + entity.getParlementaireOrganismePK().getParlementaireId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of ParlementaireOrganismeConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ParlementaireOrganismeConverter(ParlementaireOrganisme entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for parlementaireOrganismePK.
     *
     * @return value for parlementaireOrganismePK
     */
    @XmlElement
    public ParlementaireOrganismePK getParlementaireOrganismePK() {
        return (expandLevel > 0) ? entity.getParlementaireOrganismePK() : null;
    }

    /**
     * Setter for parlementaireOrganismePK.
     *
     * @param value the value to set
     */
    public void setParlementaireOrganismePK(ParlementaireOrganismePK value) {
        entity.setParlementaireOrganismePK(value);
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
     * Getter for importance.
     *
     * @return value for importance
     */
    @XmlElement
    public BigInteger getImportance() {
        return (expandLevel > 0) ? entity.getImportance() : null;
    }

    /**
     * Setter for importance.
     *
     * @param value the value to set
     */
    public void setImportance(BigInteger value) {
        entity.setImportance(value);
    }

    /**
     * Getter for debutFonction.
     *
     * @return value for debutFonction
     */
    @XmlElement
    public Date getDebutFonction() {
        return (expandLevel > 0) ? entity.getDebutFonction() : null;
    }

    /**
     * Setter for debutFonction.
     *
     * @param value the value to set
     */
    public void setDebutFonction(Date value) {
        entity.setDebutFonction(value);
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
     * Returns the ParlementaireOrganisme entity.
     *
     * @return an entity
     */
    @XmlTransient
    public ParlementaireOrganisme getEntity() {
        if (entity.getParlementaireOrganismePK() == null) {
            ParlementaireOrganismeConverter converter = UriResolver.getInstance().resolve(ParlementaireOrganismeConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved ParlementaireOrganisme entity.
     *
     * @return an resolved entity
     */
    public ParlementaireOrganisme resolveEntity(EntityManager em) {
        return entity;
    }
}
