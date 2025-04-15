package com.git.rule_forge.modules.tree.node.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.node.adapter.web.request.NodeCreationData;
import com.git.rule_forge.modules.tree.node.adapter.web.request.NodeTreeBlockData;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeBlock;

import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeTreeBlockService
 * @since v1.0 (30/11/2024)
 */
public interface NodeTreeBlockService extends GenericService<NodeTreeBlock> {
    NodeTreeBlock createBlock(NodeCreationData nodeCreationData, Boolean keepHistory) throws SystemGlobalException;
    NodeTreeBlock updateBlock(UUID id, NodeTreeBlockData nodeTreeBlockData, Boolean keepHistory) throws SystemGlobalException;
}
