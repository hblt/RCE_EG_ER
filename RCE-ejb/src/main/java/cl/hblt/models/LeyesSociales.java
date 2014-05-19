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
@Table(name = "LeyesSociales")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "LeyesSociales.findAll", query = "SELECT l FROM LeyesSociales l"),
  @NamedQuery(name = "LeyesSociales.findByIdLeyesociales", query = "SELECT l FROM LeyesSociales l WHERE l.idLeyesociales = :idLeyesociales"),
  @NamedQuery(name = "LeyesSociales.findByLesoNombre", query = "SELECT l FROM LeyesSociales l WHERE l.lesoNombre = :lesoNombre")})
public class LeyesSociales implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_leyesociales")
  private Integer idLeyesociales;
  @Size(max = 258)
  @Column(name = "leso_nombre")
  private String lesoNombre;
  @OneToMany(mappedBy = "idLeyesociales")
  private Collection<Paciente> pacienteCollection;

  public LeyesSociales() {
  }

  public LeyesSociales(Integer idLeyesociales) {
    this.idLeyesociales = idLeyesociales;
  }

  public Integer getIdLeyesociales() {
    return idLeyesociales;
  }

  public void setIdLeyesociales(Integer idLeyesociales) {
    this.idLeyesociales = idLeyesociales;
  }

  public String getLesoNombre() {
    return lesoNombre;
  }

  public void setLesoNombre(String lesoNombre) {
    this.lesoNombre = lesoNombre;
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
    hash += (idLeyesociales != null ? idLeyesociales.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof LeyesSociales)) {
      return false;
    }
    LeyesSociales other = (LeyesSociales) object;
    if ((this.idLeyesociales == null && other.idLeyesociales != null) || (this.idLeyesociales != null && !this.idLeyesociales.equals(other.idLeyesociales))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.LeyesSociales[ idLeyesociales=" + idLeyesociales + " ]";
  }
  
}
