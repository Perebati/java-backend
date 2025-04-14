package com.git.rule_forge.modules.tree.node.domain.factory;

import jakarta.validation.ValidationException;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.exception.models.DomainException;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeBlock;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;
import com.git.rule_forge.modules.tree.node.domain.factory.interfaces.NodeTreeFactory;
import org.springframework.stereotype.Component;

/**
 * Handles the creation and validation of Nodes.
 *
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeFactoryImpl
 * @since v1.0 (30/11/2024)
 */
@Component
class NodeTreeFactoryImpl implements NodeTreeFactory {

    /**
     * Validates business information and creates a NodeTree.
     *
     * @param name Name of the node.
     * @return NodeTree
     * @throws ValidationException Thrown when an error occurs on factory level.
     * @author Lucas Batista Pereira
     * @since v1.0 (30/11/2024)
     */
    public NodeTreeBlock produceBlock(String name, Node<?> nodeParent) throws SystemGlobalException {
        try {
            return new NodeTreeBlock(name, nodeParent);
        } catch (Exception e) {
            throw new DomainException("Something went wrong creating a node.", e);
        }
    }

    public NodeTreeIf produceIf(Node<?> nodeParent) throws SystemGlobalException {
        try {
            return new NodeTreeIf(nodeParent);
        } catch (Exception e) {
            throw new DomainException("Something went wrong creating a node.", e);
        }
    }
}