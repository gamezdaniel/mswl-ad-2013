package urjc.mswl.listsapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SList extends ListActivity
{

	private String TAG = getClass().getSimpleName();
	ListView lv;
	ListAdapter la;
	
	private String[] testValues = new String[] 
	{
			"URJC",
			"EOI",
			"Android"			
	};
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lists_main);
		
		lv = (ListView) this.findViewById(android.R.id.list);
		
		la = new ArrayAdapter<String>(
				this,android.R.layout.simple_list_item_1,
				testValues);
		
		lv.setAdapter(la);
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Toast.makeText(this, String.valueOf(position) + " - " + testValues[position], Toast.LENGTH_SHORT).show();
		
		Log.d(TAG, "Position = " + String.valueOf(position));
		Log.d(TAG, "Value = " + testValues[position]);
		
	}

}
