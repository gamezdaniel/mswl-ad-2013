package urjc.mswl.exercise4;

import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import urjc.mswl.exercise4.Node;
import urjc.mswl.exercise4.MapOverlay;


public class MainActivity extends MapActivity 
{
    private MapView mapView;
    private MapController mapController;

    private GeoPoint mGeoPoint;
    private Node mNodeMap;

    private TextView tvLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapView = (MapView) findViewById(R.id.mapView);

        tvLocation = (TextView) findViewById(R.id.tvLocation);

        mapView.setBuiltInZoomControls(true);
        mapView.setClickable(true);

        mapController = mapView.getController();

        fillNode();
        refreshMap();
    }

    private void fillNode() 
    {
        Intent intentFromActivity = getIntent();

        if (intentFromActivity != null) 
        {
            mNodeMap = new Node();
            mNodeMap.mTitle = intentFromActivity.getStringExtra("TITLE");
            mNodeMap.mImage = intentFromActivity.getIntExtra("IMAGE", 0);
            mNodeMap.mDescription = intentFromActivity.getStringExtra("DESCRIPTION");
            mNodeMap.mLatitude = intentFromActivity.getDoubleExtra("LATITUDE", 0);
            mNodeMap.mLongitude = intentFromActivity.getDoubleExtra("LOGITUDE", 0);
        }

    }

    private void refreshMap() 
    {
        if (mNodeMap == null) 
        {
            Toast.makeText(getBaseContext(), "Location not available.",
                    							Toast.LENGTH_LONG).show();
            return;
        }

        mGeoPoint = new GeoPoint((int) (mNodeMap.mLatitude * 1E6),
                				 (int) (mNodeMap.mLongitude * 1E6));

        mapController.setZoom(18);
        mapController.animateTo(mGeoPoint);

        MapOverlay myMapOver = new MapOverlay();

        Drawable drawable = getResources().getDrawable(mNodeMap.mImage);
        drawable.setBounds(0, 0, 50, 50);

        myMapOver.setDrawable(drawable);
        myMapOver.setGeoPoint(mGeoPoint);
        myMapOver.setMarkerText(mNodeMap.mTitle);

        final List<Overlay> overlays = mapView.getOverlays();
        overlays.clear();

        overlays.add(myMapOver);

        mapView.setBuiltInZoomControls(true);

        mapView.setClickable(true);

        tvLocation.setText("Your Current Location: \n"
                + String.valueOf(mGeoPoint.getLatitudeE6()) + " , "
                + String.valueOf(mGeoPoint.getLongitudeE6()));
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

}