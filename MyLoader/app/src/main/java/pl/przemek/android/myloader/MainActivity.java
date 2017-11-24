package pl.przemek.android.myloader;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LoaderManager.LoaderCallbacks<List<String>> callback = new LoaderManager.LoaderCallbacks<List<String>>() {
            @Override
            public Loader<List<String>> onCreateLoader(int i, Bundle bundle) {
                return new MyLoader(MainActivity.this);
            }


            @Override
            public void onLoadFinished(Loader<List<String>> loader, List<String> strings) {
                Log.d("WYNIKI", strings.toString());
                textView2.setText(strings.toString());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoaderReset(Loader<List<String>> loader) {

            }
        };
        getSupportLoaderManager().initLoader(0, null, callback);
    }
}
