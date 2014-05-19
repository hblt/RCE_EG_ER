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
@Table(name = "Menu")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
  @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu"),
  @NamedQuery(name = "Menu.findByIdMenupadre", query = "SELECT m FROM Menu m WHERE m.idMenupadre = :idMenupadre"),
  @NamedQuery(name = "Menu.findByMenuNombre", query = "SELECT m FROM Menu m WHERE m.menuNombre = :menuNombre"),
  @NamedQuery(name = "Menu.findByMenuUrl", query = "SELECT m FROM Menu m WHERE m.menuUrl = :menuUrl"),
  @NamedQuery(name = "Menu.findByMenuAncho", query = "SELECT m FROM Menu m WHERE m.menuAncho = :menuAncho"),
  @NamedQuery(name = "Menu.findByMenuAlto", query = "SELECT m FROM Menu m WHERE m.menuAlto = :menuAlto"),
  @NamedQuery(name = "Menu.findByMenuOrden", query = "SELECT m FROM Menu m WHERE m.menuOrden = :menuOrden"),
  @NamedQuery(name = "Menu.findByMenuActivo", query = "SELECT m FROM Menu m WHERE m.menuActivo = :menuActivo"),
  @NamedQuery(name = "Menu.findByMenuNombreventana", query = "SELECT m FROM Menu m WHERE m.menuNombreventana = :menuNombreventana")})
public class Menu implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_menu")
  private Integer idMenu;
  @Column(name = "id_menupadre")
  private Integer idMenupadre;
  @Size(max = 50)
  @Column(name = "menu_nombre")
  private String menuNombre;
  @Size(max = 1000)
  @Column(name = "menu_url")
  private String menuUrl;
  @Column(name = "menu_ancho")
  private Integer menuAncho;
  @Column(name = "menu_alto")
  private Integer menuAlto;
  @Column(name = "menu_orden")
  private Integer menuOrden;
  @Column(name = "menu_activo")
  private Boolean menuActivo;
  @Size(max = 50)
  @Column(name = "menu_nombreventana")
  private String menuNombreventana;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
  private Collection<MenuPerfil> menuPerfilCollection;

  public Menu() {
  }

  public Menu(Integer idMenu) {
    this.idMenu = idMenu;
  }

  public Integer getIdMenu() {
    return idMenu;
  }

  public void setIdMenu(Integer idMenu) {
    this.idMenu = idMenu;
  }

  public Integer getIdMenupadre() {
    return idMenupadre;
  }

  public void setIdMenupadre(Integer idMenupadre) {
    this.idMenupadre = idMenupadre;
  }

  public String getMenuNombre() {
    return menuNombre;
  }

  public void setMenuNombre(String menuNombre) {
    this.menuNombre = menuNombre;
  }

  public String getMenuUrl() {
    return menuUrl;
  }

  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
  }

  public Integer getMenuAncho() {
    return menuAncho;
  }

  public void setMenuAncho(Integer menuAncho) {
    this.menuAncho = menuAncho;
  }

  public Integer getMenuAlto() {
    return menuAlto;
  }

  public void setMenuAlto(Integer menuAlto) {
    this.menuAlto = menuAlto;
  }

  public Integer getMenuOrden() {
    return menuOrden;
  }

  public void setMenuOrden(Integer menuOrden) {
    this.menuOrden = menuOrden;
  }

  public Boolean getMenuActivo() {
    return menuActivo;
  }

  public void setMenuActivo(Boolean menuActivo) {
    this.menuActivo = menuActivo;
  }

  public String getMenuNombreventana() {
    return menuNombreventana;
  }

  public void setMenuNombreventana(String menuNombreventana) {
    this.menuNombreventana = menuNombreventana;
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
    hash += (idMenu != null ? idMenu.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Menu)) {
      return false;
    }
    Menu other = (Menu) object;
    if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Menu[ idMenu=" + idMenu + " ]";
  }
  
}
