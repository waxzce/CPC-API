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
import converter.ParlementaireOrganismeConverter;
import javax.ejb.Stateless;
import org.regardscitoyen.cpcapi.ParlementaireOrganisme;

/**
 *
 * @author waxzce
 */

@Stateless
public class ParlementaireOrganismeResource {
    @Context
    protected UriInfo uriInfo;
    protected EntityManager em;
    protected Long id2;
    protected Long id1;
  
    /** Creates a new instance of ParlementaireOrganismeResource */
    public ParlementaireOrganismeResource() {
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * Get method for retrieving an instance of ParlementaireOrganisme identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of ParlementaireOrganismeConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public ParlementaireOrganismeConverter get(@QueryParam("expandLevel")
                                               @DefaultValue("1")
    int expandLevel) {
        return new ParlementaireOrganismeConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
    }

    

    /**
     * Returns an instance of ParlementaireOrganisme identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of ParlementaireOrganisme
     */
    protected ParlementaireOrganisme getEntity() {
        try {
            org.regardscitoyen.cpcapi.ParlementaireOrganismePK id = new org.regardscitoyen.cpcapi.ParlementaireOrganismePK(id1, id2);
            return (ParlementaireOrganisme) em.createQuery("SELECT e FROM ParlementaireOrganisme e where e.parlementaireOrganismePK = :parlementaireOrganismePK").setParameter("parlementaireOrganismePK", id).getSingleResult();
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
    private ParlementaireOrganisme updateEntity(ParlementaireOrganisme entity, ParlementaireOrganisme newEntity) {
        entity = em.merge(newEntity);
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(ParlementaireOrganisme entity) {
        em.remove(entity);
    }
}
