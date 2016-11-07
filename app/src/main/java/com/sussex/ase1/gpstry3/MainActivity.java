package com.sussex.ase1.gpstry3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView postcode;
    Button mapButton;

    public Context context;
    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        setContentView(R.layout.activity_main);
//        final GlobalVariables globalVariable = (GlobalVariables) getApplicationContext();
        postcode = (TextView) findViewById(R.id.postcode);      //Seconds between GPS Location Updates
        mapButton  = (Button) findViewById(R.id.mapButton);          //button to update settings
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        Intent serviceIntent = new Intent(getApplicationContext(), RemoteService.class);
//        bindService(serviceIntent, myConnection, Context.BIND_AUTO_CREATE);
     //   remoteService = new RemoteService(MainActivity.this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.i("SETTINGSSJD", "Starting Settings Intent");
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            Log.i("SETTINGSSJD", "After Settings Intent Created");
            startActivity(settingsIntent);
            Log.i("SETTINGSSJD", "After Starting Settings Intent");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.author) {
            // Handle the camera action
        } else if (id == R.id.info) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.location) {
            Intent mapIntent = new Intent(this, LocationActivity.class);
            startActivity(mapIntent);

        } else if (id == R.id.task3) {
            Intent task3Intent = new Intent(this, Task3Activity.class);
            startActivity(task3Intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onClick(View arg0) {
        String pcode = postcode.getText().toString();
        if (!validPostcode(pcode)) {
            return;
        }
        Intent webIntent = new Intent(context, WebViewActivity.class);
        webIntent.putExtra("postcode", pcode);
        startActivity(webIntent);
    }

    public boolean validPostcode(String postcode){
      //  valid postcode formats    AA9A 9AA  |  A9A 9AA   |  A9 9AA  |  A99 9AA   |  AA9 9AA   |  AA99 9AA

        if (postcode == null){
            Toast.makeText(this, "Postcode is empty. Try again", Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (postcode.matches("(GIR 0AA)|((([A-Z-[QVX]][0-9][0-9]?)|(([A-Z-[QVX]][A-Z-[IJZ]][0-9][0-9]?)|(([A-Z-[QVX]][0-9][A-HJKPSTUW])|([A-Z-[QVX]][A-Z-[IJZ]][0-9][ABEHMNPRVWXY])))) [0-9][A-Z-[CIKMOV]]{2})"))
//            return true;

        String pcode = postcode.toUpperCase().trim();
        String mTest = "";

     //   switch (pcode.length()){
    //        case 1:
      //              mTest = "[A-Z-[QVX]]";
//                    break;
//            case 2:
//                    mTest = "([A-Z-[^QVX]][0-9])|([A-Z-[^QVX]][A-Z-[^IJZ]])";
//                    break;
//            case 3:
//                    mTest = "(([A-Z-[QVX]][0-9][0-9])|([A-Z-[QVX]][A-Z-[IJZ]][0-9])|([A-Z-[QVX]][0-9][A-HJKPSTUW]))";
//                    break;
//            case 4:
//                    mTest = "(([A-Z-[QVX]][A-Z-[IJZ]][0-9][0-9])|([A-Z-[QVX]][A-Z-[IJZ]][0-9][ABEHMNPRVWXY]))";
//                    break;
 //           case 5:
 //                   mTest = "(([A-Z-[QVX]][0-9][0-9] [0-9])|([A-Z-[QVX]][A-Z-[IJZ]][0-9] [0-9])|([A-Z-[QVX]][0-9][A-HJKPSTUW] [0-9])|([A-Z-[QVX]][0-9] [0-9][A-Z-[CIKMOV]])";
 //                   break;
 //           case 6:
 //                   mTest = "(([A-Z-[QVX]][0-9][0-9] [0-9][A-Z-[CIKMOV]])|([A-Z-[QVX]][A-Z-[IJZ]][0-9] [0-9][A-Z-[CIKMOV]])|([A-Z-[QVX]][0-9][A-HJKPSTUW] [0-9][A-Z-[CIKMOV]])|([A-Z-[QVX]][0-9] [0-9][A-Z-[CIKMOV]]{2})|([A-Z-[QVX]][A-Z-[IJZ]][0-9][0-9] [0-9])|([A-Z-[QVX]][A-Z-[IJZ]][0-9][ABEHMNPRVWXY] [0-9]))";
          //  valid formats   (               A99 9Aa                   )|(                  AA9 9Aa                      )|(                    A9A 9Aa                     )|(                    A9 9AA             )|(                 AA99 9aa             )|(                   AA9A 9aa                    )
 //                   break;
 //           case 7:
 //           default: ;
 //       }
 //       if (!pcode.matches(mTest)) {
 //           Toast.makeText(this, "Postcode format invalid. Try again.", Toast.LENGTH_SHORT).show();
 //           return false;
 //       }

        return true;
    }

//    public void onClick(View view)
//    {
    //    String postc = postcode.getText().toString();
 //       String mapUrl = "http://lowcost-env.kdumcfjv2e.us-west-2.elasticbeanstalk.com/TestMapServlet?maptype=heatmap&postcode=BN3";
 //       Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapUrl));
 //       startActivity(Getintent);
 //   }


}

