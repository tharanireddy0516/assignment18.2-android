package com.example.tharani.smsreceiver;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    /*onCreate is the first method in the life cycle of an activity
    savedInstance passes data to super class,data is pull to store state of application
  * setContentView is used to set layout for the activity
  *R is a resource and it is auto generate file
  * activity_main assign an integer value*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {//onCreate method is called when main activity is created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   /*getting the permission for Receiving an sms
   manifest file provides essential information about your app to the Android system,
    which the system must have before it can run any of the app's code.*/
        String permission = Manifest.permission.RECEIVE_SMS;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        //if permission granted it results the permission list
        if ( grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            //string is a sequence of characters
            permission_list[0] = permission;
            //here taking base class activity to requestPermissions
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }
        //creating an intent object of context main activity.this which results the second activity.class
        // broadcastIntent to send it to any interested BroadcastReceiver components, and startService(Intent)
        //  or bindService(Intent, ServiceConnection, int) to communicate with a background Service.
        Intent intent = new Intent(MainActivity.this,SMS_Receiver.class);
        sendBroadcast(intent);

    }

}
