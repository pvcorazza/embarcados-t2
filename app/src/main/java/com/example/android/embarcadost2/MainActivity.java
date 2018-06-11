package com.example.android.embarcadost2;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Integer NUM_ITENS;
    Integer NUM_ITERATIONS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numItensEditText = findViewById(R.id.etNumItens);
        final EditText numIterationsEditText = findViewById(R.id.etNumIterations);

        Button sortButton = findViewById(R.id.btSort);

        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (numItensEditText.getText().toString().trim().length() > 0 && numIterationsEditText.getText().toString().trim().length() > 0) {

                    NUM_ITENS = Integer.parseInt(numItensEditText.getText().toString());
                    NUM_ITERATIONS = Integer.parseInt(numIterationsEditText.getText().toString());

                    Random random = new Random();

                    ArrayList<Integer> arrayOfNumber = new ArrayList<>();

                    for (int i = 0; i < NUM_ITENS * NUM_ITERATIONS; i++) {
                        int randomInt = random.nextInt(1000);
                        arrayOfNumber.add(randomInt);
                    }



                    Debug.startMethodTracing("SelectionSort_" + NUM_ITENS + "_" + NUM_ITERATIONS);
                    for (int i = 0; i < NUM_ITERATIONS; i++) {
                        ArrayList<Integer> arraySelection = new ArrayList<>(arrayOfNumber.subList(i, i + NUM_ITENS));
                        SelectionSort selectionSort = new SelectionSort();
                        selectionSort.selectionSort(arraySelection);

                    }
                    Debug.stopMethodTracing();

                    Toast.makeText(MainActivity.this, "Log saved: SelectionSort_" + NUM_ITENS + "_" + NUM_ITERATIONS, Toast.LENGTH_SHORT).show();

                    Debug.startMethodTracing("QuickSort_" + NUM_ITENS + "_" + NUM_ITERATIONS);
                    for (int i = 0; i < NUM_ITERATIONS; i++) {
                        ArrayList<Integer> arrayQuick = new ArrayList<>(arrayOfNumber.subList(i, i + NUM_ITENS));
                        QuickSort sorter = new QuickSort();
                        sorter.sort(arrayQuick);
                    }
                    Debug.stopMethodTracing();

                    Toast.makeText(MainActivity.this, "Log saved: QuickSort_" + NUM_ITENS + "_" + NUM_ITERATIONS, Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
