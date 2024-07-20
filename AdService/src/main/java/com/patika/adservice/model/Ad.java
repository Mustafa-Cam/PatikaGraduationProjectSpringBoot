    package com.patika.adservice.model;


    import com.fasterxml.jackson.annotation.JsonFormat;
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import jakarta.persistence.*;
    import lombok.Data;
    import com.patika.adservice.model.enums.AdStatus;
    import lombok.ToString;

    import java.time.LocalDateTime;

    @Data
    @Entity
    @Table(name = "ads")
    public class Ad {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String description;
    //    private LocalDateTime createdDate;

        @Enumerated(EnumType.STRING)
    //    @Column(nullable = false)
        private AdStatus status = AdStatus.IN_REVIEW;

    //    @JsonIgnore
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
        @JoinColumn(name = "user_id")//nullable = false
        private User user;

    //    @Column(nullable = false)
        private LocalDateTime createdAt;

    //    @Column(nullable = false)
        private LocalDateTime updatedAt;

    //    @Column(nullable = false)
        private LocalDateTime expiryDate;

        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        @ManyToOne(fetch = FetchType.LAZY)// performans için var lazy yükleme gerektiğinde veriyi yükle demek yani çağırıldığında.
        @JoinColumn(name = "product_id")
        private Product product;
    //    @JsonIgnore



    }

