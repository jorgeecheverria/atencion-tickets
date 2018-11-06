/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.atenciontickets.model;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "at_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtCategoria.findAll", query = "SELECT a FROM AtCategoria a")
    , @NamedQuery(name = "AtCategoria.findByCategoriaId", query = "SELECT a FROM AtCategoria a WHERE a.categoriaId = :categoriaId")
    , @NamedQuery(name = "AtCategoria.findByNombre", query = "SELECT a FROM AtCategoria a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "AtCategoria.findByDescripcion", query = "SELECT a FROM AtCategoria a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "AtCategoria.findByAsignacion", query = "SELECT a FROM AtCategoria a WHERE a.asignacion = :asignacion")})
public class AtCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categoria_id")
    private Integer categoriaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignacion")
    private Character asignacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atCategoria")
    private List<AtTicket> atTicketList;

    public AtCategoria() {
    }

    public AtCategoria(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public AtCategoria(Integer categoriaId, String nombre, Character asignacion) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
        this.asignacion = asignacion;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Character asignacion) {
        this.asignacion = asignacion;
    }

    @XmlTransient
    public List<AtTicket> getAtTicketList() {
        return atTicketList;
    }

    public void setAtTicketList(List<AtTicket> atTicketList) {
        this.atTicketList = atTicketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaId != null ? categoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtCategoria)) {
            return false;
        }
        AtCategoria other = (AtCategoria) object;
        if ((this.categoriaId == null && other.categoriaId != null) || (this.categoriaId != null && !this.categoriaId.equals(other.categoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.kinal.tickets.model.AtCategoria[ categoriaId=" + categoriaId + " ]";
    }
    
}
