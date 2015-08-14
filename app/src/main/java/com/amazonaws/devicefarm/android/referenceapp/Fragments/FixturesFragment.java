/*
 * Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.devicefarm.android.referenceapp.Fragments;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amazonaws.devicefarm.android.referenceapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment to detect the radio statuses within the Android app
 * Used to test out the custom fixtures feature in Device Farm
 */
public class FixturesFragment extends Fragment implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "fixtures-fragment";

    @InjectView(R.id.longitude)
    TextView longitude;
    @InjectView(R.id.lat)
    TextView lat;
    @InjectView(R.id.wifi)
    TextView wifi;
    @InjectView(R.id.bluetooth)
    TextView bluetooth;
    @InjectView(R.id.gps)
    TextView gps;
    @InjectView(R.id.nfc)
    TextView nfc;

    private GoogleApiClient googleApiClient;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fixtures_layout, container, false);
        ButterKnife.inject(this, view);
        buildGoogleApiClient();

        //Registering events to detect radio changes
        final BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                final String action = intent.getAction();
                if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                    updateBluetoothStatusDisplay();
                } else if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                    updateWifiStatusDisplay();
                } else if (action.equals(LocationManager.PROVIDERS_CHANGED_ACTION)) {
                    updateGPSStatusDisplay();
                } else if (action.equals(NfcAdapter.ACTION_ADAPTER_STATE_CHANGED)) {
                    updateNFCStatusDisplay();
                }
            }
        };
        IntentFilter filter = new IntentFilter();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            filter.addAction(NfcAdapter.ACTION_ADAPTER_STATE_CHANGED);
        }

        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        filter.addAction(LocationManager.PROVIDERS_CHANGED_ACTION);

        updateWifiStatusDisplay();
        updateBluetoothStatusDisplay();
        updateGPSStatusDisplay();
        updateNFCStatusDisplay();
        getActivity().registerReceiver(receiver, filter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();

        if (googleApiClient.isConnected())
            googleApiClient.disconnect();
    }

    private synchronized void buildGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    /**
     * Updates the Wifi status
     */
    private void updateWifiStatusDisplay() {
        final WifiManager wifiManager = (WifiManager)getActivity().getSystemService(Context.WIFI_SERVICE);
        wifi.setText(Boolean.toString(wifiManager.isWifiEnabled()));
    }

    /**
     * Updates the Bluetooth status
     */
    private void updateBluetoothStatusDisplay() {
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetooth.setText(Boolean.toString(bluetoothAdapter != null && bluetoothAdapter.isEnabled()));
    }

    /**
     * Updates the GPS status
     */
    private void updateGPSStatusDisplay() {
        final LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        gps.setText(Boolean.toString(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)));
    }

    /**
     * Updates the NFC Status
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD_MR1)
    private void updateNFCStatusDisplay() {
        final NfcManager nfcManager = (NfcManager) getActivity().getSystemService(Context.NFC_SERVICE);
        final NfcAdapter adapter = nfcManager.getDefaultAdapter();
        nfc.setText(Boolean.toString(adapter != null && adapter.isEnabled()));
    }

    /**
     * Sets the location when location api is connected
     * @param bundle
     */
    @Override
    public void onConnected(Bundle bundle) {
        final Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (location != null) {
            lat.setText("" + location.getLatitude());
            longitude.setText("" + location.getLongitude());
        } else {
            lat.setText("Not Available");
            longitude.setText("Not Available");
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        googleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(TAG, "Connection failed");
    }
}
