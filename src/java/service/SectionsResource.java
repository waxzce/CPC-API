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
import converter.SectionsConverter;
import converter.SectionConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.Section;

/**
 *
 * @author waxzce
 */

@Path("/sections/")
@Stateless
public class SectionsResource {
    @javax.ejb.EJB
    private SectionResource sectionResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of SectionsResource */
    public SectionsResource() {
    }

    /**
     * Get method for retrieving a collection of Section instance in XML format.
     *
     * @return an instance of SectionsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SectionsConverter get(@QueryParam("start")
                                 @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM Section e")
    String query) {
        return new SectionsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }

    /**
     * Returns a dynamic instance of SectionResource used for entity navigation.
     *
     * @return an instance of SectionResource
     */
    @Path("{id}/")
    public SectionResource getSectionResource(@PathParam("id")
    Long id) {
        sectionResource.setId(id);
        sectionResource.setEm(em);
        return sectionResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of Section instances
     */
    protected Collection<Section> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(Section entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
