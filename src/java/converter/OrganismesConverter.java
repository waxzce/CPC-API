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
import org.regardscitoyen.cpcapi.Organisme;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "organismes")
public class OrganismesConverter {
    private Collection<Organisme> entities;
    private Collection<OrganismeConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of OrganismesConverter */
    public OrganismesConverter() {
    }

    /**
     * Creates a new instance of OrganismesConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public OrganismesConverter(Collection<Organisme> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getOrganisme();
    }

    /**
     * Returns a collection of OrganismeConverter.
     *
     * @return a collection of OrganismeConverter
     */
    @XmlElement
    public Collection<OrganismeConverter> getOrganisme() {
        if (items == null) {
            items = new ArrayList<OrganismeConverter>();
        }
        if (entities != null) {
            items.clear();
            for (Organisme entity : entities) {
                items.add(new OrganismeConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of OrganismeConverter.
     *
     * @param a collection of OrganismeConverter to set
     */
    public void setOrganisme(Collection<OrganismeConverter> items) {
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
     * Returns a collection Organisme entities.
     *
     * @return a collection of Organisme entities
     */
    @XmlTransient
    public Collection<Organisme> getEntities() {
        entities = new ArrayList<Organisme>();
        if (items != null) {
            for (OrganismeConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
