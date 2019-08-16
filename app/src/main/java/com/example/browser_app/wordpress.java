package com.example.browser_app;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import static java.lang.Thread.sleep;

public class wordpress extends AppCompatActivity implements View.OnTouchListener  {
    WebView webViewwordpress;
    FloatingActionButton btn3,btn2;
    ProgressBar pbar;
    android.support.design.widget.FloatingActionButton fab1;


    float dX;
    float dY;
    int lastAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_wordpress );
        webViewwordpress=findViewById( R.id.webviewwordpress );
        btn3=findViewById( R.id.button3 );
        btn2=findViewById( R.id.button2 );
        pbar=findViewById( R.id.pb1 );

        fab1=findViewById( R.id. floating_btn);

        final View dragView = findViewById(R.id.floatingMenu);
        dragView.setOnTouchListener(this);

        fab1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText( wordpress.this,"Up",Toast.LENGTH_SHORT ).show();

                webViewwordpress.scrollTo(0,0);
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
                WebSettings webSettings=webViewwordpress.getSettings();
                webViewwordpress.loadUrl( "https://wordpress.org/download/" );
                webViewwordpress.setWebViewClient( new WebViewClient() );
                webSettings.setJavaScriptEnabled( true );

            }
        } );

        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( wordpress.this,MainActivity.class );
                startActivity( intent );
            }
        } );

        webViewwordpress.setWebChromeClient( new WebChromeClient() {
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


        WebSettings webSettings=webViewwordpress.getSettings();
        webViewwordpress.loadUrl( "https://www.google.com" );
        webViewwordpress.setWebViewClient( new WebViewClient() );
        webSettings.setJavaScriptEnabled( true );



//        webViewwordpress.setDownloadListener(new DownloadListener() {
//            public void onDownloadStart(String url, String userAgent,
//                                        String contentDisposition, String mimetype,
//                                        long contentLength) {
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData( Uri.parse(url));
//                startActivity(i);
//            }
//        });

        webViewwordpress.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String url, String userAgent,String contentDisposition, String mimetype,long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                request.setDestinationInExternalPublicDir( Environment.DIRECTORY_DOWNLOADS, " ");
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(), "Downloading File", //To notify the Client that the file is being downloaded
                        Toast.LENGTH_LONG).show();

            }
        });
    }



    @Override
    public void onBackPressed() {

        if (webViewwordpress.canGoBack()){
            webViewwordpress.goBack();

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
