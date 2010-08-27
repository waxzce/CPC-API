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
import converter.OrganismesConverter;
import converter.OrganismeConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.Organisme;

/**
 *
 * @author waxzce
 */

@Path("/organismes/")
@Stateless
public class OrganismesResource {
    @javax.ejb.EJB
    private OrganismeResource organismeResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of OrganismesResource */
    public OrganismesResource() {
    }

    /**
     * Get method for retrieving a collection of Organisme instance in XML format.
     *
     * @return an instance of OrganismesConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public OrganismesConverter get(@QueryParam("start")
                                   @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM Organisme e")
    String query) {
        return new OrganismesConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }


    /**
     * Returns a dynamic instance of OrganismeResource used for entity navigation.
     *
     * @return an instance of OrganismeResource
     */
    @Path("{id}/")
    public OrganismeResource getOrganismeResource(@PathParam("id")
    Long id) {
        organismeResource.setId(id);
        organismeResource.setEm(em);
        return organismeResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of Organisme instances
     */
    protected Collection<Organisme> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(Organisme entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
