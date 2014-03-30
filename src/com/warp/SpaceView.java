package com.warp;

import com.warp.model.CelestialObject;
import com.warp.model.Space;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class SpaceView extends View {
	
	Space space = null;

	public SpaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public SpaceView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public SpaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		space.render(canvas);
		
	}
	
	

}
