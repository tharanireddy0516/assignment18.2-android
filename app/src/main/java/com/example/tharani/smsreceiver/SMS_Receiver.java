package com.example.tharani.smsreceiver;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by Tharani on 12/5/2017.
 */
//here created a java class called SMS_Receiver which extends BroadcastReceiver
public class SMS_Receiver extends BroadcastReceiver {
    /*  BroadcastReceiver is an Android component which allows you to register for system or
         application events.
         A receiver can be registered via the AndroidManifest.xml file
          The implementing class for a receiver extends the BroadcastReceiver class. If the event for which the broadcast receiver has registered happens,
          The onReceive() method of the receiver is called by the Android system.
         */
    //creating a method called onReceive taking the parameters as context  and intent
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //Cursor is an interface which is used as a collection to represent data it get the data the the uri given
        Cursor cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"),null,null,null,null);
        //if cursor not equals to null it Cursor is like ResultSet in java, it has rows returned by some queries with its pointer.
        // moveToFirst(), moveToNext() and moveToPosition(position) sets the pointer to desired position.
        if (cursor != null){//using  if Statement because it decides whether a certain statement will execute or not
            //Cursor is the Interface which represents a 2 dimensional table of any database
            cursor.moveToFirst();//moves to first
            //When you invokes moveToFirst() method on the Cursor, it takes the cursor pointer to the first location.
            // Now you can access the data present in the first record it  get the data of the column index

            String num=cursor.getString(cursor.getColumnIndex("address"));
            //by using string getting address
            Toast.makeText(context, " "+num, Toast.LENGTH_LONG).show();
            String body =cursor.getString(cursor.getColumnIndex("body"));
            Toast.makeText(context, " "+body, Toast.LENGTH_LONG).show();
            /*. A toast is a view containing a quick little message for the user.
            The toast class helps you create and show those.
             When the view is shown to the user, appears as a floating view over the application
              LENGTH_LONG Show the view or text notification for a long period of time*/
        }

    }
}


