package com.example.android.embarcadost2;

import java.util.ArrayList;

public class SelectionSort {

    ArrayList<Integer> array;

    public ArrayList<Integer> selectionSort(ArrayList<Integer> arr) {

        this.array = arr;


        for (int i = 0; i < array.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.size(); j++)
                if (array.get(j) < array.get(index))
                    index = j;

            int smallerNumber = array.get(index);
            array.set(index, array.get(i));
            array.set(i, smallerNumber);
        }
        return array;
    }
}
