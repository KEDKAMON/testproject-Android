package com.kedkamon.awarenessapi;

import android.app.Activity;
import android.app.PendingIntent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.awareness.Awareness;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public  Activity mActivity;
    private HashMap<Integer,String> mNameMusic = new HashMap<>();
    private static final int ACCESS_LOCATION = 12345;
    private MediaPlayer mediaPlayer;
    private PendingIntent mFencePendingIntent;
    private static final String TAG = "Awareness";
    private static final String FENCE_RECEIVER_ACTION = "FENCE_RECEIVE";
    private String[] mConditions;
    private TextView mTextActivity,mTextView,mLatLong,mtextname;

    // For Coding
    private GoogleApiClient mGoogleApiClient;
    //private HeadphoneFenceBroadcastReceiver fenceReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.main_textview_data);
        mLatLong = (TextView)findViewById(R.id. main_textview_latlong);
        mtextname = (TextView) this.findViewById ( R.id.textview_name );
        mActivity = MainActivity.this;
        mTextActivity = (TextView)findViewById(R.id.textview_activity);
        mConditions = getResources().getStringArray(R.array.weather_conditions);
//        for (int i = 0; i < mConditions.length; i++) {
//            mWeatherConditions.put(i, mConditions[i]);
//        }

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Awareness.API)
                .build();
        mGoogleApiClient.connect();
        mGoogleApiClient.registerConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {

            @Override
            public void onConnected(@Nullable Bundle bundle) {

                initSnapshots();

            }

            @Override
            public void onConnectionSuspended(int i) {

            }
        });






    }
}