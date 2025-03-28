package com.git.rule_forge.modules.tree.node.application.usecase.command;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.node.adapter.web.request.NodeCreationData;
import com.git.rule_forge.modules.tree.node.application.service.interfaces.NodeTreeBlockService;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeBlock;
import org.springframework.stereotype.Component;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class CreateNodeBlock
 * @since v1.0 (06/02/2025)
 */
@Component
public class CreateNodeBlock extends UseCase<NodeCreationData, NodeTreeBlock, NodeTreeBlockService> {
    public CreateNodeBlock(NodeTreeBlockService nodeTreeBlockService) {
        super(nodeTreeBlockService);
    }

    @Override
    public NodeTreeBlock execute(NodeCreationData input) throws SystemGlobalException {
        return service.createBlock(input, true);
    }
}
