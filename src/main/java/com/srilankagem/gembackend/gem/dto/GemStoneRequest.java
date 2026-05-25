package com.srilankagem.gembackend.gem.dto;

import com.srilankagem.gembackend.gem.models.GemOrigin;
import com.srilankagem.gembackend.gem.models.GemTreatment;
import com.srilankagem.gembackend.gem.models.GemType;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GemStoneRequest {
    @NotBlank(message = "Gem code is required")
    @Size(min = 3 , max = 30, message = "gem code must be between 3 to 30 character")
    private String gemCode;

    @NotNull(message = "gem type require")
    private GemType type;

    @NotBlank(message = "color is require")
    private String color;

    @NotNull
    @DecimalMin(value = "0.01", message = "value must be grater than 0.1")
    private Double caratWeight;

    @NotNull(message = "origin is require")
    private GemOrigin origin;

    @NotNull(message = "gem treatment is required")
    private GemTreatment treatment;

    @NotNull
    @DecimalMin(value = "0.01", message = "value must be grater than 0.1")
    private Double pricePerCarat;

    @NotNull
    @Min(value = 0, message = "value must be grater than 0")
    private Integer stockQuantity;

    @NotBlank
    @Size(max = 1000)
    private String description;

    private boolean certified;

}
