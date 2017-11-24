package pl.przemek.android.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import android.os.Handler;

public class MyService extends IntentService {


    private static final String EXTRAS_CYCLES = "EXTRA_CYCLES";

    private Handler handler = new Handler();

    public MyService() {
        super("MyService");
    }


    public static void startAction(Context context) {
        Intent intent = new Intent(context, MyService.class);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            int n = intent.getIntExtra(EXTRAS_CYCLES, 10);
            for (int i = 0; i < n; i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                Log.d("SERVICE", "lteration " + i);
                handler.post(new Runnable() {
                    @Override
                    public void run(){
                        Toast.makeText(getApplicationContext(),"HELLO SERVICE", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }
    }
}