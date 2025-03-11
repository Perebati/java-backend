package com.git.rule_forge.modules.input.adapter.web.controller;

import lombok.AllArgsConstructor;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.exception.models.AdapterException;
import com.git.rule_forge.modules.input.adapter.web.controller.interfaces.InputController;
import com.git.rule_forge.modules.input.adapter.web.request.CreateInputData;
import com.git.rule_forge.modules.input.application.usecase.command.CreateInputUseCase;
import com.git.rule_forge.modules.input.application.usecase.query.FindInputUseCase;
import com.git.rule_forge.modules.input.domain.Input;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class InputController
 * @since v1.0 (30/11/2024)
 */
@Controller
@AllArgsConstructor
class InputControllerImpl implements InputController {
    private final CreateInputUseCase createInputUseCase;
    private final FindInputUseCase findInputUseCase;


    @Override
    public ResponseEntity<Input> createInput(@NonNull CreateInputData request)
            throws SystemGlobalException {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.createInputUseCase.execute(request));
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new AdapterException("Unexpected error in input creation.", e);
        }
    }

    @Override
    public ResponseEntity<Optional<Input>> readInput(@NonNull UUID id)
            throws SystemGlobalException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.findInputUseCase.execute(id));
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new AdapterException("Unexpected error in input reading.", e);
        }
    }
}