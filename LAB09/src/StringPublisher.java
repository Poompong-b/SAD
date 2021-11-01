import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher<String>{
    //Variables
    Set<Flow.Subscriber<? super String>> subscribers = new HashSet<>();

    //Functions
    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        subscribers.add(subscriber);
//        System.out.println(subscriber.toString() + "Just Subscribed");
    }

    public void unsubscribe(Flow.Subscriber<? super String> subscriber) {
        subscribers.remove(subscriber);
//        System.out.println(subscriber.toString() + "Just Unsubscribed");
    }

    private void notifySubscriber(String text){
        for(Flow.Subscriber member : subscribers) {
            if (((StringSubscriber) member).checkType(text)) {
                member.onNext(text);
            }
        }
    }

    public void publish(String text){
        this.notifySubscriber(text);
    }
}