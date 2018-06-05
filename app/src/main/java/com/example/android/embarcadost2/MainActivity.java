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

    ArrayList<Integer> arrayToSelection = new ArrayList<>();
    ArrayList<Integer> arrayToQuick = new ArrayList<>();
    Integer NUM_ITENS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numItensEditText = findViewById(R.id.etNumItens);

        Button sortButton = findViewById(R.id.btSort);

        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (numItensEditText.getText().toString().trim().length() > 0) {

                    NUM_ITENS = Integer.parseInt(numItensEditText.getText().toString());
                    Toast.makeText(MainActivity.this, String.valueOf(NUM_ITENS), Toast.LENGTH_SHORT).show();

                    Random random = new Random();
                    Log.d("BEFORE Generated : ", NUM_ITENS.toString());

                    for (int i=0; i<NUM_ITENS; i++) {
                        int randomInt = random.nextInt(100000);
                        Log.d("Generated : ", Integer.toString(randomInt));
                        arrayToQuick.add(randomInt);
                        arrayToSelection.add(randomInt);
                    }

                    SelectionSort selectionSort = new SelectionSort();
                    Debug.startMethodTracing("SelectionSort");
                    ArrayList<Integer> arraySelection = selectionSort.selectionSort(arrayToSelection);
                    Debug.stopMethodTracing();

                    for (int i = 0; i < arraySelection.size(); i++) {
                        Log.d("SELECTION", arraySelection.get(i).toString());
                    }

                    QuickSort sorter = new QuickSort();

                    Debug.startMethodTracing("QuickSort");
                    sorter.sort(arrayToQuick);

                    Debug.stopMethodTracing();

                    for (int i = 0; i < arrayToQuick.size(); i++) {
                        Log.d("QUICKSORT", Integer.toString(arrayToQuick.get(i)));
                    }
                }
            }
        });






    }
}
