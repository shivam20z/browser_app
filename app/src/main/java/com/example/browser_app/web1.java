package com.example.browser_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class web1 extends Fragment {



    public web1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate( R.layout.fragment_network, container,false);
        ImageView imageView=view.findViewById( R.id.facebook );

        imageView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),fb.class );
                startActivity(intent);
            }
        } );


        ImageView imageView2=view.findViewById( R.id.instagram );
        imageView2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),instagram.class );
                startActivity(intent);
            }
        } );



        ImageView imageView3=view.findViewById( R.id.twitter );
        imageView3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),twitter.class );
                startActivity(intent);
            }
        } );


        ImageView imageView4=view.findViewById( R.id.wordpress );
        imageView4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),wordpress.class );
                startActivity(intent);
            }
        } );


        ImageView imageView5=view.findViewById( R.id.linkdin );
        imageView5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),linkdin.class );
                startActivity(intent);
            }
        } );


        ImageView imageView6=view.findViewById( R.id.overflow );
        imageView6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),stackoverflow.class );
                startActivity(intent);
            }
        } );

        ImageView imageView7=view.findViewById( R.id.plus );
        imageView7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),plus.class );
                startActivity(intent);
            }
        } );


        ImageView imageView8=view.findViewById( R.id.tumblr );
        imageView8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),tumblr.class );
                startActivity(intent);
            }
        } );


        ImageView imageView9=view.findViewById( R.id.youtube );
        imageView9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),youtube.class );
                startActivity(intent);
            }
        } );


        ImageView imageView10=view.findViewById( R.id.reddit );
        imageView10.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),reddit.class );
                startActivity(intent);
            }
        } );



        ImageView imageView11=view.findViewById( R.id.pinterest );
        imageView11.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),pinterest.class );
                startActivity(intent);
            }
        } );


        ImageView imageView12=view.findViewById( R.id.maps );
        imageView12.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getActivity(),maps.class );
                startActivity(intent);
            }
        } );



        return view;
    }




    }


