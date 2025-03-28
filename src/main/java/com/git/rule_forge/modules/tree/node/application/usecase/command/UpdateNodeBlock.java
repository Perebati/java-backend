package com.git.rule_forge.modules.tree.node.application.usecase.command;

import com.git.rule_forge._shared.application.usecase.UseCase2Inputs;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.node.adapter.web.request.NodeTreeBlockData;
import com.git.rule_forge.modules.tree.node.application.service.interfaces.NodeTreeBlockService;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeBlock;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class UpdateNodeBlock
 * @since v1.0 (06/02/2025)
 */
@Component
public class UpdateNodeBlock extends UseCase2Inputs<UUID, NodeTreeBlockData, NodeTreeBlock, NodeTreeBlockService> {
    public UpdateNodeBlock(NodeTreeBlockService nodeTreeBlockService) {
        super(nodeTreeBlockService);
    }

    @Override
    public NodeTreeBlock execute(UUID id, NodeTreeBlockData input) throws SystemGlobalException {
        return this.service.updateBlock(id, input, true);
    }
}
