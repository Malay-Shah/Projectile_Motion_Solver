package com.randomshot.projectilemotionsolver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
        float d ;
        float t ;
        float result;

        d = Float.parseFloat(displacement.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (d/t);

        tvResult.setText("Velocity is " + result);
    }
    public void solveForDisplacement(){
        float t ;
        float v;
        float result;

        t = Float.parseFloat(time.getText().toString());
        v = Float.parseFloat(velocity.getText().toString());

        result = (v*t);

        tvResult.setText("Displacement is " + result);

    }
    public void solveForTime(){
        float d;
        float v ;
        float result ;

        d = Float.parseFloat(displacement.getText().toString());
        v = Float.parseFloat(velocity.getText().toString());

        result = (d/v);

        tvResult.setText("Time is " + result);

    }
    public void filledSpot(){

    }

}
