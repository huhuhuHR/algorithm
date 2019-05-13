package com.github;

public class InsertSort {
    public void sort(int[] array) {
        int reference;
        for (int i = 1; i < array.length; i++) {
            reference = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > reference) {
                array[j] = array[j - 1];
                // array[j - 1] = reference;
                j--;
            }
            array[j] = reference;
        }
    }

    public void sortAnother(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;

            while (i > -1 && array[i] > key) {
                array[i + 1] = array[i];
                // array[i] = key;
                i--;
            }
            array[i + 1] = key;
        }
    }
}
