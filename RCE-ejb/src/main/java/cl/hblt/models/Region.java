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
@Table(name = "Region")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
  @NamedQuery(name = "Region.findByIdRegion", query = "SELECT r FROM Region r WHERE r.idRegion = :idRegion"),
  @NamedQuery(name = "Region.findByRegiNombre", query = "SELECT r FROM Region r WHERE r.regiNombre = :regiNombre"),
  @NamedQuery(name = "Region.findByRegiAbrev", query = "SELECT r FROM Region r WHERE r.regiAbrev = :regiAbrev")})
public class Region implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_region")
  private Integer idRegion;
  @Size(max = 1024)
  @Column(name = "regi_nombre")
  private String regiNombre;
  @Size(max = 10)
  @Column(name = "regi_abrev")
  private String regiAbrev;
  @OneToMany(mappedBy = "idRegion")
  private Collection<Ciudad> ciudadCollection;

  public Region() {
  }

  public Region(Integer idRegion) {
    this.idRegion = idRegion;
  }

  public Integer getIdRegion() {
    return idRegion;
  }

  public void setIdRegion(Integer idRegion) {
    this.idRegion = idRegion;
  }

  public String getRegiNombre() {
    return regiNombre;
  }

  public void setRegiNombre(String regiNombre) {
    this.regiNombre = regiNombre;
  }

  public String getRegiAbrev() {
    return regiAbrev;
  }

  public void setRegiAbrev(String regiAbrev) {
    this.regiAbrev = regiAbrev;
  }

  @XmlTransient
  public Collection<Ciudad> getCiudadCollection() {
    return ciudadCollection;
  }

  public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
    this.ciudadCollection = ciudadCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idRegion != null ? idRegion.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Region)) {
      return false;
    }
    Region other = (Region) object;
    if ((this.idRegion == null && other.idRegion != null) || (this.idRegion != null && !this.idRegion.equals(other.idRegion))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Region[ idRegion=" + idRegion + " ]";
  }
  
}
