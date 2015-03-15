package com.randomshot.projectilemotionsolver;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // acceleration
        Button acce = (Button) findViewById(R.id.bSolveForAcceleration);
        acce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), acceleration.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // Vertical Displacement
        Button verticalDis = (Button) findViewById(R.id.solveForVerticalDisplacement);
        verticalDis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), verticalDisplacement.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // Velocity Initial
        Button viFind = (Button) findViewById(R.id.solveForVelocityInitial);
        viFind.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), verticalVelocityInitial.class);
                startActivityForResult(myIntent, 0);
            }

        });
        // Velocity Final
        Button vfFind = (Button) findViewById(R.id.solveForVelocityFinal);
        vfFind.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), verticalVeloctyFinal.class);
                startActivityForResult(myIntent, 0);
            }

        });
        // Time
        Button tFind = (Button) findViewById(R.id.solveForTime);
        tFind.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), time.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // Hor Inputs
        Button horInputs = (Button) findViewById(R.id.bSolveForHorInputs);
        horInputs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), horizontalInputs.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}
