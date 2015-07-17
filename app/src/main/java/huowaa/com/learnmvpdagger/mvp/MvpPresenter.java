package huowaa.com.learnmvpdagger.mvp;

/**
 * Created by huowaa on 7/16/15.
 */
public interface MvpPresenter {

    public void attachView(MvpView view);

    public void detachView();

}
