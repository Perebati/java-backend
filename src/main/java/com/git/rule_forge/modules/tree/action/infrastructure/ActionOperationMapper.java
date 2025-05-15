package com.git.rule_forge.modules.tree.action.infrastructure;

import com.git.rule_forge._shared.infrastructure.mapper.GenericBusinessMapper;
import com.git.rule_forge.modules.tree.action.domain.ActionOperation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class OperationActionMapper
 * @since v1.0 (30/11/2024)
 */
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@Primary
public interface ActionOperationMapper extends GenericBusinessMapper<ActionOperation, ActionOperationEntity> {
}
