/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.WebApplicationException;
import javax.persistence.NoResultException;
import javax.persistence.EntityManager;
import converter.QuestionEcriteConverter;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.QuestionEcrite;

/**
 *
 * @author waxzce
 */

@Stateless
public class QuestionEcriteResource {
    @Context
    protected UriInfo uriInfo;
    protected EntityManager em;
    protected Long id;
  
    /** Creates a new instance of QuestionEcriteResource */
    public QuestionEcriteResource() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * Get method for retrieving an instance of QuestionEcrite identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of QuestionEcriteConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public QuestionEcriteConverter get(@QueryParam("expandLevel")
                                       @DefaultValue("1")
    int expandLevel) {
        return new QuestionEcriteConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
    }

    

    /**
     * Returns an instance of QuestionEcrite identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of QuestionEcrite
     */
    protected QuestionEcrite getEntity() {
        try {
            return (QuestionEcrite) em.createQuery("SELECT e FROM QuestionEcrite e where e.id = :id").setParameter("id", id).getSingleResult();
        } catch (NoResultException ex) {
            throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
        }
    }

    /**
     * Updates entity using data from newEntity.
     *
     * @param entity the entity to update
     * @param newEntity the entity containing the new data
     * @return the updated entity
     */
    private QuestionEcrite updateEntity(QuestionEcrite entity, QuestionEcrite newEntity) {
        entity = em.merge(newEntity);
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(QuestionEcrite entity) {
        em.remove(entity);
    }
}
