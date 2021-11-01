import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

public class NumberSubscriber extends StringSubscriber{

    //Define Type
    NumberSubscriber(){
        super("Number");
    }

    @Override
    public void onNext(String item) {
//        System.out.println("Number found in: " + item);
        this.writeFile(item);
    }

    @Override
    public boolean checkType(String text) {
        return text.matches(".*[0-9].*");
    }
}