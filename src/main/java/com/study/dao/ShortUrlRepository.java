package com.study.dao;

import com.study.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Integer> {
    public List<ShortUrl> findAll();

    public ShortUrl findByShortUrl(String shortUrl);
    public ShortUrl findBySourceUrl(String sourceUrl);

}
