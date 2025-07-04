package com.git.rule_forge.exception.models;

import com.git.rule_forge.exception.SystemGlobalException;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @since 08/11/2024
 */
public class DomainException extends SystemGlobalException {
    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
