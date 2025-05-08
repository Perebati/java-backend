package com.git.rule_forge.modules.tree.comparison.adpter.web.controller;

import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.exception.models.AdapterException;
import com.git.rule_forge.modules.tree.comparison.adpter.web.controller.interfaces.ComparisonController;
import com.git.rule_forge.modules.tree.comparison.adpter.web.request.ComparisonMultiRecord;
import com.git.rule_forge.modules.tree.comparison.adpter.web.request.ComparisonSingularRecord;
import com.git.rule_forge.modules.tree.comparison.application.usecase.command.CreateComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.application.usecase.command.CreateComparisonSingular;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ComparisonControllerImpl
 * @since v1.0 (30/11/2024)
 */
@Controller
class ComparisonControllerImpl implements ComparisonController {
    private final CreateComparisonSingular createComparisonSingular;
    private final CreateComparisonMulti createComparisonMulti;

    @Autowired
    ComparisonControllerImpl(
                             CreateComparisonSingular createComparisonSingular,
                             CreateComparisonMulti createComparisonMulti
                             ) {
        this.createComparisonSingular = createComparisonSingular;
        this.createComparisonMulti = createComparisonMulti;
    }


    @Override
    public ResponseEntity<ComparisonSingular> createSingularComparison(
            @NonNull ComparisonSingularRecord request) throws SystemGlobalException {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    this.createComparisonSingular.execute(
                            request
                    ));
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new AdapterException("Unexpected error in operation creation.", e);
        }
    }

    @Override
    public ResponseEntity<ComparisonMulti> createMultiComparison(
            @NonNull ComparisonMultiRecord request) throws SystemGlobalException {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    this.createComparisonMulti.execute(
                            request
                    ));
        } catch (SystemGlobalException e) {
            throw e;
        } catch (Exception e) {
            throw new AdapterException("Unexpected error in operation creation.", e);
        }
    }
}