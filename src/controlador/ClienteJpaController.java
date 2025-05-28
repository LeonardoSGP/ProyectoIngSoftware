package controlador;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Cliente;

public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public ClienteJpaController() {
         this.emf = Persistence.createEntityManagerFactory("Proyecto_1PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Error al guardar cliente: " + e);
        } finally {
            if (em != null) em.close();
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente existente = em.find(Cliente.class, cliente.getIdCliente());

            if (existente == null) {
                throw new NonexistentEntityException("El cliente con id " + cliente.getIdCliente() + " no existe.");
            }

            existente.setNombre(cliente.getNombre());
            existente.setApellido(cliente.getApellido());
            existente.setCedula(cliente.getCedula());
            existente.setTelefono(cliente.getTelefono());
            existente.setDireccion(cliente.getDireccion());
            existente.setEstado(cliente.getEstado());

            em.merge(existente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            if (em != null) em.close();
        }
    }

    public void destroy(int idCliente) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, idCliente);
                cliente.getIdCliente(); // Forzar acceso para validar existencia
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El cliente con id " + idCliente + " no existe.", enfe);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Error al eliminar cliente: " + e);
        } finally {
            if (em != null) em.close();
        }
    }

    public boolean existeCliente(String cedula) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Cliente> query = em.createQuery(
                "SELECT c FROM Cliente c WHERE c.cedula = :cedula", Cliente.class);
            query.setParameter("cedula", cedula);
            return !query.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }

    public boolean existeTelefono(String telefono) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Cliente> query = em.createQuery(
                "SELECT c FROM Cliente c WHERE c.telefono = :telefono", Cliente.class);
            query.setParameter("telefono", telefono);
            return !query.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(Integer idCliente) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, idCliente);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            respuesta = true;
        } catch (Exception e) {
            System.out.println("Error al guardar cliente: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

        return respuesta;
    }
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Cliente clienteExistente = em.find(Cliente.class, idCliente);

            if (clienteExistente != null) {
                clienteExistente.setNombre(objeto.getNombre());
                clienteExistente.setApellido(objeto.getApellido());
                clienteExistente.setCedula(objeto.getCedula());
                clienteExistente.setTelefono(objeto.getTelefono());
                clienteExistente.setDireccion(objeto.getDireccion());
                clienteExistente.setEstado(objeto.getEstado());
                em.getTransaction().commit();
                respuesta = true;
            } else {
                em.getTransaction().rollback();
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar cliente: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

        return respuesta;
    }

    /**
     * Método para eliminar un cliente.
     */
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, idCliente);

            if (cliente != null) {
                em.remove(cliente);
                em.getTransaction().commit();
                respuesta = true;
            } else {
                em.getTransaction().rollback();
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

        return respuesta;
    }
}
