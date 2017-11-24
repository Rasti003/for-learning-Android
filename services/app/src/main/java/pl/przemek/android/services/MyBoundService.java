package pl.przemek.android.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyBoundService extends Service {

    private final IBinder mBinder = new MyBinder();
    private Handler handler = new Handler();

    public MyBoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Services", "Bind service ");
        return mBinder;
    }

    public class MyBinder extends Binder {
        MyBoundService getService() {
            return MyBoundService.this;
        }
    }

    public void showToast() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "HELLO SERVICE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}