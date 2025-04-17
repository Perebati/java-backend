package com.git.rule_forge.modules.tree.comparison.application.usecase.query;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.comparison.application.service.interfaces.ComparisonMultiService;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class ReadComparisonMulti
 * @since v1.0 (06/02/2025)
 */
@Component
public class ReadComparisonMulti extends UseCase<UUID, Optional<ComparisonMulti>, ComparisonMultiService> {
    public ReadComparisonMulti(ComparisonMultiService comparisonMultiService) {
        super(comparisonMultiService);
    }

    @Override
    public Optional<ComparisonMulti> execute(UUID input) throws SystemGlobalException {
        return service.findById(input);
    }
}