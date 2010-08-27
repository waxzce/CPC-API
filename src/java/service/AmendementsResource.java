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
import converter.AmendementsConverter;
import converter.AmendementConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.Amendement;

/**
 *
 * @author waxzce
 */

@Path("/amendements/")
@Stateless
public class AmendementsResource {
    @javax.ejb.EJB
    private AmendementResource amendementResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of AmendementsResource */
    public AmendementsResource() {
    }

    /**
     * Get method for retrieving a collection of Amendement instance in XML format.
     *
     * @return an instance of AmendementsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public AmendementsConverter get(@QueryParam("start")
                                    @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM Amendement e")
    String query) {
        return new AmendementsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }

    

    /**
     * Returns a dynamic instance of AmendementResource used for entity navigation.
     *
     * @return an instance of AmendementResource
     */
    @Path("{id}/")
    public AmendementResource getAmendementResource(@PathParam("id")
    Long id) {
        amendementResource.setId(id);
        amendementResource.setEm(em);
        return amendementResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of Amendement instances
     */
    protected Collection<Amendement> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(Amendement entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
