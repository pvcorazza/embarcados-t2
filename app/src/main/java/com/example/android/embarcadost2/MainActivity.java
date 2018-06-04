package com.example.android.embarcadost2;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SelectionSort selectionSort = new SelectionSort();

        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(34, 2, 56, 7, 67, 88, 42));
        Debug.startMethodTracing("SelectionSort");
        ArrayList<Integer> arr2 = selectionSort.selectionSort(arr1);
        Debug.stopMethodTracing();
        for (int i = 0; i < arr2.size(); i++) {
            Log.d("SELECTION", arr2.get(i).toString());
        }

        QuickSort sorter = new QuickSort();
        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        Debug.startMethodTracing("QuickSort");
        sorter.sort(input);
        Debug.stopMethodTracing();
        for (int i : input) {
            Log.d("QUICKSORT", Integer.toString(i));
        }
    }


}
