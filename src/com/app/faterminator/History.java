package com.app.faterminator;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.R.string;
import android.app.Activity;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;


public class History extends Activity {
		
		float r=400, w=800, sr=300, j=588 ,st=909 , angle, tot;
	
	     /** Called when the activity is first created. */
	     @Override
	     public void onCreate(Bundle savedInstanceState) {
	         super.onCreate(savedInstanceState);
	         String csv = "exercising_history.csv";
			 String exerHistDir =FinalStaticVariables.DIR_FOLDER;
			 File file = new File (exerHistDir);
			 if(!file.exists())
				 file.mkdirs();
			 exerHistDir+=csv;
				 
	 		 CSVReader csvReader = null;
	 		try {
	 			
	 		csvReader = new CSVReader(new FileReader(exerHistDir));
	 		String[] row = null;
	 		row = csvReader.readNext();
	 		while(row != null) {
	 			
	 		    System.out.println(row[0]
	 		              + " # " + row[1]
	 		              + " #  " + row[2]);
	 		    row=csvReader.readNext();
	 		}
	 		//...
	 		csvReader.close();
	 		
	 		r=Float.parseFloat(row[11]);
	 		w=Float.parseFloat(row[12]);
	 		sr=Float.parseFloat(row[13]);
	 		j=Float.parseFloat(row[14]);
	 		st=Float.parseFloat(row[15]);
	 		
	 		} catch (FileNotFoundException e) {
	 			Toast.makeText(this, "Exercise history not exist!", Toast.LENGTH_SHORT).show();
	 			e.printStackTrace();
	 		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
	 		setContentView(new MyView(this));
	     }

	     public class MyView extends View {
	         public MyView(Context context) {
	              super(context);
	              // TODO Auto-generated constructor stub
	         }

	         @Override
	         protected void onDraw(Canvas canvas) {
	            // TODO Auto-generated method stub
	            super.onDraw(canvas);
	            int x = getWidth();
	            int y = getHeight();
	            
	            tot= r+w+sr+j+st;
	            r=(r/tot)*360;
	            w=(w/tot)*360;
	            sr=(sr/tot)*360;
	            j=(j/tot)*360;
	            st=(st/tot)*360;
	            
	            Paint paint = new Paint();
	            paint.setStyle(Paint.Style.FILL);
	            paint.setColor(Color.WHITE);
	            canvas.drawPaint(paint);
	            // Use Color.parseColor to define HTML colors
	            paint.setColor(Color.parseColor("#CD5C5C"));
	            RectF rectF = new RectF(50, 20, 100, 80);
				canvas.drawOval(rectF, paint);
				
				paint.setColor(Color.BLACK);
				angle=0;
				canvas.drawArc (rectF, angle, angle+r, true, paint);
				
				paint.setColor(Color.RED);
				angle+=r;
				canvas.drawArc (rectF, angle, angle+w, true, paint);
				
				paint.setColor(Color.GREEN);
				angle+=w;
				canvas.drawArc (rectF, angle, angle+sr, true, paint);
				
				paint.setColor(Color.YELLOW);
				angle+=sr;
				canvas.drawArc (rectF, angle, angle+j, true, paint);
				
				paint.setColor(Color.BLUE);
				angle+=j;
				canvas.drawArc (rectF, angle, angle+st, true, paint);
				
			
	        }
	     }
	
	/*//String array writting
	String csv = "C:\\work\\output.csv";
	CSVWriter writer = new CSVWriter(new FileWriter(csv));
	 
	String [] country = "India#China#United States".split("#");
	 
	writer.writeNext(country);
	 
	writer.close();
	
	// Full document or list of string array writting
	String csv = "C:\\work\\output.csv";
	CSVWriter writer = new CSVWriter(new FileWriter(csv));
	 
	List<string[]> data = new ArrayList<string[]>();
	data.add(new String[] {"India", "New Delhi"});
	data.add(new String[] {"United States", "Washington D.C"});
	data.add(new String[] {"Germany", "Berlin"});
	 
	writer.writeAll(data);
	 
	writer.close();*/
}
