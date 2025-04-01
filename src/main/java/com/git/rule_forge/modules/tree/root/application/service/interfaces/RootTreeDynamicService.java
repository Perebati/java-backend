package com.git.rule_forge.modules.tree.root.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.root.domain.RootTreeDynamic;

import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class RootTreeDynamicService
 * @since v1.0 (06/02/2025)
 */
public interface RootTreeDynamicService extends GenericService<RootTreeDynamic> {
    RootTreeDynamic create(String name, UUID dynamic_input, Boolean keepHistory) throws SystemGlobalException;
}
