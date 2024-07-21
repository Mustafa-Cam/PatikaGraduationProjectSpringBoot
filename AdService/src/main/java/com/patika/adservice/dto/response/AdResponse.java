package com.patika.adservice.dto.response;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patika.adservice.model.Product;
import com.patika.adservice.model.enums.AdStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdResponse {
    private long id;
    private String productOwner;
    private String title;
    private String description;
    private AdStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiryDate;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;
}
