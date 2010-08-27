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
import converter.ParlementaireOrganismesConverter;
import converter.ParlementaireOrganismeConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.ParlementaireOrganisme;

/**
 *
 * @author waxzce
 */

@Path("/parlementaireOrganismes/")
@Stateless
public class ParlementaireOrganismesResource {
    @javax.ejb.EJB
    private ParlementaireOrganismeResource parlementaireOrganismeResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of ParlementaireOrganismesResource */
    public ParlementaireOrganismesResource() {
    }

    /**
     * Get method for retrieving a collection of ParlementaireOrganisme instance in XML format.
     *
     * @return an instance of ParlementaireOrganismesConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public ParlementaireOrganismesConverter get(@QueryParam("start")
                                                @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM ParlementaireOrganisme e")
    String query) {
        return new ParlementaireOrganismesConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }

    

    /**
     * Returns a dynamic instance of ParlementaireOrganismeResource used for entity navigation.
     *
     * @return an instance of ParlementaireOrganismeResource
     */
    @Path("{organismeId},{parlementaireId}/")
    public ParlementaireOrganismeResource getParlementaireOrganismeResource(@PathParam("organismeId")
    Long id1, @PathParam("parlementaireId")
    Long id2) {
        parlementaireOrganismeResource.setId1(id1);
        parlementaireOrganismeResource.setEm(em);
        parlementaireOrganismeResource.setId2(id2);
        parlementaireOrganismeResource.setEm(em);
        return parlementaireOrganismeResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of ParlementaireOrganisme instances
     */
    protected Collection<ParlementaireOrganisme> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(ParlementaireOrganisme entity) {
        em.persist(entity);
    }
}
