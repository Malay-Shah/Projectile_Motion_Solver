package com.randomshot.projectilemotionsolver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class time extends ActionBarActivity {


    EditText acc;
    EditText vinitial;
    EditText vfinal;
    EditText vdisplacement;

    Button resultforT;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        // find the elements
        acc = (EditText) findViewById(R.id.accInputForT);
        vinitial = (EditText) findViewById(R.id.verViInputforT);
        vfinal = (EditText) findViewById(R.id.verVfInputforT);
        vdisplacement = (EditText) findViewById(R.id.displacementInputforT);

        resultforT = (Button) findViewById(R.id.bsolveForTime);

        tvResult = (TextView) findViewById(R.id.findTime);
        // set a listener
        resultforT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // This is to check if three of the four text fields
                // are populated
                int counter = 0;

                if (vdisplacement.getText().toString().isEmpty()){
                    counter++;
                }
                if (vinitial.getText().toString().isEmpty()){
                    counter++;

                }
                if (vfinal.getText().toString().isEmpty()){
                    counter++;
                }
                if (acc.getText().toString().isEmpty()){
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
                    } else if (TextUtils.isEmpty(vfinal.getText().toString())) {
                        noVf();
                    } else if (TextUtils.isEmpty(vdisplacement.getText().toString())) {
                        noVdis();
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
        float vi = 0;
        float vf  = 0;
        float vdis = 0;
        float result = 0;

        vi = Float.parseFloat(vinitial.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        vdis = Float.parseFloat(vdisplacement.getText().toString());

        result = (vdis / ((vf + vi) / 2));

        tvResult.setText("Time is " + result);
    }
    public void noVi(){

        float a = 0;
        float vf  = 0;
        float vdis = 0;
        float result = 0;
        float result2 = 0;

        a = Float.parseFloat(acc.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        vdis = Float.parseFloat(vdisplacement.getText().toString());
        a = a/2;
        vdis = -(vdis);

        result = (float) ((-vf + Math.sqrt((vf * vf) - (4 * a * vdis))) / (2*a));
        result2 = (float) ((-vf - Math.sqrt((vf * vf) - (4 * a * vdis))) / (2*a));

        tvResult.setText(result + " and "+ result2);
    }
    public void noVf(){

        float vi = 0;
        float a  = 0;
        float vdis = 0;
        float result = 0;
        float result2 = 0;

        vi = Float.parseFloat(vinitial.getText().toString());
        a = Float.parseFloat(acc.getText().toString());
        vdis = Float.parseFloat(vdisplacement.getText().toString());
        a = -(a/2);

        result = (float) ((vi + Math.sqrt((vi * vi) - (4 * a * vdis))) / (2*a));
        result2 = (float) ((vi - Math.sqrt((vi * vi) - (4 * a * vdis))) / (2*a));

        tvResult.setText(result + " and "+ result2);
    }
    public void noVdis(){

        float vi = 0;
        float vf  = 0;
        float a = 0;
        float result = 0;

        vi = Float.parseFloat(vinitial.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        a = Float.parseFloat(acc.getText().toString());

        result = (vf - vi) / a;

        tvResult.setText("Time is " + result);
    }
    public void filledSpot(){
        float vi = 0;
        float vf  = 0;
        float vdis = 0;
        float result = 0;

        vi = Float.parseFloat(vinitial.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        vdis = Float.parseFloat(vdisplacement.getText().toString());

        result = (vdis / ((vf + vi) / 2));

        tvResult.setText("Time is " + result);
    }
}
