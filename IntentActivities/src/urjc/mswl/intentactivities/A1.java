package urjc.mswl.intentactivities;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class A1 extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.a1, menu);
		return true;
	}

}
