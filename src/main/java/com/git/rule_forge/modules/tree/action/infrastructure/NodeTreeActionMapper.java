package com.git.rule_forge.modules.tree.action.infrastructure;

import com.git.rule_forge._shared.infrastructure.mapper.GenericBusinessMapper;
import com.git.rule_forge.modules.tree.action.domain.NodeTreeAction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeTreeActionMapper
 * @since 22/01/2025
 */

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@Primary
public interface NodeTreeActionMapper extends GenericBusinessMapper<NodeTreeAction, NodeTreeActionEntity> {
}