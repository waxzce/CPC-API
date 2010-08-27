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
import org.regardscitoyen.cpcapi.Amendement;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "amendements")
public class AmendementsConverter {
    private Collection<Amendement> entities;
    private Collection<AmendementConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of AmendementsConverter */
    public AmendementsConverter() {
    }

    /**
     * Creates a new instance of AmendementsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public AmendementsConverter(Collection<Amendement> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getAmendement();
    }

    /**
     * Returns a collection of AmendementConverter.
     *
     * @return a collection of AmendementConverter
     */
    @XmlElement
    public Collection<AmendementConverter> getAmendement() {
        if (items == null) {
            items = new ArrayList<AmendementConverter>();
        }
        if (entities != null) {
            items.clear();
            for (Amendement entity : entities) {
                items.add(new AmendementConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of AmendementConverter.
     *
     * @param a collection of AmendementConverter to set
     */
    public void setAmendement(Collection<AmendementConverter> items) {
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
     * Returns a collection Amendement entities.
     *
     * @return a collection of Amendement entities
     */
    @XmlTransient
    public Collection<Amendement> getEntities() {
        entities = new ArrayList<Amendement>();
        if (items != null) {
            for (AmendementConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
