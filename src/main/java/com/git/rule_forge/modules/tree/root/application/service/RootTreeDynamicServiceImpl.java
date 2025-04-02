package com.git.rule_forge.modules.tree.root.application.service;

import jakarta.transaction.Transactional;
import com.git.rule_forge._shared.application.GenericServiceImpl;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.exception.models.ApplicationException;
import com.git.rule_forge.modules.tree._shared.application.service.interfaces.RootTreeService;
import com.git.rule_forge.modules.tree.root.application.service.interfaces.RootTreeDynamicService;
import com.git.rule_forge.modules.tree.root.domain.RootTreeDynamic;
import com.git.rule_forge.modules.tree.root.domain.factory.interfaces.RootTreeFactory;
import com.git.rule_forge.modules.tree.root.infrastructure.repository.interfaces.RootTreeDynamicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class RootTreeDynamicServiceImpl
 * @since v1.0 (06/02/2025)
 */
@Service
public class RootTreeDynamicServiceImpl
        extends GenericServiceImpl<RootTreeDynamic, RootTreeDynamicRepository>
        implements RootTreeDynamicService {
    private final RootTreeService rootTreeService;
    private final RootTreeFactory rootTreeFactory;

    @Autowired
    public RootTreeDynamicServiceImpl(
            RootTreeDynamicRepository repository,
            RootTreeService rootTreeService,
            RootTreeFactory rootTreeFactory
    ) {
        super(repository);
        this.rootTreeService = rootTreeService;
        this.rootTreeFactory = rootTreeFactory;
    }

    /**
     * Creates a Root node that references a dynamic input by its id.
     *
     * @param name          Name of given root node.
     * @param dynamic_input Identification of referenced dynamic input.
     * @return RootTreeDynamic
     * @throws SystemGlobalException DealSafe standard error.
     */
    @Override
    @Transactional
    public RootTreeDynamic create(String name, UUID dynamic_input, Boolean keepHistory) throws SystemGlobalException {
        try {
            RootTreeDynamic newRoot = this.repository.create(rootTreeFactory.produce(name, dynamic_input), getRepositoryAuth());
            if(keepHistory) this.rootTreeService.keepHistory(newRoot.getId());
            return newRoot;
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new ApplicationException("Something went wrong creating a dynamic root.", e);
        }
    }
}
