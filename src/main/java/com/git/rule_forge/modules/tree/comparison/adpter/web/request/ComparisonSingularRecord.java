package com.git.rule_forge.modules.tree.comparison.adpter.web.request;

import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;
import org.springframework.lang.NonNull;

import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @record ComparisonCreationDTO
 * @since v1.0 (04/11/2024)
 */
public record ComparisonSingularRecord(@NonNull ComparisonSingular.ComparisonSingularTypeEnum type,
                                       @NonNull String jsonPath,
                                       @NonNull String variable,
                                       @NonNull UUID parentId,
                                       NodeTreeIf.SetNode position) {
}
