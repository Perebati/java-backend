package com.git.rule_forge._shared.application.usecase;

import com.git.rule_forge.exception.SystemGlobalException;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @since v1.0 (10/02/2025)
 */
public abstract class UseCase2Inputs<IN1, IN2, OUT, SERVICE> {

    protected final SERVICE service;

    public UseCase2Inputs(SERVICE service) {
        this.service = service;
    }

    public abstract OUT execute(IN1 input1, IN2 input2) throws SystemGlobalException;
}