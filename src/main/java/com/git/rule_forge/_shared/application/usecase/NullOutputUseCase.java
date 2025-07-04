package com.git.rule_forge._shared.application.usecase;

import com.git.rule_forge.exception.SystemGlobalException;

/**
 * UseCase for null output.
 *
 * @author Lucas Batista Pereira
 * @version v1.0
 * @since v1.0 (30/01/2025)
 */
public abstract class NullOutputUseCase<IN, SERVICE> {
    protected final SERVICE service;
    protected NullOutputUseCase(SERVICE service) {
        this.service = service;
    }

    public abstract void execute(IN input) throws SystemGlobalException;
}
