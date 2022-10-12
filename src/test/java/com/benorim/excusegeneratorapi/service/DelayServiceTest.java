package com.benorim.excusegeneratorapi.service;

import com.benorim.excusegeneratorapi.model.Delay;
import com.benorim.excusegeneratorapi.repository.DelayRepository;
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
@DisplayName("Delay Service Tests")
class DelayServiceTest {

    @InjectMocks
    private DelayService delayService;

    @Mock
    private DelayRepository delayRepository;

    @BeforeEach
    void setUp() {
        Delay delay1 = new Delay();
        delay1.setId(1);
        delay1.setText("delay 1");

        Delay delay2 = new Delay();
        delay2.setId(2);
        delay2.setText("delay 2");

        Delay delay3 = new Delay();
        delay3.setId(3);
        delay3.setText("delay 3");

        when(delayRepository.findAll()).thenReturn(List.of(delay1, delay2, delay3));
    }

    @Test
    @DisplayName("Get a random delay")
    void getRandomDelay() {
        Delay randomDelay = delayService.getRandomDelay();
        assertNotNull(randomDelay);
        assertTrue(List.of(1L, 2L, 3L).contains(randomDelay.getId()));
        assertTrue(List.of("delay 1", "delay 2", "delay 3").contains(randomDelay.getText()));
    }

    @Test
    @DisplayName("Get all delays")
    void getAllDelays() {
        assertNotNull(delayService.getAllDelays());
        assertEquals(3, delayService.getAllDelays().size());
    }
}