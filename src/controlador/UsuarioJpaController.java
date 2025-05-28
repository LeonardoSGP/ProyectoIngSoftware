package controlador;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Usuario;

public class UsuarioJpaController implements Serializable {

    private EntityManagerFactory emf;

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UsuarioJpaController() {
           this.emf = Persistence.createEntityManagerFactory("Proyecto_1PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear nuevo usuario
    public void create(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Error al guardar usuario: " + e);
        } finally {
            if (em != null) em.close();
        }
    }

    // Actualizar usuario
    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Usuario existente = em.find(Usuario.class, usuario.getIdUsuario());
            if (existente == null) {
                throw new NonexistentEntityException("El usuario con id " + usuario.getIdUsuario() + " no existe.");
            }

            existente.setNombre(usuario.getNombre());
            existente.setApellido(usuario.getApellido());
            existente.setUsuario(usuario.getUsuario());
            existente.setPassword(usuario.getPassword());
            existente.setTelefono(usuario.getTelefono());
            existente.setEstado(usuario.getEstado());

            em.merge(existente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            if (em != null) em.close();
        }
    }

    // Eliminar usuario
    public void destroy(int idUsuario) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, idUsuario);
                usuario.getIdUsuario(); // Forzar carga
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El usuario con id " + idUsuario + " no existe.", enfe);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Error al eliminar usuario: " + e);
        } finally {
            if (em != null) em.close();
        }
    }

    // Validar existencia por nombre de usuario
    public boolean existeUsuario(String nombreUsuario) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.usuario = :usuario", Usuario.class);
            query.setParameter("usuario", nombreUsuario);
            return !query.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }

    // Validar existencia por teléfono
    public boolean existeTelefono(String telefono) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.telefono = :telefono", Usuario.class);
            query.setParameter("telefono", telefono);
            return !query.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }

    // Login de usuario
    public boolean login(String usuario, String password) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.password = :password", Usuario.class);
            query.setParameter("usuario", usuario);
            query.setParameter("password", password);
            return !query.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }

    // Buscar usuario por ID
    public Usuario findUsuario(int idUsuario) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, idUsuario);
        } finally {
            em.close();
        }
    }

    // Listar todos los usuarios
    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    // Contar usuarios
    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     /**
     * Método para guardar un nuevo usuario
     */
    public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            respuesta = true;
        } catch (Exception e) {
            System.out.println("Error al guardar usuario: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

        return respuesta;
    }
    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.password = :password", Usuario.class);
            query.setParameter("usuario", objeto.getUsuario());
            query.setParameter("password", objeto.getPassword());
            List<Usuario> resultados = query.getResultList();
            respuesta = !resultados.isEmpty();
        } catch (Exception e) {
            System.out.println("Error al Iniciar Sesion: " + e);
        } finally {
            em.close();
        }

        return respuesta;
    }
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Usuario usuarioExistente = em.find(Usuario.class, idUsuario);
            if (usuarioExistente != null) {
                usuarioExistente.setNombre(objeto.getNombre());
                usuarioExistente.setApellido(objeto.getApellido());
                usuarioExistente.setUsuario(objeto.getUsuario());
                usuarioExistente.setPassword(objeto.getPassword());
                usuarioExistente.setTelefono(objeto.getTelefono());
                usuarioExistente.setEstado(objeto.getEstado());
                em.getTransaction().commit();
                respuesta = true;
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

        return respuesta;
    }

}
