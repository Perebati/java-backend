package com.git.rule_forge.modules.tree.comparison.infrastructure.repository;

import jakarta.persistence.EntityManager;
import com.git.rule_forge._shared.infrastructure.repository.GenericBusinessRepositoryImpl;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import com.git.rule_forge.modules.tree.comparison.infrastructure.ComparisonSingularEntity;
import com.git.rule_forge.modules.tree.comparison.infrastructure.mapper.ComparisonSingularMapper;
import com.git.rule_forge.modules.tree.comparison.infrastructure.repository.interfaces.ComparisonSingularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ComparisonOperationRepositoryImpl
 * @since v1.0 (30/11/2024)
 */
@Repository
class ComparisonSingularRepositoryImpl
        extends GenericBusinessRepositoryImpl<ComparisonSingular, ComparisonSingularEntity>
        implements ComparisonSingularRepository {

    @Autowired
    ComparisonSingularRepositoryImpl(
            ComparisonSingularMapper mapper,
            EntityManager entityManager
    ) {
        super(mapper, new SimpleJpaRepository<>(ComparisonSingularEntity.class, entityManager), ComparisonSingularEntity.class);
    }
}