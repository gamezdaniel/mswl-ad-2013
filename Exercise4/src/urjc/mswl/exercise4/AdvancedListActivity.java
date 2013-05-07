package urjc.mswl.exercise4;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
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

public class AdvancedListActivity  extends ListActivity
{
    private MyAdapter mAdapter = null;

    // Node List Array
    private static ArrayList<Node> mArray = new ArrayList<Node>();
   

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);                      
        setContentView(R.layout.activity_main);
        fillNode();
       
        mAdapter = new MyAdapter(this);
        setListAdapter(mAdapter);                      
    }

    private void fillNode()
    {
        mArray.clear();
        
        // Item 1
        Node mynode = new Node();  
        mynode.mTitle = this.getResources().getString(R.string.item_1);
        mynode.mDescription = "Description1";
        mynode.mImage = R.drawable.image1;
        mynode.mLongitude = 24.950000;
        mynode.mLatitude = 60.169400;
        mArray.add(mynode);

        //Item 2
        Node mynode2 = new Node();
        mynode2.mTitle = this.getResources().getString(R.string.item_2);
        mynode2.mDescription = "Description2";
        mynode2.mImage = R.drawable.image2;
        mynode2.mLongitude = -122.255231;
        mynode2.mLatitude = 37.873708;
        mArray.add(mynode2);

        //Item 3
        Node mynode3 = new Node(); 
        mynode3.mTitle = this.getResources().getString(R.string.item_3);
        mynode3.mDescription = "Description3";
        mynode3.mImage = R.drawable.image3;
        mynode3.mLongitude = -88.021633;
        mynode3.mLatitude = 41.972076;
        mArray.add(mynode3);
    }


    protected void onListItemClick(ListView l, View v, int position, long id)
    {  
    	Toast.makeText(this, mArray.get(position).mTitle, Toast.LENGTH_SHORT).show();
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
            	Log.d("TAG", "position " + String.valueOf(position));

            	View view=null;

            	LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            	               	
            	view = inflater.inflate(R.layout.activity_list, null);
            	
            	// position = position - ((position + 1) / 3);
            	
            	TextView tvTitle = (TextView) view.findViewById(R.id.title);
            	tvTitle.setText(mArray.get(position).mTitle);
            	TextView tvDescription = (TextView) view.findViewById(R.id.description);
            	tvDescription.setText(mArray.get(position).mDescription);            	
            	ImageView img = (ImageView) view.findViewById(R.id.image);
            	img.setImageDrawable( mContext.getResources().getDrawable(
            					mArray.get(position).mImage));

            	return view;
            }
    }
}
