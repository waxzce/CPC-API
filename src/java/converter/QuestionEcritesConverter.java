/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.net.URI;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.ArrayList;
import org.regardscitoyen.cpcapi.QuestionEcrite;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "questionEcrites")
public class QuestionEcritesConverter {
    private Collection<QuestionEcrite> entities;
    private Collection<QuestionEcriteConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of QuestionEcritesConverter */
    public QuestionEcritesConverter() {
    }

    /**
     * Creates a new instance of QuestionEcritesConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public QuestionEcritesConverter(Collection<QuestionEcrite> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getQuestionEcrite();
    }

    /**
     * Returns a collection of QuestionEcriteConverter.
     *
     * @return a collection of QuestionEcriteConverter
     */
    @XmlElement
    public Collection<QuestionEcriteConverter> getQuestionEcrite() {
        if (items == null) {
            items = new ArrayList<QuestionEcriteConverter>();
        }
        if (entities != null) {
            items.clear();
            for (QuestionEcrite entity : entities) {
                items.add(new QuestionEcriteConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of QuestionEcriteConverter.
     *
     * @param a collection of QuestionEcriteConverter to set
     */
    public void setQuestionEcrite(Collection<QuestionEcriteConverter> items) {
        this.items = items;
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
     * Returns a collection QuestionEcrite entities.
     *
     * @return a collection of QuestionEcrite entities
     */
    @XmlTransient
    public Collection<QuestionEcrite> getEntities() {
        entities = new ArrayList<QuestionEcrite>();
        if (items != null) {
            for (QuestionEcriteConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
