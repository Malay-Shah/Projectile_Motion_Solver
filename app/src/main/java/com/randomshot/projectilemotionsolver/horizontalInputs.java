package com.randomshot.projectilemotionsolver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;


public class horizontalInputs extends ActionBarActivity {

    EditText velocity;
    EditText displacement;
    EditText time;

    Button resultForHor;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_inputs);
        velocity = (EditText) findViewById(R.id.velocityInputforHor);
        displacement = (EditText) findViewById(R.id.displacementInputforHor);
        time = (EditText) findViewById(R.id.timeInputforHor);

        resultForHor = (Button) findViewById(R.id.solveForHor);

        tvResult = (TextView) findViewById(R.id.tvForHorAnswer);

        resultForHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This is to check if three of the four text fields
                // are populated
                int counter = 0;

                if (velocity.getText().toString().isEmpty()){
                    counter++;
                }
                if (displacement.getText().toString().isEmpty()){
                    counter++;

                }
                if (time.getText().toString().isEmpty()){
                    counter++;
                }
                if ( counter >= 2  ) {
                    noInfo();
                }else {
                    if (TextUtils.isEmpty(velocity.getText().toString())) {
                        solveForVelocity();
                    } else if (TextUtils.isEmpty(displacement.getText().toString())) {
                        solveForDisplacement();
                    } else if (TextUtils.isEmpty(time.getText().toString())) {
                        solveForTime();
                    } else {
                        filledSpot();
                    }
                }
            }
        });
}
    public void noInfo(){
        Toast.makeText(this, "Please fill in more information! ", Toast.LENGTH_SHORT).show();
    }
    public void solveForVelocity(){
        float d = 0;
        float t = 0;
        float result = 0;

        d = Float.parseFloat(displacement.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (d/t);

        tvResult.setText("Velocity is " + result);
    }
    public void solveForDisplacement(){
        float t = 0;
        float v = 0;
        float result = 0;

        t = Float.parseFloat(time.getText().toString());
        v = Float.parseFloat(velocity.getText().toString());

        result = (v*t);

        tvResult.setText("Displacement is " + result);

    }
    public void solveForTime(){
        float d = 0;
        float v = 0;
        float result = 0;

        d = Float.parseFloat(displacement.getText().toString());
        v = Float.parseFloat(velocity.getText().toString());

        result = (d/v);

        tvResult.setText("Time is " + result);

    }
    public void filledSpot(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_horizontal_inputs, menu);
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
}
