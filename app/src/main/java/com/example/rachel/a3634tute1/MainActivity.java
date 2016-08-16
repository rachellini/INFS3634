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

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private StringBuilder operation = new StringBuilder();
    private Double num1 = 0.0;
    private Double num2 = 0.0;
    private String operate = "";
    private Double calculate = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    public void numberOnClick(View view) {
        Button value = (Button) view;
        TextView answer = (TextView) findViewById(R.id.numberDisplay);

        operation = operation.append(value.getText());
        answer.setText(operation);
    }

    public void operatorOnClick(View view) {
        Button operator = (Button) view;
        TextView answer = (TextView) findViewById(R.id.numberDisplay);

        num1 = Double.parseDouble(operation.toString());
        operate = (String) operator.getText();
        //System.out.print(num1 + operate);

        operation = operation.append(operator.getText());
        answer.setText(operation);
    }

    public void equalsOnClick(View view){
        TextView answer = (TextView) findViewById(R.id.numberDisplay);
        String elementsString = operation.toString();
        String[] elements = elementsString.split(Pattern.quote(operate));
        num2 = Double.parseDouble(elements[1]);

        switch(operate) {
            case("+"):
                calculate = num1 + num2;
                break;
            case("-"):
                calculate = num1 - num2;
                break;
            case("/"):
                calculate = num1/num2;
                break;
            case("x"):
                calculate = num1*num2;
                break;
        }

        answer.setText(calculate.toString());
        operation.setLength(0);
        operation.append(calculate);
    }

    public void clearOnClick(View view) {
        Button clear = (Button) view;
        TextView answer = (TextView) findViewById(R.id.numberDisplay);

        operation.setLength(0);
        answer.setText(operation);
        num1 = 0.0;
        num2 = 0.0;
        operate = "";
    }

}
