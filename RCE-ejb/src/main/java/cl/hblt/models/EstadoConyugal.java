/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edwin Guaman
 */
@Entity
@Table(name = "EstadoConyugal")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "EstadoConyugal.findAll", query = "SELECT e FROM EstadoConyugal e"),
  @NamedQuery(name = "EstadoConyugal.findByIdEstadoconyugal", query = "SELECT e FROM EstadoConyugal e WHERE e.idEstadoconyugal = :idEstadoconyugal"),
  @NamedQuery(name = "EstadoConyugal.findByEscoNombre", query = "SELECT e FROM EstadoConyugal e WHERE e.escoNombre = :escoNombre")})
public class EstadoConyugal implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_estadoconyugal")
  private Integer idEstadoconyugal;
  @Size(max = 50)
  @Column(name = "esco_nombre")
  private String escoNombre;
  @OneToMany(mappedBy = "idEstadoconyugal")
  private Collection<Persona> personaCollection;

  public EstadoConyugal() {
  }

  public EstadoConyugal(Integer idEstadoconyugal) {
    this.idEstadoconyugal = idEstadoconyugal;
  }

  public Integer getIdEstadoconyugal() {
    return idEstadoconyugal;
  }

  public void setIdEstadoconyugal(Integer idEstadoconyugal) {
    this.idEstadoconyugal = idEstadoconyugal;
  }

  public String getEscoNombre() {
    return escoNombre;
  }

  public void setEscoNombre(String escoNombre) {
    this.escoNombre = escoNombre;
  }

  @XmlTransient
  public Collection<Persona> getPersonaCollection() {
    return personaCollection;
  }

  public void setPersonaCollection(Collection<Persona> personaCollection) {
    this.personaCollection = personaCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idEstadoconyugal != null ? idEstadoconyugal.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EstadoConyugal)) {
      return false;
    }
    EstadoConyugal other = (EstadoConyugal) object;
    if ((this.idEstadoconyugal == null && other.idEstadoconyugal != null) || (this.idEstadoconyugal != null && !this.idEstadoconyugal.equals(other.idEstadoconyugal))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.EstadoConyugal[ idEstadoconyugal=" + idEstadoconyugal + " ]";
  }
  
}
