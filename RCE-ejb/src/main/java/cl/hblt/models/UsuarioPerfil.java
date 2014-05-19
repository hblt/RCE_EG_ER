/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edwin Guaman
 */
@Entity
@Table(name = "UsuarioPerfil")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "UsuarioPerfil.findAll", query = "SELECT u FROM UsuarioPerfil u"),
  @NamedQuery(name = "UsuarioPerfil.findByIdUsuarioperfil", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK.idUsuarioperfil = :idUsuarioperfil"),
  @NamedQuery(name = "UsuarioPerfil.findByIdPerfil", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK.idPerfil = :idPerfil"),
  @NamedQuery(name = "UsuarioPerfil.findByIdUsuario", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK.idUsuario = :idUsuario")})
public class UsuarioPerfil implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected UsuarioPerfilPK usuarioPerfilPK;
  @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Usuario usuario;
  @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Perfil perfil;

  public UsuarioPerfil() {
  }

  public UsuarioPerfil(UsuarioPerfilPK usuarioPerfilPK) {
    this.usuarioPerfilPK = usuarioPerfilPK;
  }

  public UsuarioPerfil(int idUsuarioperfil, int idPerfil, int idUsuario) {
    this.usuarioPerfilPK = new UsuarioPerfilPK(idUsuarioperfil, idPerfil, idUsuario);
  }

  public UsuarioPerfilPK getUsuarioPerfilPK() {
    return usuarioPerfilPK;
  }

  public void setUsuarioPerfilPK(UsuarioPerfilPK usuarioPerfilPK) {
    this.usuarioPerfilPK = usuarioPerfilPK;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Perfil getPerfil() {
    return perfil;
  }

  public void setPerfil(Perfil perfil) {
    this.perfil = perfil;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (usuarioPerfilPK != null ? usuarioPerfilPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UsuarioPerfil)) {
      return false;
    }
    UsuarioPerfil other = (UsuarioPerfil) object;
    if ((this.usuarioPerfilPK == null && other.usuarioPerfilPK != null) || (this.usuarioPerfilPK != null && !this.usuarioPerfilPK.equals(other.usuarioPerfilPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.UsuarioPerfil[ usuarioPerfilPK=" + usuarioPerfilPK + " ]";
  }
  
}
