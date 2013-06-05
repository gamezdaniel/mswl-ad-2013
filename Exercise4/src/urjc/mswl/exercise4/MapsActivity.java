package urjc.mswl.exercise4;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;


public class MapsActivity extends MapActivity 
{

	private MapView mapview = null;
	private MapController mapControl = null;
	private TextView tvlocation;

	private Node mNode = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		
		mapview = (MapView) findViewById(R.id.mapView);
		tvlocation = (TextView) findViewById(R.id.tvLocation);
		
		mapview.setBuiltInZoomControls(true);
		mapControl = mapview.getController();

		mNode = new Node();
		
		Intent intent = getIntent();
		
		if (intent != null) 
        {
			mNode.mTitle = intent.getStringExtra("TITLE");
			mNode.mImageResource = intent.getIntExtra("IMAGE", R.drawable.icon);
			mNode.mDescription = intent.getStringExtra("DESCRIPTION");
            
			mNode.setmGeoPoint(new GeoPoint(intent.getIntExtra("LATITUDE", 0) , 
											intent.getIntExtra("LONGITUDE", 0)));
        }
		
		drawResource();		
	}
	
	
	private void drawResource() 
	{
		if (mNode == null) 
		{
			Toast.makeText(getBaseContext(), "Location not available.",
					Toast.LENGTH_LONG).show();

			return;
		}

		GeoPoint geoPoint = new GeoPoint((int) (mNode.getLatitude()),
										 (int) (mNode.getLongitude()));

		mapControl.setZoom(16);
		mapControl.animateTo(geoPoint);

		MapOverlay myMapOver = new MapOverlay();
		
		myMapOver.setMarkerText(mNode.mTitle);
		myMapOver.setDrawable(getResources().getDrawable(mNode.mImageResource));
		myMapOver.setGeoPoint(geoPoint);

		final List<Overlay> overlays = mapview.getOverlays();
		overlays.clear();

		overlays.add(myMapOver);

		mapview.setBuiltInZoomControls(true);
		mapview.setClickable(true);

		tvlocation.setText("University Location: \n"
				+ String.valueOf(mNode.getLatitude()/1000000.0) + " , "
				+ String.valueOf(mNode.getLongitude()/1000000.0));

	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.maps, menu);
		return true;
	}

	@Override
	protected boolean isRouteDisplayed() 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
