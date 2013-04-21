package en.mswl.actividad2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Actividad2 extends Activity {

	private final int FROM_A2 = 2;
	public static final String PARAM = "PARAM";   
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actividad2);
		
		Button b1 = (Button) this.findViewById(R.id.b1);
		if (b1 != null )
		{
			b1.setOnClickListener( new OnClickListener() 
			{
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					
				Intent intent = new Intent(Actividad2.this, Actividad3.class);
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
			Intent intent = new Intent(Actividad2.this, A2.class);
			intent.putExtra("TITLE", "A2");
			startActivityForResult(intent, FROM_A2);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actividad2, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if ( resultCode == Activity.RESULT_OK) 
		{
			Integer value = data.getIntExtra(PARAM, -1);

			if (requestCode == FROM_A2)
				Toast.makeText(this, "Retorno de A2: " + String.valueOf(value), Toast.LENGTH_SHORT).show();
		}
	}
	
}
