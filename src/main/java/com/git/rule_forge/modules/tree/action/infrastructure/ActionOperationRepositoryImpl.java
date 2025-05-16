package com.git.rule_forge.modules.tree.action.infrastructure;

import jakarta.persistence.EntityManager;
import com.git.rule_forge._shared.infrastructure.repository.GenericBusinessRepositoryImpl;
import com.git.rule_forge.modules.tree.action.domain.ActionOperation;
import com.git.rule_forge.modules.tree.action.domain.ActionOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ActionOperationRepositoryImpl
 * @since v1.0 (30/11/2024)
 */
@Repository
class ActionOperationRepositoryImpl
        extends GenericBusinessRepositoryImpl<ActionOperation, ActionOperationEntity>
        implements ActionOperationRepository {
    @Autowired
    ActionOperationRepositoryImpl(
            ActionOperationMapper mapper,
            EntityManager entityManager) {
        super(mapper, new SimpleJpaRepository<>(ActionOperationEntity.class, entityManager), ActionOperationEntity.class);
    }
}
