package com.example.wille.embarcados;

import android.util.Log;

import java.util.ArrayList;

public class BubbleSort {

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> arr) {

        ArrayList<Integer> array = arr;
        int temp;

        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - 1; j++) {
                if (array.get(i) > array.get(j+1)) {
                    temp = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, temp);
                }
            }
        }

        return array;
    }
}
