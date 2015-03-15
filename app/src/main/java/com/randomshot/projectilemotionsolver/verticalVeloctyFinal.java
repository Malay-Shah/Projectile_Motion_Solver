package com.randomshot.projectilemotionsolver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class verticalVeloctyFinal extends ActionBarActivity {


    EditText acc;
    EditText vinitial;
    EditText vDisplacement;
    EditText time;

    Button resultforVf;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_velocty_final);
        // find the elements
        acc = (EditText) findViewById(R.id.accInputForVf);
        vinitial = (EditText) findViewById(R.id.verViInputforVf);
        vDisplacement = (EditText) findViewById(R.id.displacementInputforVf);
        time = (EditText) findViewById(R.id.timeInputforVf);

        resultforVf = (Button) findViewById(R.id.bsolveForVeloctyFinal);

        tvResult = (TextView) findViewById(R.id.findVerticalVelocityFinal);
        // set a listener
        resultforVf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // This is to check if three of the four text fields
                // are populated
                int counter = 0;

                if (vDisplacement.getText().toString().isEmpty()){
                    counter++;
                }
                if (vinitial.getText().toString().isEmpty()){
                    counter++;

                }
                if (acc.getText().toString().isEmpty()){
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
                    } else if (TextUtils.isEmpty(vinitial.getText().toString())) {
                        noVi();
                    } else if (TextUtils.isEmpty(vDisplacement.getText().toString())) {
                        noVdis();
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
        float vi;
        float vdis;
        float t;
        float result;

        vi = Float.parseFloat(vinitial.getText().toString());
        vdis = Float.parseFloat(vDisplacement.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (((2 * (vdis / t)) - vi));

        tvResult.setText("Velocity Final is " + result);
    }
    public void noVi(){
        float a;
        float vdis;
        float t;
        float result;

        a = Float.parseFloat(acc.getText().toString());
        vdis = Float.parseFloat(vDisplacement.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (float) ((vdis + (0.5 * a * (t * t))) / t);

        tvResult.setText("Velocity Final is " + result);
    }
    public void noVdis(){

        float vi;
        float a;
        float t;
        float result;

        vi = Float.parseFloat(vinitial.getText().toString());
        a = Float.parseFloat(acc.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (vi + (a * t));

        tvResult.setText("Velocity Final is " + result);
    }
    public void noT(){

        float vi;
        float vdis;
        float a;
        float result;

        vi = Float.parseFloat(vinitial.getText().toString());
        vdis = Float.parseFloat(vDisplacement.getText().toString());
        a = Float.parseFloat(acc.getText().toString());

        result = (float) Math.sqrt((vi * vi) + (2 * a * vdis));

        tvResult.setText("Velocity Final is " + result);
    }
    public void filledSpot(){
        float vi;
        float vdis;
        float t;
        float result;

        vi = Float.parseFloat(vinitial.getText().toString());
        vdis = Float.parseFloat(vDisplacement.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (((2 * (vdis / t)) - vi));

        tvResult.setText("Velocity Final is " + result);
    }
}
