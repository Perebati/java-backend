package com.git.rule_forge.modules.tree.node.infrastructure.repository;

import jakarta.persistence.EntityManager;
import com.git.rule_forge._shared.infrastructure.repository.GenericBusinessRepositoryImpl;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;
import com.git.rule_forge.modules.tree.node.infrastructure.NodeTreeIfEntity;
import com.git.rule_forge.modules.tree.node.infrastructure.mapper.NodeTreeIfMapper;
import com.git.rule_forge.modules.tree.node.infrastructure.repository.interfaces.NodeTreeIfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class NodeTreeIfRepositoryImpl
 * @since v1.0 (06/02/2025)
 */
@Repository
class NodeTreeIfRepositoryImpl
        extends GenericBusinessRepositoryImpl<NodeTreeIf, NodeTreeIfEntity>
        implements NodeTreeIfRepository {

    @Autowired
    NodeTreeIfRepositoryImpl(
            NodeTreeIfMapper mapper,
            EntityManager entityManager
    ) {
        super(mapper, new SimpleJpaRepository<>(NodeTreeIfEntity.class, entityManager), NodeTreeIfEntity.class);
    }
}