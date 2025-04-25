package com.git.rule_forge.modules.tree.comparison.domain.factory;

import jakarta.validation.ValidationException;
import com.git.rule_forge._shared.infrastructure.repository.exception.EntityNotFound;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.exception.models.DomainException;
import com.git.rule_forge.exception.models.FailedRequestException;
import com.git.rule_forge.modules.input.application.service.interfaces.InputService;
import com.git.rule_forge.modules.input.domain.Input;
import com.git.rule_forge.modules.input.domain.predefined.PredefinedTypeEnum;
import com.git.rule_forge.modules.tree._shared.application.service.interfaces.RootTreeService;
import com.git.rule_forge.modules.tree._shared.domain.Node;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import com.git.rule_forge.modules.tree.comparison.domain.exception.IllegalFieldException;
import com.git.rule_forge.modules.tree.comparison.domain.factory.interfaces.ComparisonFactory;
import com.git.rule_forge.modules.tree.root.domain.RootTreeDynamic;
import com.git.rule_forge.modules.tree.root.domain.RootTreeStatic;
import com.git.rule_forge.utils.converter.PathNormalizer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Handles Comparisons creation.
 *
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ComparisonOperationFactory
 * @since v1.0 (30/11/2024)
 */
@Component
public class ComparisonFactoryImpl implements ComparisonFactory {
    private final RootTreeService rootTreeService;
    private final InputService inputService;

    public ComparisonFactoryImpl(
            RootTreeService rootTreeService,
            InputService inputService
    ) {
        this.rootTreeService = rootTreeService;
        this.inputService = inputService;
    }

    /**
     * This method creates an operation,
     * however before creating it checks the node in order to find the root node,
     * then through the root it checks if the jsonPath exists inside the input variable.
     * After all this validation, the Comparison is created.
     *
     * @param type     Comparison type.
     * @param jsonPath JsonPath to compared variable.
     * @param variable Variable value.
     * @param parent   Parent node.
     * @return Comparison
     * @throws ValidationException Thrown when something wrong happened on factory layer.
     * @author Lucas Batista Pereira
     * @since v1.0 (30/11/2024)
     */
    public ComparisonSingular produce(
            ComparisonSingular.ComparisonSingularTypeEnum type,
            String jsonPath,
            String variable,
            Node<?> parent
    ) throws SystemGlobalException {
        try {
            jsonPath = PathNormalizer.normalizePath(jsonPath);

            Object rootTreeEntity = this.rootTreeService
                    .readGenericRoot(this.rootTreeService
                            .findRootIdByNodeId(parent.getId())
                            .orElseThrow(() -> new EntityNotFound("Root parent not found!", null)));

            if (rootTreeEntity instanceof RootTreeStatic) {
                PredefinedTypeEnum predefinedTypeEnum = ((RootTreeStatic) rootTreeEntity).getInput_type();
                predefinedTypeEnum.validateJsonPath(predefinedTypeEnum, jsonPath);
            } else if (rootTreeEntity instanceof RootTreeDynamic) {
                Input input = this.inputService.read(((RootTreeDynamic) rootTreeEntity).getDynamicInputId());
                input.validateJsonPathAndType(jsonPath, variable);
            }

            return new ComparisonSingular(type, jsonPath, variable, parent);
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new DomainException("Something went wrong creating a singular comparison operation.", e);
        }
    }

    public ComparisonMulti produce(
            ComparisonMulti.ComparisonMultiTypeEnum comparisonTypeEnum,
            String jsonVariablePath,
            List<String> expectedVars,
            Node<?> parent
    ) throws SystemGlobalException {
        try {
            jsonVariablePath = PathNormalizer.normalizePath(jsonVariablePath);

            validateComparison(jsonVariablePath, parent);
            return new ComparisonMulti(comparisonTypeEnum, jsonVariablePath, expectedVars, parent);
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new DomainException("Something went wrong creating a multi comparison operation.", e);
        }
    }

    private void validateComparison(String jsonPath, Node<?> parent) throws SystemGlobalException {
        Object rootTreeEntity = this.rootTreeService
                .readGenericRoot(this.rootTreeService
                        .findRootIdByNodeId(parent.getId())
                        .orElseThrow(() -> new EntityNotFound("Root parent not found!", null)));
        if (rootTreeEntity instanceof RootTreeStatic) {
            PredefinedTypeEnum predefinedTypeEnum = ((RootTreeStatic) rootTreeEntity).getInput_type();
            try {
                predefinedTypeEnum.validateJsonPath(predefinedTypeEnum, jsonPath);
            } catch (FailedRequestException e) {
                throw new IllegalFieldException("Field not found: " + e.getMessage(), e);
            }
        } else if (rootTreeEntity instanceof RootTreeDynamic) {
            Input input = this.inputService.read(((RootTreeDynamic) rootTreeEntity).getDynamicInputId());
            input.validateJsonPath(jsonPath);
        }
    }
}