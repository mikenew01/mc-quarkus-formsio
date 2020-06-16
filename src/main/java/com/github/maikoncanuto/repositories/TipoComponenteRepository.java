package com.github.maikoncanuto.repositories;

import com.github.maikoncanuto.entities.TipoComponente;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class TipoComponenteRepository {

    @Inject
    EntityManager entityManager;

    @Transactional
    public TipoComponente save(final TipoComponente tipoComponente) {
        entityManager.persist(tipoComponente);
        return tipoComponente;
    }

    public TipoComponente update(final TipoComponente tipoComponente) {
        return entityManager.merge(tipoComponente);
    }

    public TipoComponente findById(final Long id) {
        return entityManager.find(TipoComponente.class, id);
    }

    public List<TipoComponente> findAll() {
        return entityManager.createQuery("SELECT tipo FROM TipoComponente tipo", TipoComponente.class).getResultList();
    }

}
