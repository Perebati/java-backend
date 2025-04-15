package com.git.rule_forge.modules.tree.node.application.service.interfaces;

import com.git.rule_forge._shared.application.interfaces.GenericService;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.node.adapter.web.request.NodeIfCreationData;
import com.git.rule_forge.modules.tree.node.domain.NodeTreeIf;

public interface NodeTreeIfService extends GenericService<NodeTreeIf> {
    NodeTreeIf createIf(NodeIfCreationData nodeCreationData, Boolean keepHistory) throws SystemGlobalException;
}
