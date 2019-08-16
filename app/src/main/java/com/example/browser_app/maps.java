package com.example.browser_app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class maps extends AppCompatActivity {
    WebView webViewmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_maps );
        webViewmap=findViewById( R.id.webviewmap );


        String uri="http://maps.google.com/maps?saddr=" + "9982878" + "," + "76285774" + "&daddr=" + "9992084" + "," + "76286455";
        Intent intent=new Intent( android.content.Intent.ACTION_VIEW,Uri.parse( uri ) );
        intent.setClassName( "com.google.android.apps.maps","com.google.android.maps.MapsActivity" );
        startActivity( intent );

    }
}
