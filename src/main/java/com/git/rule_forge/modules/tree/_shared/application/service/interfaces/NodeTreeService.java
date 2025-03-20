package com.git.rule_forge.modules.tree._shared.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree._shared.domain.NodeInput;
import com.git.rule_forge.modules.tree._shared.domain.NodeTree;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeTreeService
 * @since v1.0 (10/02/2025)
 */
public interface NodeTreeService<T extends NodeTree<NodeInput>> extends GenericService<NodeTree<NodeInput>> {
    T createNode(T newNode,
                 Node<?> parent,
                 NodeTreeIf.SetNode nodeSet) throws SystemGlobalException;
}
