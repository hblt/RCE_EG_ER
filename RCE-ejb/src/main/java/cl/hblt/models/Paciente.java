/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.models;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edwin Guaman
 */
@Entity
@Table(name = "Paciente")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
  @NamedQuery(name = "Paciente.findByIdPaciente", query = "SELECT p FROM Paciente p WHERE p.idPaciente = :idPaciente"),
  @NamedQuery(name = "Paciente.findByPaciNifcha", query = "SELECT p FROM Paciente p WHERE p.paciNifcha = :paciNifcha")})
public class Paciente implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_paciente")
  private Integer idPaciente;
  @Size(max = 512)
  @Column(name = "paci_nifcha")
  private String paciNifcha;
  @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
  @ManyToOne
  private Persona idPersona;
  @JoinColumn(name = "id_leyesociales", referencedColumnName = "id_leyesociales")
  @ManyToOne
  private LeyesSociales idLeyesociales;
  @JoinColumn(name = "id_consultorio", referencedColumnName = "id_consultorio")
  @ManyToOne
  private Consultorio idConsultorio;
  @JoinColumn(name = "id_clasificacionprevision", referencedColumnName = "id_clasificacionprevision")
  @ManyToOne
  private ClasificacionPrevision idClasificacionprevision;

  public Paciente() {
  }

  public Paciente(Integer idPaciente) {
    this.idPaciente = idPaciente;
  }

  public Integer getIdPaciente() {
    return idPaciente;
  }

  public void setIdPaciente(Integer idPaciente) {
    this.idPaciente = idPaciente;
  }

  public String getPaciNifcha() {
    return paciNifcha;
  }

  public void setPaciNifcha(String paciNifcha) {
    this.paciNifcha = paciNifcha;
  }

  public Persona getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Persona idPersona) {
    this.idPersona = idPersona;
  }

  public LeyesSociales getIdLeyesociales() {
    return idLeyesociales;
  }

  public void setIdLeyesociales(LeyesSociales idLeyesociales) {
    this.idLeyesociales = idLeyesociales;
  }

  public Consultorio getIdConsultorio() {
    return idConsultorio;
  }

  public void setIdConsultorio(Consultorio idConsultorio) {
    this.idConsultorio = idConsultorio;
  }

  public ClasificacionPrevision getIdClasificacionprevision() {
    return idClasificacionprevision;
  }

  public void setIdClasificacionprevision(ClasificacionPrevision idClasificacionprevision) {
    this.idClasificacionprevision = idClasificacionprevision;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPaciente != null ? idPaciente.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Paciente)) {
      return false;
    }
    Paciente other = (Paciente) object;
    if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Paciente[ idPaciente=" + idPaciente + " ]";
  }
  
}
