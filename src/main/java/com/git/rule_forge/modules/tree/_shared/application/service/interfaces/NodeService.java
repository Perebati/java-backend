package com.git.rule_forge.modules.tree._shared.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree._shared.domain.NodeInput;

import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeService
 * @since v1.0 (13/02/2025)
 */

public interface NodeService extends GenericService<Node<NodeInput>> {
    void deleteNode(UUID id, Boolean keepHistory) throws SystemGlobalException;
}
