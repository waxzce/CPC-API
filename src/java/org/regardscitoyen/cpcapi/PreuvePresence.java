/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.regardscitoyen.cpcapi;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author waxzce
 */
@Entity
@Table(name = "preuve_presence")
@NamedQueries({
    @NamedQuery(name = "PreuvePresence.findAll", query = "SELECT p FROM PreuvePresence p"),
    @NamedQuery(name = "PreuvePresence.findById", query = "SELECT p FROM PreuvePresence p WHERE p.id = :id"),
    @NamedQuery(name = "PreuvePresence.findByPresenceId", query = "SELECT p FROM PreuvePresence p WHERE p.presenceId = :presenceId"),
    @NamedQuery(name = "PreuvePresence.findByType", query = "SELECT p FROM PreuvePresence p WHERE p.type = :type"),
    @NamedQuery(name = "PreuvePresence.findBySource", query = "SELECT p FROM PreuvePresence p WHERE p.source = :source"),
    @NamedQuery(name = "PreuvePresence.findByCreatedAt", query = "SELECT p FROM PreuvePresence p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "PreuvePresence.findByUpdatedAt", query = "SELECT p FROM PreuvePresence p WHERE p.updatedAt = :updatedAt")})
public class PreuvePresence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "presence_id")
    private BigInteger presenceId;
    @Column(name = "type")
    private String type;
    @Column(name = "source")
    private String source;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public PreuvePresence() {
    }

    public PreuvePresence(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getPresenceId() {
        return presenceId;
    }

    public void setPresenceId(BigInteger presenceId) {
        this.presenceId = presenceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreuvePresence)) {
            return false;
        }
        PreuvePresence other = (PreuvePresence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.regardscitoyen.cpcapi.PreuvePresence[id=" + id + "]";
    }

}
