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
@Table(name = "MenuPerfil")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "MenuPerfil.findAll", query = "SELECT m FROM MenuPerfil m"),
  @NamedQuery(name = "MenuPerfil.findByIdMenuperfil", query = "SELECT m FROM MenuPerfil m WHERE m.menuPerfilPK.idMenuperfil = :idMenuperfil"),
  @NamedQuery(name = "MenuPerfil.findByIdMenu", query = "SELECT m FROM MenuPerfil m WHERE m.menuPerfilPK.idMenu = :idMenu"),
  @NamedQuery(name = "MenuPerfil.findByIdPerfil", query = "SELECT m FROM MenuPerfil m WHERE m.menuPerfilPK.idPerfil = :idPerfil")})
public class MenuPerfil implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected MenuPerfilPK menuPerfilPK;
  @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Perfil perfil;
  @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Menu menu;

  public MenuPerfil() {
  }

  public MenuPerfil(MenuPerfilPK menuPerfilPK) {
    this.menuPerfilPK = menuPerfilPK;
  }

  public MenuPerfil(int idMenuperfil, int idMenu, int idPerfil) {
    this.menuPerfilPK = new MenuPerfilPK(idMenuperfil, idMenu, idPerfil);
  }

  public MenuPerfilPK getMenuPerfilPK() {
    return menuPerfilPK;
  }

  public void setMenuPerfilPK(MenuPerfilPK menuPerfilPK) {
    this.menuPerfilPK = menuPerfilPK;
  }

  public Perfil getPerfil() {
    return perfil;
  }

  public void setPerfil(Perfil perfil) {
    this.perfil = perfil;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (menuPerfilPK != null ? menuPerfilPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MenuPerfil)) {
      return false;
    }
    MenuPerfil other = (MenuPerfil) object;
    if ((this.menuPerfilPK == null && other.menuPerfilPK != null) || (this.menuPerfilPK != null && !this.menuPerfilPK.equals(other.menuPerfilPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.MenuPerfil[ menuPerfilPK=" + menuPerfilPK + " ]";
  }
  
}
