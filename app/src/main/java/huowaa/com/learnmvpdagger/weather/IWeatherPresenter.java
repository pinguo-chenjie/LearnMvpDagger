package huowaa.com.learnmvpdagger.weather;

import huowaa.com.learnmvpdagger.mvp.MvpPresenter;

/**
 * Created by huowaa on 7/16/15.
 */
public interface IWeatherPresenter extends MvpPresenter{

    public void startMonitor();

    public void stopMonitor();
}
