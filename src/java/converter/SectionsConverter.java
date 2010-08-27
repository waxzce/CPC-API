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
import org.regardscitoyen.cpcapi.Section;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "sections")
public class SectionsConverter {
    private Collection<Section> entities;
    private Collection<SectionConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SectionsConverter */
    public SectionsConverter() {
    }

    /**
     * Creates a new instance of SectionsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SectionsConverter(Collection<Section> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getSection();
    }

    /**
     * Returns a collection of SectionConverter.
     *
     * @return a collection of SectionConverter
     */
    @XmlElement
    public Collection<SectionConverter> getSection() {
        if (items == null) {
            items = new ArrayList<SectionConverter>();
        }
        if (entities != null) {
            items.clear();
            for (Section entity : entities) {
                items.add(new SectionConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of SectionConverter.
     *
     * @param a collection of SectionConverter to set
     */
    public void setSection(Collection<SectionConverter> items) {
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
     * Returns a collection Section entities.
     *
     * @return a collection of Section entities
     */
    @XmlTransient
    public Collection<Section> getEntities() {
        entities = new ArrayList<Section>();
        if (items != null) {
            for (SectionConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
