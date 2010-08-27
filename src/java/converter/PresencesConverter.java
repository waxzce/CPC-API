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
import org.regardscitoyen.cpcapi.Presence;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "presences")
public class PresencesConverter {
    private Collection<Presence> entities;
    private Collection<PresenceConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PresencesConverter */
    public PresencesConverter() {
    }

    /**
     * Creates a new instance of PresencesConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PresencesConverter(Collection<Presence> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getPresence();
    }

    /**
     * Returns a collection of PresenceConverter.
     *
     * @return a collection of PresenceConverter
     */
    @XmlElement
    public Collection<PresenceConverter> getPresence() {
        if (items == null) {
            items = new ArrayList<PresenceConverter>();
        }
        if (entities != null) {
            items.clear();
            for (Presence entity : entities) {
                items.add(new PresenceConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of PresenceConverter.
     *
     * @param a collection of PresenceConverter to set
     */
    public void setPresence(Collection<PresenceConverter> items) {
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
     * Returns a collection Presence entities.
     *
     * @return a collection of Presence entities
     */
    @XmlTransient
    public Collection<Presence> getEntities() {
        entities = new ArrayList<Presence>();
        if (items != null) {
            for (PresenceConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
