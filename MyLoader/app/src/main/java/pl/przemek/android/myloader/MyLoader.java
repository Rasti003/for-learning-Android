package pl.przemek.android.myloader;


import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import  java.util.List;

public class MyLoader extends AsyncTaskLoader<List<String>> {

    public MyLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }


    @Override
    public List<String> loadInBackground() {
        List<String> strings = new ArrayList<>();
        for (int i = 20; i >0 ; i--){
            strings.add(String.valueOf(i));
            Log.d("LOADING", strings.toString());
            try {
                Thread.sleep(200);

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    @Override
    public void deliverResult(List<String> data) {
        super.deliverResult(data);
    }
}
