package com.git.rule_forge.modules.input.infrastructure.repository;

import jakarta.persistence.EntityManager;
import com.git.rule_forge._shared.infrastructure.repository.GenericBusinessRepositoryImpl;
import com.git.rule_forge.modules.input.domain.Input;
import com.git.rule_forge.modules.input.infrastructure.InputEntity;
import com.git.rule_forge.modules.input.infrastructure.mapper.InputMapper;
import com.git.rule_forge.modules.input.infrastructure.repository.interfaces.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class InputRepositoryImpl
 * @since v1.0 (30/11/2024)
 */


@Repository
class InputRepositoryImpl
        extends GenericBusinessRepositoryImpl<Input, InputEntity>
        implements InputRepository {

    @Autowired
    InputRepositoryImpl(
            InputMapper mapper,
            EntityManager entityManager) {
        super(mapper, new SimpleJpaRepository<>(InputEntity.class, entityManager), InputEntity.class);
    }
}