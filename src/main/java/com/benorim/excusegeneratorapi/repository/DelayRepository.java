package com.benorim.excusegeneratorapi.repository;

import com.benorim.excusegeneratorapi.model.Delay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelayRepository extends JpaRepository<Delay, Long> {
}
