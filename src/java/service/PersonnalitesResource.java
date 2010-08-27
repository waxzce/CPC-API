/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.Collection;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.persistence.EntityManager;
import converter.PersonnalitesConverter;
import converter.PersonnaliteConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.Personnalite;

/**
 *
 * @author waxzce
 */

@Path("/personnalites/")
@Stateless
public class PersonnalitesResource {
    @javax.ejb.EJB
    private PersonnaliteResource personnaliteResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of PersonnalitesResource */
    public PersonnalitesResource() {
    }

    /**
     * Get method for retrieving a collection of Personnalite instance in XML format.
     *
     * @return an instance of PersonnalitesConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public PersonnalitesConverter get(@QueryParam("start")
                                      @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM Personnalite e")
    String query) {
        return new PersonnalitesConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }

    /**
     * Returns a dynamic instance of PersonnaliteResource used for entity navigation.
     *
     * @return an instance of PersonnaliteResource
     */
    @Path("{id}/")
    public PersonnaliteResource getPersonnaliteResource(@PathParam("id")
    Long id) {
        personnaliteResource.setId(id);
        personnaliteResource.setEm(em);
        return personnaliteResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of Personnalite instances
     */
    protected Collection<Personnalite> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(Personnalite entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
