package com.example.serviceapplication.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.serviceapplication.R;
import com.example.serviceapplication.data.DataProcessController;
import com.example.serviceapplication.ui.dialog.ToastHelper;


/**
 * The type Bound service remote sample.
 *
 * @author dev.cobb
 * @version 1.0
 * @since 8 oct 2016
 */
public class BoundServiceRemoteSample extends AppCompatActivity implements View.OnClickListener {
    /**
     * The Is service bound.
     *
     */
    boolean isServiceBound = false;

    /**
     * The Service intent.
     */
    Intent  serviceIntent;
    /**
     * The Button bind.
     */
    Button  buttonBind, /**
     * The Button unbind.
     */
    buttonUnbind, /**
     * The Button get number.
     */
    buttonGetNumber;
    /**
     * The Text view random number.
     */
    TextView textViewRandomNumber;
    /**
     * The constant GET_RANDOM_NUMBER.
     */
    public static final int  GET_RANDOM_NUMBER=0;
    /**
     * The Random number value.
     */
    int randomNumberValue;
    /**
     * The Request messenger.
     */
    Messenger requestMessenger, /**
     * The Receive messenger.
     */
    receiveMessenger;


    /**
     * The type Receive random number.
     */
    class ReceiveRandomNumber extends Handler {

        @Override
        public void handleMessage(Message msg) {
            randomNumberValue=0;
            switch (msg.what){
                case GET_RANDOM_NUMBER:
                    randomNumberValue=msg.arg1;
                    textViewRandomNumber.setText("Random Number :  " + randomNumberValue);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remort_bound);
        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("cobb.dev.messangerdemo","cobb.dev.messangerdemo.MessengerDEMOService"));



        buttonBind = (Button) findViewById(R.id.buttonBind);
        buttonBind.setOnClickListener(this);

        buttonUnbind = (Button) findViewById(R.id.buttonUnbind);
        buttonUnbind.setOnClickListener(this);

        buttonGetNumber = (Button) findViewById(R.id.buttonGetNumber);
        buttonGetNumber.setOnClickListener(this);


        textViewRandomNumber = (TextView) findViewById(R.id.textviewRandomNumber);
    }


    /**
     * The Service connection.
     */
    ServiceConnection serviceConnection = new ServiceConnection() {

                @Override
                public void onServiceConnected(ComponentName className,
                                               IBinder service) {
                    requestMessenger=new Messenger(service);
                    receiveMessenger=new Messenger(new ReceiveRandomNumber() );
                    isServiceBound = true;
                }

                @Override
                public void onServiceDisconnected(ComponentName arg0) {

                    requestMessenger=null;
                    receiveMessenger=null;
                    isServiceBound = false;
                }
            };

    /**
     * Bind bound service.
     */
    public void bindBoundService() {

        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
//        ToastHelper.show("Bind service success");
    }

    /**
     * Unbind bound service.
     */
    public void unbindBoundService() {



            unbindService(serviceConnection);
            isServiceBound = false;

        ToastHelper.show("Unbind service success");

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.buttonBind:
                bindBoundService();
                break;
            case R.id.buttonUnbind:
                unbindBoundService();
                break;
            case R.id.buttonGetNumber:
                getRandomNumber();
                break;


        }

    }
 private void getRandomNumber(){
if (isServiceBound){
    Message reqMessage=Message.obtain(null,GET_RANDOM_NUMBER);
    reqMessage.replyTo=receiveMessenger;
    try {

        requestMessenger.send(reqMessage);
    } catch (RemoteException e) {
        e.printStackTrace();
    }

}else {
    ToastHelper.show("Service unbound , cant get random number");
}
 }


    @Override
    public void onBackPressed() {
        DataProcessController.getDataProcessController().getNavigator().navigateToHome(BoundServiceRemoteSample.this);
    }
}
