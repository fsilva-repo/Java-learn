package com.web.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.web.app.domain.Promotion;
public interface PromotionRepository extends JpaRepository<Promotion, Long>{}
