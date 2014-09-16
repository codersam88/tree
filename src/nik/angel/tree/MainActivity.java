package nik.angel.tree;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends Activity {
	
	private Paper paper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //paper = (Paper)findViewById(R.id.paper);
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
    
}
