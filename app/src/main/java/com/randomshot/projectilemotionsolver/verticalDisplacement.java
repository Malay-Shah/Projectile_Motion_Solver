package com.randomshot.projectilemotionsolver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class verticalDisplacement extends ActionBarActivity {

    EditText acc;
    EditText vinitial;
    EditText vfinal;
    EditText time;

    Button resultforVd;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_displacement);
        // find the elements
        acc = (EditText) findViewById(R.id.accInputforVd);
        vinitial = (EditText) findViewById(R.id.displacementInputforVd);
        vfinal = (EditText) findViewById(R.id.verVfInputforVd);
        time = (EditText) findViewById(R.id.timeInputforVd);

        resultforVd = (Button) findViewById(R.id.bFindVerDis);

        tvResult = (TextView) findViewById(R.id.findVerticalDisplacement);

        // set a listener
        resultforVd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // This is to check if three of the four text fields
                // are populated
                int counter = 0;

                if (acc.getText().toString().isEmpty()){
                    counter++;
                }
                if (vinitial.getText().toString().isEmpty()){
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
                    } else if (TextUtils.isEmpty(vinitial.getText().toString())) {
                        noVi();
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
        float vi ;
        float vf ;
        float t;
        float result ;

        vi = Float.parseFloat(vinitial.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (vi + vf)/2 * t;

        tvResult.setText("Displacement is " + result);
    }
    public void noVi(){

        float a ;
        float vf  ;
        float t;
        float result;

        a = Float.parseFloat(acc.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (float) ((vf*t) - (0.5*a*(t*t)));

        tvResult.setText("Displacement is " + result);
    }
    public void noVf(){

        float a;
        float vi;
        float t;
        float result;

        a = Float.parseFloat(acc.getText().toString());
        vi = Float.parseFloat(vinitial.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (float) ((vi*t) + (0.5*a*(t*t)));

        tvResult.setText("Displacement is " + result);
    }
    public void noT(){

        float a ;
        float vi;
        float vf ;
        float result;

        a = Float.parseFloat(acc.getText().toString());
        vi = Float.parseFloat(vinitial.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());

        result = (((vf * vf) - (vi * vi)) / (2 * a));

        tvResult.setText("Displacement is " + result);
    }
    public void filledSpot(){
        float vi;
        float vf;
        float t;
        float result;

        vi = Float.parseFloat(vinitial.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (vi + vf)/2 * t;

        tvResult.setText("Displacement is " + result);
    }
}
