package com.git.rule_forge.modules.tree.comparison.application.usecase.query;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.comparison.application.service.interfaces.ComparisonSingularService;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class ReadComparisonSingular
 * @since v1.0 (06/02/2025)
 */
@Component
public class ReadComparisonSingular extends UseCase<UUID, Optional<ComparisonSingular>, ComparisonSingularService> {
    public ReadComparisonSingular(ComparisonSingularService comparisonSingularService) {
        super(comparisonSingularService);
    }

    @Override
    public Optional<ComparisonSingular> execute(UUID input) throws SystemGlobalException {
        return this.service.findById(input);
    }
}