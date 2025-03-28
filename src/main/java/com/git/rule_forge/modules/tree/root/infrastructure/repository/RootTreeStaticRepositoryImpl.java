package com.git.rule_forge.modules.tree.root.infrastructure.repository;

import jakarta.persistence.EntityManager;
import com.git.rule_forge._shared.infrastructure.repository.GenericBusinessRepositoryImpl;
import com.git.rule_forge.modules.tree.root.domain.RootTreeStatic;
import com.git.rule_forge.modules.tree.root.infrastructure.RootTreeStaticEntity;
import com.git.rule_forge.modules.tree.root.infrastructure.mapper.RootTreeStaticMapper;
import com.git.rule_forge.modules.tree.root.infrastructure.repository.interfaces.RootTreeStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class RootTreeStaticRepositoryImpl
 * @since v1.0 (30/11/2024)
 */
@Repository
class RootTreeStaticRepositoryImpl
        extends GenericBusinessRepositoryImpl<RootTreeStatic, RootTreeStaticEntity>
        implements RootTreeStaticRepository {
    @Autowired
    RootTreeStaticRepositoryImpl(
            RootTreeStaticMapper mapper,
            EntityManager entityManager) {
        super(mapper, new SimpleJpaRepository<>(RootTreeStaticEntity.class, entityManager), RootTreeStaticEntity.class);
    }
}
