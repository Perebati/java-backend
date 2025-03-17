package com.git.rule_forge.modules.tree._shared.infrastructure.mapper;

import com.git.rule_forge.modules.tree._shared.domain.NodeInput;
import com.git.rule_forge.modules.tree._shared.domain.RootTree;
import com.git.rule_forge.modules.tree._shared.infrastructure.RootTreeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class RootTreeMapper
 * @since v1.0 (30/11/2024)
 */
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@Primary
public interface RootTreeMapper extends NodeTreeGenericMapper<RootTree<NodeInput>, RootTreeEntity> {
    @Override
    @Mapping(target = "nodes", source = "nodes", qualifiedByName = "mapNodes")
    RootTree<NodeInput> toEntity(RootTreeEntity schema);
}