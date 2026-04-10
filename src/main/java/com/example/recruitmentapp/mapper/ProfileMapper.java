package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.ProfileRequest;
import com.example.recruitmentapp.dto.ProfileResponse;
import com.example.recruitmentapp.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public Profile toEntity(ProfileRequest request) {
        Profile entity = new Profile();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setStatus(request.getStatus());
        return entity;
    }

    public void updateEntity(Profile entity, ProfileRequest request) {
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setStatus(request.getStatus());
    }

    public ProfileResponse toResponse(Profile entity) {
        return ProfileResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .build();
    }
}
