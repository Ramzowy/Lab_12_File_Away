import javax.swing.*;
import java.io.BufferedReader;
import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {



        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();

        // Show open dialog
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();

            // Process the selected file
            processFile(selectedFile);
        } else {
            System.out.println("No file selected. Exiting...");
        }
    }

    private static void processFile(File file) {
        try {
            // FileReader and BufferedReader for efficient reading
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Variables to store counts
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            // Read file line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Increment line count
                lineCount++;

                // Split the line into words and update word count and character count
                String[] words = line.split("\\s+");
                wordCount += words.length;
                for (String word : words) {
                    charCount += word.length();
                }
            }

            // Close the BufferedReader
            bufferedReader.close();

            // Print the summary report
            System.out.println("Summary Report:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);

        } catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

