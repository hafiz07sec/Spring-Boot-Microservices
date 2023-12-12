package com.hafiz.organizationservice.controller;

import com.hafiz.organizationservice.dto.OrganizationDto;
import com.hafiz.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - OrganizationController",
        description = "OrganizationController Exposes REST APIs for Organization Service"
)
@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    //Build Save Organization REST API
    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save Organization object in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    //Build Get Organization By Code REST API
    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization REST API is used to get Organization object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode ){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }

}
