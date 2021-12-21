
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Cliente;
import logica.Empleado;
import logica.ServicioTuristico;
import logica.PaqueteTuristico;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public VentaJpaController(){
        emf = Persistence.createEntityManagerFactory("TpFinalPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = venta.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getId());
                venta.setCliente(cliente);
            }
            Empleado empleado = venta.getEmpleado();
            if (empleado != null) {
                empleado = em.getReference(empleado.getClass(), empleado.getId());
                venta.setEmpleado(empleado);
            }
            ServicioTuristico servicioTuristico = venta.getServicioTuristico();
            if (servicioTuristico != null) {
                servicioTuristico = em.getReference(servicioTuristico.getClass(), servicioTuristico.getCodigoServicio());
                venta.setServicioTuristico(servicioTuristico);
            }
            PaqueteTuristico paqueteTuristico = venta.getPaqueteTuristico();
            if (paqueteTuristico != null) {
                paqueteTuristico = em.getReference(paqueteTuristico.getClass(), paqueteTuristico.getCodigoPaquete());
                venta.setPaqueteTuristico(paqueteTuristico);
            }
            em.persist(venta);
            if (cliente != null) {
                cliente.getListaVentas().add(venta);
                cliente = em.merge(cliente);
            }
            if (empleado != null) {
                empleado.getListaVentas().add(venta);
                empleado = em.merge(empleado);
            }
            if (servicioTuristico != null) {
                servicioTuristico.getListaVentas().add(venta);
                servicioTuristico = em.merge(servicioTuristico);
            }
            if (paqueteTuristico != null) {
                paqueteTuristico.getListaVentas().add(venta);
                paqueteTuristico = em.merge(paqueteTuristico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getNumVenta());
            Cliente clienteOld = persistentVenta.getCliente();
            Cliente clienteNew = venta.getCliente();
            Empleado empleadoOld = persistentVenta.getEmpleado();
            Empleado empleadoNew = venta.getEmpleado();
            ServicioTuristico servicioTuristicoOld = persistentVenta.getServicioTuristico();
            ServicioTuristico servicioTuristicoNew = venta.getServicioTuristico();
            PaqueteTuristico paqueteTuristicoOld = persistentVenta.getPaqueteTuristico();
            PaqueteTuristico paqueteTuristicoNew = venta.getPaqueteTuristico();
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getId());
                venta.setCliente(clienteNew);
            }
            if (empleadoNew != null) {
                empleadoNew = em.getReference(empleadoNew.getClass(), empleadoNew.getId());
                venta.setEmpleado(empleadoNew);
            }
            if (servicioTuristicoNew != null) {
                servicioTuristicoNew = em.getReference(servicioTuristicoNew.getClass(), servicioTuristicoNew.getCodigoServicio());
                venta.setServicioTuristico(servicioTuristicoNew);
            }
            if (paqueteTuristicoNew != null) {
                paqueteTuristicoNew = em.getReference(paqueteTuristicoNew.getClass(), paqueteTuristicoNew.getCodigoPaquete());
                venta.setPaqueteTuristico(paqueteTuristicoNew);
            }
            venta = em.merge(venta);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getListaVentas().remove(venta);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getListaVentas().add(venta);
                clienteNew = em.merge(clienteNew);
            }
            if (empleadoOld != null && !empleadoOld.equals(empleadoNew)) {
                empleadoOld.getListaVentas().remove(venta);
                empleadoOld = em.merge(empleadoOld);
            }
            if (empleadoNew != null && !empleadoNew.equals(empleadoOld)) {
                empleadoNew.getListaVentas().add(venta);
                empleadoNew = em.merge(empleadoNew);
            }
            if (servicioTuristicoOld != null && !servicioTuristicoOld.equals(servicioTuristicoNew)) {
                servicioTuristicoOld.getListaVentas().remove(venta);
                servicioTuristicoOld = em.merge(servicioTuristicoOld);
            }
            if (servicioTuristicoNew != null && !servicioTuristicoNew.equals(servicioTuristicoOld)) {
                servicioTuristicoNew.getListaVentas().add(venta);
                servicioTuristicoNew = em.merge(servicioTuristicoNew);
            }
            if (paqueteTuristicoOld != null && !paqueteTuristicoOld.equals(paqueteTuristicoNew)) {
                paqueteTuristicoOld.getListaVentas().remove(venta);
                paqueteTuristicoOld = em.merge(paqueteTuristicoOld);
            }
            if (paqueteTuristicoNew != null && !paqueteTuristicoNew.equals(paqueteTuristicoOld)) {
                paqueteTuristicoNew.getListaVentas().add(venta);
                paqueteTuristicoNew = em.merge(paqueteTuristicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = venta.getNumVenta();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getNumVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = venta.getCliente();
            if (cliente != null) {
                cliente.getListaVentas().remove(venta);
                cliente = em.merge(cliente);
            }
            Empleado empleado = venta.getEmpleado();
            if (empleado != null) {
                empleado.getListaVentas().remove(venta);
                empleado = em.merge(empleado);
            }
            ServicioTuristico servicioTuristico = venta.getServicioTuristico();
            if (servicioTuristico != null) {
                servicioTuristico.getListaVentas().remove(venta);
                servicioTuristico = em.merge(servicioTuristico);
            }
            PaqueteTuristico paqueteTuristico = venta.getPaqueteTuristico();
            if (paqueteTuristico != null) {
                paqueteTuristico.getListaVentas().remove(venta);
                paqueteTuristico = em.merge(paqueteTuristico);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
