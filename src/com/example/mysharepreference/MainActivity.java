package com.example.mysharepreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	SharedPreferences mSharedPreference;
	EditText mEt;
	Button bt_save;
	TextView mTv;  
	Button mMenu;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mEt = (EditText)findViewById(R.id.etView1);
		bt_save = (Button)findViewById(R.id.button1);
		mSharedPreference = getSharedPreferences("myPref" ,MODE_PRIVATE );
		if(mSharedPreference.getString("userName" , "") != "")
		{
			
			bt_save.setVisibility(View.GONE);
			mEt.setVisibility(View.GONE);
			String userName = mSharedPreference.getString("userName", "");
			mTv = (TextView)findViewById(R.id.textView1);
			mTv.setText("welcome "+ userName);
			
		}
		
		bt_save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save_Content();
			}


		});
		mMenu = (Button)findViewById(R.id.button2);
		mMenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent menu = new Intent(getBaseContext(), Mymenu.class);
				startActivity(menu); 
				
			}
		});
		
		
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
		Boolean green = settings.getBoolean("first", false);
		Boolean yellow = settings.getBoolean("second", false);
		Boolean red = settings.getBoolean("third", false);
		View layout = findViewById(R.id.relativelayoutid1);
		if(green)
			layout.setBackgroundColor(Color.GREEN);
		if(yellow)
			layout.setBackgroundColor(Color.YELLOW);
		if(red)
			layout.setBackgroundColor(Color.RED);
		if(green== false && yellow == false && red == false)
			layout.setBackgroundColor(Color.WHITE);
	
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		save_Content();
		
	}
	private void save_Content() {
		String userName = mEt.getText().toString();
		SharedPreferences.Editor edit = mSharedPreference.edit();
		edit.putString("userName" , userName);
		edit.commit();
		Toast.makeText(MainActivity.this, userName, Toast.LENGTH_LONG).show();
	}

}
