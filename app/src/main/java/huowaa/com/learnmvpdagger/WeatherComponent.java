package huowaa.com.learnmvpdagger;

import javax.inject.Singleton;

import dagger.Component;
import huowaa.com.learnmvpdagger.dagger.PresenterModule;

/**
 * Created by huowaa on 7/16/15.
 */
@Component(modules = PresenterModule.class)
@Singleton
interface WeatherComponent {
    void inject(WeatherBoardActivity w);
}
