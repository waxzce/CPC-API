/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.Personnalite;
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

@XmlRootElement(name = "personnalite")
public class PersonnaliteConverter {
    private Personnalite entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PersonnaliteConverter */
    public PersonnaliteConverter() {
        entity = new Personnalite();
    }

    /**
     * Creates a new instance of PersonnaliteConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public PersonnaliteConverter(Personnalite entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of PersonnaliteConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PersonnaliteConverter(Personnalite entity, URI uri, int expandLevel) {
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
     * Returns the Personnalite entity.
     *
     * @return an entity
     */
    @XmlTransient
    public Personnalite getEntity() {
        if (entity.getId() == null) {
            PersonnaliteConverter converter = UriResolver.getInstance().resolve(PersonnaliteConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved Personnalite entity.
     *
     * @return an resolved entity
     */
    public Personnalite resolveEntity(EntityManager em) {
        return entity;
    }
}
