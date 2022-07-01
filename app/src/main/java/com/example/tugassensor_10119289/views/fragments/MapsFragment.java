package com.example.tugassensor_10119289.views.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.example.tugassensor_10119289.R;

public class MapsFragment extends Fragment {
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;
    private final LatLng WARKOP_ADD = new LatLng(-6.888724165048298, 107.61841874125373);
    private final LatLng WARKOP_SUKARASA = new LatLng(-6.887573818678371, 107.61597256616743);
    private final LatLng BEBEK_ALI_DORME = new LatLng(-6.89134441311757, 107.61692743101463);
    private final LatLng MC_DONADLS = new LatLng(-6.884868721347366, 107.61347869220624);
    private final LatLng MIE_MERAPI = new LatLng(-6.89131298026832, 107.61742131989575);

    private Location location;
    private Marker markerBMT;
    private Marker markerMBS;
    private Marker markerBP;
    private Marker markerBTRI;
    private Marker markerCFT;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
                LatLng lokasi = new LatLng(location.getLatitude(),location.getLongitude());
                MarkerOptions options = new MarkerOptions().position(lokasi).title("Lokasi Saat Ini");
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi,17));
                googleMap.addMarker(options);
            markerBMT = showMarkerResto(WARKOP_ADD,googleMap,"WARKOP ADD");
            markerBP = showMarkerResto(BEBEK_ALI_DORME,googleMap,"BUBUR PASIGARAN");
            markerMBS = showMarkerResto(WARKOP_SUKARASA,googleMap,"WARKOP SUKARASA");
            markerBTRI = showMarkerResto(MC_DONADLS,googleMap,"MC DONALD'S");
            markerCFT = showMarkerResto(MIE_MERAPI,googleMap,"MIE MERAPI");

            markerBMT.setTag(0);
            markerBP.setTag(0);
            markerMBS.setTag(0);
            markerBTRI.setTag(0);
            markerCFT.setTag(0);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            getCurrentLocation();
//            mapFragment.getMapAsync(callback);
        }

    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location2) {
                if(location2 != null){
                    location = location2;
                    mapFragment.getMapAsync(callback);
                }
            }
        });
    }

    private Marker showMarkerResto(LatLng position2,GoogleMap map,String title2){
        return map.addMarker(new MarkerOptions()
                .position(position2)
                .title(title2));
    }

}