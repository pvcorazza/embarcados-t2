package com.example.android.embarcadost2;

import android.util.Log;

import java.util.ArrayList;

public class QuickSort {

    private ArrayList<Integer> array;
    private int length;

    public void sort(ArrayList<Integer> inputArr) {

        if (inputArr == null || inputArr.size() == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.size();
        quickSort(0, length - 1);
        for (int i =0; i<array.size(); i++) {
            Log.d("QUICK " + i, array.get(i).toString());

        }
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array.get(i) < pivot) {
                i++;
            }
            while (array.get(j) > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }


}