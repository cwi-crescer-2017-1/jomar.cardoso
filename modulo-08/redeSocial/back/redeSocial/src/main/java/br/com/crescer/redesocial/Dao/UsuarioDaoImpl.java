package br.com.crescer.redesocial.Dao;

import br.com.crescer.redesocial.models.Usuario;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

/**
 * @author carloshenrique
 */
public class UsuarioDaoImpl extends AbstractCrudDao<Usuario, BigDecimal> implements UsuarioDao {

    private final EntityManager entityManager;

    public UsuarioDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
