package com.git.rule_forge.modules.tree.action.domain;

import com.git.rule_forge.exception.SystemGlobalException;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ActionOperationFactory
 * @since v1.0 (30/11/2024)
 */

public interface ActionOperationFactory {
    ActionOperation produce(String url, String message) throws SystemGlobalException;
}
