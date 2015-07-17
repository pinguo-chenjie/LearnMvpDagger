package huowaa.com.learnmvpdagger.weather;

import android.util.Log;

import javax.inject.Inject;

import huowaa.com.learnmvpdagger.mvp.MvpView;

/**
 * Created by huowaa on 7/16/15.
 */
public class WeatherPresenter implements IWeatherPresenter, IWeatherModel.OnWeatherChangeListener{
    private static String TAG = WeatherPresenter.class.getSimpleName();

    IWeatherView mWeatherView;

    IWeatherModel mWeatherModel;

    @Inject
    public WeatherPresenter(IWeatherModel weatherModel) {
        mWeatherModel = weatherModel;
        mWeatherModel.setOnWeatherChangeListener(this);
        Log.i(TAG, "Inject presenter, model and listener");
    }

    @Override
    public void startMonitor() {
        Log.i(TAG, "startMonitor");
        mWeatherModel.startMonitoring();
    }

    @Override
    public void stopMonitor() {
        mWeatherModel.stopMonitoring();
    }

    @Override
    public void attachView(MvpView view) {
        mWeatherView = (IWeatherView) view;
        mWeatherView.showTemp(mWeatherModel.getTemp());
        mWeatherView.showCloud(mWeatherModel.getCloud());
        mWeatherView.showHumidity(mWeatherModel.getHumidity());
    }

    @Override
    public void detachView() {
        mWeatherView = null;
    }

    @Override
    public void onWeatherChange() {
        Log.i(TAG, "onWeatherChange");

        if (mWeatherView != null) {
            Log.i(TAG, "Changing content");
            mWeatherView.showTemp(mWeatherModel.getTemp());
            mWeatherView.showCloud(mWeatherModel.getCloud());
            mWeatherView.showHumidity(mWeatherModel.getHumidity());
        }
    }
}
