import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Portfolio extends Website {
    Scanner sc = new Scanner(System.in);
    private String contactEmail;
    private ArrayList<String> skills;
    private ArrayList<String> projects;
    private WebPage webPage; //  association
    private boolean isAdmin;
    private boolean isUserLogin;
    public Portfolio(String Name, String contactEmail, String URL, String Description, String domainName,
                     String hostingServer, String dataBaseTechnology, boolean CMS, String creationDate,
                     String webServerTechnology, String FrontEndFramework, String FrontendLanguage,
                     String BackEndLanguage, String BackEndFramework, boolean IsWebsiteActive, String HostingProvider,
                     String DomainRegistrar, ArrayList<String> skills, ArrayList<String> projects) throws IOException {
        super(Name, URL, Description, domainName, dataBaseTechnology, CMS, creationDate, webServerTechnology,
                FrontEndFramework, FrontendLanguage, BackEndLanguage, BackEndFramework, IsWebsiteActive, HostingProvider,
                DomainRegistrar);
        this.contactEmail = contactEmail;
        this.skills = new ArrayList<>();
        this.projects = new ArrayList<>();
        WebPage Home = new WebPage("https://www.AsfandDal.com/home", "Homepage",
                "This is the HomePage of Asfand Dal Web portfolio, content here....", true, true);

        WebPage contactMe = new WebPage("https:www.AsfandDal.com/contactMe", "Contact Me", "Contact to Asfand Dal", true, true);

        WebPage AboutMe = new WebPage("https://www.AsfandDal.com/AboutMe", "About Us",
                "Learn more about Asfand Dal, Software Engineer & public Speaker", true, true);
        addWebPage(Home);
        addWebPage(AboutMe);
        addWebPage(contactMe);

        
    }

    public void setContactEmail(String email) {
        contactEmail = email;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void addProject(String project) {
        if (login.getIsAdmin()) {
            projects.add(project);
            System.out.println("Project added successfully !");
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

    public void displayProjects() {
        for (int i = 0; i < projects.size(); i++) {
            System.out.println(i + ". " + projects.get(i));
        }
    }

    public void setSkills(String skill) {
        if (login.getIsAdmin()) {
            skills.add(skill);
            System.out.println("Skill added successfully !");
        } else {
            System.out.println("Only admin can set skills!");
        }
    }

    public void displaySkills() {
        for (int i = 0; i < skills.size(); i++) {
            System.out.println((i + 1) + ". " + skills.get(i));
        }
    }

    public void readArticles() {
        if (isUserLogin) {
            System.out.println("You can read articles");
        } else {
            System.out.println("Please login to read articles");
        }
    }

    public void signupUser() throws IOException {
        if (!isUserLogin) {
            login.Register();
        } else {
            System.out.println("User is already logged in. Logout first.");
        }
    }

    // @Override
    public void loginUser() throws IOException {
        if (!isUserLogin) {
            if (login.CheckCredentials()) {
                isUserLogin = true;
                System.out.println("User Login Successful!");
            } else {
                System.out.println("Invalid Credentials! Login Failed.");
            }
        } else {
            System.out.println("User is already logged in. Logout first.");
        }
    }

    public void logoutUser(String name) throws IOException {
        super.logoutUser(name);
        if (isUserLogin) {
            login.logoutUser(name);
            isUserLogin = false;
            System.out.println("User Logout Successful!");
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void setAdminLogin(boolean isAdmin) {
        if (isAdmin) {
            login.setIsAdmin(isAdmin);
            if (login.getIsAdmin()) {
                System.out.println("Admin Login Set!");
            } else {
                System.out.println("Admin Login Removed!");
            }
        } else {
            System.out.println("User is currently logged in. Cannot set admin login.");
        }
    }

    public void deleteArticle(String articleTitle) {
        // Check if the user is an admin
        if (login.getIsAdmin()) {
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
    public void writeArticle(String articleTitle,boolean isAdmin) throws IOException {
        ArticleThread articleThread = new ArticleThread(articleTitle,isAdmin);
        articleThread.start();
    }
    
   
}
