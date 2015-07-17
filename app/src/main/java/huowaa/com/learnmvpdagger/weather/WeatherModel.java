package huowaa.com.learnmvpdagger.weather;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * Created by huowaa on 7/16/15.
 */
public class WeatherModel implements IWeatherModel {
    private static String TAG = WeatherModel.class.getSimpleName();

    private OnWeatherChangeListener mWeatherChangeListener;

    // Monitor thread
    private Thread mMonitorThread;
    private boolean mIsRunning;


    @Override
    public int getTemp() {
        return (int)(Math.random() * 45);
    }

    @Override
    public String getCloudDirection() {
        int index = (int)(1000 * Math.random() % DIRECTION.values().length);
        String direction = DIRECTION.values()[index].name();
        return direction;
    }

    @Override
    public int getCloud() {
        return (int) (Math.random() * 9);
    }

    @Override
    public String getHumidity() {
        int index = (int) (1000 * Math.random() % HUMIDITY.values().length);
        String humidity = HUMIDITY.values()[index].name();
        return humidity;
    }

    @Override
    public void setOnWeatherChangeListener(OnWeatherChangeListener listener) {
        this.mWeatherChangeListener  = listener;
    }

    @Override
    public void startMonitoring() {
        Log.i(TAG, "startMonitoring");
        if ( mMonitorThread == null || !mMonitorThread.isAlive() || !mIsRunning ) {
            mIsRunning = true;
            mMonitorThread = new SelfChangeThread();
            mMonitorThread.start();
            Log.i(TAG, "MonitorThread started");
        }
    }

    @Override
    public void stopMonitoring() {
        this.mIsRunning = false;
    }

    // Self change thread
    private final class SelfChangeThread extends Thread {

        private Handler mMainHandler;

        SelfChangeThread () {
            mMainHandler = new Handler(Looper.getMainLooper());
        }

        @Override
        public void run() {
            while (mIsRunning) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mMainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mWeatherChangeListener != null) {
                            mWeatherChangeListener.onWeatherChange();
                        }
                    }
                });
            }
        }
    }
}
