package com.git.rule_forge.modules.tree.comparison.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.comparison.adpter.web.request.ComparisonSingularRecord;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ComparisonOperationBusiness
 * @since v1.0 (30/11/2024)
 */
public interface ComparisonSingularService extends GenericService<ComparisonSingular> {
    ComparisonSingular createComparison(ComparisonSingularRecord input,
                                        Boolean keepHistory) throws SystemGlobalException;
}
