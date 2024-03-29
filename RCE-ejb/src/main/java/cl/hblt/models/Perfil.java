/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Perfil")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
  @NamedQuery(name = "Perfil.findByIdPerfil", query = "SELECT p FROM Perfil p WHERE p.idPerfil = :idPerfil"),
  @NamedQuery(name = "Perfil.findByPerfNombre", query = "SELECT p FROM Perfil p WHERE p.perfNombre = :perfNombre"),
  @NamedQuery(name = "Perfil.findByPerfVigente", query = "SELECT p FROM Perfil p WHERE p.perfVigente = :perfVigente")})
public class Perfil implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_perfil")
  private Integer idPerfil;
  @Size(max = 100)
  @Column(name = "perf_nombre")
  private String perfNombre;
  @Column(name = "perf_vigente")
  private Boolean perfVigente;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
  private Collection<UsuarioPerfil> usuarioPerfilCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
  private Collection<MenuPerfil> menuPerfilCollection;

  public Perfil() {
  }

  public Perfil(Integer idPerfil) {
    this.idPerfil = idPerfil;
  }

  public Integer getIdPerfil() {
    return idPerfil;
  }

  public void setIdPerfil(Integer idPerfil) {
    this.idPerfil = idPerfil;
  }

  public String getPerfNombre() {
    return perfNombre;
  }

  public void setPerfNombre(String perfNombre) {
    this.perfNombre = perfNombre;
  }

  public Boolean getPerfVigente() {
    return perfVigente;
  }

  public void setPerfVigente(Boolean perfVigente) {
    this.perfVigente = perfVigente;
  }

  @XmlTransient
  public Collection<UsuarioPerfil> getUsuarioPerfilCollection() {
    return usuarioPerfilCollection;
  }

  public void setUsuarioPerfilCollection(Collection<UsuarioPerfil> usuarioPerfilCollection) {
    this.usuarioPerfilCollection = usuarioPerfilCollection;
  }

  @XmlTransient
  public Collection<MenuPerfil> getMenuPerfilCollection() {
    return menuPerfilCollection;
  }

  public void setMenuPerfilCollection(Collection<MenuPerfil> menuPerfilCollection) {
    this.menuPerfilCollection = menuPerfilCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPerfil != null ? idPerfil.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Perfil)) {
      return false;
    }
    Perfil other = (Perfil) object;
    if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Perfil[ idPerfil=" + idPerfil + " ]";
  }
  
}
