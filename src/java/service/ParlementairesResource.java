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
import converter.ParlementairesConverter;
import converter.ParlementaireConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.Parlementaire;

/**
 *
 * @author waxzce
 */

@Path("/parlementaires/")
@Stateless
public class ParlementairesResource {
    @javax.ejb.EJB
    private ParlementaireResource parlementaireResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "cpcapiPU")
    protected EntityManager em;
  
    /** Creates a new instance of ParlementairesResource */
    public ParlementairesResource() {
    }

    /**
     * Get method for retrieving a collection of Parlementaire instance in XML format.
     *
     * @return an instance of ParlementairesConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public ParlementairesConverter get(@QueryParam("start")
                                       @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM Parlementaire e")
    String query) {
        return new ParlementairesConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }

    
    /**
     * Returns a dynamic instance of ParlementaireResource used for entity navigation.
     *
     * @return an instance of ParlementaireResource
     */
    @Path("{id}/")
    public ParlementaireResource getParlementaireResource(@PathParam("id")
    Long id) {
        parlementaireResource.setId(id);
        parlementaireResource.setEm(em);
        return parlementaireResource;
    }

    /**
     * Returns a dynamic instance of ParlementaireResource used for entity navigation.
     *
     * @return an instance of ParlementaireResource
     */
    @Path("/byslug/{slug}/")
    public ParlementaireResource getParlementaireResourceBySlug(@PathParam("slug")
    String slug) {
        parlementaireResource.setSlug(slug);
        parlementaireResource.setEm(em);
        return parlementaireResource;
    }

    /**
     * Returns jpeg photo for parlementaire slug
     *
     * @return a byte stream, jpeg photo
     */
    @GET
    @Path("/byslug/{slug}/photo")
    @Produces("image/jpeg")
    public byte[] getParlementairePhotoBySlug(@PathParam("slug")
    String slug) {
        parlementaireResource.setSlug(slug);
        parlementaireResource.setEm(em);
        return parlementaireResource.getPhoto();
    }

     /**
     * Returns jpeg photo for parlementaire id
     *
     * @return a byte stream, jpeg photo
     */
    @GET
    @Path("/{id}/photo")
    @Produces("image/jpeg")
    public byte[] getParlementairePhotoBySlug(@PathParam("id")
    Long id) {
        parlementaireResource.setId(id);
        parlementaireResource.setEm(em);
        return parlementaireResource.getPhoto();
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of Parlementaire instances
     */
    protected Collection<Parlementaire> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(Parlementaire entity) {
        entity.setId(null);
        em.persist(entity);
    }
}
