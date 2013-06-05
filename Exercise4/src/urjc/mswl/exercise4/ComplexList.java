package urjc.mswl.exercise4;

import java.util.ArrayList;
import com.google.android.maps.GeoPoint;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ComplexList extends ListActivity 
{
	private MyAdapter mAdapter = null;
	
	private static ArrayList<Node> mArray = new ArrayList<Node>();

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        setData();
        
        mAdapter = new MyAdapter(this);
        setListAdapter(mAdapter);
	}

    protected void onListItemClick(ListView l, View v, int position, long id)
    {
    // Create a new intent to call other Activity
    // Using the methods "putExtra" we can send data to the new activity           
    	Toast.makeText(this, mArray.get(position).mTitle, Toast.LENGTH_SHORT).show();
    	
    	Node currentNode = mArray.get(position);
    	
    	Intent intent = new Intent(ComplexList.this, MapsActivity.class);
    	
    	intent.putExtra("TITLE", currentNode.mTitle);
    	intent.putExtra("DESCRIPTION", currentNode.mDescription);
    	intent.putExtra("IMAGE", currentNode.mImageResource);
    	intent.putExtra("LATITUDE", currentNode.getLatitude()); // .mLatitude 
    	intent.putExtra("LONGITUDE", currentNode.getLongitude()); // .mLongitude 
        
		startActivity(intent);
    }

    private void setData ()
    { 
            mArray.clear();
 
            // Item 1
            Node mynode = new Node();  
            mynode.mTitle = this.getResources().getString(R.string.item_1);
            mynode.mDescription = this.getResources().getString(R.string.desc_1);
            mynode.mImageResource = R.drawable.alcala;
            mynode.setmGeoPoint(new GeoPoint (Integer.parseInt(getString(R.string.lat1)) , 
            								  Integer.parseInt(getString(R.string.lon1))));
            mArray.add(mynode);
 
            //Item 2
            Node mynode2 = new Node();
            mynode2.mTitle = this.getResources().getString(R.string.item_2);
            mynode2.mDescription = this.getResources().getString(R.string.desc_2);
            mynode2.mImageResource = R.drawable.autonoma;
            mynode2.setmGeoPoint(new GeoPoint (Integer.parseInt(getString(R.string.lat2)) , 
					  						   Integer.parseInt(getString(R.string.lon2))));            
            mArray.add(mynode2);
 
            //Item 3
            Node mynode3 = new Node();
            mynode3.mTitle = this.getResources().getString(R.string.item_3);
            mynode3.mDescription = this.getResources().getString(R.string.desc_3);
            mynode3.mImageResource = R.drawable.complutense;
            mynode3.setmGeoPoint(new GeoPoint (Integer.parseInt(getString(R.string.lat3)) , 
					  					       Integer.parseInt(getString(R.string.lon3))));
            mArray.add(mynode3);
            
            //Item 4
            Node mynode4 = new Node();
            mynode4.mTitle = this.getResources().getString(R.string.item_4);
            mynode4.mDescription = this.getResources().getString(R.string.desc_4);
            mynode4.mImageResource = R.drawable.urjc;
            mynode4.setmGeoPoint(new GeoPoint (Integer.parseInt(getString(R.string.lat4)) , 
            								   Integer.parseInt(getString(R.string.lon4))));
            mArray.add(mynode4);            
    }
    
    public static class MyAdapter extends BaseAdapter
    {   
    	   private Context mContext;
    	   
           public MyAdapter (Context context)
           {
        	   mContext = context;
           }

            @Override
            public int getCount() 
            {
            	return mArray.size();
            }

            @Override
            public Object getItem(int position) 
            {
            	return mArray.get(position);      
            }

            @Override
            public long getItemId(int position) 
            {
                    // TODO Auto-generated method stub
                    return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) 
            {                   
            	View view;
            	
            	LayoutInflater inflater = (LayoutInflater) mContext.
            			getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            	               	
            	view = inflater.inflate(R.layout.activity_complex_list, null);
            	
            	TextView tvTitle = (TextView) view.findViewById(R.id.title);
            	tvTitle.setText(mArray.get(position).mTitle);
            	
            	TextView tvDescription = (TextView) view.findViewById(R.id.description);
            	tvDescription.setText(mArray.get(position).mDescription);
            	
            	ImageView img = (ImageView) view.findViewById(R.id.image);
            	img.setImageDrawable(mContext.getResources().getDrawable(
            					mArray.get(position).mImageResource));
            	
            	return view;
            }
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.complex_list, menu);
		return true;
	}
	
}