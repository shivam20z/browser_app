package com.example.browser_app;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import static com.example.browser_app.R.layout.fragment_google;


/**
 * A simple {@link Fragment} subclass.
 */
public class web extends Fragment {


     WebView webView;

    public web() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate( fragment_google,container,false );
        final EditText editText=view.findViewById( R.id.et2 );
        final WebView webView=view.findViewById( R.id.webview2 );
        Button button=view.findViewById( R.id.btn2 );

        final ProgressBar pbar=view.findViewById( R.id.pb1 );

        webView.setWebChromeClient( new WebChromeClient() {
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


        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String call=editText.getText().toString();
                WebSettings webSettings=webView.getSettings();
                //webView.loadUrl( "https://" + call );
                webView.loadUrl( "https://www.google.com/search?q=" + call );
                webView.setWebViewClient( new WebViewClient() );
                webSettings.setJavaScriptEnabled( true );


            }
        } );


        webView.canGoBack();
        webView.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            }
        });

        return view;
    }







}
