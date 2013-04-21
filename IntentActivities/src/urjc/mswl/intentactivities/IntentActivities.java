package urjc.mswl.intentactivities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class IntentActivities extends Activity 
{

	private final int FROM_A2 = 2;
	private final int FROM_A3 = 3;
	
	
	public static final String PARAM = "PARAM";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_activities);
		
		Button b1 = (Button) this.findViewById(R.id.b1);
		if ( b1 != null ) 
		{
			b1.setOnClickListener( new OnClickListener() 
			{
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					Intent intent = new Intent(IntentActivities.this, A1.class);
					startActivity(intent);
				}
			});
		}

		Button b2 = (Button) this.findViewById(R.id.b2);
		b2.setOnClickListener( new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(IntentActivities.this, A2.class);
				intent.putExtra("TITLE", "Activity 2");
				startActivityForResult(intent, FROM_A2);
			}
		});
		
		Button b3 = (Button) this.findViewById(R.id.b3);
		b3.setOnClickListener( new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(IntentActivities.this, A3.class);
				startActivityForResult(intent, FROM_A3);
			}
		});
		
		Button browser = (Button) this.findViewById(R.id.b4);
		browser.setOnClickListener( new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es"));
				startActivity(browserIntent);

			}
		});
		
		Button call = (Button) this.findViewById(R.id.b5);
		call.setOnClickListener( new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:123-456-789"));
				startActivity(intent);
			}
			});
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.intent_activities, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if ( resultCode == Activity.RESULT_OK) 
		{
			Integer value = data.getIntExtra(PARAM, -1);

			if (requestCode == FROM_A2)
				Toast.makeText(this, "Return from Activity 2: " + String.valueOf(value), Toast.LENGTH_SHORT).show();
			
			else if (requestCode == FROM_A3)
				Toast.makeText(this, "Return from Activity 3: " + String.valueOf(value), Toast.LENGTH_SHORT).show();
				
		}
	}	
}
