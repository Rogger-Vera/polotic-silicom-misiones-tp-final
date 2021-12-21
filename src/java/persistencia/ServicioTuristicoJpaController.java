
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.PaqueteTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.ServicioTuristico;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;


public class ServicioTuristicoJpaController implements Serializable {

    public ServicioTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ServicioTuristicoJpaController(){
        emf = Persistence.createEntityManagerFactory("TpFinalPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ServicioTuristico servicioTuristico) {
        if (servicioTuristico.getListaPaquetes() == null) {
            servicioTuristico.setListaPaquetes(new ArrayList<PaqueteTuristico>());
        }
        if (servicioTuristico.getListaVentas() == null) {
            servicioTuristico.setListaVentas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PaqueteTuristico> attachedListaPaquetes = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaquetesPaqueteTuristicoToAttach : servicioTuristico.getListaPaquetes()) {
                listaPaquetesPaqueteTuristicoToAttach = em.getReference(listaPaquetesPaqueteTuristicoToAttach.getClass(), listaPaquetesPaqueteTuristicoToAttach.getCodigoPaquete());
                attachedListaPaquetes.add(listaPaquetesPaqueteTuristicoToAttach);
            }
            servicioTuristico.setListaPaquetes(attachedListaPaquetes);
            List<Venta> attachedListaVentas = new ArrayList<Venta>();
            for (Venta listaVentasVentaToAttach : servicioTuristico.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getNumVenta());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            servicioTuristico.setListaVentas(attachedListaVentas);
            em.persist(servicioTuristico);
            for (PaqueteTuristico listaPaquetesPaqueteTuristico : servicioTuristico.getListaPaquetes()) {
                listaPaquetesPaqueteTuristico.getListaServicios().add(servicioTuristico);
                listaPaquetesPaqueteTuristico = em.merge(listaPaquetesPaqueteTuristico);
            }
            for (Venta listaVentasVenta : servicioTuristico.getListaVentas()) {
                ServicioTuristico oldServicioTuristicoOfListaVentasVenta = listaVentasVenta.getServicioTuristico();
                listaVentasVenta.setServicioTuristico(servicioTuristico);
                listaVentasVenta = em.merge(listaVentasVenta);
                if (oldServicioTuristicoOfListaVentasVenta != null) {
                    oldServicioTuristicoOfListaVentasVenta.getListaVentas().remove(listaVentasVenta);
                    oldServicioTuristicoOfListaVentasVenta = em.merge(oldServicioTuristicoOfListaVentasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ServicioTuristico servicioTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ServicioTuristico persistentServicioTuristico = em.find(ServicioTuristico.class, servicioTuristico.getCodigoServicio());
            List<PaqueteTuristico> listaPaquetesOld = persistentServicioTuristico.getListaPaquetes();
            List<PaqueteTuristico> listaPaquetesNew = servicioTuristico.getListaPaquetes();
            List<Venta> listaVentasOld = persistentServicioTuristico.getListaVentas();
            List<Venta> listaVentasNew = servicioTuristico.getListaVentas();
            List<PaqueteTuristico> attachedListaPaquetesNew = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaquetesNewPaqueteTuristicoToAttach : listaPaquetesNew) {
                listaPaquetesNewPaqueteTuristicoToAttach = em.getReference(listaPaquetesNewPaqueteTuristicoToAttach.getClass(), listaPaquetesNewPaqueteTuristicoToAttach.getCodigoPaquete());
                attachedListaPaquetesNew.add(listaPaquetesNewPaqueteTuristicoToAttach);
            }
            listaPaquetesNew = attachedListaPaquetesNew;
            servicioTuristico.setListaPaquetes(listaPaquetesNew);
            List<Venta> attachedListaVentasNew = new ArrayList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getNumVenta());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            servicioTuristico.setListaVentas(listaVentasNew);
            servicioTuristico = em.merge(servicioTuristico);
            for (PaqueteTuristico listaPaquetesOldPaqueteTuristico : listaPaquetesOld) {
                if (!listaPaquetesNew.contains(listaPaquetesOldPaqueteTuristico)) {
                    listaPaquetesOldPaqueteTuristico.getListaServicios().remove(servicioTuristico);
                    listaPaquetesOldPaqueteTuristico = em.merge(listaPaquetesOldPaqueteTuristico);
                }
            }
            for (PaqueteTuristico listaPaquetesNewPaqueteTuristico : listaPaquetesNew) {
                if (!listaPaquetesOld.contains(listaPaquetesNewPaqueteTuristico)) {
                    listaPaquetesNewPaqueteTuristico.getListaServicios().add(servicioTuristico);
                    listaPaquetesNewPaqueteTuristico = em.merge(listaPaquetesNewPaqueteTuristico);
                }
            }
            for (Venta listaVentasOldVenta : listaVentasOld) {
                if (!listaVentasNew.contains(listaVentasOldVenta)) {
                    listaVentasOldVenta.setServicioTuristico(null);
                    listaVentasOldVenta = em.merge(listaVentasOldVenta);
                }
            }
            for (Venta listaVentasNewVenta : listaVentasNew) {
                if (!listaVentasOld.contains(listaVentasNewVenta)) {
                    ServicioTuristico oldServicioTuristicoOfListaVentasNewVenta = listaVentasNewVenta.getServicioTuristico();
                    listaVentasNewVenta.setServicioTuristico(servicioTuristico);
                    listaVentasNewVenta = em.merge(listaVentasNewVenta);
                    if (oldServicioTuristicoOfListaVentasNewVenta != null && !oldServicioTuristicoOfListaVentasNewVenta.equals(servicioTuristico)) {
                        oldServicioTuristicoOfListaVentasNewVenta.getListaVentas().remove(listaVentasNewVenta);
                        oldServicioTuristicoOfListaVentasNewVenta = em.merge(oldServicioTuristicoOfListaVentasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicioTuristico.getCodigoServicio();
                if (findServicioTuristico(id) == null) {
                    throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.");
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
            ServicioTuristico servicioTuristico;
            try {
                servicioTuristico = em.getReference(ServicioTuristico.class, id);
                servicioTuristico.getCodigoServicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.", enfe);
            }
            List<PaqueteTuristico> listaPaquetes = servicioTuristico.getListaPaquetes();
            for (PaqueteTuristico listaPaquetesPaqueteTuristico : listaPaquetes) {
                listaPaquetesPaqueteTuristico.getListaServicios().remove(servicioTuristico);
                listaPaquetesPaqueteTuristico = em.merge(listaPaquetesPaqueteTuristico);
            }
            List<Venta> listaVentas = servicioTuristico.getListaVentas();
            for (Venta listaVentasVenta : listaVentas) {
                listaVentasVenta.setServicioTuristico(null);
                listaVentasVenta = em.merge(listaVentasVenta);
            }
            em.remove(servicioTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ServicioTuristico> findServicioTuristicoEntities() {
        return findServicioTuristicoEntities(true, -1, -1);
    }

    public List<ServicioTuristico> findServicioTuristicoEntities(int maxResults, int firstResult) {
        return findServicioTuristicoEntities(false, maxResults, firstResult);
    }

    private List<ServicioTuristico> findServicioTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ServicioTuristico.class));
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

    public ServicioTuristico findServicioTuristico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ServicioTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ServicioTuristico> rt = cq.from(ServicioTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
