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
import converter.PresencesConverter;
import converter.PresenceConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.Presence;

/**
 *
 * @author waxzce
 */

@Path("/presences/")
@Stateless
public class PresencesResource {
    @javax.ejb.EJB
    private PresenceResource presenceResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of PresencesResource */
    public PresencesResource() {
    }

    /**
     * Get method for retrieving a collection of Presence instance in XML format.
     *
     * @return an instance of PresencesConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public PresencesConverter get(@QueryParam("start")
                                  @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM Presence e")
    String query) {
        return new PresencesConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }

    

    /**
     * Returns a dynamic instance of PresenceResource used for entity navigation.
     *
     * @return an instance of PresenceResource
     */
    @Path("{id}/")
    public PresenceResource getPresenceResource(@PathParam("id")
    Long id) {
        presenceResource.setId(id);
        presenceResource.setEm(em);
        return presenceResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of Presence instances
     */
    protected Collection<Presence> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(Presence entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
