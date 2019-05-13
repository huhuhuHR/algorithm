package com.github;


import java.util.Arrays;

public class InsertSortTest {

    @org.junit.Test
    public void sort() {
        int[] array = {10, 7, 8, 32, 63, 3, 2};
        InsertSort sort = new InsertSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}