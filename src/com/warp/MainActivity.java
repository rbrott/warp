package com.warp;

import com.warp.model.CelestialObject;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		final ActionBar actionBar = getActionBar();
		
		actionBar.hide();
		
		CelestialObject obj1 = new CelestialObject(0.0, 0.0, 0.0, 0.0, Math.pow(10.0, 30.0));
		CelestialObject obj2 = new CelestialObject(Math.pow(10.0, 20.0), Math.pow(10.0, 20.0), 0.0, 0.0, Math.pow(10.0, 35.0));
		Log.i("Gravity", "(" + obj1.getX() + ", " + obj1.getY() + ")");
		obj1.applyGravitationalAcceleration(obj2);
		obj1.update(0);
		Log.i("Gravity", "(" + obj1.getX() + ", " + obj1.getY() + ")");
		
	}
	
}