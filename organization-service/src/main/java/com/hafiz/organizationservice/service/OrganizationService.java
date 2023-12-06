package com.hafiz.organizationservice.service;

import com.hafiz.organizationservice.dto.OrganizationDto;


public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String OrganizationCode);
}
