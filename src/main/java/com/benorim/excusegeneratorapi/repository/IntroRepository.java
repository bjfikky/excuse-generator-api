package com.benorim.excusegeneratorapi.repository;

import com.benorim.excusegeneratorapi.model.Intro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntroRepository extends JpaRepository<Intro, Long> {
}
