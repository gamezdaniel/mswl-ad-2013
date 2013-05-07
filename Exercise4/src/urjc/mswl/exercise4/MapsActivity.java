package urjc.mswl.exercise4;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapsActivity extends MapActivity 
{	
	private MapView mapview = null;
	private MapController mapControl = null;
	private Location mLoc = null;
	private LocationManager mLocationManager;
	private MyLocationListener mLocationListener;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        
        mapview = (MapView) findViewById(R.id.mapView);
        mapview.setBuiltInZoomControls(true);
        mapview.setClickable(true);
        
        mapControl = mapview.getController();
        
        GeoPoint geoPoint = new GeoPoint(
        		(int) (0.0 * 1000000),
        		(int) (0.0 * 1000000) );
        
        mapControl.setZoom(18);
        mapControl.animateTo(geoPoint);
        
        setLocationListener();
        
    }
    
    private void refreshMap()
    {
        GeoPoint geoPoint = new GeoPoint(
        		(int) (mLoc.getLatitude() * 1000000),
        		(int) (mLoc.getLongitude() * 1000000) );
        
        mapControl.setZoom(18);
        mapControl.animateTo(geoPoint);
    }


    private void setLocationListener ()
    {
    	mLocationManager = (LocationManager)
    	getSystemService(Context.LOCATION_SERVICE);
    	
    	mLocationListener = new MyLocationListener();
    	
    	mLocationManager.requestLocationUpdates(
    			LocationManager.GPS_PROVIDER,
    			5000, 15, mLocationListener);
    }
    
    private class MyLocationListener implements LocationListener
    {
		@Override
		public void onLocationChanged(Location location) 
		{
			// TODO Auto-generated method stub
			mLoc = location;
			Log.d("Location:", String.valueOf(mLoc.getLatitude()) + " " +
					String.valueOf(mLoc.getLongitude()));
			
			refreshMap();			
		}

		@Override
		public void onProviderDisabled(String provider) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) 
		{
			// TODO Auto-generated method stub
			
		}	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	@Override
	protected boolean isRouteDisplayed() 
	{
		// TODO Auto-generated method stub
		return false;
	}
    
    @Override
    protected void onDestroy() 
    {
    	// TODO Auto-generated method stub
    	mLocationManager.removeUpdates(mLocationListener);
    	super.onDestroy();
    }
    
}
