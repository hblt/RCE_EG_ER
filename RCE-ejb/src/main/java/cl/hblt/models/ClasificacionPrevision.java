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
@Table(name = "ClasificacionPrevision")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ClasificacionPrevision.findAll", query = "SELECT c FROM ClasificacionPrevision c"),
  @NamedQuery(name = "ClasificacionPrevision.findByIdClasificacionprevision", query = "SELECT c FROM ClasificacionPrevision c WHERE c.idClasificacionprevision = :idClasificacionprevision"),
  @NamedQuery(name = "ClasificacionPrevision.findByClprNombre", query = "SELECT c FROM ClasificacionPrevision c WHERE c.clprNombre = :clprNombre")})
public class ClasificacionPrevision implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_clasificacionprevision")
  private Integer idClasificacionprevision;
  @Size(max = 250)
  @Column(name = "clpr_nombre")
  private String clprNombre;
  @JoinColumn(name = "id_prevision", referencedColumnName = "id_prevision")
  @ManyToOne
  private Prevision idPrevision;
  @OneToMany(mappedBy = "idClasificacionprevision")
  private Collection<Paciente> pacienteCollection;

  public ClasificacionPrevision() {
  }

  public ClasificacionPrevision(Integer idClasificacionprevision) {
    this.idClasificacionprevision = idClasificacionprevision;
  }

  public Integer getIdClasificacionprevision() {
    return idClasificacionprevision;
  }

  public void setIdClasificacionprevision(Integer idClasificacionprevision) {
    this.idClasificacionprevision = idClasificacionprevision;
  }

  public String getClprNombre() {
    return clprNombre;
  }

  public void setClprNombre(String clprNombre) {
    this.clprNombre = clprNombre;
  }

  public Prevision getIdPrevision() {
    return idPrevision;
  }

  public void setIdPrevision(Prevision idPrevision) {
    this.idPrevision = idPrevision;
  }

  @XmlTransient
  public Collection<Paciente> getPacienteCollection() {
    return pacienteCollection;
  }

  public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
    this.pacienteCollection = pacienteCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idClasificacionprevision != null ? idClasificacionprevision.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ClasificacionPrevision)) {
      return false;
    }
    ClasificacionPrevision other = (ClasificacionPrevision) object;
    if ((this.idClasificacionprevision == null && other.idClasificacionprevision != null) || (this.idClasificacionprevision != null && !this.idClasificacionprevision.equals(other.idClasificacionprevision))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.ClasificacionPrevision[ idClasificacionprevision=" + idClasificacionprevision + " ]";
  }
  
}
