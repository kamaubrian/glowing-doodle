package brian.com.mvp;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by brian-kamau on 2/7/18.
 */

public class GetQuoteInteractorImpl implements GetQuoteInteractor {


        List arrayList = Arrays.asList(
                "Be Yourself, everyone else is already Taken",
                "A room without books is like a body without a soul",
                "You Only Live oncr, but if you do it right, once is enough",
                "Be the change that you wish to see in the world",
                "If you tell the truth, you dont have to remember anything."
        );

        @Override
        public void getNextQuote(final OnFinishedListener listener){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onFinished(getRandomString());
                }
            },1200);
        }

        public String getRandomString(){
            Random random = new Random();
            int index = random.nextInt(arrayList.size());
            return (String) arrayList.get(index);
    }
}
