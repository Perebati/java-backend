package com.git.rule_forge.modules.input.application.usecase.query;

import com.git.rule_forge._shared.application.usecase.NullInputUseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.input.application.service.interfaces.InputService;
import com.git.rule_forge.modules.input.domain.Input;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ReadAllInputUseCase
 * @since v1.0 (07/02/2025)
 */

@Component
public class ReadAllInputUseCase extends NullInputUseCase<List<Input>, InputService> {
    public ReadAllInputUseCase(InputService inputService) {
        super(inputService);
    }

    @Override
    public List<Input> execute() throws SystemGlobalException {
        return this.service.readAll().get();
    }
}