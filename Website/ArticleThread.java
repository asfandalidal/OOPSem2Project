import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArticleThread extends Thread {
    private String articleTitle;
    private WebLogin login;
    private static final Object lock = new Object();

    public ArticleThread(String articleTitle, boolean isAdmin) throws IOException {
        this.articleTitle = articleTitle;
        this.login = new WebLogin();
        login.setIsAdmin(isAdmin);
    }

    @Override
    public void run() {
        // Check if the user is an admin
        if (login.getIsAdmin()) {
            try {
                synchronized (lock) {
                    System.out.println("Admin is writing the article. Please hold on...");
                    // Create a file for the article
                    File articleFile = new File(articleTitle + ".txt");

                    // Check if the file already exists
                    if (articleFile.exists()) {
                        System.out.println(articleTitle);
                        System.out.println("Article with the same title already exists. Please choose a different title.");
                        return; // Exit the thread
                    }

                    articleFile.createNewFile();
                    String article = "";
                    FileWriter write = new FileWriter(articleFile);

                    // Use a Scanner to read user input
                    Scanner userInputScanner = new Scanner(System.in);
                    
                    System.out.println("Enter the content of the " + articleTitle + " article (press Enter on an empty line to finish):");


                    while (true) {
                        String userInput = userInputScanner.nextLine();
                        if (userInput.isEmpty()) {
                            break; // Exit the loop when the user presses Enter
                        } else {
                            article += userInput + "\n"; // Append the input to the article content
                        }
                    }

                    // Write the article content to the file
                    write.write(article);
                    write.close();

                    System.out.println(articleTitle + " Article published successfully.");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Only admin can write articles!");
        }
    }
}
