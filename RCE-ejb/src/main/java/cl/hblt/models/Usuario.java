/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Usuario")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
  @NamedQuery(name = "Usuario.findAllRelacionado", query = "SELECT u FROM Usuario u JOIN u.idProfesional p JOIN p.idCargo c JOIN p.idSubespecialidad sb JOIN sb.idEspecialidad JOIN u.idPersona pe "),
  @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
  @NamedQuery(name = "Usuario.findByUsuaName", query = "SELECT u FROM Usuario u WHERE u.usuaName = :usuaName"),
  @NamedQuery(name = "Usuario.findByUsuaPass", query = "SELECT u FROM Usuario u WHERE u.usuaPass = :usuaPass"),
  @NamedQuery(name = "Usuario.loginUsuario", query="Select u FROM Usuario u WHERE u.usuaName= :user AND u.usuaPass=md5(:pass)"),
  @NamedQuery(name = "Usuario.findByUsuaIntentosfallidos", query = "SELECT u FROM Usuario u WHERE u.usuaIntentosfallidos = :usuaIntentosfallidos")})
  
public class Usuario implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_usuario")
  private Integer idUsuario;
  @Size(max = 50)
  @Column(name = "usua_name")
  private String usuaName;
  @Size(max = 256)
  @Column(name = "usua_pass")
  private String usuaPass;
  @Column(name = "usua_intentosfallidos")
  private Integer usuaIntentosfallidos;
  @JoinColumn(name = "id_profesional", referencedColumnName = "id_profesional")
  @ManyToOne
  private Profesional idProfesional;
  @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
  @ManyToOne
  private Persona idPersona;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
  private List<UsuarioPerfil> usuarioperfilList;

  public Usuario() {
  }

  public Usuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getUsuaName() {
    return usuaName;
  }

  public void setUsuaName(String usuaName) {
    this.usuaName = usuaName;
  }

  public String getUsuaPass() {
    return usuaPass;
  }

  public void setUsuaPass(String usuaPass) {
    this.usuaPass = usuaPass;
  }

  public Integer getUsuaIntentosfallidos() {
    return usuaIntentosfallidos;
  }

  public void setUsuaIntentosfallidos(Integer usuaIntentosfallidos) {
    this.usuaIntentosfallidos = usuaIntentosfallidos;
  }

  public Profesional getIdProfesional() {
    return idProfesional;
  }

  public void setIdProfesional(Profesional idProfesional) {
    this.idProfesional = idProfesional;
  }

  public Persona getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Persona idPersona) {
    this.idPersona = idPersona;
  }

  @XmlTransient
  public List<UsuarioPerfil> getUsuarioperfilList() {
    return usuarioperfilList;
  }

  public void setUsuarioperfilList(List<UsuarioPerfil> usuarioperfilList) {
    this.usuarioperfilList = usuarioperfilList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idUsuario != null ? idUsuario.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Usuario)) {
      return false;
    }
    Usuario other = (Usuario) object;
    if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Usuario[ idUsuario=" + idUsuario + " ]";
  }
  
}
