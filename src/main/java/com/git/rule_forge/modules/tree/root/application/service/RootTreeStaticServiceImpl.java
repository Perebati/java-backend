package com.git.rule_forge.modules.tree.root.application.service;

import jakarta.transaction.Transactional;
import com.git.rule_forge._shared.application.GenericServiceImpl;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.exception.models.ApplicationException;
import com.git.rule_forge.modules.input.domain.predefined.PredefinedTypeEnum;
import com.git.rule_forge.modules.tree._shared.application.service.interfaces.RootTreeService;
import com.git.rule_forge.modules.tree.root.application.service.interfaces.RootTreeStaticService;
import com.git.rule_forge.modules.tree.root.domain.RootTreeStatic;
import com.git.rule_forge.modules.tree.root.domain.factory.interfaces.RootTreeFactory;
import com.git.rule_forge.modules.tree.root.infrastructure.repository.interfaces.RootTreeStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class RootTreeStaticServiceImpl
 * @since v1.0 (06/02/2025)
 */
@Service
class RootTreeStaticServiceImpl
        extends GenericServiceImpl<RootTreeStatic, RootTreeStaticRepository>
        implements RootTreeStaticService {
    private final RootTreeService rootTreeService;
    private final RootTreeFactory rootTreeFactory;

    @Autowired
    protected RootTreeStaticServiceImpl(
            RootTreeStaticRepository repository,
            RootTreeService rootTreeService,
            RootTreeFactory rootTreeFactory
    ) {
        super(repository);
        this.rootTreeService = rootTreeService;
        this.rootTreeFactory = rootTreeFactory;
    }

    /**
     * Creates a Root node that references a static input by its type.
     *
     * @param name         Name of given root node.
     * @param static_input Identification of referenced predefined input.
     * @return RootTreeStatic
     * @throws ApplicationException Thrown when an error occurs on business level.
     * @author Lucas Batista Pereira
     * @since v1.0 (30/11/2024)
     */
    @Override
    @Transactional
    public RootTreeStatic create(String name, PredefinedTypeEnum static_input, Boolean keepHistory) throws SystemGlobalException {
        try {
            RootTreeStatic newNode = this.repository.create(rootTreeFactory.produce(name, static_input), getRepositoryAuth());
            if(keepHistory) this.rootTreeService.keepHistory(newNode.getId());
            return newNode;
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new ApplicationException("Something went wrong creating a static root.", e);
        }
    }
}