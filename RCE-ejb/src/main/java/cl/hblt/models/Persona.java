/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edwin Guaman
 */
@Entity
@Table(name = "Persona")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
  @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
  @NamedQuery(name = "Persona.findByPersRun", query = "SELECT p FROM Persona p WHERE p.persRun = :persRun"),
  @NamedQuery(name = "Persona.findByPersDv", query = "SELECT p FROM Persona p WHERE p.persDv = :persDv"),
  @NamedQuery(name = "Persona.findByPersNombres", query = "SELECT p FROM Persona p WHERE p.persNombres = :persNombres"),
  @NamedQuery(name = "Persona.findByPersApepaterno", query = "SELECT p FROM Persona p WHERE p.persApepaterno = :persApepaterno"),
  @NamedQuery(name = "Persona.findByPersApematerno", query = "SELECT p FROM Persona p WHERE p.persApematerno = :persApematerno"),
  @NamedQuery(name = "Persona.findByPersEmail", query = "SELECT p FROM Persona p WHERE p.persEmail = :persEmail"),
  @NamedQuery(name = "Persona.findByPersTelefono", query = "SELECT p FROM Persona p WHERE p.persTelefono = :persTelefono"),
  @NamedQuery(name = "Persona.findByPersCelular", query = "SELECT p FROM Persona p WHERE p.persCelular = :persCelular"),
  @NamedQuery(name = "Persona.findByPersTelcontacto", query = "SELECT p FROM Persona p WHERE p.persTelcontacto = :persTelcontacto"),
  @NamedQuery(name = "Persona.findByPersDireccion", query = "SELECT p FROM Persona p WHERE p.persDireccion = :persDireccion"),
  @NamedQuery(name = "Persona.findByPersNdepartamento", query = "SELECT p FROM Persona p WHERE p.persNdepartamento = :persNdepartamento"),
  @NamedQuery(name = "Persona.findByPersActividad", query = "SELECT p FROM Persona p WHERE p.persActividad = :persActividad"),
  @NamedQuery(name = "Persona.findByPersFnacimiento", query = "SELECT p FROM Persona p WHERE p.persFnacimiento = :persFnacimiento"),
  @NamedQuery(name = "Persona.findByPersNacionalidad", query = "SELECT p FROM Persona p WHERE p.persNacionalidad = :persNacionalidad"),
  @NamedQuery(name = "Persona.findByUserIngresa", query = "SELECT p FROM Persona p WHERE p.userIngresa = :userIngresa"),
  @NamedQuery(name = "Persona.findByUserFingresa", query = "SELECT p FROM Persona p WHERE p.userFingresa = :userFingresa"),
  @NamedQuery(name = "Persona.findByUserModifica", query = "SELECT p FROM Persona p WHERE p.userModifica = :userModifica"),
  @NamedQuery(name = "Persona.findByUserFmodifica", query = "SELECT p FROM Persona p WHERE p.userFmodifica = :userFmodifica")})
public class Persona implements Serializable {
private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_persona")
  private Integer idPersona;
  @Column(name = "pers_run")
  private Integer persRun;
  @Column(name = "pers_dv")
  private Character persDv;
  @Size(max = 50)
  @Column(name = "pers_nombres")
  private String persNombres;
  @Size(max = 50)
  @Column(name = "pers_apepaterno")
  private String persApepaterno;
  @Size(max = 50)
  @Column(name = "pers_apematerno")
  private String persApematerno;
  @Size(max = 50)
  @Column(name = "pers_email")
  private String persEmail;
  @Size(max = 30)
  @Column(name = "pers_telefono")
  private String persTelefono;
  @Size(max = 30)
  @Column(name = "pers_celular")
  private String persCelular;
  @Size(max = 30)
  @Column(name = "pers_telcontacto")
  private String persTelcontacto;
  @Size(max = 100)
  @Column(name = "pers_direccion")
  private String persDireccion;
  @Size(max = 20)
  @Column(name = "pers_ndepartamento")
  private String persNdepartamento;
  @Size(max = 64)
  @Column(name = "pers_actividad")
  private String persActividad;
  @Column(name = "pers_fnacimiento")
  @Temporal(TemporalType.DATE)
  private Date persFnacimiento;
  @Size(max = 128)
  @Column(name = "pers_nacionalidad")
  private String persNacionalidad;
  @Size(max = 50)
  @Column(name = "user_ingresa")
  private String userIngresa;
  @Column(name = "user_fingresa")
  @Temporal(TemporalType.DATE)
  private Date userFingresa;
  @Size(max = 50)
  @Column(name = "user_modifica")
  private String userModifica;
  @Column(name = "user_fmodifica")
  @Temporal(TemporalType.DATE)
  private Date userFmodifica;
  @OneToMany(mappedBy = "idPersona")
  private List<Paciente> pacienteList;
  @OneToMany(mappedBy = "idPersona")
  private List<Usuario> usuarioList;
  @JoinColumn(name = "id_religion", referencedColumnName = "id_religion")
  @ManyToOne
  private Religion idReligion;
  @JoinColumn(name = "id_pueblooriginario", referencedColumnName = "id_pueblooriginario")
  @ManyToOne
  private PuebloOriginario idPueblooriginario;
  @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
  @ManyToOne
  private Genero idGenero;
  @JoinColumn(name = "id_estadoconyugal", referencedColumnName = "id_estadoconyugal")
  @ManyToOne
  private EstadoConyugal idEstadoconyugal;
  @JoinColumn(name = "id_educacion", referencedColumnName = "id_educacion")
  @ManyToOne
  private Educacion idEducacion;
  @JoinColumn(name = "id_comuna", referencedColumnName = "id_comuna")
  @ManyToOne
  private Comuna idComuna;

