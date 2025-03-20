package com.git.rule_forge.modules.tree._shared.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree._shared.domain.NodeInput;
import com.git.rule_forge.modules.tree._shared.domain.RootTree;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class RootTreeService
 * @since v1.0 (30/11/2024)
 */
public interface RootTreeService extends GenericService<RootTree<NodeInput>> {
    Object readGenericRoot(UUID id) throws SystemGlobalException;

    Optional<UUID> findRootIdByNodeId(UUID node_id) throws SystemGlobalException;

    void keepHistory(UUID id) throws SystemGlobalException;
}
