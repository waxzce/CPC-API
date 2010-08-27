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
import org.regardscitoyen.cpcapi.Parlementaire;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "parlementaires")
public class ParlementairesConverter {
    private Collection<Parlementaire> entities;
    private Collection<ParlementaireConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ParlementairesConverter */
    public ParlementairesConverter() {
    }

    /**
     * Creates a new instance of ParlementairesConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ParlementairesConverter(Collection<Parlementaire> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getParlementaire();
    }

    /**
     * Returns a collection of ParlementaireConverter.
     *
     * @return a collection of ParlementaireConverter
     */
    @XmlElement
    public Collection<ParlementaireConverter> getParlementaire() {
        if (items == null) {
            items = new ArrayList<ParlementaireConverter>();
        }
        if (entities != null) {
            items.clear();
            for (Parlementaire entity : entities) {
                items.add(new ParlementaireConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of ParlementaireConverter.
     *
     * @param a collection of ParlementaireConverter to set
     */
    public void setParlementaire(Collection<ParlementaireConverter> items) {
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
     * Returns a collection Parlementaire entities.
     *
     * @return a collection of Parlementaire entities
     */
    @XmlTransient
    public Collection<Parlementaire> getEntities() {
        entities = new ArrayList<Parlementaire>();
        if (items != null) {
            for (ParlementaireConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
