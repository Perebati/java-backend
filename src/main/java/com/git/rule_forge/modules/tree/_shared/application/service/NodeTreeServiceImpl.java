package com.git.rule_forge.modules.tree._shared.application.service;

import com.git.rule_forge._shared.application.GenericServiceImpl;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.exception.models.ApplicationException;
import com.git.rule_forge.modules.tree._shared.application.service.interfaces.NodeTreeService;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree._shared.domain.NodeInput;
import com.git.rule_forge.modules.tree._shared.domain.NodeTree;
import com.git.rule_forge.modules.tree._shared.infrastructure.repository.interfaces.NodeTreeRepository;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;
import org.springframework.stereotype.Service;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeTreeServiceImpl
 * @since v1.0 (10/02/2025)
 */

@Service
class NodeTreeServiceImpl<T extends NodeTree<NodeInput>>
        extends GenericServiceImpl<NodeTree<NodeInput>, NodeTreeRepository<T>>
        implements NodeTreeService<T> {

    protected NodeTreeServiceImpl(NodeTreeRepository<T> repository) {
        super(repository);
    }

    @Override
    public T createNode(T newNode,
                        Node<?> parent,
                        NodeTreeIf.SetNode nodeSet) throws SystemGlobalException {
        try {
            return this.repository.createNode(newNode, parent, nodeSet, getRepositoryAuth());
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new ApplicationException("Something went wrong creating a new node", e);
        }
    }
}