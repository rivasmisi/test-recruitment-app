package com.example.recruitmentapp.dto;

import com.example.recruitmentapp.enums.FileType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationFileResponse {

    private Integer id;

    private Integer applicationId;

    private FileType fileType;

    private String fileName;

    private String fileUrl;
}
