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
import org.regardscitoyen.cpcapi.Personnalite;

/**
 *
 * @author waxzce
 */

@XmlRootElement(name = "personnalites")
public class PersonnalitesConverter {
    private Collection<Personnalite> entities;
    private Collection<PersonnaliteConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PersonnalitesConverter */
    public PersonnalitesConverter() {
    }

    /**
     * Creates a new instance of PersonnalitesConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PersonnalitesConverter(Collection<Personnalite> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getPersonnalite();
    }

    /**
     * Returns a collection of PersonnaliteConverter.
     *
     * @return a collection of PersonnaliteConverter
     */
    @XmlElement
    public Collection<PersonnaliteConverter> getPersonnalite() {
        if (items == null) {
            items = new ArrayList<PersonnaliteConverter>();
        }
        if (entities != null) {
            items.clear();
            for (Personnalite entity : entities) {
                items.add(new PersonnaliteConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of PersonnaliteConverter.
     *
     * @param a collection of PersonnaliteConverter to set
     */
    public void setPersonnalite(Collection<PersonnaliteConverter> items) {
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
     * Returns a collection Personnalite entities.
     *
     * @return a collection of Personnalite entities
     */
    @XmlTransient
    public Collection<Personnalite> getEntities() {
        entities = new ArrayList<Personnalite>();
        if (items != null) {
            for (PersonnaliteConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
