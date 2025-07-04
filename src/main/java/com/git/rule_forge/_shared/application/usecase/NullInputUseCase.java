package com.git.rule_forge._shared.application.usecase;

import com.git.rule_forge.exception.SystemGlobalException;

/**
 * UseCase for null input.
 *
 * @author Lucas Batista Pereira
 * @version v1.0
 * @since v1.0 (30/01/2025)
 */
public abstract class NullInputUseCase<OUT, SERVICE> {
    protected final SERVICE service;

    public NullInputUseCase(SERVICE service) {
        this.service = service;
    }

    public abstract OUT execute() throws SystemGlobalException;
}