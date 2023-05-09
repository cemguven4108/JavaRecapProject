package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.Color;
import jakarta.persistence.UniqueConstraint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ColorRepositoryTest {

    @Autowired
    private ColorRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void GivenValidWhenExistsByColorNameThenShouldReturnTrue() {

        // given
        String colorName = "White";
        Color color = new Color();
        color.setColorName(colorName);

        underTest.save(color);

        // when
        boolean expected = underTest.existsByColorName(colorName);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void GivenNullWhenExistsByColorNameShouldReturnException() {

        // given
    }
}