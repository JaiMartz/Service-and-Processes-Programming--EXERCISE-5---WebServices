/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorwebservices;

import java.util.List;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelos.Moneda;
import modelos.Pais;
import modelos.Zona;

/**
 *
 * @author Jairo
 */
@WebService
public class PaisesWebService {
    public List<Pais> getPaises() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("paises.odb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Pais> consulta = (TypedQuery<Pais>) entityManager.createQuery("SELECT pais FROM Pais pais");
        
        List<Pais> paises = consulta.getResultList();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return paises;
    }
    /**
     * Method that llow to return the countries in the same zone
     * @param idZona
     * @return 
     */
    public List<Pais> getPaisesZona(long idZona) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("paises.odb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Pais> consulta = (TypedQuery<Pais>) entityManager.createQuery("SELECT pais FROM Pais pais WHERE pais.idArea = " + idZona);
        
        List<Pais> paises = consulta.getResultList();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return paises;
    }
    /**
     * Method that allow to return all the countries with the same coin.
     * @param codigoDivisa
     * @return 
     */
    public List<Pais> getPaisesMoneda(String codigoDivisa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("paises.odb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Pais> consulta = (TypedQuery<Pais>) entityManager.createQuery("SELECT pais FROM Pais pais WHERE pais.codigoDivisa ='"+codigoDivisa+"'");
        
        List<Pais> paises = consulta.getResultList();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return paises;
    }
    
    /**
     * Method that allow to return the differents zones.
     * @return 
     */
    public List<Zona> getZonas() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("paises.odb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Zona> consulta = (TypedQuery<Zona>) entityManager.createQuery("SELECT zona FROM Zona zona");
        
        List<Zona> zonas = consulta.getResultList();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return zonas;
    }
    /**
     * Method that allow to return the different zones by their ID
     * @param idZona
     * @return 
     */
    
    public Zona getZonaById(long idZona) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("paises.odb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Zona> consulta = (TypedQuery<Zona>) entityManager.createQuery("SELECT zona FROM Zona zona WHERE zona.id = " + idZona);
        
        Zona zona = consulta.getSingleResult();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return zona;
    }
    /**
     * Method that return different coins.
     * @return 
     */
    public List<Moneda> getMonedas() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("paises.odb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Moneda> consulta = (TypedQuery<Moneda>) entityManager.createQuery("SELECT moneda FROM Moneda moneda");
        
        List<Moneda> monedas = consulta.getResultList();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return monedas;
    }
    
    /**
     * Method that allow to return coins by their different codes.
    */
    public Moneda getMonedaByCodigo(String codigo) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("paises.odb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Moneda> consulta = (TypedQuery<Moneda>) entityManager.createQuery("SELECT moneda FROM Moneda moneda WHERE moneda.codigo ='"+codigo+"'");
        
        Moneda moneda = consulta.getSingleResult();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return moneda;
    }
}
