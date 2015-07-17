package huowaa.com.learnmvpdagger.weather;

import huowaa.com.learnmvpdagger.mvp.MvpModel;

/**
 * Created by huowaa on 7/16/15.
 */
public interface IWeatherModel extends MvpModel {

    public static enum DIRECTION {North, West, South, East}
    public static enum HUMIDITY {A, B, C, D}

    // Weather change listener
    public interface OnWeatherChangeListener {
        public void onWeatherChange();
    }

    public int getTemp();

    public String getCloudDirection();

    public int getCloud();

    public String getHumidity();

    // Change listener
    public void setOnWeatherChangeListener(OnWeatherChangeListener listener);

    // Monitor
    public void startMonitoring();

    public void stopMonitoring();

}
