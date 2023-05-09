package com.recap.carrental;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRentalApplicationTests {

    Calculator underTest = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        // given
        int numberOne = 20;
        int numberTwo = 30;

        // when
        int result = underTest.add(numberOne, numberTwo);

        // then
        int expected = numberOne + numberTwo;
        assertThat(result).isEqualTo(expected);
    }


    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }
}
