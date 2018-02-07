package brian.com.mvp;

/**
 * Created by brian-kamau on 2/7/18.
 */

public interface GetQuoteInteractor {

    interface OnFinishedListener{
        void onFinished(String string);
    }

    void getNextQuote(OnFinishedListener listener);
}
