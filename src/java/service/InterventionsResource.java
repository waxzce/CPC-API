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
import converter.InterventionsConverter;
import converter.InterventionConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.Intervention;

/**
 *
 * @author waxzce
 */

@Path("/interventions/")
@Stateless
public class InterventionsResource {
    @javax.ejb.EJB
    private InterventionResource interventionResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of InterventionsResource */
    public InterventionsResource() {
    }

    /**
     * Get method for retrieving a collection of Intervention instance in XML format.
     *
     * @return an instance of InterventionsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public InterventionsConverter get(@QueryParam("start")
                                      @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM Intervention e")
    String query) {
        return new InterventionsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }


    /**
     * Returns a dynamic instance of InterventionResource used for entity navigation.
     *
     * @return an instance of InterventionResource
     */
    @Path("{id}/")
    public InterventionResource getInterventionResource(@PathParam("id")
    Long id) {
        interventionResource.setId(id);
        interventionResource.setEm(em);
        return interventionResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of Intervention instances
     */
    protected Collection<Intervention> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(Intervention entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
