package com.git.rule_forge.modules.input.domain.factory.interfaces;

import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.input.domain.Input;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class InputFactory
 * @since v1.0 (30/11/2024)
 */

public interface InputFactory {
    Input produce(String name, String json) throws SystemGlobalException;
}
