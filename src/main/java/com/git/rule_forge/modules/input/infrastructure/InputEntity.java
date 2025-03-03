package com.git.rule_forge.modules.input.infrastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.git.rule_forge._shared.infrastructure.GenericBusinessEntity;
import com.git.rule_forge.utils.converter.HashMapConverter;

import java.util.HashMap;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class InputSchema
 * @since v1.0 (30/11/2024)
 */

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "input_dynamic")
public class InputEntity extends GenericBusinessEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Convert(converter = HashMapConverter.class)
    @Column(name = "fields", columnDefinition = "TEXT")
    private HashMap<String, Object> fields = new HashMap<>();
}