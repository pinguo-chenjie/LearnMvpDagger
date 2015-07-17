package huowaa.com.learnmvpdagger.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import huowaa.com.learnmvpdagger.weather.IWeatherModel;
import huowaa.com.learnmvpdagger.weather.WeatherModel;

/**
 * Created by huowaa on 7/16/15.
 */
@Module
public class ModelModule {
    @Provides
    @Singleton
    public IWeatherModel provideWeatherModel() {
        return new WeatherModel();
    }
}
