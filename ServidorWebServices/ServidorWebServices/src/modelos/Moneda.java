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
public class Moneda implements Serializable{
    @Id
    private String codigo;
    private String nombre;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s)", nombre, codigo);
    }
}
