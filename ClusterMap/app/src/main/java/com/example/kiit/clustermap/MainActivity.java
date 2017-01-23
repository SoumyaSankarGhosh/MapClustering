package com.example.kiit.clustermap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClusterManager.OnClusterClickListener<Person>, ClusterManager.OnClusterInfoWindowClickListener<Person>, ClusterManager.OnClusterItemClickListener<Person>, ClusterManager.OnClusterItemInfoWindowClickListener<Person>{

    MapView mapView;
    GoogleMap map;
    ClusterManager<Person> mClusterManager;
    // MarkerOptions markerOptions;
    Person offsetItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
    }

    @Override
    public void onResume() {
        super.onResume();
        createMap();

    }
    private void initialize() {
//
        mapView = (MapView)findViewById(R.id.view);
    }
    private void createMap() {
        MapsInitializer.initialize(MainActivity.this);
        map = mapView.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        map.setMyLocationEnabled(true);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(22.5726, 88.3639), 10));
        mClusterManager = new ClusterManager<>(this, map);
        mClusterManager.setRenderer(new PersonRenderer());
        map.setOnCameraChangeListener(mClusterManager);
        map.setOnMarkerClickListener(mClusterManager);
        mClusterManager.setOnClusterClickListener(this);
        mClusterManager.setOnClusterInfoWindowClickListener(this);
        mClusterManager.setOnClusterItemClickListener(this);
        mClusterManager.setOnClusterItemInfoWindowClickListener(this);

        addItems();
        mClusterManager.cluster();
    }
    private void addItems() {
        // Set some lat/lng coordinates to start with.
        double lat = 22.5726;
        double lng = 88.3639;

        // Add ten cluster items in close proximity, for purposes of this example.
      /*  for (int i = 0; i < 10; i++) {
            double offset = i / 60d;
            lat = lat + offset;
            lng = lng + offset;
            LatLng latLng = new LatLng(lat,lng);
            //  myClusterRenderer = new MyClusterRenderer(this,map,mClusterManager);


            offsetItem = new Person(latLng,"points",R.mipmap.ic_launcher);
            mClusterManager.addItem(offsetItem);


        }*/

        LatLng latLng=new LatLng(22.6026, 88.3659);
        offsetItem = new Person(latLng,"Bagbazar",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

        LatLng latLng1=new LatLng(22.5803, 88.3640);
        offsetItem = new Person(latLng1,"CollegeStreet",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

        LatLng latLng2=new LatLng(22.5958, 88.2636);
        offsetItem = new Person(latLng2,"Howrah",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

        LatLng latLng3=new LatLng(22.5646, 88.3433);
        offsetItem = new Person(latLng3,"Eden Garden",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

        LatLng latLng4=new LatLng(22.5867, 88.4171);
        offsetItem = new Person(latLng4,"SaltLake",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

        LatLng latLng5=new LatLng(22.5547, 88.3503);
        offsetItem = new Person(latLng5,"ParkStreet",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

        LatLng latLng6=new LatLng(22.6383, 88.3654);
        offsetItem = new Person(latLng6,"Baranagar",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

        LatLng latLng7=new LatLng(22.5279, 88.3625);
        offsetItem = new Person(latLng7,"Ballygunge",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

        LatLng latLng8=new LatLng(22.6982, 88.3895);
        offsetItem = new Person(latLng8,"Sodepur",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

        LatLng latLng9=new LatLng(22.5421, 88.3190);
        offsetItem = new Person(latLng9,"Kidderpore",R.drawable.ic_person);
        mClusterManager.addItem(offsetItem);

    }





    @Override
    public boolean onClusterClick(Cluster<Person> cluster) {
        return false;
    }

    @Override
    public void onClusterInfoWindowClick(Cluster<Person> cluster) {

    }

    @Override
    public boolean onClusterItemClick(Person person) {
        return false;
    }

    @Override
    public void onClusterItemInfoWindowClick(Person person) {

    }




    private class PersonRenderer extends DefaultClusterRenderer<Person> {
        private final IconGenerator mIconGenerator = new IconGenerator(getApplicationContext());
        private final IconGenerator mClusterIconGenerator = new IconGenerator(getApplicationContext());
        private final ImageView mImageView;




        public PersonRenderer() {
            super(getApplicationContext(), map, mClusterManager);

            mImageView = new ImageView(getApplicationContext());

              mIconGenerator.setContentView(mImageView);
        }

        @Override
        protected void onBeforeClusterItemRendered(Person person, MarkerOptions markerOptions) {
            // Draw a single person.
            // Set the info window to show their name.

           /* If u use inbuild marker

           BitmapDescriptor markerDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE);

            markerOptions.icon(markerDescriptor).title(person.name);

            */





            final Drawable clusterIcon = getResources().getDrawable(R.drawable.ic_person);
            clusterIcon.setColorFilter(getResources().getColor(android.R.color.holo_red_dark), PorterDuff.Mode.SRC_ATOP);

            mIconGenerator.setBackground(clusterIcon);
            Bitmap icon = mIconGenerator.makeIcon();


            mIconGenerator.setContentPadding(80,70,0,0);

            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon)).title(person.name);
        }



        @Override
        protected void onBeforeClusterRendered(Cluster<Person> cluster, MarkerOptions markerOptions) {
            // Draw multiple people.
            // Note: this method runs on the UI thread. Don't spend too much time in here (like in this example).



            final Drawable clusterIcon = getResources().getDrawable(R.drawable.ic_person);
            clusterIcon.setColorFilter(getResources().getColor(android.R.color.holo_green_dark), PorterDuff.Mode.SRC_ATOP);

            mClusterIconGenerator.setBackground(clusterIcon);

            //modify padding for one or two digit numbers
            if (cluster.getSize() < 10) {
                mClusterIconGenerator.setContentPadding(130, 100, 0, 0);
            }
            else {
                mClusterIconGenerator.setContentPadding(50, 30, 0, 0);
            }

            LayoutInflater myInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View activityView = myInflater.inflate(R.layout.cluster_view, null, false);

            mClusterIconGenerator.setContentView(activityView);

            Bitmap icon = mClusterIconGenerator.makeIcon(String.valueOf(cluster.getSize()));

            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
        }

        @Override
        protected boolean shouldRenderAsCluster(Cluster cluster) {
            // Always render clusters.
            return cluster.getSize() > 1;
        }
    }


}
