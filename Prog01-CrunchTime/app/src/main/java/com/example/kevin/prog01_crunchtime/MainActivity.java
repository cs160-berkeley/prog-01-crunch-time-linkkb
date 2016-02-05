package com.example.kevin.prog01_crunchtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private double calories = 0;
    private double multiplier = 1;
    private String unitLabel;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.buttonPush:
                if (checked)
                    multiplier = 3.5;
                    ((TextView)findViewById(R.id.unitsLabel)).setText("reps");
                    break;
            case R.id.buttonSit:
                if (checked)
                    multiplier = 2.0;
                    ((TextView)findViewById(R.id.unitsLabel)).setText("reps");
                    break;
            case R.id.buttonJump:
                if (checked)
                    multiplier = 0.1;
                    ((TextView)findViewById(R.id.unitsLabel)).setText("minutes");
                    break;
            case R.id.buttonJog:
                if (checked)
                    multiplier = .12;
                    ((TextView)findViewById(R.id.unitsLabel)).setText("minutes");
                    break;

        }
    }

    public void buttonOnClick(View v){
        //do something when button is clicked
        EditText input = (EditText) findViewById(R.id.editText);
        String inputString = input.getText().toString();
        calories = Integer.parseInt(inputString)/multiplier;
        TextView output = (TextView)findViewById(R.id.caloriesOut);
        output.setText(String.format("%.0f", calories));
        ((TextView)findViewById(R.id.outputPush)).setText(String.format("%.0f reps", calories * 3.5));
        ((TextView)findViewById(R.id.outputSit)).setText(String.format("%.0f reps", calories * 2.0));
        ((TextView)findViewById(R.id.outputJump)).setText(String.format("%.0f minutes", calories * 0.1));
        ((TextView)findViewById(R.id.outputJog)).setText(String.format("%.0f minutes", calories * 0.12));
    }

}