  public Persona() {
  }

  public Persona(Integer idPersona) {
    this.idPersona = idPersona;
  }

  public Integer getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Integer idPersona) {
    this.idPersona = idPersona;
  }

  public Integer getPersRun() {
    return persRun;
  }

  public void setPersRun(Integer persRun) {
    this.persRun = persRun;
  }

  public Character getPersDv() {
    return persDv;
  }

  public void setPersDv(Character persDv) {
    this.persDv = persDv;
  }

  public String getPersNombres() {
    return persNombres;
  }

  public void setPersNombres(String persNombres) {
    this.persNombres = persNombres;
  }

  public String getPersApepaterno() {
    return persApepaterno;
  }

  public void setPersApepaterno(String persApepaterno) {
    this.persApepaterno = persApepaterno;
  }

  public String getPersApematerno() {
    return persApematerno;
  }

  public void setPersApematerno(String persApematerno) {
    this.persApematerno = persApematerno;
  }

  public String getPersEmail() {
    return persEmail;
  }

  public void setPersEmail(String persEmail) {
    this.persEmail = persEmail;
  }

  public String getPersTelefono() {
    return persTelefono;
  }

  public void setPersTelefono(String persTelefono) {
    this.persTelefono = persTelefono;
  }

  public String getPersCelular() {
    return persCelular;
  }

  public void setPersCelular(String persCelular) {
    this.persCelular = persCelular;
  }

  public String getPersTelcontacto() {
    return persTelcontacto;
  }

  public void setPersTelcontacto(String persTelcontacto) {
    this.persTelcontacto = persTelcontacto;
  }

  public String getPersDireccion() {
    return persDireccion;
  }

  public void setPersDireccion(String persDireccion) {
    this.persDireccion = persDireccion;
  }

  public String getPersNdepartamento() {
    return persNdepartamento;
  }

  public void setPersNdepartamento(String persNdepartamento) {
    this.persNdepartamento = persNdepartamento;
  }

  public String getPersActividad() {
    return persActividad;
  }

  public void setPersActividad(String persActividad) {
    this.persActividad = persActividad;
  }

  public Date getPersFnacimiento() {
    return persFnacimiento;
  }

  public void setPersFnacimiento(Date persFnacimiento) {
    this.persFnacimiento = persFnacimiento;
  }

  public String getPersNacionalidad() {
    return persNacionalidad;
  }

  public void setPersNacionalidad(String persNacionalidad) {
    this.persNacionalidad = persNacionalidad;
  }

  public String getUserIngresa() {
    return userIngresa;
  }

  public void setUserIngresa(String userIngresa) {
    this.userIngresa = userIngresa;
  }

  public Date getUserFingresa() {
    return userFingresa;
  }

  public void setUserFingresa(Date userFingresa) {
    this.userFingresa = userFingresa;
  }

  public String getUserModifica() {
    return userModifica;
  }

  public void setUserModifica(String userModifica) {
    this.userModifica = userModifica;
  }

  public Date getUserFmodifica() {
    return userFmodifica;
  }

  public void setUserFmodifica(Date userFmodifica) {
    this.userFmodifica = userFmodifica;
  }

  @XmlTransient
  public List<Paciente> getPacienteList() {
    return pacienteList;
  }

  public void setPacienteList(List<Paciente> pacienteList) {
    this.pacienteList = pacienteList;
  }

  @XmlTransient
  public List<Usuario> getUsuarioList() {
    return usuarioList;
  }

  public void setUsuarioList(List<Usuario> usuarioList) {
    this.usuarioList = usuarioList;
  }

  public Religion getIdReligion() {
    return idReligion;
  }

  public void setIdReligion(Religion idReligion) {
    this.idReligion = idReligion;
  }

  public PuebloOriginario getIdPueblooriginario() {
    return idPueblooriginario;
  }

  public void setIdPueblooriginario(PuebloOriginario idPueblooriginario) {
    this.idPueblooriginario = idPueblooriginario;
  }

  public Genero getIdGenero() {
    return idGenero;
  }

  public void setIdGenero(Genero idGenero) {
    this.idGenero = idGenero;
  }

  public EstadoConyugal getIdEstadoconyugal() {
    return idEstadoconyugal;
  }

  public void setIdEstadoconyugal(EstadoConyugal idEstadoconyugal) {
    this.idEstadoconyugal = idEstadoconyugal;
  }

  public Educacion getIdEducacion() {
    return idEducacion;
  }

  public void setIdEducacion(Educacion idEducacion) {
    this.idEducacion = idEducacion;
  }

  public Comuna getIdComuna() {
    return idComuna;
  }

  public void setIdComuna(Comuna idComuna) {
    this.idComuna = idComuna;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPersona != null ? idPersona.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Persona)) {
      return false;
    }
    Persona other = (Persona) object;
    if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Persona[ idPersona=" + idPersona + " ]";
  }
  
}
