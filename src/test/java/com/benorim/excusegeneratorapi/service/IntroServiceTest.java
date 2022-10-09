package com.benorim.excusegeneratorapi.service;

import com.benorim.excusegeneratorapi.model.Intro;
import com.benorim.excusegeneratorapi.repository.IntroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@SpringBootTest
@DisplayName("Intro Service Tests")
class IntroServiceTest {
    @InjectMocks
    private IntroService introService;

    @Mock
    private IntroRepository introRepository;

    @BeforeEach
    void setUp() {
        Intro intro1 = new Intro();
        intro1.setId(1);
        intro1.setText("introduction 1");

        Intro intro2 = new Intro();
        intro2.setId(2);
        intro2.setText("introduction 2");

        Intro intro3 = new Intro();
        intro3.setId(3);
        intro3.setText("introduction 3");

        when(introRepository.findAll()).thenReturn(List.of(intro1, intro2, intro3));
    }

    @Test
    @DisplayName("Get a random intro")
    void getRandomIntro() {
        Intro randomIntro = introService.getRandomIntro();
        assertNotNull(randomIntro);
        assertTrue(List.of(1L, 2L, 3L).contains(randomIntro.getId()));
        assertTrue(List.of("introduction 1", "introduction 2", "introduction 3").contains(randomIntro.getText()));
    }

    @Test
    @DisplayName("Get all intros")
    void getAllIntros() {
        assertNotNull(introService.getAllIntros());
        assertEquals(3, introService.getAllIntros().size());
    }
}