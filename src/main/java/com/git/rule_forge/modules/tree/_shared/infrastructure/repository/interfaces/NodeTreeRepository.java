package com.git.rule_forge.modules.tree._shared.infrastructure.repository.interfaces;

import com.git.rule_forge._shared.infrastructure.RepositoryAuth;
import com.git.rule_forge._shared.infrastructure.repository.interfaces.GenericBusinessRepository;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree._shared.domain.NodeInput;
import com.git.rule_forge.modules.tree._shared.domain.NodeTree;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeRepository
 * @since 24/01/2025
 */
public interface NodeTreeRepository<T extends NodeTree<NodeInput>>
        extends GenericBusinessRepository<NodeTree<NodeInput>> {
    T createNode(T newNode, Node<?> parent, NodeTreeIf.SetNode nodeSet, RepositoryAuth auth) throws SystemGlobalException;
}
