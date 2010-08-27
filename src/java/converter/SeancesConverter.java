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
import org.regardscitoyen.cpcapi.Seance;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "seances")
public class SeancesConverter {
    private Collection<Seance> entities;
    private Collection<SeanceConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SeancesConverter */
    public SeancesConverter() {
    }

    /**
     * Creates a new instance of SeancesConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SeancesConverter(Collection<Seance> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getSeance();
    }

    /**
     * Returns a collection of SeanceConverter.
     *
     * @return a collection of SeanceConverter
     */
    @XmlElement
    public Collection<SeanceConverter> getSeance() {
        if (items == null) {
            items = new ArrayList<SeanceConverter>();
        }
        if (entities != null) {
            items.clear();
            for (Seance entity : entities) {
                items.add(new SeanceConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of SeanceConverter.
     *
     * @param a collection of SeanceConverter to set
     */
    public void setSeance(Collection<SeanceConverter> items) {
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
     * Returns a collection Seance entities.
     *
     * @return a collection of Seance entities
     */
    @XmlTransient
    public Collection<Seance> getEntities() {
        entities = new ArrayList<Seance>();
        if (items != null) {
            for (SeanceConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
