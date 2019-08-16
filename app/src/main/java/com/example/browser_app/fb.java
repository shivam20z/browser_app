package com.example.browser_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import static java.lang.Thread.sleep;

public class fb extends AppCompatActivity implements View.OnTouchListener  {
    WebView webViewfb;
    FloatingActionButton btn3,btn2;
    ProgressBar pbar;
    android.support.design.widget.FloatingActionButton fab1;

    float dX;
    float dY;
    int lastAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fb );
        webViewfb=findViewById( R.id.webviewfb );
        btn3=findViewById( R.id.button3 );
        btn2=findViewById( R.id.button2 );
        pbar=findViewById( R.id.pb1 );
        //fab1=findViewById( R.id. floating_btn);

        final View dragView = findViewById(R.id.floating_btn);
        dragView.setOnTouchListener(this);
        dragView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( fb.this,"dcdcdc",Toast.LENGTH_SHORT ).show();
            }
        } );

//        fab1.setOnClickListener( new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText( fb.this,"Up",Toast.LENGTH_SHORT ).show();
//
//                webViewfb.scrollTo(0,0);
//                try {
//                    sleep( 300 );
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        } );

        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebSettings webSettings=webViewfb.getSettings();
                webViewfb.loadUrl( "https://www.facebook.com/" );
                webViewfb.setWebViewClient( new WebViewClient() );
                webSettings.setJavaScriptEnabled( true );

            }
        } );


        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( fb.this,MainActivity.class );
                startActivity( intent );
            }
        });

        webViewfb.setWebChromeClient( new WebChromeClient() {
            public void onProgressChanged(WebView view,int progress) {
                if (progress < 100 && pbar.getVisibility() == ProgressBar.GONE) {
                    pbar.setVisibility( ProgressBar.VISIBLE );
                }

                pbar.setProgress( progress );
                if (progress == 100) {
                    pbar.setVisibility( ProgressBar.GONE );
                }
            }
        } );


        WebSettings webSettings=webViewfb.getSettings();
        webViewfb.loadUrl( "https://www.facebook.com/" );
        webViewfb.setWebViewClient( new WebViewClient() );
        webSettings.setJavaScriptEnabled( true );


    }
    Boolean isMoving = false;
    public void onClick(View arg0) {

        switch (arg0.getId()) {

            case R.id.floating_btn:
                if(!isMoving) {
                    //code for on click here
                    Toast.makeText( this,"5555",Toast.LENGTH_SHORT ).show();
                }
            default:
                break;
        }
    }



    @Override
    public void onBackPressed() {

        if (webViewfb.canGoBack()){
            webViewfb.goBack();

        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getActionMasked()) {

            case MotionEvent.ACTION_DOWN:
                isMoving = true;

                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                lastAction = MotionEvent.ACTION_DOWN;




                break;

            case MotionEvent.ACTION_MOVE:
                isMoving = true;

                view.setY(event.getRawY() + dY);
                view.setX(event.getRawX() + dX);
                lastAction = MotionEvent.ACTION_MOVE;

                break;

            case MotionEvent.ACTION_UP:
                isMoving = true;

                if (lastAction == MotionEvent.ACTION_DOWN)
//                    Toast.makeText(plus.this, "Clicked!", Toast.LENGTH_SHORT).show();
                    break;

            case MotionEvent.ACTION_BUTTON_PRESS:
                isMoving = true;

                if(lastAction==MotionEvent.ACTION_DOWN )
                    Toast.makeText( this,"work",Toast.LENGTH_SHORT ).show();
                break;


            default:
                return false;
        }
        return true;
    }
}
