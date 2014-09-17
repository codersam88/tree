package nik.angel.tree;

import java.util.UUID;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button savBtn;
	private Paper paper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paper = (Paper)findViewById(R.id.paper);
        savBtn = (Button)findViewById(R.id.savBtn);
        savBtn.setOnClickListener(this);
    }

    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN: {
            //Log.e(TAG, " - DOWN -");
            //Log.e(TAG, " getX: " + event.getX());
            break;
        }
        case MotionEvent.ACTION_UP: {
            //Log.e(TAG, " - UP -");
            //Log.e(TAG, " getX: " + event.getX());
            break;
        }
        }
        return true;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	

	@Override
	public void onClick(View v) {
		paper.setDrawingCacheEnabled(true);
		String imgSaved = MediaStore.Images.Media.insertImage(
				getContentResolver(), paper.getDrawingCache(),
				UUID.randomUUID().toString()+".png", "drawing");
		paper.destroyDrawingCache();
		
	}
    
}
