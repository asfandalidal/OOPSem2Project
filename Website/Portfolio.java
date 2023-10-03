import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Portfolio extends Website implements Runnable {
    Scanner sc=new Scanner(System.in);
    private String contactEmail;
    private ArrayList<String> skills;
    private ArrayList<String> projects;
    private WebLogin user;
    private boolean isAdmin;
    private boolean isUserLogin;
   
    public Portfolio(String Name, String contactEmail, String URL, String Description, String domainName,
            String hostingServer, String dataBaseTechnology, boolean CMS,String creationDate,
            String webServerTechnology, String FrontEndFramework, String FrontendLanguage, String BackEndLanguage,
            String BackEndFramework, boolean IsWebsiteActive, String HostingProvider, String DomainRegistrar,
            ArrayList<String> skills, ArrayList<String> projects) throws IOException {
        super(Name, URL, Description, domainName, dataBaseTechnology, CMS, creationDate, webServerTechnology,
                FrontEndFramework, FrontendLanguage, BackEndLanguage, BackEndFramework, IsWebsiteActive, HostingProvider,
                DomainRegistrar);
        this.contactEmail = contactEmail;
        this.skills = new ArrayList<>();
        this.projects = new ArrayList<>();
        user = new WebLogin();
    }

    public void setContactEmail(String email) {
        contactEmail = email;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void addProject(String project) {
        if (user.getIsAdmin()) {
            projects.add(project);
            System.out.println("project added successfully !");
        } else {
            System.out.println("Only admin can add projects!");
        }
    }

    public void removeProject(String pName) {
        if (isAdmin) {
            boolean found = false;
            ArrayList<String> projectCopy = new ArrayList<>(projects);
            for (String projectName : projectCopy) {
                if (projectName.equals(pName)) {
                    projects.remove(pName);
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("Project removed");
            } else {
                System.out.println("Project doesn't exist");
            }
        } else {
            System.out.println("Only admin can remove projects!");
        }
    }

    public void DisplayProject() {
        for (int i = 0; i < projects.size(); i++) {
            System.out.println(i+". "+projects.get(i));
        }
    }

    public void setSkills(String skill) {
        if(user.getIsAdmin()){
            skills.add(skill);
            System.out.println("Skill added successfully !");
        }
        else
            System.out.println("Only admin can set skills!");
    }

    public void displaySkills() {
        for (int i = 0; i <skills.size(); i++) {
            System.out.println((i+1)+". "+skills.get(i));
        }
    }

    public void ReadArticles() {
        if (isUserLogin) {
            System.out.println("You can read articles");
        }
        else {
            System.out.println("Please login to read articles");
        }
    }
    public void SignupUser() throws IOException {
        if (!isUserLogin) {
            user.Register();
        } else {
            System.out.println("User is already logged in. Logout first.");
        }
    }

    public void LoginUser() throws IOException {
        if (!isUserLogin) {
            if (user.CheckCredentials()) {
                isUserLogin = true;
                System.out.println("User Login Successful!");
            } else {
                System.out.println("Invalid Credentials! Login Failed.");
            }
        } else {
            System.out.println("User is already logged in. Logout first.");
        }
    }

    public void LogoutUser(String name) throws IOException{
        if (isUserLogin) {
            user.logoutUser(name);
            isUserLogin = false;
            System.out.println("User Logout Successful!");
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void SetAdminLogin(boolean isAdmin) {
        if (!isUserLogin) {
            user.setIsAdmin(isAdmin);
            if (user.getIsAdmin()) {
                System.out.println("Admin Login Set!");
            } else {
                System.out.println("Admin Login Removed!");
            }
        } else {
            System.out.println("User is currently logged in. Cannot set admin login.");
        }
    }
    public void writeArticles(String ArticleTitle) throws IOException {
        // Check if the user is an admin
        if (user.getIsAdmin()) {
            // Create a file for the article
            File articleFile = new File(ArticleTitle + ".txt");
            // Check if the file already exists
            if (articleFile.exists()) {
                System.out.println("Article with the same title already exists. Please choose a different title.");
                return; // Exit the method
            }
    
            articleFile.createNewFile();
            String article = "";
            FileWriter write = new FileWriter(articleFile);
            
            // Use a Scanner to read user input
            Scanner userInputScanner = new Scanner(System.in);
            System.out.println("Enter the content of the article (press Enter on an empty line to finish):");
    
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
            
    
            System.out.println("Article published successfully.");
        } else {
            System.out.println("Only admin can write articles!");
        }
    }
public void deleteArticle(String articleTitle) {
    // Check if the user is an admin
    if (user.getIsAdmin()) {
        // Create a File object for the article
        File articleFile = new File(articleTitle + ".txt");

        // Check if the article file exists
        if (articleFile.exists()) {
            // Delete the article file
            if (articleFile.delete()) {
                System.out.println("Article '" + articleTitle + "' has been deleted.");
            } else {
                System.out.println("Failed to delete the article.");
            }
        } else {
            System.out.println("Article not found.");
        }
    } else {
        System.out.println("Only admin can delete articles!");
    }
}

@Override
public void run() {
    try {
        System.out.println("thread is starting its task.");
        // Perform some task
        for (int i = 0; i < 5; i++) {
            System.out.println(" someone is working: " + i);
            try {
                LoginUser();
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("someone has completed its task.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

