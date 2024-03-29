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
@Table(name = "Especialidad")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
  @NamedQuery(name = "Especialidad.findByIdEspecialidad", query = "SELECT e FROM Especialidad e WHERE e.idEspecialidad = :idEspecialidad"),
  @NamedQuery(name = "Especialidad.findByEspeNombre", query = "SELECT e FROM Especialidad e WHERE e.espeNombre = :espeNombre"),
  @NamedQuery(name = "Especialidad.findByEspeActivo", query = "SELECT e FROM Especialidad e WHERE e.espeActivo = :espeActivo")})
public class Especialidad implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_especialidad")
  private Integer idEspecialidad;
  @Size(max = 256)
  @Column(name = "espe_nombre")
  private String espeNombre;
  @Column(name = "espe_activo")
  private Boolean espeActivo;
  @OneToMany(mappedBy = "idEspecialidad")
  private Collection<SubEspecialidad> subEspecialidadCollection;

  public Especialidad() {
  }

  public Especialidad(Integer idEspecialidad) {
    this.idEspecialidad = idEspecialidad;
  }

  public Integer getIdEspecialidad() {
    return idEspecialidad;
  }

  public void setIdEspecialidad(Integer idEspecialidad) {
    this.idEspecialidad = idEspecialidad;
  }

  public String getEspeNombre() {
    return espeNombre;
  }

  public void setEspeNombre(String espeNombre) {
    this.espeNombre = espeNombre;
  }

  public Boolean getEspeActivo() {
    return espeActivo;
  }

  public void setEspeActivo(Boolean espeActivo) {
    this.espeActivo = espeActivo;
  }

  @XmlTransient
  public Collection<SubEspecialidad> getSubEspecialidadCollection() {
    return subEspecialidadCollection;
  }

  public void setSubEspecialidadCollection(Collection<SubEspecialidad> subEspecialidadCollection) {
    this.subEspecialidadCollection = subEspecialidadCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Especialidad)) {
      return false;
    }
    Especialidad other = (Especialidad) object;
    if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Especialidad[ idEspecialidad=" + idEspecialidad + " ]";
  }
  
}
