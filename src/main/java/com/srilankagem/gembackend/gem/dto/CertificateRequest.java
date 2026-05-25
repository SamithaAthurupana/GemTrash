package com.srilankagem.gembackend.gem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateRequest {

    @NotBlank(message = "Certificate number is required")
    private String certificateNumber;

    @NotNull(message = "Gem Id is required")
    private Long gemId;

    @NotBlank(message = "issue by is required")
    private String issueBy;

    @NotBlank(message = "issue date is required")
    private LocalDate issueDate;

    @NotBlank(message = "expiry date is required")
    private LocalDate expiryDate;

    private String remarks;

}
