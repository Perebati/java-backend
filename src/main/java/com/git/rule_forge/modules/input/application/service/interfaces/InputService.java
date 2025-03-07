package com.git.rule_forge.modules.input.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.input.adapter.web.request.CreateInputData;
import com.git.rule_forge.modules.input.domain.Input;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class InputBusiness
 * @since v1.0 (30/11/2024)
 */

public interface InputService extends GenericService<Input> {
    Input createInput(CreateInputData request) throws SystemGlobalException;
}
