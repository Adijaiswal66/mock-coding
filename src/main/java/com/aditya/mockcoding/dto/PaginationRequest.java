package com.aditya.mockcoding.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationRequest {

    @PositiveOrZero(message = "Please enter a valid page number")
    private int page;

    @Positive(message = "Please enter a valid size")
    @Max(100)
    private int size;

}
