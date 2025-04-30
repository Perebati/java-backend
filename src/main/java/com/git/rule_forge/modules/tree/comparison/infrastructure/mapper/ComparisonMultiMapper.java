package com.git.rule_forge.modules.tree.comparison.infrastructure.mapper;

import com.git.rule_forge._shared.infrastructure.mapper.GenericBusinessMapper;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.infrastructure.ComparisonMultiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class ComparisonMultiMapper
 * @since v1.0 (06/02/2025)
 */
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@Primary
public interface ComparisonMultiMapper extends GenericBusinessMapper<ComparisonMulti, ComparisonMultiEntity> {
}
