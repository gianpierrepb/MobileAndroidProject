package com.example.juma.moments.fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.juma.moments.R;
import com.example.juma.moments.activities.AddMomentActivity;
import com.example.juma.moments.activities.DetailMomentActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mgoogleMap;
    MapView mapView;
    View view;
    Location location;

    private final static int MY_PERMISSION_FINE_LOCATION = 101;

    public MapsFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) view.findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());

        Context context = getContext();

        mgoogleMap = googleMap;
        final Marker myMarket;
        final Marker publicMarker;


        LocationManager lm = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();



        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

       myMarket= googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .title("Publica un Moment"));
        myMarket.setTag(myMarket.getPosition());


        myMarket.showInfoWindow();

        publicMarker= googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude+2, longitude+2))
                .title(" ")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTitle().equals("Publica un Moment")) {
                    Toast.makeText(getActivity(), myMarket.getTitle(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getActivity(), AddMomentActivity.class));
                    getActivity().overridePendingTransition(R.anim.left_in, R.anim.stay);
                    return true;
                }
                if (!(marker.getTitle().equals("Publica un Moment"))){
                    startActivity(new Intent(getActivity(), AddMomentActivity.class));
                   // Toast.makeText(getActivity(), "Marcador Publicoo", Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(getActivity(), DetailMomentActivity.class));
                    //getActivity().overridePendingTransition(R.anim.left_in, R.anim.stay);
                    return true;
                }
                return true;
            }
        });






        CameraPosition liberty = CameraPosition
                .builder()
                .target(new LatLng(latitude, longitude))
                .zoom(16)
                .bearing(0)
                .tilt(45)
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty));

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            googleMap.setMyLocationEnabled(true);
        } else {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
        }




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        mgoogleMap.setMyLocationEnabled(true);
                    }

                } else {
                    Toast.makeText(getContext(), "this app reqires location permissions to be  granted", Toast.LENGTH_LONG).show();

                }

                break;
        }

    }




}

