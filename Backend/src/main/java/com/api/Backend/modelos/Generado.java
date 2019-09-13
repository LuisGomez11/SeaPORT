
package com.api.Backend.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicios_generados")
public class Generado {
    
    @Id
    @Column(name = "id_generado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "referencia")
    private String referencia;
    
    @Column(name = "terminal")
    private String terminal;
    
    @Column(name = "id_entidadM")
    private int id_entidadM;
    
    @Column(name = "lloyd")
    private String lloyd;
    
    @Column(name = "uvi")
    private String uvi;
    
    @Column(name = "muelle")
    private String muelle;
    
    @Column(name = "id_entidadG")
    private int id_entidadG;
    
    @Column(name = "fecha_cita")
    private String fechaCita;
    
    @Column(name = "hora_cita")
    private String horaCita;
    
    @Column(name = "hrs_op")
    private String hrsOp;
    
    @Column(name = "fecha_final")
    private String fechaFinal;
    
    @Column(name = "hora_final")
    private String horaFinal;
    
    @Column(name = "id_servicio")
    private int id_servicio;
    
    @Column(name = "estado")
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getId_entidadM() {
        return id_entidadM;
    }

    public void setId_entidadM(int id_entidadM) {
        this.id_entidadM = id_entidadM;
    }

    public String getLloyd() {
        return lloyd;
    }

    public void setLloyd(String lloyd) {
        this.lloyd = lloyd;
    }

    public String getUvi() {
        return uvi;
    }

    public void setUvi(String uvi) {
        this.uvi = uvi;
    }

    public String getMuelle() {
        return muelle;
    }

    public void setMuelle(String muelle) {
        this.muelle = muelle;
    }

    public int getId_entidadG() {
        return id_entidadG;
    }

    public void setId_entidadG(int id_entidadG) {
        this.id_entidadG = id_entidadG;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getHrsOp() {
        return hrsOp;
    }

    public void setHrsOp(String hrsOp) {
        this.hrsOp = hrsOp;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
