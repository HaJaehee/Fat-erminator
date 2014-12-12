package com.app.faterminator;


import com.faterminator.R;

import android.app.Activity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;



public class HomePage extends Activity{
	// D�claration des ressources
	//N'oubliez pas de d�clarer le bon package dans lequel se trouve le fichier !
	ImageView home = null;
	public HomePage self = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //We set the view for the activity
        setContentView(R.layout.home_page);
        //We get back needed views
        home= (ImageView) findViewById(R.id.homePage);
        //We define the listener for the needed views
        home.setOnClickListener(homeListener);
    } 
    public OnClickListener homeListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			//We launch the new activity
            Intent appel = new Intent(self, UserInformation.class);
            startActivity(appel);	
            finish();
		}
    	
    };
}
	


