/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import org.regardscitoyen.cpcapi.QuestionEcrite;
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

@XmlRootElement(name = "questionEcrite")
public class QuestionEcriteConverter {
    private QuestionEcrite entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of QuestionEcriteConverter */
    public QuestionEcriteConverter() {
        entity = new QuestionEcrite();
    }

    /**
     * Creates a new instance of QuestionEcriteConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public QuestionEcriteConverter(QuestionEcrite entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of QuestionEcriteConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public QuestionEcriteConverter(QuestionEcrite entity, URI uri, int expandLevel) {
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
     * Getter for numero.
     *
     * @return value for numero
     */
    @XmlElement
    public BigInteger getNumero() {
        return (expandLevel > 0) ? entity.getNumero() : null;
    }

    /**
     * Setter for numero.
     *
     * @param value the value to set
     */
    public void setNumero(BigInteger value) {
        entity.setNumero(value);
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
     * Getter for dateCloture.
     *
     * @return value for dateCloture
     */
    @XmlElement
    public Date getDateCloture() {
        return (expandLevel > 0) ? entity.getDateCloture() : null;
    }

    /**
     * Setter for dateCloture.
     *
     * @param value the value to set
     */
    public void setDateCloture(Date value) {
        entity.setDateCloture(value);
    }

    /**
     * Getter for ministere.
     *
     * @return value for ministere
     */
    @XmlElement
    public String getMinistere() {
        return (expandLevel > 0) ? entity.getMinistere() : null;
    }

    /**
     * Setter for ministere.
     *
     * @param value the value to set
     */
    public void setMinistere(String value) {
        entity.setMinistere(value);
    }

    /**
     * Getter for themes.
     *
     * @return value for themes
     */
    @XmlElement
    public String getThemes() {
        return (expandLevel > 0) ? entity.getThemes() : null;
    }

    /**
     * Setter for themes.
     *
     * @param value the value to set
     */
    public void setThemes(String value) {
        entity.setThemes(value);
    }

    /**
     * Getter for question.
     *
     * @return value for question
     */
    @XmlElement
    public String getQuestion() {
        return (expandLevel > 0) ? entity.getQuestion() : null;
    }

    /**
     * Setter for question.
     *
     * @param value the value to set
     */
    public void setQuestion(String value) {
        entity.setQuestion(value);
    }

    /**
     * Getter for reponse.
     *
     * @return value for reponse
     */
    @XmlElement
    public String getReponse() {
        return (expandLevel > 0) ? entity.getReponse() : null;
    }

    /**
     * Setter for reponse.
     *
     * @param value the value to set
     */
    public void setReponse(String value) {
        entity.setReponse(value);
    }

    /**
     * Getter for motifRetrait.
     *
     * @return value for motifRetrait
     */
    @XmlElement
    public String getMotifRetrait() {
        return (expandLevel > 0) ? entity.getMotifRetrait() : null;
    }

    /**
     * Setter for motifRetrait.
     *
     * @param value the value to set
     */
    public void setMotifRetrait(String value) {
        entity.setMotifRetrait(value);
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
     * Returns the QuestionEcrite entity.
     *
     * @return an entity
     */
    @XmlTransient
    public QuestionEcrite getEntity() {
        if (entity.getId() == null) {
            QuestionEcriteConverter converter = UriResolver.getInstance().resolve(QuestionEcriteConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved QuestionEcrite entity.
     *
     * @return an resolved entity
     */
    public QuestionEcrite resolveEntity(EntityManager em) {
        return entity;
    }
}
