/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Edwin Guaman
 */
@Embeddable
public class UsuarioPerfilPK implements Serializable {
  @Basic(optional = false)
  @Column(name = "id_usuarioperfil")
  private int idUsuarioperfil;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_perfil")
  private int idPerfil;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_usuario")
  private int idUsuario;

  public UsuarioPerfilPK() {
  }

  public UsuarioPerfilPK(int idUsuarioperfil, int idPerfil, int idUsuario) {
    this.idUsuarioperfil = idUsuarioperfil;
    this.idPerfil = idPerfil;
    this.idUsuario = idUsuario;
  }

  public int getIdUsuarioperfil() {
    return idUsuarioperfil;
  }

  public void setIdUsuarioperfil(int idUsuarioperfil) {
    this.idUsuarioperfil = idUsuarioperfil;
  }

  public int getIdPerfil() {
    return idPerfil;
  }

  public void setIdPerfil(int idPerfil) {
    this.idPerfil = idPerfil;
  }

  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) idUsuarioperfil;
    hash += (int) idPerfil;
    hash += (int) idUsuario;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UsuarioPerfilPK)) {
      return false;
    }
    UsuarioPerfilPK other = (UsuarioPerfilPK) object;
    if (this.idUsuarioperfil != other.idUsuarioperfil) {
      return false;
    }
    if (this.idPerfil != other.idPerfil) {
      return false;
    }
    if (this.idUsuario != other.idUsuario) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.UsuarioPerfilPK[ idUsuarioperfil=" + idUsuarioperfil + ", idPerfil=" + idPerfil + ", idUsuario=" + idUsuario + " ]";
  }
  
}
