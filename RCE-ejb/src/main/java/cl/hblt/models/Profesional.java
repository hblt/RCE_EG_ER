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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edwin Guaman
 */
@Entity
@Table(name = "Profesional")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p"),
  @NamedQuery(name = "Profesional.findByIdProfesional", query = "SELECT p FROM Profesional p WHERE p.idProfesional = :idProfesional"),
  @NamedQuery(name = "Profesional.findByProfActivo", query = "SELECT p FROM Profesional p WHERE p.profActivo = :profActivo")})
public class Profesional implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_profesional")
  private Integer idProfesional;
  @Column(name = "prof_activo")
  private Boolean profActivo;
  @OneToMany(mappedBy = "idProfesional")
  private Collection<Usuario> usuarioCollection;
  @JoinColumn(name = "id_subespecialidad", referencedColumnName = "id_subespecialidad")
  @ManyToOne
  private SubEspecialidad idSubespecialidad;
  @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
  @ManyToOne
  private Persona idPersona;
  @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
  @ManyToOne
  private Cargo idCargo;

  public Profesional() {
  }

  public Profesional(Integer idProfesional) {
    this.idProfesional = idProfesional;
  }

  public Integer getIdProfesional() {
    return idProfesional;
  }

  public void setIdProfesional(Integer idProfesional) {
    this.idProfesional = idProfesional;
  }

  public Boolean getProfActivo() {
    return profActivo;
  }

  public void setProfActivo(Boolean profActivo) {
    this.profActivo = profActivo;
  }

  @XmlTransient
  public Collection<Usuario> getUsuarioCollection() {
    return usuarioCollection;
  }

  public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
    this.usuarioCollection = usuarioCollection;
  }

  public SubEspecialidad getIdSubespecialidad() {
    return idSubespecialidad;
  }

  public void setIdSubespecialidad(SubEspecialidad idSubespecialidad) {
    this.idSubespecialidad = idSubespecialidad;
  }

  public Persona getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Persona idPersona) {
    this.idPersona = idPersona;
  }

  public Cargo getIdCargo() {
    return idCargo;
  }

  public void setIdCargo(Cargo idCargo) {
    this.idCargo = idCargo;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idProfesional != null ? idProfesional.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Profesional)) {
      return false;
    }
    Profesional other = (Profesional) object;
    if ((this.idProfesional == null && other.idProfesional != null) || (this.idProfesional != null && !this.idProfesional.equals(other.idProfesional))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Profesional[ idProfesional=" + idProfesional + " ]";
  }
  
}
