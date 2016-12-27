package com.kalkulatorek.lukasz.kalkulatorek;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {

    private Button additionButton;
    private Button subtractionButton;
    private Button multiplicationButton;

    private TextView resultTextView;
    private EditText firstNumberEditText;
    private EditText secondNumberEditText;
    private MathematicalOperation mathematicalOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        additionButton = (Button) findViewById(R.id.additionButton);
        subtractionButton = (Button) findViewById(R.id.subtractionButton);
        multiplicationButton = (Button) findViewById(R.id.multiplicationButton);

        resultTextView = (TextView) findViewById(R.id.ResultText);

        firstNumberEditText = (EditText) findViewById(R.id.FirstNumberText);
        secondNumberEditText = (EditText) findViewById(R.id.SecondNumberText);


        mathematicalOperation = new Addition();//domyslnie ustawiam operacje na dodawanie, wzorzec strategia
        onClickListeners();
    }



    void DrawResult()
    {
        float firstValue = Float.parseFloat(firstNumberEditText.getText().toString());
        float secondValue = Float.parseFloat(secondNumberEditText.getText().toString());
        resultTextView.setText(firstValue+" "+mathematicalOperation.GetOperationType()+" "+secondValue+" = "+mathematicalOperation.Calculate(firstValue, secondValue));
    }


    void onClickListeners() {
        additionButton.setOnClickListener(v -> {//Lambda
            mathematicalOperation = new Addition();//operacja dodawanie, wzorzec strategi
            DrawResult();
         });


        subtractionButton.setOnClickListener(v -> {//Lambda
            mathematicalOperation = new Subtraction();//operacja odejmowania, wzorzec strategia
            DrawResult();
        });


        multiplicationButton.setOnClickListener(v -> {//Lambda
            mathematicalOperation = new Multiplicatio();//operacja mnożenia, wzorzec strategia
            DrawResult();
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
