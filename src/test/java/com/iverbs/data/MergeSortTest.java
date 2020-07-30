package com.iverbs.data;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MergeSortTest {
    
    private MergeSort sorter = new MergeSort();
    
    
    @Test
    public void shouldSortValues() {
        int[] values = new int[] {9, -3, 5, 0, 1};
        int[] expectedOrder = new int[] {-3, 0, 1, 5, 9};
        
        sorter.sort(values);
        assertArrayEquals(expectedOrder, values);
    }

}
