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
import org.regardscitoyen.cpcapi.ParlementaireAmendement;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "parlementaireAmendements")
public class ParlementaireAmendementsConverter {
    private Collection<ParlementaireAmendement> entities;
    private Collection<ParlementaireAmendementConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ParlementaireAmendementsConverter */
    public ParlementaireAmendementsConverter() {
    }

    /**
     * Creates a new instance of ParlementaireAmendementsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ParlementaireAmendementsConverter(Collection<ParlementaireAmendement> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getParlementaireAmendement();
    }

    /**
     * Returns a collection of ParlementaireAmendementConverter.
     *
     * @return a collection of ParlementaireAmendementConverter
     */
    @XmlElement
    public Collection<ParlementaireAmendementConverter> getParlementaireAmendement() {
        if (items == null) {
            items = new ArrayList<ParlementaireAmendementConverter>();
        }
        if (entities != null) {
            items.clear();
            for (ParlementaireAmendement entity : entities) {
                items.add(new ParlementaireAmendementConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of ParlementaireAmendementConverter.
     *
     * @param a collection of ParlementaireAmendementConverter to set
     */
    public void setParlementaireAmendement(Collection<ParlementaireAmendementConverter> items) {
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
     * Returns a collection ParlementaireAmendement entities.
     *
     * @return a collection of ParlementaireAmendement entities
     */
    @XmlTransient
    public Collection<ParlementaireAmendement> getEntities() {
        entities = new ArrayList<ParlementaireAmendement>();
        if (items != null) {
            for (ParlementaireAmendementConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
