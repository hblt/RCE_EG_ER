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
@Table(name = "Genero")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
  @NamedQuery(name = "Genero.findByIdGenero", query = "SELECT g FROM Genero g WHERE g.idGenero = :idGenero"),
  @NamedQuery(name = "Genero.findByGeneNombre", query = "SELECT g FROM Genero g WHERE g.geneNombre = :geneNombre")})
public class Genero implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_genero")
  private Integer idGenero;
  @Size(max = 50)
  @Column(name = "gene_nombre")
  private String geneNombre;
  @OneToMany(mappedBy = "idGenero")
  private Collection<Persona> personaCollection;

  public Genero() {
  }

  public Genero(Integer idGenero) {
    this.idGenero = idGenero;
  }

  public Integer getIdGenero() {
    return idGenero;
  }

  public void setIdGenero(Integer idGenero) {
    this.idGenero = idGenero;
  }

  public String getGeneNombre() {
    return geneNombre;
  }

  public void setGeneNombre(String geneNombre) {
    this.geneNombre = geneNombre;
  }

  @XmlTransient
  public Collection<Persona> getPersonaCollection() {
    return personaCollection;
  }

  public void setPersonaCollection(Collection<Persona> personaCollection) {
    this.personaCollection = personaCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idGenero != null ? idGenero.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Genero)) {
      return false;
    }
    Genero other = (Genero) object;
    if ((this.idGenero == null && other.idGenero != null) || (this.idGenero != null && !this.idGenero.equals(other.idGenero))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Genero[ idGenero=" + idGenero + " ]";
  }
  
}
