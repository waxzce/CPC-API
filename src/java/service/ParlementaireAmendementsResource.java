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
import converter.ParlementaireAmendementsConverter;
import converter.ParlementaireAmendementConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.ParlementaireAmendement;

/**
 *
 * @author waxzce
 */

@Path("/parlementaireAmendements/")
@Stateless
public class ParlementaireAmendementsResource {
    @javax.ejb.EJB
    private ParlementaireAmendementResource parlementaireAmendementResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of ParlementaireAmendementsResource */
    public ParlementaireAmendementsResource() {
    }

    /**
     * Get method for retrieving a collection of ParlementaireAmendement instance in XML format.
     *
     * @return an instance of ParlementaireAmendementsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public ParlementaireAmendementsConverter get(@QueryParam("start")
                                                 @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM ParlementaireAmendement e")
    String query) {
        return new ParlementaireAmendementsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }

    /**
     * Returns a dynamic instance of ParlementaireAmendementResource used for entity navigation.
     *
     * @return an instance of ParlementaireAmendementResource
     */
    @Path("{id}/")
    public ParlementaireAmendementResource getParlementaireAmendementResource(@PathParam("id")
    Long id) {
        parlementaireAmendementResource.setId(id);
        parlementaireAmendementResource.setEm(em);
        return parlementaireAmendementResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of ParlementaireAmendement instances
     */
    protected Collection<ParlementaireAmendement> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(ParlementaireAmendement entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
