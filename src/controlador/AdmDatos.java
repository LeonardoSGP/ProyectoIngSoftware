
package controlador;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdmDatos {
    protected static EntityManagerFactory emf;
    public EntityManagerFactory getEmf(){
        if(emf==null)
            emf = Persistence.createEntityManagerFactory("Proyecto_1PU");
            return emf;
    }
}
