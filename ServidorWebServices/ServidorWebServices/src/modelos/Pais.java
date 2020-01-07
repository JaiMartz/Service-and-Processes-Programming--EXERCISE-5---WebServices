/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author alconesp
 */
@Entity
public class Pais  implements Serializable{
    @Id
    private long id;
    private String nombre;
    private long idArea;
    private String codigoDivisa;
    private String codigoBandera;
    private String codigoNic;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    public String getCodigoDivisa() {
        return codigoDivisa;
    }

    public void setCodigoDivisa(String codigoDivisa) {
        this.codigoDivisa = codigoDivisa;
    }

    public String getCodigoBandera() {
        return codigoBandera;
    }

    public void setCodigoBandera(String codigoBandera) {
        this.codigoBandera = codigoBandera;
    }

    public String getCodigoNic() {
        return codigoNic;
    }

    public void setCodigoNic(String codigoNic) {
        this.codigoNic = codigoNic;
    }

    public Pais(long id, String nombre, long idArea, String codigoDivisa, String codigoBandera, String codigoNic) {
        this.id = id;
        this.nombre = nombre;
        this.idArea = idArea;
        this.codigoDivisa = codigoDivisa;
        this.codigoBandera = codigoBandera;
        this.codigoNic = codigoNic;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s", nombre, codigoDivisa);
    }
}
