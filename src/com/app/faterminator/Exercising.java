package com.app.faterminator;

import com.faterminator.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;

public class Exercising extends Activity {
	private ProgressBar pg;
	static String TEMP="com.faterminator.TEMP";
	public Exercising self=this;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Intent appel = new Intent(self, Exercising.class);
        //We set the view for the activity
        setContentView(R.layout.exercising);
       // x= appel.getIntExtra(Exercising.TEMP, 0);
        //x=x+10;
        //if (x>100) x=0;
        pg = new ProgressBar(this);
        setContentView(pg);
       /* appel.putExtra(TEMP, 10);
        startActivity(appel);	
        finish();*/
        
	}
}

