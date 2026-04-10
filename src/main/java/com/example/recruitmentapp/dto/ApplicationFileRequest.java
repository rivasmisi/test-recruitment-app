package com.example.recruitmentapp.dto;

import com.example.recruitmentapp.enums.FileType;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationFileRequest {

    @NotNull
    private Integer applicationId;

    @NotNull
    private FileType fileType;

    @NotBlank
    private String fileName;

    @NotBlank
    private String fileUrl;
}
