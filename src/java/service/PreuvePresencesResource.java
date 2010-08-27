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
import converter.PreuvePresencesConverter;
import converter.PreuvePresenceConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.PreuvePresence;

/**
 *
 * @author waxzce
 */

@Path("/preuvePresences/")
@Stateless
public class PreuvePresencesResource {
    @javax.ejb.EJB
    private PreuvePresenceResource preuvePresenceResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of PreuvePresencesResource */
    public PreuvePresencesResource() {
    }

    /**
     * Get method for retrieving a collection of PreuvePresence instance in XML format.
     *
     * @return an instance of PreuvePresencesConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public PreuvePresencesConverter get(@QueryParam("start")
                                        @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM PreuvePresence e")
    String query) {
        return new PreuvePresencesConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }


    /**
     * Returns a dynamic instance of PreuvePresenceResource used for entity navigation.
     *
     * @return an instance of PreuvePresenceResource
     */
    @Path("{id}/")
    public PreuvePresenceResource getPreuvePresenceResource(@PathParam("id")
    Long id) {
        preuvePresenceResource.setId(id);
        preuvePresenceResource.setEm(em);
        return preuvePresenceResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of PreuvePresence instances
     */
    protected Collection<PreuvePresence> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(PreuvePresence entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
