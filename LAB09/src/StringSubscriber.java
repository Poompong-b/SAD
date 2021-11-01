import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber<String>{

    //Variables
    protected  Flow.Subscription subscription; // keep it for nothing :/
    protected String type;

    //Get the Directory
    private String directoryFile = System.getProperty("user.dir") + "\\log\\";

    //Write File Function
    protected void writeFile(String item){

        //Create Log Timestamp Format
        String pattern = "HH:mm:ss EEE MMM dd yyyy : ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        try {
            FileWriter myWriter = new FileWriter(directoryFile + this.type +".txt", true);
            PrintWriter myPrinter = new PrintWriter(myWriter);
            myPrinter.print(date + item + "\n");
            myPrinter.close();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Public Functions
    public  StringSubscriber(String type){
        this.type = type;
        File log = new File(directoryFile + type + ".txt");
    }

    public void onSubscribe(Flow.Subscription subscription){
        //wtf is this for??????
    }

    //All the Override are here boys!!!
    @Override
    public abstract void onNext(String item);

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }

    @Override
    public String toString() {
        return this.type + " Subscriber";
    }

    //Abstract
    public abstract boolean checkType(String text);


}