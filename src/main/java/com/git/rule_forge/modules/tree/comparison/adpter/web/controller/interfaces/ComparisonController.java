package com.git.rule_forge.modules.tree.comparison.adpter.web.controller.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.git.rule_forge.exception.SystemGlobalException;
import com.git.rule_forge.modules.tree.comparison.adpter.web.request.ComparisonMultiRecord;
import com.git.rule_forge.modules.tree.comparison.adpter.web.request.ComparisonSingularRecord;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonMulti;
import com.git.rule_forge.modules.tree.comparison.domain.ComparisonSingular;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lucas Batista Pereira
 * @version v1.0
 * @class ComparisonController
 * @since v1.0 (04/11/2024)
 */
@RestController
@RequestMapping("tree/operation")
@Tag(name = "Operação")
@SecurityRequirement(name = "BearerAuth")
public interface ComparisonController {
    @Operation(summary = "Cadastro de uma operação de comparação simples",
            description = "Registra uma nova operação de comparação no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação de comparação criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    @PostMapping("comparison-singular")
    ResponseEntity<ComparisonSingular> createSingularComparison(@NonNull @RequestBody ComparisonSingularRecord request)
            throws SystemGlobalException;

    @Operation(summary = "Cadastro de uma operação de comparação multípla",
            description = "Registra uma nova operação de comparação no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação de comparação criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    @PostMapping("comparison-multi")
    ResponseEntity<ComparisonMulti> createMultiComparison(@NonNull @RequestBody ComparisonMultiRecord request)
            throws SystemGlobalException;
}
