package nik.angel.tree;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Paper extends View{
	
	//drawing path
	private Path drawPath;
	//drawing and canvas paint
	private Paint drawPaint, canvasPaint;
	//initial color
	private int paintColor = 0xFF660000;
	//canvas
	private Canvas drawCanvas;
	//canvas bitmap
	private Bitmap canvasBitmap;

	public Paper(Context ctxt,AttributeSet attrs)
	{
		super(ctxt,attrs);
		setupDrawing();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
	
		canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
		canvas.drawPath(drawPath, drawPaint);
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh)
	{
		super.onSizeChanged(w, h, oldw, oldh);
		canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		drawCanvas = new Canvas(canvasBitmap);
	}
																																																																																																																																																																																																																																																																																
	public boolean onTouchEvent(MotionEvent mv)
	{
//		MainActivity ma = new MainActivity();
//		ActionBar ab = ma.getActionBar();
		if(MainActivity.bar.isShowing())
			MainActivity.bar.hide();
		else
			MainActivity.bar.show();																																																																																																																																																																																																									
		float touchX = mv.getX();
		float touchY = mv.getY();
		switch (mv.getAction()) {
		case MotionEvent.ACTION_DOWN:
			
		    drawPath.moveTo(touchX, touchY);
		    break;
		case MotionEvent.ACTION_MOVE:
		    drawPath.lineTo(touchX, touchY);
		    break;
		case MotionEvent.ACTION_UP:
		    drawCanvas.drawPath(drawPath, drawPaint);
		    drawPath.reset();
		    break;
		default:
		    return false;
		}
		invalidate();
		return true;
	}
	
	private void setupDrawing()
	{
		drawPath = new Path();
		drawPaint = new Paint();  
		drawPaint.setAntiAlias(true);
		drawPaint.setStrokeWidth(5);
		drawPaint.setStyle(Paint.Style.STROKE);
		drawPaint.setStrokeJoin(Paint.Join.ROUND);
		drawPaint.setStrokeCap(Paint.Cap.ROUND);
		canvasPaint = new Paint(Paint.DITHER_FLAG);
	}
	
	
}
