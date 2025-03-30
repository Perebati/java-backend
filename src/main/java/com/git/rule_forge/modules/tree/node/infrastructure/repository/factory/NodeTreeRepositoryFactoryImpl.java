package com.git.rule_forge.modules.tree.node.infrastructure.repository.factory;

import lombok.AllArgsConstructor;
import com.git.rule_forge._shared.infrastructure.repository.interfaces.GenericBusinessRepository;
import com.git.rule_forge.modules.tree.action.domain.NodeTreeActionRepository;
import com.git.rule_forge.modules.tree.comparison.infrastructure.repository.interfaces.ComparisonMultiRepository;
import com.git.rule_forge.modules.tree.comparison.infrastructure.repository.interfaces.ComparisonSingularRepository;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree.node.infrastructure.repository.factory.interfaces.NodeTreeRepositoryFactory;
import com.git.rule_forge.modules.tree.node.infrastructure.repository.interfaces.NodeTreeBlockRepository;
import com.git.rule_forge.modules.tree.node.infrastructure.repository.interfaces.NodeTreeIfRepository;
import org.springframework.stereotype.Component;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class NodeTreeRepositoryFactoryImpl
 * @since v1.0 (06/02/2025)
 */
@Component
@AllArgsConstructor
class NodeTreeRepositoryFactoryImpl implements NodeTreeRepositoryFactory {
    private final NodeTreeBlockRepository nodeTreeBlockRepository;
    private final NodeTreeIfRepository nodeTreeIfRepository;
    private final NodeTreeActionRepository nodeTreeActionRepository;
    private final ComparisonMultiRepository comparisonMultiRepository;
    private final ComparisonSingularRepository comparisonSingularRepository;

    @SuppressWarnings("unchecked")
    public <T extends Node<?>> GenericBusinessRepository<T> getRepositoryForNode(T node) {
        return switch (node.getNodeType()) {
            case Node.NodeType.NODE_BLOCK -> (GenericBusinessRepository<T>) nodeTreeBlockRepository;
            case Node.NodeType.NODE_IF -> (GenericBusinessRepository<T>) nodeTreeIfRepository;
            case Node.NodeType.NODE_ACTION -> (GenericBusinessRepository<T>) nodeTreeActionRepository;
            case Node.NodeType.CONDITIONAL_COMPARISON_SINGULAR ->
                    (GenericBusinessRepository<T>) comparisonSingularRepository;
            case Node.NodeType.CONDITIONAL_COMPARISON_MULTIPLE ->
                    (GenericBusinessRepository<T>) comparisonMultiRepository;
            default -> throw new IllegalArgumentException("Unsupported node type: " + node.getNodeType());
        };
    }
}