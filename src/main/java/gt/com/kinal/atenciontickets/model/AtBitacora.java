/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.atenciontickets.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "at_bitacora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtBitacora.findAll", query = "SELECT a FROM AtBitacora a")
    , @NamedQuery(name = "AtBitacora.findByBitacoraId", query = "SELECT a FROM AtBitacora a WHERE a.bitacoraId = :bitacoraId")
    , @NamedQuery(name = "AtBitacora.findByEstado", query = "SELECT a FROM AtBitacora a WHERE a.estado = :estado")
    , @NamedQuery(name = "AtBitacora.findByFechaCreacion", query = "SELECT a FROM AtBitacora a WHERE a.fechaCreacion = :fechaCreacion")})
public class AtBitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bitacora_id")
    private Integer bitacoraId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumns({
        @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
        , @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")})
    @ManyToOne(optional = false)
    private AtTicket atTicket;

    public AtBitacora() {
    }

    public AtBitacora(Integer bitacoraId) {
        this.bitacoraId = bitacoraId;
    }

    public AtBitacora(Integer bitacoraId, Character estado, Date fechaCreacion) {
        this.bitacoraId = bitacoraId;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getBitacoraId() {
        return bitacoraId;
    }

    public void setBitacoraId(Integer bitacoraId) {
        this.bitacoraId = bitacoraId;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public AtTicket getAtTicket() {
        return atTicket;
    }

    public void setAtTicket(AtTicket atTicket) {
        this.atTicket = atTicket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bitacoraId != null ? bitacoraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtBitacora)) {
            return false;
        }
        AtBitacora other = (AtBitacora) object;
        if ((this.bitacoraId == null && other.bitacoraId != null) || (this.bitacoraId != null && !this.bitacoraId.equals(other.bitacoraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.kinal.tickets.model.AtBitacora[ bitacoraId=" + bitacoraId + " ]";
    }
    
}
