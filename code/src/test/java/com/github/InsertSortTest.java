package com.github;


import org.junit.Test;

import java.util.Arrays;

public class InsertSortTest {

    @Test
    public void sort() {
        int[] array = {10, 7, 8, 32, 63, 3, 2};
        InsertSort sort = new InsertSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void sortAnother() {
        int[] array = {10, 7, 8, 32, 63, 3, 2};
        InsertSort sort = new InsertSort();
        sort.sortAnother(array);
        System.out.println(Arrays.toString(array));
    }
}