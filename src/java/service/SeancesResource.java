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
import converter.SeancesConverter;
import converter.SeanceConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.Seance;

/**
 *
 * @author waxzce
 */

@Path("/seances/")
@Stateless
public class SeancesResource {
    @javax.ejb.EJB
    private SeanceResource seanceResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of SeancesResource */
    public SeancesResource() {
    }

    /**
     * Get method for retrieving a collection of Seance instance in XML format.
     *
     * @return an instance of SeancesConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SeancesConverter get(@QueryParam("start")
                                @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM Seance e")
    String query) {
        return new SeancesConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }


    /**
     * Returns a dynamic instance of SeanceResource used for entity navigation.
     *
     * @return an instance of SeanceResource
     */
    @Path("{id}/")
    public SeanceResource getSeanceResource(@PathParam("id")
    Long id) {
        seanceResource.setId(id);
        seanceResource.setEm(em);
        return seanceResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of Seance instances
     */
    protected Collection<Seance> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(Seance entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
