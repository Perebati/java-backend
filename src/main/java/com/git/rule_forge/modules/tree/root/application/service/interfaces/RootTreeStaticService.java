package com.git.rule_forge.modules.tree.root.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.input.domain.predefined.PredefinedTypeEnum;
import com.git.rule_forge.modules.tree.root.domain.RootTreeStatic;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class RootTreeStaticService
 * @since v1.0 (06/02/2025)
 */
public interface RootTreeStaticService extends GenericService<RootTreeStatic> {
    RootTreeStatic create(String name, PredefinedTypeEnum static_input, Boolean keepHistory) throws SystemGlobalException;
}
