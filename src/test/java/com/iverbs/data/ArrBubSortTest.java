package com.iverbs.data;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ArrBubSortTest {

    ArrayBub arBub = new ArrayBub(100);
    
    @Test
    public void whenUnorderedArrayPassed_orderedArrayIsProduced() {
        int[] values = new int[] {9, -3, 5, 0, 1};
        long[] expectedOrder = new long[] {-3, 0, 1, 5, 9};
        ArrayBub arBub = new ArrayBub(values);
        arBub.bubbleSort();
        assertArrayEquals(expectedOrder, arBub.getArray());
    }
}
