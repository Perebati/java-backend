package com.git.rule_forge.modules.tree.comparison.application.service;

import com.git.rule_forge._shared.application.GenericServiceImpl;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.exception.models.ApplicationException;
import com.git.rule_forge.modules.tree._shared.application.service.interfaces.NodeService;
import com.git.rule_forge.modules.tree._shared.application.service.interfaces.NodeTreeService;
import com.git.rule_forge.modules.tree._shared.application.service.interfaces.RootTreeService;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree.comparison.adpter.web.request.ComparisonMultiRecord;
import com.git.rule_forge.modules.tree.comparison.application.service.interfaces.ComparisonMultiService;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.domain.factory.interfaces.ComparisonFactory;
import com.git.rule_forge.modules.tree.comparison.infrastructure.repository.interfaces.ComparisonMultiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handles Writing/Reading operations of a comparison that uses a fixed multi variable list.
 *
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class ComparisonMultiServiceImpl
 * @since v1.0 (06/02/2025)
 */
@Service
class ComparisonMultiServiceImpl
        extends GenericServiceImpl<ComparisonMulti, ComparisonMultiRepository>
        implements ComparisonMultiService {
    private final NodeService nodeService;
    private final RootTreeService rootTreeService;
    private final NodeTreeService<ComparisonMulti> nodeTreeService;
    private final ComparisonFactory comparisonOperationFactory;


    @Autowired
    public ComparisonMultiServiceImpl(
            ComparisonMultiRepository comparisonMultiRepository,
            ComparisonFactory comparisonOperationFactory,
            NodeService nodeService,
            RootTreeService rootTreeService,
            NodeTreeService<ComparisonMulti> nodeTreeService
    ) {
        super(comparisonMultiRepository);
        this.comparisonOperationFactory = comparisonOperationFactory;
        this.nodeService = nodeService;
        this.rootTreeService = rootTreeService;
        this.nodeTreeService = nodeTreeService;
    }

    /**
     * Handles creation of a comparison that operates upon a fixed list of variables.
     *
     * @param request Record containing all data for Comparison creation.
     * @return ComparisonMulti
     * @throws SystemGlobalException Standard DealSafe error.
     */
    public ComparisonMulti createComparison(ComparisonMultiRecord request,
                                            Boolean keepHistory) throws SystemGlobalException {
        try {
            Node<?> parent = this.nodeService.read(request.parentId());
            ComparisonMulti newOperation = this.comparisonOperationFactory.produce(
                    request.type(),
                    request.jsonPath(),
                    request.variables(),
                    parent);
            newOperation = this.nodeTreeService.createNode(newOperation, parent, request.position());
            if(keepHistory) this.rootTreeService.keepHistory(newOperation.getId());
            return newOperation;
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new ApplicationException("Something went wrong creating a comparison operation.", e);
        }
    }
}