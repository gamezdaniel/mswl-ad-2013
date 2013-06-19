package urjc.mswl.intentactivities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class A3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a3);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.a3, menu);
		return true;
	}
	
	public void finish() 
	{
		Intent returnIntent = new Intent();
		returnIntent.putExtra("PARAM", 30);
		
		setResult(RESULT_OK, returnIntent);
		
		super.finish();
	}

}
