import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        Scanner fileScanner;
        String fileName;

        BufferedWriter fileWriter;

        while (true) {
            System.out.print("File name : ");
            fileName = consoleScanner.nextLine();

            try {
                fileScanner = new Scanner(new File(fileName));
                fileWriter = new BufferedWriter(new FileWriter("copy-" + fileName));

                consoleScanner.close();

                while (fileScanner.hasNextLine()) {
                    fileWriter.write(fileScanner.nextLine());
                    fileWriter.newLine();
                }

                fileScanner.close();
                fileWriter.close();

                break;
            } catch (FileNotFoundException e) {
                System.out.println("File " + fileName + " not found!");
            } catch (IOException e) {
                System.out.println("Error writing to file copy-" + fileName);
            }
        }

    }
}
