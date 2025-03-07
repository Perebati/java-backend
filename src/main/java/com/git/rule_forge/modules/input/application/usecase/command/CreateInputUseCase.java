package com.git.rule_forge.modules.input.application.usecase.command;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.input.adapter.web.request.CreateInputData;
import com.git.rule_forge.modules.input.application.service.interfaces.InputService;
import com.git.rule_forge.modules.input.domain.Input;
import org.springframework.stereotype.Component;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class CreateInputUseCase
 * @since v1.0 (07/02/2025)
 */
@Component
public class CreateInputUseCase extends UseCase<CreateInputData, Input, InputService> {
    public CreateInputUseCase(InputService inputService) {
        super(inputService);
    }

    @Override
    public Input execute(CreateInputData input) throws SystemGlobalException {
        return this.service.createInput(input);
    }
}