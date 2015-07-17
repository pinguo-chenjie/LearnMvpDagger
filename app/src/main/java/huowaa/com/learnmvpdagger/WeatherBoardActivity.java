package huowaa.com.learnmvpdagger;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.InjectView;
import huowaa.com.learnmvpdagger.weather.IWeatherPresenter;
import huowaa.com.learnmvpdagger.weather.IWeatherView;

public class WeatherBoardActivity extends ActionBarActivity implements IWeatherView{
    private static String TAG = WeatherBoardActivity.class.getSimpleName();

    // ButterKnife inject views
    @InjectView(R.id.temp_value)
    TextView mTempView;
    @InjectView(R.id.cloud_value)
    TextView mCloudView;
    @InjectView(R.id.humidity_value)
    TextView mHumidityView;
    @InjectView(R.id.start)
    Button mStartButton;

    // Dagger inject presenter
    @Inject
    IWeatherPresenter mWeatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_board);

        // Dagger
        DaggerWeatherComponent.builder().build().inject(this);

        //Butter knife
        ButterKnife.inject(this);
        mWeatherPresenter.attachView(this);

        // init
//        showTemp(30);
//        showCloud(6);
//        showHumidity("ABCD");
    }


    public void startOrStopMonitor(View view) {
        Log.i(TAG, "startOrStopMonitor");
        mWeatherPresenter.startMonitor();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather_board, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showTemp(int temp) {
        mTempView.setText(String.valueOf(temp));
    }

    @Override
    public void showCloudDirection(String direction) {
        // Todo nothing
    }

    @Override
    public void showCloud(int cloud) {
        mCloudView.setText(String.valueOf(cloud));
    }

    @Override
    public void showHumidity(String humidity) {
        mHumidityView.setText(humidity);
    }
}
