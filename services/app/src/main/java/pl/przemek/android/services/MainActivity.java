package pl.przemek.android.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    protected boolean mBound = false;
    private ServiceConnection mConnection = new MyServiceConnection();
    private MyBoundService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent service = new Intent(this, MyBoundService.class);
        bindService(service, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mConnection);
    }

    public void runService(View view) {
        Log.d("ACTIVITY", "Starting Service");
        MyService.startAction(this);
    }

    public void runBoundService(View view) {
        if (mService!= null && mBound){
            Log.d("ACTIVITY", "Starting Bound Service");
            mService.showToast();
        }
    }


    private class MyServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.MyBinder binder = (MyBoundService.MyBinder) iBinder;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBound = false;
        }

    }
}
