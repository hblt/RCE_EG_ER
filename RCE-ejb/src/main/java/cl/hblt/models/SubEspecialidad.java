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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SubEspecialidad")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "SubEspecialidad.findAll", query = "SELECT s FROM SubEspecialidad s"),
  @NamedQuery(name = "SubEspecialidad.findByIdSubespecialidad", query = "SELECT s FROM SubEspecialidad s WHERE s.idSubespecialidad = :idSubespecialidad"),
  @NamedQuery(name = "SubEspecialidad.findBySuesNombre", query = "SELECT s FROM SubEspecialidad s WHERE s.suesNombre = :suesNombre"),
  @NamedQuery(name = "SubEspecialidad.findBySuesActivo", query = "SELECT s FROM SubEspecialidad s WHERE s.suesActivo = :suesActivo")})
public class SubEspecialidad implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_subespecialidad")
  private Integer idSubespecialidad;
  @Size(max = 256)
  @Column(name = "sues_nombre")
  private String suesNombre;
  @Column(name = "sues_activo")
  private Boolean suesActivo;
  @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
  @ManyToOne
  private Especialidad idEspecialidad;
  @OneToMany(mappedBy = "idSubespecialidad")
  private Collection<Profesional> profesionalCollection;

  public SubEspecialidad() {
  }

  public SubEspecialidad(Integer idSubespecialidad) {
    this.idSubespecialidad = idSubespecialidad;
  }

  public Integer getIdSubespecialidad() {
    return idSubespecialidad;
  }

  public void setIdSubespecialidad(Integer idSubespecialidad) {
    this.idSubespecialidad = idSubespecialidad;
  }

  public String getSuesNombre() {
    return suesNombre;
  }

  public void setSuesNombre(String suesNombre) {
    this.suesNombre = suesNombre;
  }

  public Boolean getSuesActivo() {
    return suesActivo;
  }

  public void setSuesActivo(Boolean suesActivo) {
    this.suesActivo = suesActivo;
  }

  public Especialidad getIdEspecialidad() {
    return idEspecialidad;
  }

  public void setIdEspecialidad(Especialidad idEspecialidad) {
    this.idEspecialidad = idEspecialidad;
  }

  @XmlTransient
  public Collection<Profesional> getProfesionalCollection() {
    return profesionalCollection;
  }

  public void setProfesionalCollection(Collection<Profesional> profesionalCollection) {
    this.profesionalCollection = profesionalCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idSubespecialidad != null ? idSubespecialidad.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SubEspecialidad)) {
      return false;
    }
    SubEspecialidad other = (SubEspecialidad) object;
    if ((this.idSubespecialidad == null && other.idSubespecialidad != null) || (this.idSubespecialidad != null && !this.idSubespecialidad.equals(other.idSubespecialidad))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.SubEspecialidad[ idSubespecialidad=" + idSubespecialidad + " ]";
  }
  
}
