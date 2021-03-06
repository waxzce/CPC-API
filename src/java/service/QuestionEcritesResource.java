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
import converter.QuestionEcritesConverter;
import converter.QuestionEcriteConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.QuestionEcrite;

/**
 *
 * @author waxzce
 */

@Path("/questionEcrites/")
@Stateless
public class QuestionEcritesResource {
    @javax.ejb.EJB
    private QuestionEcriteResource questionEcriteResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of QuestionEcritesResource */
    public QuestionEcritesResource() {
    }

    /**
     * Get method for retrieving a collection of QuestionEcrite instance in XML format.
     *
     * @return an instance of QuestionEcritesConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public QuestionEcritesConverter get(@QueryParam("start")
                                        @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM QuestionEcrite e")
    String query) {
        return new QuestionEcritesConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }


    /**
     * Returns a dynamic instance of QuestionEcriteResource used for entity navigation.
     *
     * @return an instance of QuestionEcriteResource
     */
    @Path("{id}/")
    public QuestionEcriteResource getQuestionEcriteResource(@PathParam("id")
    Long id) {
        questionEcriteResource.setId(id);
        questionEcriteResource.setEm(em);
        return questionEcriteResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of QuestionEcrite instances
     */
    protected Collection<QuestionEcrite> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(QuestionEcrite entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
