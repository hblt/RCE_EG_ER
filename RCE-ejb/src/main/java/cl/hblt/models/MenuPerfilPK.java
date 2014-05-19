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
public class MenuPerfilPK implements Serializable {
  @Basic(optional = false)
  @Column(name = "id_menuperfil")
  private int idMenuperfil;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_menu")
  private int idMenu;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_perfil")
  private int idPerfil;

  public MenuPerfilPK() {
  }

  public MenuPerfilPK(int idMenuperfil, int idMenu, int idPerfil) {
    this.idMenuperfil = idMenuperfil;
    this.idMenu = idMenu;
    this.idPerfil = idPerfil;
  }

  public int getIdMenuperfil() {
    return idMenuperfil;
  }

  public void setIdMenuperfil(int idMenuperfil) {
    this.idMenuperfil = idMenuperfil;
  }

  public int getIdMenu() {
    return idMenu;
  }

  public void setIdMenu(int idMenu) {
    this.idMenu = idMenu;
  }

  public int getIdPerfil() {
    return idPerfil;
  }

  public void setIdPerfil(int idPerfil) {
    this.idPerfil = idPerfil;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) idMenuperfil;
    hash += (int) idMenu;
    hash += (int) idPerfil;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MenuPerfilPK)) {
      return false;
    }
    MenuPerfilPK other = (MenuPerfilPK) object;
    if (this.idMenuperfil != other.idMenuperfil) {
      return false;
    }
    if (this.idMenu != other.idMenu) {
      return false;
    }
    if (this.idPerfil != other.idPerfil) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.MenuPerfilPK[ idMenuperfil=" + idMenuperfil + ", idMenu=" + idMenu + ", idPerfil=" + idPerfil + " ]";
  }
  
}
