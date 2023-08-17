import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("src\\test.txt");
        File file1 = new File("src\\testToCopy");
        File file2 = new File("test2");

        FileManager fm = new FileManager();


        try {
            fm.readFile(file);
            fm.copyFile(file, file1);
            fm.copyFile(file2, file1);
        } catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
        } catch (NullPointerException e){
            System.out.println("Нельзя скопирровать, т.к. такого файла не существует");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        fm.writeFile(file);

    }
}