package com.example.recruitmentapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponse {

    private Integer id;

    private String name;

    private String description;

    private String status;
}
