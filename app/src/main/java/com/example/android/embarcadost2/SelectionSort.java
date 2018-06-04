package com.example.android.embarcadost2;

import java.util.ArrayList;

public class SelectionSort {

    public ArrayList<Integer> selectionSort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.size(); j++)
                if (arr.get(j) < arr.get(index))
                    index = j;

            int smallerNumber = arr.get(index);
            arr.set(index, arr.get(i));
            arr.set(i, smallerNumber);
        }
        return arr;
    }
}
