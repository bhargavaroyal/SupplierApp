package com.mojro.supplier.supplierapp.UI.Activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mojro.supplier.supplierapp.R;

import java.io.IOException;
import java.util.List;

/**
 * Created by Lenovo on 8/2/2016.
 */
public class LocationActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, AdapterView.OnItemClickListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
//    private final Context mContext;

    // flag for GPS status
    boolean isGPSEnabled = false;

    // flag for network status
    boolean isNetworkEnabled = false;

    // flag for GPS status
    boolean canGetLocation = false;

    Location location; // location
    double latitude; // latitude
    double longitude; // longitude

    Marker marker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFrag = (SupportMapFragment)
                getSupportFragmentManager().
                        findFragmentById(R.id.map);
        mMap = mapFrag.getMap();

        if (mMap != null) {

            mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(LatLng latLng) {
                    Geocoder geocoder = new Geocoder(LocationActivity.this);
                    List<Address> list;
                    try {
                        list = geocoder.getFromLocation(latLng.latitude,
                                latLng.longitude, 1);
                    } catch (IOException e) {
                        return;
                    }
                    Address address = list.get(0);
                    if (marker != null) {
                        marker.remove();
                    }

                    MarkerOptions options = new MarkerOptions()
                            .title(address.getLocality())
                            .position(new LatLng(latLng.latitude,
                                    latLng.longitude));

                    marker = mMap.addMarker(options);
                }
            });
        }

    }

    public void findLocation(View v) throws IOException {

        EditText et = (EditText)findViewById(R.id.editText);
        String location = et.getText().toString();
        Geocoder geocoder = new Geocoder(this);
        List<Address> list = geocoder.getFromLocationName(location, 1);
        Address add = list.get(0);
        String locality = add.getLocality();
        LatLng ll = new LatLng(add.getLatitude(), add.getLongitude());
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, 15);
        mMap.moveCamera(update);
        if(marker != null)
            marker.remove();
        MarkerOptions markerOptions = new MarkerOptions()
                .title(locality)
                .position(new LatLng(add.getLatitude(), add.getLongitude()));
        marker = mMap.addMarker(markerOptions);

    }

    private void replaceMapFragment() {
//        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
//                .getMap();

        MapFragment mMap = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mMap.getMapAsync(this);

//
//        // Enable Zoom
//        mMap.getUiSettings().setZoomGesturesEnabled(true);
//
//        //set Map TYPE
//        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


//        mMap.setMyLocationEnabled(true);

        //enable Current location Button

        //set "listener" for changing my location
        //map.setOnMyLocationChangeListener(myLocationChangeListener());

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

    }

//    private void setUpMap() {
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        mMap.setMyLocationEnabled(true);
//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//        mMap.setTrafficEnabled(true);
//        mMap.setIndoorEnabled(true);
//        mMap.setBuildingsEnabled(true);
//        mMap.getUiSettings().setZoomControlsEnabled(true);
//
//    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
