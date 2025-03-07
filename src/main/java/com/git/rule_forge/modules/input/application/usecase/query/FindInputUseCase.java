package com.git.rule_forge.modules.input.application.usecase.query;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.input.application.service.interfaces.InputService;
import com.git.rule_forge.modules.input.domain.Input;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ReadInputUseCase
 * @since v1.0 (07/02/2025)
 */
@Component
public class FindInputUseCase extends UseCase<UUID, Optional<Input>, InputService>{
    public FindInputUseCase(InputService inputService) {
        super(inputService);
    }

    @Override
    public Optional<Input> execute(UUID input) throws SystemGlobalException {
        return this.service.findById(input);
    }
}
