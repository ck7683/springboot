package com.study.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "short_url")
public class ShortUrl {
    @Id
    @Column(name = "short_url")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String shortUrl;
    @Column(name = "source_url")
    private String sourceUrl;
    @Column(name = "recently_used_date")
    private LocalDate recentlyUsedDate;
    @Column(name = "creation_date")
    private LocalDate creationDate;
}
