import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class BookPrinter implements FileManager,ScreenManager {

    private Book book;
    BookPrinter(Book book) {
        this.book = book;
    }

    public void printToFile() {
        boolean isEven = false;
        String previousPage = "";
        try {
            FileWriter fileWriter = new FileWriter(book.getTitle() + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            do {
                if (isEven) {
                    previousPage = book.getCurrentPage();
                    isEven = false;
                } else {
                    printWriter.printf("%-25s : %25s%n", previousPage, book.getCurrentPage());
                    isEven = true;
                }
            } while (book.turnToNextPage());
            printWriter.close();
        } catch (IOException ex) {
            System.out.println("Cannot print this book due to IOException");
        }
    }

    public void printToScreen() {
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }
}
