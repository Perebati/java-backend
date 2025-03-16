package com.git.rule_forge.modules.tree.comparison.application.usecase.command;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.comparison.adpter.web.request.ComparisonSingularRecord;
import com.git.rule_forge.modules.tree.comparison.application.service.interfaces.ComparisonSingularService;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import org.springframework.stereotype.Component;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class CreateComparisonSingular
 * @since v1.0 (06/02/2025)
 */
@Component
public class CreateComparisonSingular extends UseCase<ComparisonSingularRecord, ComparisonSingular, ComparisonSingularService> {
    public CreateComparisonSingular(ComparisonSingularService comparisonSingularService) {
        super(comparisonSingularService);
    }

    @Override
    public ComparisonSingular execute(ComparisonSingularRecord input) throws SystemGlobalException {
        return this.service.createComparison(input, true);
    }
}