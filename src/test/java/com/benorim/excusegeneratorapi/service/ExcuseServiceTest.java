package com.benorim.excusegeneratorapi.service;

import com.benorim.excusegeneratorapi.model.Delay;
import com.benorim.excusegeneratorapi.model.Intro;
import com.benorim.excusegeneratorapi.model.Scapegoat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Excuse Service Tests")
class ExcuseServiceTest {

    @InjectMocks
    private ExcuseService excuseService;

    @Mock
    private DelayService delayService;

    @Mock
    private IntroService introService;

    @Mock
    private ScapegoatService scapegoatService;

    @BeforeEach
    void setUp() {
        Intro intro = new Intro();
        intro.setId(1);
        intro.setText("intro text");

        Scapegoat scapegoat = new Scapegoat();
        scapegoat.setId(1);
        scapegoat.setText("scapegoat text");

        Delay delay = new Delay();
        delay.setId(1);
        delay.setText("delay text");

        when(introService.getRandomIntro()).thenReturn(intro);
        when(delayService.getRandomDelay()).thenReturn(delay);
        when(scapegoatService.getRandomScapegoat()).thenReturn(scapegoat);
    }

    @Test
    @DisplayName("Compose excuse")
    void composeExcuse() {
        assertEquals("intro text scapegoat text delay text", excuseService.composeExcuse());
    }
}