package com.git.rule_forge.modules.tree.root.domain.factory.interfaces;

import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.input.domain.predefined.PredefinedTypeEnum;
import com.git.rule_forge.modules.tree.root.domain.RootTreeDynamic;
import com.git.rule_forge.modules.tree.root.domain.RootTreeStatic;

import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class TreeRootFactory
 * @since v1.0 (30/11/2024)
 */
public interface RootTreeFactory {
    RootTreeDynamic produce(String name, UUID dynamic_input) throws SystemGlobalException;

    RootTreeStatic produce(String name, PredefinedTypeEnum static_input) throws SystemGlobalException;
}
