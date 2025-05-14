package com.git.rule_forge.modules.tree.action.infrastructure;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.git.rule_forge.modules.tree.action.domain.ActionEnum;
import com.git.rule_forge.modules.tree._shared.infrastructure.NodeEntity;
import com.git.rule_forge.modules.tree._shared.infrastructure.NodeTreeEntity;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeTreeActionEntity
 * @since 22/01/2025
 */

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(NodeEntity.DISCRIMINATOR_ACTION)
@Table(
        name = "tree_node_action",
        indexes = {
                @Index(name = "idx_tree_node_action_id", columnList = "id")
        }
)
public class NodeTreeActionEntity extends NodeTreeEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "action_type")
    ActionEnum actionType;
}