package urjc.mswl.listsapp;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
 
public class AdvancedList extends ListActivity
{
        private MyAdapter mAdapter = null;
       
       
        // We define a structure to save the data
        public class Node
        {
                public String mTitle;
                public String mDescription;
                public Integer mImageResource;
        }
       
        // ArrayList
        private static ArrayList<Node> mArray = new ArrayList<Node>();
       
 
        @Override
    public void onCreate(Bundle savedInstanceState)
        {
	        super.onCreate(savedInstanceState);                      
	        setContentView(R.layout.activity_lists_main);
	        setData();
	       
	        mAdapter = new MyAdapter(this);
	        setListAdapter(mAdapter);                      
                   
        }
       
    protected void onListItemClick(ListView l, View v, int position, long id)
        {
 
        // Create a new intent to call other Activity.
        // Using the methods "putExtra" we can send data to the new activity.
    		if ( ((position+1) % 3 != 0) && (position < 6) )
    			Toast.makeText(this, mArray.get(position).mTitle, Toast.LENGTH_SHORT).show();
        }
       
   
    private void setData ()
    { 
            mArray.clear();
 
            // Item 1
            Node mynode = new Node();  
            mynode.mTitle = this.getResources().getString(R.string.item_1);
            mynode.mDescription = "Description1";
            mynode.mImageResource = R.drawable.image1;
            mArray.add(mynode);
 
            //Item 2
            Node mynode2 = new Node();
            mynode2.mTitle = this.getResources().getString(R.string.item_2);
            mynode2.mDescription = "Description2";
            mynode2.mImageResource = R.drawable.image2; 
            mArray.add(mynode2);
 
            //Item 3
            Node mynode3 = new Node(); 
            mynode3.mTitle = this.getResources().getString(R.string.item_3);
            mynode3.mDescription = "Description3";
            mynode3.mImageResource = R.drawable.image3;
            mArray.add(mynode3);
           
            mArray.addAll(mArray);                      
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
                	return mArray.size() + 
                			( mArray.size() / 2 ) + 
                			( mArray.size() % 2 );
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
                	Log.d("TAG", "position " + String.valueOf(position));
                    View view = null;

                    LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(
                   			Context.LAYOUT_INFLATER_SERVICE);

	               	if ( (position+1) % 3 == 0 )
	               	{
	               		view = inflater.inflate(R.layout.activity_lists_banner, null);
	                		
	               		TextView tvTitle = (TextView) view.findViewById(R.id.banner);
	               		tvTitle.setTextColor(Color.WHITE);
	               		tvTitle.setText(R.string.banner);
	               		tvTitle.setBackgroundColor(Color.GREEN);
	                		
	               	} else 
	               	{
	               		position = position - ( (position+1) / 3 );
	                		
	               		view = inflater.inflate(R.layout.activity_lists_elements, null);
	                		
	               		TextView tvTitle = (TextView) view.findViewById(R.id.title);
	               		tvTitle.setText(mArray.get(position).mTitle);
	               		TextView tvDescription = (TextView) view.findViewById(R.id.description);
	               		tvDescription.setText(mArray.get(position).mDescription);
                		ImageView img = (ImageView) view.findViewById(R.id.image);	                    
                		img.setImageDrawable(mContext.getResources().getDrawable(
                    					mArray.get(position).mImageResource));
                	}

                	return view;
                }
        }
}