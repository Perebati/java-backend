package com.git.rule_forge.modules.tree.node.adapter.web.controller;

import lombok.AllArgsConstructor;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.node.adapter.web.controller.interfaces.NodeTreeController;
import com.git.rule_forge.modules.tree.node.adapter.web.request.NodeCreationData;
import com.git.rule_forge.modules.tree.node.adapter.web.request.NodeIfCreationData;
import com.git.rule_forge.modules.tree.node.adapter.web.request.NodeTreeBlockData;
import com.git.rule_forge.modules.tree.node.application.usecase.command.CreateNodeBlock;
import com.git.rule_forge.modules.tree.node.application.usecase.command.CreateNodeIf;
import com.git.rule_forge.modules.tree.node.application.usecase.command.UpdateNodeBlock;
import com.git.rule_forge.modules.tree.node.application.usecase.query.FindNodeBlock;
import com.git.rule_forge.modules.tree.node.application.usecase.query.FindNodeIf;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeBlock;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeTreeControllerImpl
 * @since v1.0 (30/11/2024)
 */
@Controller
@AllArgsConstructor
class NodeTreeControllerImpl implements NodeTreeController {
    private final CreateNodeBlock createNodeBlock;
    private final CreateNodeIf createNodeIf;
    private final UpdateNodeBlock updateNodeBlock;
    private final FindNodeBlock findNodeBlock;
    private final FindNodeIf findNodeIf;

    @Override
    public ResponseEntity<NodeTreeBlock> createNodeBlock(@NonNull NodeCreationData request) throws SystemGlobalException {
        return ResponseEntity.ok(this.createNodeBlock.execute(request));
    }

    @Override
    public ResponseEntity<NodeTreeIf> createNodeIf(@NonNull NodeIfCreationData request) throws SystemGlobalException {
        return ResponseEntity.ok(this.createNodeIf.execute(request));
    }

    @Override
    public ResponseEntity<Optional<NodeTreeBlock>> findNodeBlock(@NonNull UUID id) throws SystemGlobalException {
        return ResponseEntity.ok(this.findNodeBlock.execute(id));
    }

    @Override
    public ResponseEntity<Optional<NodeTreeIf>> findNodeIf(@NonNull UUID id) throws SystemGlobalException {
        return ResponseEntity.ok(this.findNodeIf.execute(id));
    }

    @Override
    public ResponseEntity<NodeTreeBlock> updateNodeBlock(@NonNull UUID id,
                                                         @NonNull NodeTreeBlockData request) throws SystemGlobalException {
        return ResponseEntity.ok(this.updateNodeBlock.execute(id, request));
    }
}