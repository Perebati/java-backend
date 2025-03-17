package com.git.rule_forge.modules.tree._shared.infrastructure.mapper;

import com.git.rule_forge._shared.domain.GenericClass;
import com.git.rule_forge._shared.infrastructure.GenericEntity;
import com.git.rule_forge._shared.infrastructure.mapper.GenericBusinessMapper;
import com.git.rule_forge.modules.tree._shared.domain.NodeInput;
import com.git.rule_forge.modules.tree._shared.domain.NodeTree;
import com.git.rule_forge.modules.tree._shared.infrastructure.NodeTreeEntity;
import com.git.rule_forge.modules.tree.action.domain.NodeTreeAction;
import com.git.rule_forge.modules.tree.action.infrastructure.NodeTreeActionEntity;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import com.git.rule_forge.modules.tree.comparison.infrastructure.ComparisonMultiEntity;
import com.git.rule_forge.modules.tree.comparison.infrastructure.ComparisonSingularEntity;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeBlock;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;
import com.git.rule_forge.modules.tree.node.infrastructure.NodeTreeBlockEntity;
import com.git.rule_forge.modules.tree.node.infrastructure.NodeTreeIfEntity;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class NodeTreeMapper
 * @since v1.0 (06/02/2025)
 */
public interface NodeTreeGenericMapper<E extends GenericClass, S extends GenericEntity>
        extends GenericBusinessMapper<E, S> {
    ComparisonMulti toComparisonMulti(ComparisonMultiEntity entity);

    ComparisonSingular toComparisonSingular(ComparisonSingularEntity entity);

    NodeTreeIf toNodeTreeIf(NodeTreeIfEntity entity);

    NodeTreeBlock toNodeTreeBlock(NodeTreeBlockEntity entity);

    NodeTreeAction toNodeTreeAction(NodeTreeActionEntity entity);

    default NodeTree<NodeInput> toEntity(NodeTreeEntity entity) {
        return switch (entity) {
            case null -> null;
            case ComparisonMultiEntity comparisonMultiEntity -> toComparisonMulti(comparisonMultiEntity);
            case ComparisonSingularEntity comparisonSingularEntity -> toComparisonSingular(comparisonSingularEntity);
            case NodeTreeIfEntity nodeTreeIfEntity -> toNodeTreeIf(nodeTreeIfEntity);
            case NodeTreeBlockEntity nodeTreeBlockEntity -> toNodeTreeBlock(nodeTreeBlockEntity);
            case NodeTreeActionEntity nodeTreeActionEntity -> toNodeTreeAction(nodeTreeActionEntity);
            default -> throw new IllegalArgumentException("Unknown node type: " + entity.getClass().getName());
        };
    }

    @Named("mapNodes")
    default List<NodeTree<NodeInput>> mapNodes(List<NodeTreeEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}