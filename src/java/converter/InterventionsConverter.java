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
import org.regardscitoyen.cpcapi.Intervention;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "interventions")
public class InterventionsConverter {
    private Collection<Intervention> entities;
    private Collection<InterventionConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of InterventionsConverter */
    public InterventionsConverter() {
    }

    /**
     * Creates a new instance of InterventionsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public InterventionsConverter(Collection<Intervention> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getIntervention();
    }

    /**
     * Returns a collection of InterventionConverter.
     *
     * @return a collection of InterventionConverter
     */
    @XmlElement
    public Collection<InterventionConverter> getIntervention() {
        if (items == null) {
            items = new ArrayList<InterventionConverter>();
        }
        if (entities != null) {
            items.clear();
            for (Intervention entity : entities) {
                items.add(new InterventionConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of InterventionConverter.
     *
     * @param a collection of InterventionConverter to set
     */
    public void setIntervention(Collection<InterventionConverter> items) {
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
     * Returns a collection Intervention entities.
     *
     * @return a collection of Intervention entities
     */
    @XmlTransient
    public Collection<Intervention> getEntities() {
        entities = new ArrayList<Intervention>();
        if (items != null) {
            for (InterventionConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
