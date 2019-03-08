package ca.mcgill.ecse321.treeple;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 *
 * created by leaakkari
 */

public class MapsActivity extends AppCompatActivity implements GoogleMap.OnMarkerClickListener,OnMapReadyCallback {

    private GoogleMap mMap;

    private String error = null;

    private List<String> munName = new ArrayList<>();
    private ArrayAdapter<String> munAdapter;

    TextView msg;

    Button back;


    /**
     *
     * @param savedInstanceState
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Spinner munSpinner = (Spinner) findViewById(R.id.spinnerl);

        msg = (TextView)findViewById(R.id.error_m);

        munAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, munName);
        munAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        munSpinner.setAdapter(munAdapter);
        munSpinner.setVisibility(View.GONE);


        refresh(munAdapter ,munName, "trees");

        back = (Button)findViewById(R.id.back_maps);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                if(userType.equals("User")){

                    Intent i = new Intent(MapsActivity.this, Options.class);
                    i.putExtra("userName",userName);
                    i.putExtra("userType", userType);
                    startActivity(i);

                }else if(userType.equals("Scientist")){

                    Intent i = new Intent(MapsActivity.this, ScientistOptions.class);
                    i.putExtra("userName",userName);
                    i.putExtra("userType", userType);
                    startActivity(i);

                }



            }

        });

    }

    /**
     *
     * @param adapter
     * @param names
     * @param restFunctionName get trees
     */
    private void refresh(final ArrayAdapter<String> adapter, final List<String> names,String restFunctionName) {
        HttpUtils.get(restFunctionName, new RequestParams(), new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                names.clear();
                names.add("Please select...");
                for( int i = 0; i < response.length(); i++){
                    //JSONObject mun = new JSONObject();
                    try {

                        //names.add(response.getJSONObject(i).getString("name"));
                        names.add(response.getJSONObject(i).getString("longitude"));

                        Double longitude = Double.parseDouble(names.get(i));

                      if(response.getJSONObject(i).getJSONObject("currentStatus").getString("treeState").matches("Planted")) {
                          Double lgt_planted = Double.parseDouble(response.getJSONObject(i).getString("longitude"));
                          Double lat_planted = Double.parseDouble(response.getJSONObject(i).getString("latitude"));
                          LatLng planted_p = new LatLng(lat_planted, lgt_planted);
                          String species = response.getJSONObject(i).getString("treeSpecies");





                          Marker m = mMap.addMarker(new MarkerOptions().position(planted_p).title("Planted").snippet(species).icon(BitmapDescriptorFactory.fromResource(R.drawable.treemarker)));

                      }else if (response.getJSONObject(i).getJSONObject("currentStatus").getString("treeState").matches("ToBeCut")){
                              Double lgt_planted = Double.parseDouble(response.getJSONObject(i).getString("longitude"));
                              Double lat_planted = Double.parseDouble(response.getJSONObject(i).getString("latitude"));
                              LatLng planted_p = new LatLng(lat_planted, lgt_planted);
                              String species = response.getJSONObject(i).getString("treeSpecies");

                              Marker m = mMap.addMarker(new MarkerOptions().position(planted_p).title("Marked to Be Cut").snippet(species).icon(BitmapDescriptorFactory.fromResource(R.drawable.trunk1)));


                      }else if (response.getJSONObject(i).getJSONObject("currentStatus").getString("treeState").matches("Diseased")) {
                          Double lgt_planted = Double.parseDouble(response.getJSONObject(i).getString("longitude"));
                          Double lat_planted = Double.parseDouble(response.getJSONObject(i).getString("latitude"));
                          LatLng planted_p = new LatLng(lat_planted, lgt_planted);
                          String species = response.getJSONObject(i).getString("treeSpecies");



                          Marker m = mMap.addMarker(new MarkerOptions().position(planted_p).title("Diseased").snippet(species).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_diseased)));
                      }

                        //Double.parseDouble(aString)

                    } catch (Exception e) {
                        error += e.getMessage();

                    }
                    refreshErrorMessage();
                }

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
                refreshErrorMessage();
            }
        });

    }


    /**
     *
     * @param googleMap object, and setting marker click listener
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMarkerClickListener(this);

    }


    /**
     *
     * @param marker
     * @return boolean if marker is clicked
     */
    @Override
    public boolean onMarkerClick(final Marker marker) {

        if (marker.equals(marker)) {
            //handle click here
            Toast.makeText(this, "Position:  "  +  marker.getPosition()+ "\n"  + "Status:  " + marker.getTitle()+ "\n"  + "Species:  " + marker.getSnippet(),
                    Toast.LENGTH_SHORT).show();
            return true;

        }
        else{
            return false;
    }


    }

    /**
     * refreshes error message displayed on user screen
     */
    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = (TextView) findViewById(R.id.error_m);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } /*else {
            tvError.setVisibility(View.VISIBLE);
        }*/

    }







}






