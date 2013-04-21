package urjc.mswl.intentactivities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class A2 extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a2);
		
		TextView tv_a2 = (TextView) this.findViewById(R.id.tv_a2);
		
		Intent i_f_a = getIntent();
		
		if (i_f_a != null) 
		{
			String title = i_f_a.getStringExtra("TITLE");
			if (title != null)
			{
				tv_a2.setText(title);
			}
		}		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.a2, menu);
		return true;
	}

	public void finish() 
	{
		Intent returnIntent = new Intent();
		returnIntent.putExtra("PARAM", 20);
		
		setResult(RESULT_OK, returnIntent);
		
		super.finish();
	}
	
}
