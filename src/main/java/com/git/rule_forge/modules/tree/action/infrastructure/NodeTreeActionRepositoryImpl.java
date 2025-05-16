package com.git.rule_forge.modules.tree.action.infrastructure;

import jakarta.persistence.EntityManager;
import com.git.rule_forge._shared.infrastructure.repository.GenericBusinessRepositoryImpl;
import com.git.rule_forge.modules.tree.action.domain.NodeTreeAction;
import com.git.rule_forge.modules.tree.action.domain.NodeTreeActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeTreeActionRepositoryImpl
 * @since 22/01/2025
 */

@Repository
class NodeTreeActionRepositoryImpl
        extends GenericBusinessRepositoryImpl<NodeTreeAction, NodeTreeActionEntity>
        implements NodeTreeActionRepository {

    @Autowired
    NodeTreeActionRepositoryImpl(
            NodeTreeActionMapper mapper,
            EntityManager entityManager
    ) {
        super(mapper, new SimpleJpaRepository<>(NodeTreeActionEntity.class, entityManager), NodeTreeActionEntity.class);
    }
}