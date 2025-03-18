package com.git.rule_forge.modules.tree._shared.infrastructure.repository.interfaces;

import com.git.rule_forge._shared.infrastructure.RepositoryAuth;
import com.git.rule_forge._shared.infrastructure.repository.interfaces.GenericBusinessRepository;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree._shared.domain.NodeInput;

import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class NodeRepository
 * @since v1.0 (06/02/2025)
 */
public interface NodeRepository extends GenericBusinessRepository<Node<NodeInput>> {
    void deleteNode(UUID id, RepositoryAuth auth) throws SystemGlobalException;
}
