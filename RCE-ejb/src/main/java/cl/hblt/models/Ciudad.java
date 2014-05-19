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
@Table(name = "Ciudad")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
  @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad"),
  @NamedQuery(name = "Ciudad.findByCiudNombre", query = "SELECT c FROM Ciudad c WHERE c.ciudNombre = :ciudNombre"),
  @NamedQuery(name = "Ciudad.findByCiudAbrev", query = "SELECT c FROM Ciudad c WHERE c.ciudAbrev = :ciudAbrev")})
public class Ciudad implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_ciudad")
  private Integer idCiudad;
  @Size(max = 1024)
  @Column(name = "ciud_nombre")
  private String ciudNombre;
  @Size(max = 10)
  @Column(name = "ciud_abrev")
  private String ciudAbrev;
  @OneToMany(mappedBy = "idCiudad")
  private Collection<Comuna> comunaCollection;
  @JoinColumn(name = "id_region", referencedColumnName = "id_region")
  @ManyToOne
  private Region idRegion;

  public Ciudad() {
  }

  public Ciudad(Integer idCiudad) {
    this.idCiudad = idCiudad;
  }

  public Integer getIdCiudad() {
    return idCiudad;
  }

  public void setIdCiudad(Integer idCiudad) {
    this.idCiudad = idCiudad;
  }

  public String getCiudNombre() {
    return ciudNombre;
  }

  public void setCiudNombre(String ciudNombre) {
    this.ciudNombre = ciudNombre;
  }

  public String getCiudAbrev() {
    return ciudAbrev;
  }

  public void setCiudAbrev(String ciudAbrev) {
    this.ciudAbrev = ciudAbrev;
  }

  @XmlTransient
  public Collection<Comuna> getComunaCollection() {
    return comunaCollection;
  }

  public void setComunaCollection(Collection<Comuna> comunaCollection) {
    this.comunaCollection = comunaCollection;
  }

  public Region getIdRegion() {
    return idRegion;
  }

  public void setIdRegion(Region idRegion) {
    this.idRegion = idRegion;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idCiudad != null ? idCiudad.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Ciudad)) {
      return false;
    }
    Ciudad other = (Ciudad) object;
    if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Ciudad[ idCiudad=" + idCiudad + " ]";
  }
  
}
