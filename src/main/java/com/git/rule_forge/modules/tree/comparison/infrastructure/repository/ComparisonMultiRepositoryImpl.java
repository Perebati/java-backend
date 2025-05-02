package com.git.rule_forge.modules.tree.comparison.infrastructure.repository;

import jakarta.persistence.EntityManager;
import com.git.rule_forge._shared.infrastructure.repository.GenericBusinessRepositoryImpl;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.infrastructure.ComparisonMultiEntity;
import com.git.rule_forge.modules.tree.comparison.infrastructure.mapper.ComparisonMultiMapper;
import com.git.rule_forge.modules.tree.comparison.infrastructure.repository.interfaces.ComparisonMultiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class ComparisonMultiRepositoryImpl
 * @since v1.0 (06/02/2025)
 */
@Repository
public class ComparisonMultiRepositoryImpl
        extends GenericBusinessRepositoryImpl<ComparisonMulti, ComparisonMultiEntity>
        implements ComparisonMultiRepository {

    @Autowired
    ComparisonMultiRepositoryImpl(
            ComparisonMultiMapper mapper,
            EntityManager entityManager
    ) {
        super(mapper, new SimpleJpaRepository<>(ComparisonMultiEntity.class, entityManager), ComparisonMultiEntity.class);
    }
}