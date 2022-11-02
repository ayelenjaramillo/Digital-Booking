package com.dh.CrudCategorias.models;

import javax.persistence.*;

@Entity
@Table(name="Caracteristicas")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Caracteristica_sequence")
    @SequenceGenerator(name = "Caracteristica_sequence", sequenceName = "Caracteristica_sequence", allocationSize = 1)
    private Integer id;
    private String descripcion;
    private Boolean disponibilidad;
    private String politica;
    private Boolean wifi;
    @Column (name= "aire_acondicionado")
    private Boolean aireAcondicionado;
    @Column (name= "apto_mascota")
    private Boolean aptoMascota;
    private Boolean cocina;
    private Boolean baniadera;
    private Boolean tele;
    private Boolean piscina;
    private Boolean accesibilidad;
    @Column (name= "estacionamiento_gratuito")
    private Boolean estacionamientoGratuito;
    @Column(name= "libre_de_humo")
    private Boolean libreDeHumo;
    private Boolean conVista;

    //vacio
    public Caracteristica() {
    }

    //sin ID
    public Caracteristica(String descripcion, Boolean disponibilidad, String politica, Boolean wifi, Boolean aireAcondicionado, Boolean aptoMascota, Boolean cocina, Boolean baniadera, Boolean tele, Boolean piscina, Boolean accesibilidad, Boolean estacionamientoGratuito, Boolean libreDeHumo, Boolean conVista) {
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.politica = politica;
        this.wifi = wifi;
        this.aireAcondicionado = aireAcondicionado;
        this.aptoMascota = aptoMascota;
        this.cocina = cocina;
        this.baniadera = baniadera;
        this.tele = tele;
        this.piscina = piscina;
        this.accesibilidad = accesibilidad;
        this.estacionamientoGratuito = estacionamientoGratuito;
        this.libreDeHumo = libreDeHumo;
        this.conVista = conVista;
    }

    //con ID
    public Caracteristica(Integer id, String descripcion, Boolean disponibilidad, String politica, Boolean wifi, Boolean aireAcondicionado, Boolean aptoMascota, Boolean cocina, Boolean baniadera, Boolean tele, Boolean piscina, Boolean accesibilidad, Boolean estacionamientoGratuito, Boolean libreDeHumo, Boolean conVista) {
        this.id = id;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.politica = politica;
        this.wifi = wifi;
        this.aireAcondicionado = aireAcondicionado;
        this.aptoMascota = aptoMascota;
        this.cocina = cocina;
        this.baniadera = baniadera;
        this.tele = tele;
        this.piscina = piscina;
        this.accesibilidad = accesibilidad;
        this.estacionamientoGratuito = estacionamientoGratuito;
        this.libreDeHumo = libreDeHumo;
        this.conVista = conVista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getPolitica() {
        return politica;
    }

    public void setPolitica(String politica) {
        this.politica = politica;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getAptoMascota() {
        return aptoMascota;
    }

    public void setAptoMascota(Boolean aptoMascota) {
        this.aptoMascota = aptoMascota;
    }

    public Boolean getCocina() {
        return cocina;
    }

    public void setCocina(Boolean cocina) {
        this.cocina = cocina;
    }

    public Boolean getBaniadera() {
        return baniadera;
    }

    public void setBaniadera(Boolean baniadera) {
        this.baniadera = baniadera;
    }

    public Boolean getTele() {
        return tele;
    }

    public void setTele(Boolean tele) {
        this.tele = tele;
    }

    public Boolean getPiscina() {
        return piscina;
    }

    public void setPiscina(Boolean piscina) {
        this.piscina = piscina;
    }

    public Boolean getAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(Boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public Boolean getEstacionamientoGratuito() {
        return estacionamientoGratuito;
    }

    public void setEstacionamientoGratuito(Boolean estacionamientoGratuito) {
        this.estacionamientoGratuito = estacionamientoGratuito;
    }

    public Boolean getLibreDeHumo() {
        return libreDeHumo;
    }

    public void setLibreDeHumo(Boolean libreDeHumo) {
        this.libreDeHumo = libreDeHumo;
    }

    public Boolean getConVista() {
        return conVista;
    }

    public void setConVista(Boolean conVista) {
        this.conVista = conVista;
    }
}
