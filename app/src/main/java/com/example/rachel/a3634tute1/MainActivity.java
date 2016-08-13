package com.example.rachel.a3634tute1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button multiply = (Button) findViewById(R.id.timesButton);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double number1 = Double.parseDouble(((EditText) findViewById(R.id.number1)).getText().toString());
                Double number2 = Double.parseDouble(((EditText) findViewById(R.id.number2)).getText().toString());

                Double answer = number1 * number2;

                calculate(answer);
            }
        });

        Button divide = (Button) findViewById(R.id.divideButton);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double number1 = Double.parseDouble(((EditText) findViewById(R.id.number1)).getText().toString());
                Double number2 = Double.parseDouble(((EditText) findViewById(R.id.number2)).getText().toString());

                Double answer = number1/number2;

                calculate(answer);

            }
        });

        Button plus = (Button) findViewById(R.id.plusButton);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double number1 = Double.parseDouble(((EditText) findViewById(R.id.number1)).getText().toString());
                Double number2 = Double.parseDouble(((EditText) findViewById(R.id.number2)).getText().toString());

                Double answer = number1 + number2;

                calculate(answer);

            }
        });

        Button minus = (Button) findViewById(R.id.minusButton);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double number1 = Double.parseDouble(((EditText) findViewById(R.id.number1)).getText().toString());
                Double number2 = Double.parseDouble(((EditText) findViewById(R.id.number2)).getText().toString());

                Double answer = number1 - number2;

                calculate(answer);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
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

    public void calculate(Double answer) {
        TextView calculate = (TextView) findViewById(R.id.answer);
        calculate.setText(String.format("Total: %.2f", answer));
    }
}
