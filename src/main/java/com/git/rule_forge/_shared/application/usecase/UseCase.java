package com.git.rule_forge._shared.application.usecase;

import com.git.rule_forge.exception.SystemGlobalException;

/**
 * Abstract class for UseCase,
 * every single UseCase should extend from this or its variations.
 *
 * @author Lucas Batista Pereira
 * @version v1.0
 * @since v1.0 (30/01/2025)
 */
public abstract class UseCase<IN, OUT, SERVICE>{
    protected final SERVICE service;

    public UseCase(SERVICE service) {
        this.service = service;
    }

    public abstract OUT execute(IN input) throws SystemGlobalException;
}