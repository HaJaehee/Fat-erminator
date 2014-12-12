package com.app.faterminator;




import java.io.File;
import java.io.FileWriter;

import com.faterminator.R;

import android.text.Editable;
import android.text.TextWatcher;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import au.com.bytecode.opencsv.CSVWriter;

public class UserInformation extends Activity {
	//Instantiation

	private String a,w,h,s,n;
	

	public UserInformation self = this;
	private EditText name, height, weight, age;
	private Button save, back;
	private RadioButton female, male;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //We set the view for the activity
        setContentView(R.layout.user_information);
      //We get back needed views
        name=(EditText) findViewById(R.id.name_edit);
        height=(EditText) findViewById(R.id.height_edit);
        weight=(EditText) findViewById(R.id.weight_edit);
        age=(EditText) findViewById(R.id.age_edit);
        save=(Button) findViewById(R.id.save_button);
        back=(Button) findViewById(R.id.back_button);
        female=(RadioButton) findViewById(R.id.female_check);
        male=(RadioButton) findViewById(R.id.male_check);
        //We set a listener for the needed views
        name.addTextChangedListener(textWatcher);
        save.setOnClickListener(saveListener);
        back.setOnClickListener(backListener);
       
        age.addTextChangedListener(textWatcher);
        weight.addTextChangedListener(textWatcher);
        height.addTextChangedListener(textWatcher);
	}
	private TextWatcher textWatcher = new TextWatcher() {

	    @Override
	    public void onTextChanged(CharSequence s, int start, int before, int count) {

	    }
			
	    @Override
	    public void beforeTextChanged(CharSequence s, int start, int count,
	      int after) {
	  
	    }
	  
	    @Override
	    public void afterTextChanged(Editable s) {
	  
	    }

		
	  };

	  public OnClickListener saveListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
		try
		{
			n = name.getText().toString();
			if (female.isChecked()) s="female";
			else if (male.isChecked()) s="male";
			a = age.getText().toString();
			h = height.getText().toString();
			w = weight.getText().toString();
			Toast.makeText(self, "Name:"+n+", age:"+a+", height:"+h+", weight:"+w+", gender:"+s, Toast.LENGTH_SHORT).show();
			//String array writting
			String csv = "user_info.csv";
			 String userInfoPath =FinalStaticVariables.DIR_FOLDER;
			 File file = new File (userInfoPath);
			 if(!file.exists())
				 file.mkdirs();
			 userInfoPath+=csv;
				 
			FileWriter writer = new FileWriter(userInfoPath);
			 
			String collName = "Username,age,sex,height,weight\n";
			String userInfo = n+","+a+","+s+","+h+","+w+"\n";
			 
			writer.write(collName);
			writer.write(userInfo);
			writer.flush();
			 
			writer.close();
			
			/*// Full document or list of string array writting
			String csv = "C:\\work\\output.csv";
			CSVWriter writer = new CSVWriter(new FileWriter(csv));
			 
			List<string[]> data = new ArrayList<string[]>();
			data.add(new String[] {"India", "New Delhi"});
			data.add(new String[] {"United States", "Washington D.C"});
			data.add(new String[] {"Germany", "Berlin"});
			 
			writer.writeAll(data);
			 
			writer.close();*/
			Intent appel = new Intent(self, Menu.class);
	          startActivity(appel);
	          finish();
		} catch (Exception e) {
	          e.printStackTrace();
	          Toast.makeText(self, "Fill again please, you did a mistake or you forgot a field.", Toast.LENGTH_SHORT).show();
	          Intent appel = new Intent(self, UserInformation.class);
	          startActivity(appel);
	          finish();
	        }
		}
		  
	  };
	  
	  public OnClickListener backListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent appel = new Intent(self, Menu.class);
		          startActivity(appel);
		          finish();
				
			}
			  
		  };
}
