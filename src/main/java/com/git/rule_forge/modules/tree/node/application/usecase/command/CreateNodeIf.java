package com.git.rule_forge.modules.tree.node.application.usecase.command;

import com.git.rule_forge._shared.application.usecase.UseCase;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.node.adapter.web.request.NodeIfCreationData;
import com.git.rule_forge.modules.tree.node.application.service.interfaces.NodeTreeIfService;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;
import org.springframework.stereotype.Component;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @class CreateNodeIf
 * @since v1.0 (06/02/2025)
 */
@Component
public class CreateNodeIf extends UseCase<NodeIfCreationData, NodeTreeIf, NodeTreeIfService> {
    public CreateNodeIf(NodeTreeIfService nodeTreeIfService) {
        super(nodeTreeIfService);
    }

    @Override
    public NodeTreeIf execute(NodeIfCreationData input) throws SystemGlobalException {
        return this.service.createIf(input, true);
    }
}