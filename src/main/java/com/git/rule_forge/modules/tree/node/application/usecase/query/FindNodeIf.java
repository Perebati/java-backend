package com.git.rule_forge.modules.tree.node.application.usecase.query;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.node.application.service.interfaces.NodeTreeIfService;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class ReadNodeIf
 * @since v1.0 (06/02/2025)
 */
@Component
public class FindNodeIf extends UseCase<UUID, Optional<NodeTreeIf>, NodeTreeIfService> {
    public FindNodeIf(NodeTreeIfService nodeTreeIfService) {
        super(nodeTreeIfService);
    }

    @Override
    public Optional<NodeTreeIf> execute(UUID input) throws SystemGlobalException {
        return this.service.findById(input);
    }
}