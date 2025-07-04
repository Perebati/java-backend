package com.git.rule_forge.exception.models;

import com.git.rule_forge.exception.SystemGlobalException;

/**
 * @author Lucas Batista Pereira
 * @version v1.1
 * @since v1.0 (06/02/2025)
 */
public class AdapterException extends SystemGlobalException {
    public AdapterException(String message, Throwable cause) {
        super(message, cause);
    }
}
