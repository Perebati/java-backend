package com.git.rule_forge.modules.tree._shared.domain;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class NodeTreeInterface
 * @since 21/01/2025
 */
public interface NodeTraversal<T> {
    boolean traverse(T inputData);
}
