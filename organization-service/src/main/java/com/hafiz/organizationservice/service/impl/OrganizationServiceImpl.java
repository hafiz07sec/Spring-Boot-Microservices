package com.hafiz.organizationservice.service.impl;

import com.hafiz.organizationservice.dto.OrganizationDto;
import com.hafiz.organizationservice.entity.Organization;
import com.hafiz.organizationservice.mapper.OrganizationMapper;
import com.hafiz.organizationservice.repository.OrganizationRepository;
import com.hafiz.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        //convert OrganizationDto into Organization jpa entity
        Organization organization= OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization=organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
