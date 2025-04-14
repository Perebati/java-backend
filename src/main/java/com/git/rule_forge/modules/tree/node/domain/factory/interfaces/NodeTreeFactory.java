package com.git.rule_forge.modules.tree.node.domain.factory.interfaces;

import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeBlock;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeFactory
 * @since v1.0 (30/11/2024)
 */
public interface NodeTreeFactory {
    NodeTreeBlock produceBlock(String name, Node<?> nodeParent) throws SystemGlobalException;

    NodeTreeIf produceIf(Node<?> nodeParent) throws SystemGlobalException;

}
