package nik.angel.tree;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Paper extends View{

	public Paper(Context ctxt,AttributeSet attrs)
	{
		super(ctxt,attrs);
	}
	
	public boolean onTouchEvent(MotionEvent mv)
	{
		return true;
	}
}
