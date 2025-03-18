package com.git.rule_forge.modules.tree._shared.infrastructure.repository.interfaces;

import jakarta.validation.constraints.NotNull;
import com.git.rule_forge._shared.infrastructure.RepositoryAuth;
import com.git.rule_forge._shared.infrastructure.repository.interfaces.GenericBusinessRepository;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree._shared.domain.NodeInput;
import com.git.rule_forge.modules.tree._shared.domain.RootTree;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class RootTreeRepository
 * @since v1.0 (30/11/2024)
 */
public interface RootTreeRepository extends GenericBusinessRepository<RootTree<NodeInput>> {
    Object readGenericRoot(@NotNull UUID id, @NotNull RepositoryAuth auth) throws SystemGlobalException;

    Optional<UUID> findRootIdByNodeId(@NotNull UUID node_id) throws SystemGlobalException;
}
