package com.git.rule_forge.modules.tree.comparison.application.usecase.command;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.comparison.adpter.web.request.ComparisonMultiRecord;
import com.git.rule_forge.modules.tree.comparison.application.service.interfaces.ComparisonMultiService;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import org.springframework.stereotype.Component;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class CreateComparisonMulti
 * @since v1.0 (06/02/2025)
 */
@Component
public class CreateComparisonMulti extends UseCase<ComparisonMultiRecord, ComparisonMulti, ComparisonMultiService> {
    public CreateComparisonMulti(ComparisonMultiService comparisonMultiService) {
        super(comparisonMultiService);
    }

    @Override
    public ComparisonMulti execute(ComparisonMultiRecord input) throws SystemGlobalException {
        return this.service.createComparison(input, true);
    }
}