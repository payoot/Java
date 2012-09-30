/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.in.java.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author nuboat
 */
public abstract class AbstractFacade<T> {
    private transient final Class<T> entityClass;

    public AbstractFacade(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract String getUnitName();

    protected abstract EntityManager getEntityManager();

    public void create(final T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(final T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(final T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(final Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        final CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(final int[] range) {
        final CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        final Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        final CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        final Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        final Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
