import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription{


    @Override
    public void request(long n) {}

    //This sh*t goes on unsubscribe function on StringSubscribers
    @Override
    public void cancel() {}

}