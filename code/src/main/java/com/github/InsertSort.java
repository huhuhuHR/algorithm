package com.github;

public class InsertSort {
    public void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int reference;
        for (int i = 1; i < array.length; i++) {
            reference = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > reference) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = reference;
        }
    }

}
