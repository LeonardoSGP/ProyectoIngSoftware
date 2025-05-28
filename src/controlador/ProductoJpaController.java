package controlador;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Producto;

public class ProductoJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ProductoJpaController() {
      this.emf = Persistence.createEntityManagerFactory("Proyecto_1PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Guardar nuevo producto
    public void create(Producto producto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Error al guardar producto: " + e);
        } finally {
            if (em != null) em.close();
        }
    }

    // Editar producto
    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Producto existente = em.find(Producto.class, producto.getIdProducto());
            if (existente == null) {
                throw new NonexistentEntityException("El producto con ID " + producto.getIdProducto() + " no existe.");
            }

            existente.setNombre(producto.getNombre());
            existente.setCantidad(producto.getCantidad());
            existente.setPrecio(producto.getPrecio());
            existente.setDescripcion(producto.getDescripcion());
            existente.setPorcentajeIva(producto.getPorcentajeIva());
            existente.setIdCategoria(producto.getIdCategoria());
            existente.setEstado(producto.getEstado());

            em.merge(existente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            if (em != null) em.close();
        }
    }

    // Eliminar producto
    public void destroy(int idProducto) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, idProducto);
                producto.getIdProducto(); // Forzar acceso
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El producto con ID " + idProducto + " no existe.", enfe);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Error al eliminar producto: " + e);
        } finally {
            if (em != null) em.close();
        }
    }

    // Verifica si existe un producto por nombre
    public boolean existeProducto(String nombre) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(p) FROM Producto p WHERE p.nombre = :nombre", Long.class);
            query.setParameter("nombre", nombre);
            return query.getSingleResult() > 0;
        } finally {
            em.close();
        }
    }

    // Verifica si existe un producto por descripción (código)
    public boolean existeCodigo(String codigo) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(p) FROM Producto p WHERE p.descripcion = :codigo", Long.class);
            query.setParameter("codigo", codigo);
            return query.getSingleResult() > 0;
        } finally {
            em.close();
        }
    }

    // Actualiza únicamente el stock
    public void actualizarStock(int idProducto, int nuevaCantidad) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Producto producto = em.find(Producto.class, idProducto);
            if (producto == null) {
                throw new NonexistentEntityException("El producto con ID " + idProducto + " no existe.");
            }
            producto.setCantidad(nuevaCantidad);
            em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Error al actualizar stock: " + e);
        } finally {
            em.close();
        }
    }

    // Listado completo
    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    // Listado con paginación
    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    // Buscar por ID
    public Producto findProducto(int idProducto) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, idProducto);
        } finally {
            em.close();
        }
    }

    // Contar productos
    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
        public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            respuesta = true;
        } catch (Exception e) {
            System.out.println("Error al guardar producto: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return respuesta;
    }
         public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Producto p = em.find(Producto.class, idProducto);
            if (p != null) {
                p.setNombre(objeto.getNombre());
                p.setCantidad(objeto.getCantidad());
                p.setPrecio(objeto.getPrecio());
                p.setDescripcion(objeto.getDescripcion());
                p.setPorcentajeIva(objeto.getPorcentajeIva());
                p.setIdCategoria(objeto.getIdCategoria());
                p.setEstado(objeto.getEstado());
                em.merge(p);
                respuesta = true;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return respuesta;
    }

    /**
     * Método para eliminar un producto.
     */
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Producto p = em.find(Producto.class, idProducto);
            if (p != null) {
                em.remove(p);
                respuesta = true;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return respuesta;
    }
        public boolean actualizarStock(Producto objeto, int idProducto) {
        boolean respuesta = false;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Producto p = em.find(Producto.class, idProducto);
            if (p != null) {
                p.setCantidad(objeto.getCantidad());
                em.merge(p);
                respuesta = true;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar stock del producto: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return respuesta;
    }

}
