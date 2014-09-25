package nik.angel.tree;

import java.util.UUID;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Notification.Action;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class MainActivity extends Activity{
	
	private Paper paper;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paper = (Paper)findViewById(R.id.paper);
        getActionBar().hide();
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_save:
	        	paper.setDrawingCacheEnabled(true);
	    		String imgSaved = MediaStore.Images.Media.insertImage(
	    				getContentResolver(), paper.getDrawingCache(),
	    				UUID.randomUUID().toString()+".png", "drawing");
	    		paper.destroyDrawingCache();
	            return true;
//	        case R.id.action_settings:
//	            openSettings();
//	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
    
}
