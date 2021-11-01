import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("LAB09 : Behavioral Design Pattern\n------------------------------------");
        System.out.print("Here's How It's Work\n\n" +
                "Type something if it has only string it will be contain in Alphabet.txt." +
                "\nIf it has only numbers it will be contain in Number.txt." +
                "\nIf it has only symbol it will be contain in Symbol.txt" +
                "\nif it has more than 2 types of data, it will be contain in 2 or more text file."+
                "\nType X and Press enter to Exit.\n\n");

        //Create Subscribers
        AlphabetSubscriber alphabetSubscriber = new AlphabetSubscriber();
        NumberSubscriber numberSubscriber = new NumberSubscriber();
        SymbolSubscriber symbolSubscriber = new SymbolSubscriber();

        //Create Publisher
        StringPublisher publisher = new StringPublisher();
        publisher.subscribe(alphabetSubscriber);
        publisher.subscribe(numberSubscriber);
        publisher.subscribe(symbolSubscriber);


        while (true){
            //Create Input Scanner
            Scanner scanner = new Scanner(System.in);

            System.out.print("Type Something : ");
            String inputText = scanner.nextLine();

            //Main Function
            if(!inputText.equals("x")){     //For Exit
                publisher.publish(inputText);
            }else {
                publisher.unsubscribe(alphabetSubscriber);
                publisher.unsubscribe(numberSubscriber);
                publisher.unsubscribe(symbolSubscriber);
                break;
            }
        }
    }
}