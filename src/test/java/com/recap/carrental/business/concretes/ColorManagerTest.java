package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.ColorService;
import com.recap.carrental.business.mappers.abstracts.ColorDTOMapperService;
import com.recap.carrental.business.mappers.concretes.ColorDTOMapperManager;
import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.dataAccess.ColorRepository;
import com.recap.carrental.entities.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ColorManagerTest {
    @Mock private ColorRepository colorRepository;
    private ColorService underTest;
    private AutoCloseable autoCloseable;
    private ColorDTOMapperService colorDTOMapperService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        colorDTOMapperService = new ColorDTOMapperManager();
        underTest = new ColorManager(colorRepository, colorDTOMapperService);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void GivenValidWhenCreateThenShouldCreateData() {
        // Given
        String colorName = "White";
        ColorCreateRequest request = new ColorCreateRequest(
                colorName
        );

        // When
        underTest.create(request);

        // Then
        Mockito.verify(colorRepository).existsByColorName(colorName);
    }

    @Test
    void GivenNoneWhenGetAllThenShouldReturnData() {
        // when
        underTest.getAll();

        // then
        Mockito.verify(colorRepository).findAll();
    }
}