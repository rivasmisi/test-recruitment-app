package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.ProfileStageTemplateRequest;
import com.example.recruitmentapp.dto.ProfileStageTemplateResponse;
import com.example.recruitmentapp.entity.Profile;
import com.example.recruitmentapp.entity.ProfileStageTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProfileStageTemplateMapper {

    public ProfileStageTemplate toEntity(ProfileStageTemplateRequest request, Profile profile) {
        ProfileStageTemplate entity = new ProfileStageTemplate();
        entity.setProfile(profile);
        entity.setDisplayOrder(request.getDisplayOrder());
        entity.setName(request.getName());
        return entity;
    }

    public void updateEntity(ProfileStageTemplate entity, ProfileStageTemplateRequest request, Profile profile) {
        entity.setProfile(profile);
        entity.setDisplayOrder(request.getDisplayOrder());
        entity.setName(request.getName());
    }

    public ProfileStageTemplateResponse toResponse(ProfileStageTemplate entity) {
        return ProfileStageTemplateResponse.builder()
                .id(entity.getId())
                .profileId(entity.getProfile() != null ? entity.getProfile().getId() : null)
                .displayOrder(entity.getDisplayOrder())
                .name(entity.getName())
                .build();
    }
}
