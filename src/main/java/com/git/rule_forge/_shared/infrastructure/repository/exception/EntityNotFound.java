package com.git.rule_forge._shared.infrastructure.repository.exception;

import com.git.rule_forge.exception.models.InfrastructureException;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @since v1.0 (06/02/2025)
 */
public class EntityNotFound extends InfrastructureException {
    public EntityNotFound(String message, Throwable e) {
        super(message, e);
    }
}
