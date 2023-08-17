import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class FileManager {

    public FileManager() {

    }


    public void readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        System.out.println("Данные файла: ");
        String str;
        while ((str = br.readLine()) != null) {
            System.out.printf("%s\n", str);
        }
        br.close();
    }

    public void writeFile(File file) {
        try (Scanner sc = new Scanner(System.in);
             FileWriter fw = new FileWriter(file.getAbsolutePath(), true);) {
            System.out.println("Введите данные для записи: ");
            String text = sc.nextLine();
            fw.append("\n");
            fw.append(text);
            System.out.println("Данные успешно внесены");
            ;
        } catch (FileNotFoundException e) {
            System.out.println("Запись невозможна, т.к. такого файла не существует");
            System.out.println("Произошла ошибка! Данные не внесены");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Произошла ошибка! Данные не внесены");
        }

    }

    public void copyFile(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {

            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();

            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            System.out.println("Файл скопированн");
        } catch (IOException e) {
            System.out.println("Файл не скопирован!");
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

}
