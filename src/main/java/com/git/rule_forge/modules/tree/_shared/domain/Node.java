package com.git.rule_forge.modules.tree._shared.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import com.git.rule_forge._shared.domain.GenericBusinessClass;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeBlock;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;
import com.git.rule_forge.modules.tree.root.domain.RootTreeDynamic;
import com.git.rule_forge.modules.tree.root.domain.RootTreeStatic;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class Node
 * @since 24/01/2025
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION
)
@JsonSubTypes({
        @JsonSubTypes.Type(RootTreeStatic.class),
        @JsonSubTypes.Type(RootTreeDynamic.class),
        @JsonSubTypes.Type(NodeTreeBlock.class),
        @JsonSubTypes.Type(NodeTreeIf.class),
        @JsonSubTypes.Type(ComparisonSingular.class),
        @JsonSubTypes.Type(ComparisonMulti.class),
})
public class Node<T extends NodeInput> extends GenericBusinessClass implements NodeTraversal<T> {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private NodeType nodeType;

    @Override
    public boolean traverse(T inputData) {
        return false;
    }

    public enum NodeType {
        ROOT_STATIC,
        ROOT_DYNAMIC,
        NODE_BLOCK,
        NODE_ACTION,
        NODE_IF,
        CONDITIONAL_COMPARISON_SINGULAR,
        CONDITIONAL_COMPARISON_MULTIPLE,
        CONDITIONAL_COMPARISON_CUSTOM
    }
}