package org.example.jpamanytoonee23a.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class KommuneTest {

    @Test
    @Disabled
    void fejl() {
        if (3>4)
        fail("Not yet implemented");
    }

    @Test
    void Test2() {
        assertEquals("ABC", "ABC");
    }

    @Test
    void testDiv0() {
        int i = 10;
        int y = 0;
        assertEquals(0, i/y);
    }

    @Test
    void testArr() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    @DisplayName("array med 4 værdier 1,3,5,6")
    void testArrFejl() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,14,12};
        Arrays.sort(numbers);
        //assertArrayEquals(expected, numbers);
        assertArrayEquals(expected, numbers, () -> "Sortering af 4 tal" + expected[1]);
    }

    @DisplayName("paramtest med 3 arrays")
    @ParameterizedTest
    @MethodSource("sortnumbersArguments")
    void testArr(int[] numbers, int[] expected) {
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, "Sortering af " + numbers.length + " tal");
    }

    private static Stream<Arguments> sortnumbersArguments() {
        return Stream.of(
                Arguments.of(IntStream.of(1,2,3).toArray(), IntStream.of(1,2,3).toArray()),
                Arguments.of(IntStream.of(8,1,2,3,5).toArray(), IntStream.of(1,2,3,5,8).toArray()),
                Arguments.of(IntStream.of(16,1,2,3).toArray(), IntStream.of(1,2,3,16).toArray())
        );
    }


}