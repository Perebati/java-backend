package com.git.rule_forge.modules.tree.comparison.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.comparison.adpter.web.request.ComparisonMultiRecord;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class ComparisonMultiService
 * @since v1.0 (06/02/2025)
 */
public interface ComparisonMultiService extends GenericService<ComparisonMulti> {
    ComparisonMulti createComparison(ComparisonMultiRecord input,
                                     Boolean keepHistory) throws SystemGlobalException;
}
