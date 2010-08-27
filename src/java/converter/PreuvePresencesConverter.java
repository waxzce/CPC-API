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
import org.regardscitoyen.cpcapi.PreuvePresence;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "preuvePresences")
public class PreuvePresencesConverter {
    private Collection<PreuvePresence> entities;
    private Collection<PreuvePresenceConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PreuvePresencesConverter */
    public PreuvePresencesConverter() {
    }

    /**
     * Creates a new instance of PreuvePresencesConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PreuvePresencesConverter(Collection<PreuvePresence> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getPreuvePresence();
    }

    /**
     * Returns a collection of PreuvePresenceConverter.
     *
     * @return a collection of PreuvePresenceConverter
     */
    @XmlElement
    public Collection<PreuvePresenceConverter> getPreuvePresence() {
        if (items == null) {
            items = new ArrayList<PreuvePresenceConverter>();
        }
        if (entities != null) {
            items.clear();
            for (PreuvePresence entity : entities) {
                items.add(new PreuvePresenceConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of PreuvePresenceConverter.
     *
     * @param a collection of PreuvePresenceConverter to set
     */
    public void setPreuvePresence(Collection<PreuvePresenceConverter> items) {
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
     * Returns a collection PreuvePresence entities.
     *
     * @return a collection of PreuvePresence entities
     */
    @XmlTransient
    public Collection<PreuvePresence> getEntities() {
        entities = new ArrayList<PreuvePresence>();
        if (items != null) {
            for (PreuvePresenceConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
