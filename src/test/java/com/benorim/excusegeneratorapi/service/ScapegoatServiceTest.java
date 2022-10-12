package com.benorim.excusegeneratorapi.service;

import com.benorim.excusegeneratorapi.model.Scapegoat;
import com.benorim.excusegeneratorapi.repository.ScapegoatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@DisplayName("Scapegoat service tests")
class ScapegoatServiceTest {

    @InjectMocks
    private ScapegoatService scapegoatService;

    @Mock
    private ScapegoatRepository scapegoatRepository;

    @BeforeEach
    void setUp() {
        Scapegoat scapegoat1 = new Scapegoat();
        scapegoat1.setId(1);
        scapegoat1.setText("scapegoat 1");

        Scapegoat scapegoat2 = new Scapegoat();
        scapegoat2.setId(2);
        scapegoat2.setText("scapegoat 2");

        Scapegoat scapegoat3 = new Scapegoat();
        scapegoat3.setId(3);
        scapegoat3.setText("scapegoat 3");

        Mockito.when(scapegoatRepository.findAll()).thenReturn(List.of(scapegoat1, scapegoat2, scapegoat3));
    }

    @Test
    void getRandomScapegoat() {
        Scapegoat randomScapegoat = scapegoatService.getRandomScapegoat();
        assertNotNull(randomScapegoat);
        assertTrue(List.of(1L, 2L, 3L).contains(randomScapegoat.getId()));
        assertTrue(List.of("scapegoat 1", "scapegoat 2", "scapegoat 3").contains(randomScapegoat.getText()));
    }

    @Test
    @DisplayName("Get all scapegoats")
    void getAllScapegoats() {
        assertNotNull(scapegoatService.getAllScapegoats());
        assertEquals(3, scapegoatService.getAllScapegoats().size());
    }
}