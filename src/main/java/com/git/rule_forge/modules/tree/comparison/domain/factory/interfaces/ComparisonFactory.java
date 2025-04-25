package com.git.rule_forge.modules.tree.comparison.domain.factory.interfaces;

import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import com.git.rule_forge.modules.tree._shared.domain.Node;

import java.util.List;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ComparisonOperationFactory
 * @since v1.0 (30/11/2024)
 */
public interface ComparisonFactory {
    ComparisonSingular produce(
            ComparisonSingular.ComparisonSingularTypeEnum type,
            String jsonPath, String variable,
            Node<?> parent
    ) throws SystemGlobalException;

    ComparisonMulti produce(
            ComparisonMulti.ComparisonMultiTypeEnum comparisonTypeEnum,
            String jsonVariablePath,
            List<String> expectedVars,
            Node<?> parent
    ) throws SystemGlobalException;
}