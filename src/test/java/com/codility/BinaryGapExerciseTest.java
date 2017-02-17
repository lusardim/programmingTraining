package com.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryGapExerciseTest {

    @Test
    public void testBinaryGap() {
        BinaryGapExercise binaryGapExercise = new BinaryGapExercise();
        assertEquals(binaryGapExercise.solution(1041), 5);
        assertEquals(binaryGapExercise.solution(15), 0);
        assertEquals(binaryGapExercise.solution(1), 0);
        assertEquals(binaryGapExercise.solution(2147483647), 0);
        assertEquals(binaryGapExercise.solution(6), 0);
        assertEquals(binaryGapExercise.solution(328), 2);
        assertEquals(binaryGapExercise.solution(51712), 2);
    }
}
