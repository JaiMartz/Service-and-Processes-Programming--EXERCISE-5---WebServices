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
public class Zona  implements Serializable{
    @Id
    private long id;
    private String nombre;
    
    

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

    public Zona(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
