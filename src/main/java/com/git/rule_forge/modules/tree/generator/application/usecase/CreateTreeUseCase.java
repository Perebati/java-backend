package com.git.rule_forge.modules.tree.generator.application.usecase;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.generator.application.service.interfaces.TreeGeneratorService;
import com.git.rule_forge.modules.tree._shared.domain.RootTree;
import org.springframework.stereotype.Component;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class CreateTreeUseCase
 * @since v1.0 (13/02/2025)
 */
@Component
public class CreateTreeUseCase extends UseCase<RootTree<?>, RootTree<?>, TreeGeneratorService> {
    public CreateTreeUseCase(TreeGeneratorService treeGeneratorService) {
        super(treeGeneratorService);
    }

    @Override
    public RootTree<?> execute(RootTree<?> input) throws SystemGlobalException {
        return this.service.createTree(input);
    }
}
