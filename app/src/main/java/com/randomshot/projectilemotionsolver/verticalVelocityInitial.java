package com.randomshot.projectilemotionsolver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class verticalVelocityInitial extends ActionBarActivity {


    EditText acc;
    EditText vDisplacement;
    EditText vfinal;
    EditText time;

    Button resultforVi;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_velocity_initial);
        // find the elements
        acc = (EditText) findViewById(R.id.accInputforVi);
        vDisplacement = (EditText) findViewById(R.id.displacementInputforVi);
        vfinal = (EditText) findViewById(R.id.verVfInputforVi);
        time = (EditText) findViewById(R.id.timeInputfoVi);

        resultforVi = (Button) findViewById(R.id.bsolveForVeloctyInitial);

        tvResult = (TextView) findViewById(R.id.findVerticalVelocityInitial);
        // set a listener
        resultforVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // This is to check if three of the four text fields
                // are populated
                int counter = 0;

                if (vDisplacement.getText().toString().isEmpty()){
                    counter++;
                }
                if (acc.getText().toString().isEmpty()){
                    counter++;

                }
                if (vfinal.getText().toString().isEmpty()){
                    counter++;
                }
                if (time.getText().toString().isEmpty()){
                    counter++;
                }
                // If field requirements are met, do the math
                if ( counter >= 2  ) {
                    noInfo();
                }else {
                    // check if the fields are empty
                    if (TextUtils.isEmpty(acc.getText().toString())) {
                        noAcc();
                    } else if (TextUtils.isEmpty(vDisplacement.getText().toString())) {
                        noVdis();
                    } else if (TextUtils.isEmpty(vfinal.getText().toString())) {
                        noVf();
                    } else if (TextUtils.isEmpty(time.getText().toString())) {
                        noT();
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
    public void noAcc(){
        float vdis ;
        float vf ;
        float t ;
        float result;

        vdis = Float.parseFloat(vDisplacement.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (((2 * vdis) /t) - vf);

        tvResult.setText("Velocity Initial is " + result);
    }
    public void noVdis(){

        float a;
        float vf;
        float t;
        float result;

        a = Float.parseFloat(acc.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (vf - (a * t));

        tvResult.setText("Velocity Initial is " + result);
    }
    public void noVf(){

        float vdis;
        float a;
        float t;
        float result;

        vdis = Float.parseFloat(vDisplacement.getText().toString());
        a = Float.parseFloat(acc.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (float) ((vdis / t) - (0.5 * a * t));

        tvResult.setText("Velocity Initial is " + result);
    }
    public void noT(){

        float vdis;
        float vf;
        float a;
        float result;

        vdis = Float.parseFloat(vDisplacement.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        a = Float.parseFloat(acc.getText().toString());

        result = (float) (Math.sqrt((vf * vf) - (2 * a * vdis)));

        tvResult.setText("Velocity Initial is " + result);
    }
    public void filledSpot(){
        float vdis;
        float vf;
        float t;
        float result;

        vdis = Float.parseFloat(vDisplacement.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (((2 * vdis) /t) - vf);

        tvResult.setText("Velocity Initial is " + result);
    }
}
