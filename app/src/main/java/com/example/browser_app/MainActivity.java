package com.example.browser_app;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    FloatingActionButton fab1;
    com.github.clans.fab.FloatingActionButton btn5,btn6,btn7;
    int images[]={R.drawable.groups,R.drawable.google_c,R.drawable.web};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout=findViewById(R.id.layout11);
        tab=findViewById(R.id.tabs);
        toolbar = findViewById(R.id.toolbar);
        viewPager=findViewById(R.id.vpager);
        btn5=findViewById(R.id.button1);
        btn6=findViewById(R.id.button2);
        btn7=findViewById(R.id.button3);
        fab1=findViewById( R.id.floating_btn );

        setSupportActionBar(toolbar);






        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar=Snackbar.make(v,"Edit Category" , Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });


        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar=Snackbar.make(v,"Add Product" , Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar=Snackbar.make(v,"Subcategory" , Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                                startActivity(intent);
//
//
//            }
//        });

        setUpViewPager();
        tab.setupWithViewPager(viewPager);
        setUpTabIcon();
    }



    private void setUpTabIcon() {
        tab.getTabAt( 0 ).setIcon( images[0] );
        tab.getTabAt( 1 ).setIcon( images[1] );
        tab.getTabAt( 2 ).setIcon( images[2] );
    }



    private void setUpViewPager() {

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new web1(), "Web");
        viewPagerAdapter.addFragment(new web(), "Web1");
        viewPagerAdapter.addFragment(new web2(), "Web2");

        viewPager.setAdapter(viewPagerAdapter);
    }



    private class ViewPagerAdapter  extends FragmentPagerAdapter {
        List<Fragment> fragmentList=new ArrayList<>();
        List<String> fragmentTitle=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            return fragmentList.get(i);
        }

        @Override
        public int getCount() {

            return fragmentList.size();
        }
        public void addFragment(Fragment fragment,String title){
            fragmentList.add(fragment);
            fragmentTitle.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position)
        {
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.red) {
            Toast.makeText(this, "Color Red", Toast.LENGTH_SHORT).show();
            coordinatorLayout.setBackgroundColor( Color.RED);
        }

        if (item.getItemId() == R.id.green) {
            Toast.makeText(this, "Color Green", Toast.LENGTH_SHORT).show();
            coordinatorLayout.setBackgroundColor(Color.GREEN);
        }

        if (item.getItemId() == R.id.blue) {
            Toast.makeText(this, "Color Blue", Toast.LENGTH_SHORT).show();
            coordinatorLayout.setBackgroundColor(Color.BLUE);
        }

        if (item.getItemId() == R.id.yellow) {
            Toast.makeText(this, "Color yellow", Toast.LENGTH_SHORT).show();
            coordinatorLayout.setBackgroundColor(Color.YELLOW);
        }

        if (item.getItemId() == R.id.defaults) {
            Toast.makeText(this, "Color White", Toast.LENGTH_SHORT).show();
            coordinatorLayout.setBackgroundColor(Color.WHITE);
        }
        return super.onOptionsItemSelected(item);
    }

}

