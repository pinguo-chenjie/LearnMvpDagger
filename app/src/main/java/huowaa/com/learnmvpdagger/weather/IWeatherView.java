package huowaa.com.learnmvpdagger.weather;

import huowaa.com.learnmvpdagger.mvp.MvpView;

/**
 * Created by huowaa on 7/16/15.
 */
public interface IWeatherView extends MvpView {

    public void showTemp(int temp);

    public void showCloudDirection(String direction);

    public void showCloud(int cloud);

    public void showHumidity(String humidity);

}
