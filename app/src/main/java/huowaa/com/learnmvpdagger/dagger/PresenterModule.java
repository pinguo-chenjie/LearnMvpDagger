package huowaa.com.learnmvpdagger.dagger;

import dagger.Module;
import dagger.Provides;
import huowaa.com.learnmvpdagger.weather.IWeatherPresenter;
import huowaa.com.learnmvpdagger.weather.WeatherPresenter;

/**
 * Created by huowaa on 7/16/15.
 */
@Module(includes = ModelModule.class)
public class PresenterModule {
    @Provides
    IWeatherPresenter provideWeatherPresenter(WeatherPresenter presenter) {
        return presenter;
    }
}
