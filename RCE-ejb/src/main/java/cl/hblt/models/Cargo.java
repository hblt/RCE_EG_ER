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
@Table(name = "Cargo")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
  @NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT c FROM Cargo c WHERE c.idCargo = :idCargo"),
  @NamedQuery(name = "Cargo.findByCargNombre", query = "SELECT c FROM Cargo c WHERE c.cargNombre = :cargNombre")})
public class Cargo implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_cargo")
  private Integer idCargo;
  @Size(max = 256)
  @Column(name = "carg_nombre")
  private String cargNombre;
  @OneToMany(mappedBy = "idCargo")
  private Collection<Profesional> profesionalCollection;

  public Cargo() {
  }

  public Cargo(Integer idCargo) {
    this.idCargo = idCargo;
  }

  public Integer getIdCargo() {
    return idCargo;
  }

  public void setIdCargo(Integer idCargo) {
    this.idCargo = idCargo;
  }

  public String getCargNombre() {
    return cargNombre;
  }

  public void setCargNombre(String cargNombre) {
    this.cargNombre = cargNombre;
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
    hash += (idCargo != null ? idCargo.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Cargo)) {
      return false;
    }
    Cargo other = (Cargo) object;
    if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Cargo[ idCargo=" + idCargo + " ]";
  }
  
}
