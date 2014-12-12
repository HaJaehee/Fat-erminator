package com.app.faterminator;

import com.app.faterminator.ExerciseProgram;
import com.faterminator.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.View;
public class Menu extends Activity{
	
	private Button m1=null,m2=null,m3=null,m4=null,m5=null;
	private Menu self=this;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //We set the view for the activity
        setContentView(R.layout.menu);
      //We get back needed views
        m1=(Button) findViewById(R.id.button_menu1);
        m2=(Button) findViewById(R.id.button_menu2);
        m3=(Button) findViewById(R.id.button_menu3);
        m4=(Button) findViewById(R.id.button_menu4);
        m5=(Button) findViewById(R.id.button_menu5);
		//We set a listener for the needed views
        m1.setOnClickListener(m1Listener);
        m2.setOnClickListener(m2Listener);
        m3.setOnClickListener(m3Listener);
        m4.setOnClickListener(m4Listener);
        m5.setOnClickListener(m5Listener);
        
        m1.setVisibility(View.INVISIBLE);
        m2.setVisibility(View.INVISIBLE);
        m3.setVisibility(View.INVISIBLE);
        m4.setVisibility(View.INVISIBLE);
	}

		public OnClickListener m1Listener = new OnClickListener ()
		{

			@Override
			public void onClick(View v) {
				try
				{
				Intent appel = new Intent(self, Exercising.class);
		          startActivity(appel);
		          finish();
				} catch (Exception e)
				{
					Toast.makeText(self, "LOL ?", Toast.LENGTH_SHORT).show();
				}
				
			}
			
		};
		public OnClickListener m2Listener = new OnClickListener ()
		{

			@Override
			public void onClick(View v) {
				Intent appel = new Intent(self, History.class);
		          startActivity(appel);
		          finish();
				
			}
			
		};
		public OnClickListener m3Listener = new OnClickListener ()
		{

			@Override
			public void onClick(View v) {
				Intent appel = new Intent(self, ExerciseProgram.class);
		          startActivity(appel);
		          finish();
				
			}
			
		};
		public OnClickListener m4Listener = new OnClickListener ()
		{

			@Override
			public void onClick(View v) {
				Intent appel = new Intent(self, TipMenu.class);
		          startActivity(appel);
		          finish();
				
			}
			
		};
		public OnClickListener m5Listener = new OnClickListener ()
		{

			@Override
			public void onClick(View v) {
				Intent appel = new Intent(self, UserInformation.class);
		          startActivity(appel);
		          finish();
				
			}
			
		};
}
