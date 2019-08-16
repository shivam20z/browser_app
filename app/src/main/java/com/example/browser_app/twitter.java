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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import static java.lang.Thread.sleep;

public class twitter extends AppCompatActivity implements View.OnTouchListener  {
    WebView webViewtwi;
    FloatingActionButton btn3,btn2;
    ProgressBar pbar;
    android.support.design.widget.FloatingActionButton fab1;


    float dX;
    float dY;
    int lastAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_twitter );

        webViewtwi=findViewById( R.id.webviewtwi );

        btn3=findViewById( R.id.button3 );
        btn2=findViewById( R.id.button2 );
        pbar=findViewById( R.id.pb1 );

        fab1=findViewById( R.id. floating_btn);

        final View dragView = findViewById(R.id.floatingMenu);
        dragView.setOnTouchListener(this);

        fab1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText( twitter.this,"Up",Toast.LENGTH_SHORT ).show();

                webViewtwi.scrollTo(0,0);
                try {
                    sleep( 300 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        } );

        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebSettings webSettings=webViewtwi.getSettings();
                webViewtwi.loadUrl( "https://twitter.com/login" );
                webViewtwi.setWebViewClient( new WebViewClient() );
                webSettings.setJavaScriptEnabled( true );

            }
        } );

        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( twitter.this,MainActivity.class );
                startActivity( intent );
            }
        });


        webViewtwi.setWebChromeClient( new WebChromeClient() {
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


        WebSettings webSettings=webViewtwi.getSettings();
        webViewtwi.loadUrl( "https://twitter.com/login" );
        webViewtwi.setWebViewClient( new WebViewClient() );
        webSettings.setJavaScriptEnabled( true );


    }



    @Override
    public void onBackPressed() {

        if (webViewtwi.canGoBack()){
            webViewtwi.goBack();

        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getActionMasked()) {

            case MotionEvent.ACTION_DOWN:
                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                lastAction = MotionEvent.ACTION_DOWN;




                break;

            case MotionEvent.ACTION_MOVE:
                view.setY(event.getRawY() + dY);
                view.setX(event.getRawX() + dX);
                lastAction = MotionEvent.ACTION_MOVE;

                break;

            case MotionEvent.ACTION_UP:
                if (lastAction == MotionEvent.ACTION_DOWN)
//                    Toast.makeText(plus.this, "Clicked!", Toast.LENGTH_SHORT).show();
                    break;

            case MotionEvent.ACTION_BUTTON_PRESS:
                if(lastAction==MotionEvent.ACTION_DOWN )
                    Toast.makeText( this,"work",Toast.LENGTH_SHORT ).show();
                break;




            default:
                return false;
        }
        return true;
    }

}

