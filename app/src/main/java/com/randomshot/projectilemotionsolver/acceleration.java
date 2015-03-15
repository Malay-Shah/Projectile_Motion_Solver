package com.randomshot.projectilemotionsolver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class acceleration extends ActionBarActivity {


    EditText vDisplacement;
    EditText vinitial;
    EditText vfinal;
    EditText time;

    Button resultforAcc;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceleration);
        // find the elements
        vDisplacement = (EditText) findViewById(R.id.displacementInputforAcc);
        vinitial = (EditText) findViewById(R.id.verViInputForAcc);
        vfinal = (EditText) findViewById(R.id.verVfInputforAcc);
        time = (EditText) findViewById(R.id.timeInputforAcc);

        resultforAcc = (Button) findViewById(R.id.bsolveforAcc);

        tvResult = (TextView) findViewById(R.id.findAcceleration);
        // set a listener

            resultforAcc.setOnClickListener(new View.OnClickListener() {
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
                    if (vfinal.getText().toString().isEmpty()){
                        counter++;
                    }
                    if (time.getText().toString().isEmpty()){
                        counter++;
                    }
                    // If field requirements are met, do the math
                    if ( counter >= 2  ) {
                        noInfo();
                    }else{
                        // check if the fields are empty
                        if (TextUtils.isEmpty(vDisplacement.getText().toString())) {
                            noVdispl();
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
    public void noVdispl(){
        float vi = 0;
        float vf  = 0;
        float t = 0;
        float result = 0;

        vi = Float.parseFloat(vinitial.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result = (vi - vf)/ t;

        tvResult.setText("Acceleration is " + result);
    }
    public void noVi(){

        float vDis = 0;
        float vf  = 0;
        float t = 0;
        float result = 0;

        vDis = Float.parseFloat(vDisplacement.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result =  (2 * (( vf * t)- vDis))/ (t * t);

        tvResult.setText("Acceleration is " + result);
    }
    public void noVf(){

        float vi = 0;
        float vDis  = 0;
        float t = 0;
        float result = 0;

        vi = Float.parseFloat(vinitial.getText().toString());
        vDis = Float.parseFloat(vDisplacement.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result =  (2 * (vDis - ( vi * t)))/ (t * t);

        tvResult.setText("Acceleration is " + result);
    }
    public void noT(){

        float vi = 0;
        float vf  = 0;
        float vDis = 0;
        float result = 0;

        vi = Float.parseFloat(vinitial.getText().toString());
        vf = Float.parseFloat(vfinal.getText().toString());
        vDis = Float.parseFloat(vDisplacement.getText().toString());

        result = (((vf * vf) - (vi * vi)) / (2 * vDis));

        tvResult.setText("Acceleration is " + result);
    }
    public void filledSpot(){
        float vi = 0;
        float vDis  = 0;
        float t = 0;
        float result = 0;

        vi = Float.parseFloat(vinitial.getText().toString());
        vDis = Float.parseFloat(vDisplacement.getText().toString());
        t = Float.parseFloat(time.getText().toString());

        result =  (2 * (vDis - ( vi * t)))/ (t * t);

        tvResult.setText("Acceleration is " + result);
    }

}
