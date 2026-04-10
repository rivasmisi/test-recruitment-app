package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.ProfileRequest;
import com.example.recruitmentapp.dto.ProfileResponse;

import java.util.List;

public interface ProfileService {
    ProfileResponse create(ProfileRequest request);

    ProfileResponse getById(Integer id);

    List<ProfileResponse> getAll();

    ProfileResponse update(Integer id, ProfileRequest request);

    void delete(Integer id);
}
