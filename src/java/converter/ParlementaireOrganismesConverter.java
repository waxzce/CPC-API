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
import org.regardscitoyen.cpcapi.ParlementaireOrganisme;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "parlementaireOrganismes")
public class ParlementaireOrganismesConverter {
    private Collection<ParlementaireOrganisme> entities;
    private Collection<ParlementaireOrganismeConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ParlementaireOrganismesConverter */
    public ParlementaireOrganismesConverter() {
    }

    /**
     * Creates a new instance of ParlementaireOrganismesConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ParlementaireOrganismesConverter(Collection<ParlementaireOrganisme> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getParlementaireOrganisme();
    }

    /**
     * Returns a collection of ParlementaireOrganismeConverter.
     *
     * @return a collection of ParlementaireOrganismeConverter
     */
    @XmlElement
    public Collection<ParlementaireOrganismeConverter> getParlementaireOrganisme() {
        if (items == null) {
            items = new ArrayList<ParlementaireOrganismeConverter>();
        }
        if (entities != null) {
            items.clear();
            for (ParlementaireOrganisme entity : entities) {
                items.add(new ParlementaireOrganismeConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of ParlementaireOrganismeConverter.
     *
     * @param a collection of ParlementaireOrganismeConverter to set
     */
    public void setParlementaireOrganisme(Collection<ParlementaireOrganismeConverter> items) {
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
     * Returns a collection ParlementaireOrganisme entities.
     *
     * @return a collection of ParlementaireOrganisme entities
     */
    @XmlTransient
    public Collection<ParlementaireOrganisme> getEntities() {
        entities = new ArrayList<ParlementaireOrganisme>();
        if (items != null) {
            for (ParlementaireOrganismeConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
