package com.example.mysharepreference;


import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;



public class Mymenu extends PreferenceActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
	
		super.onCreate(savedInstanceState);
		getFragmentManager().beginTransaction().replace(android.R.id.content, new PF()).commit();
		
		

	}
	public static class PF extends PreferenceFragment
	{
		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.my_preference);
		}
	}


}
