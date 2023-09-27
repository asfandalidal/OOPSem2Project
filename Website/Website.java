package Website;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Website
{
    // atributes every website must have
    private String Name;
    private String URL;
    private String Description;
    private String domainName;
    private String hostingServer;
    private String dataBaseTechnology;
    private boolean CMS;
    private int numberOfVisitors;
    private String creationDate;
    private WebPage webPages;
    private User webUsers;
    private ArrayList <WebPage> pages; //assuming Page is a class representing website pages
    private ArrayList <User> users;  //assuming User is a class representing website users
    private String webServerTechnology;
    private String FrontEndFramework;
    private String FrontendLanguage;
    private String BackEndLanguage;
    private String BackEndFramework;
    private String IsWebsiteActive;
    private String HostingProvider;
    private String DomainRegistrar;
    private ArrayList <String> WebsiteCategories;
    private ArrayList <String> SocialMediaLinks;
    private ArrayList <String> LanguageSupported;
    public Website(String Name, String URL, String Description, String domainName, String hostingServer,
    String dataBaseTechnology, boolean CMS, int numberOfVisitors, String creationDate,
    WebPage webPages, User webUsers, ArrayList<WebPage> pages, ArrayList<User> users,
    String webServerTechnology, String FrontEndFramework, String FrontendLanguage,
    String BackEndLanguage, String BackEndFramework, String IsWebsiteActive,
    String HostingProvider, String DomainRegistrar, ArrayList<String> WebsiteCategories,
    ArrayList<String> SocialMediaLinks, ArrayList<String> LanguageSupported) {
this.Name = Name;
this.URL = URL;
this.Description = Description;
this.domainName = domainName;
this.hostingServer = hostingServer;
this.dataBaseTechnology = dataBaseTechnology;
this.CMS = CMS;
this.numberOfVisitors = numberOfVisitors;
this.creationDate = creationDate;
this.webPages = webPages;
this.webUsers = webUsers;
this.pages = pages;
this.users = users;
this.webServerTechnology = webServerTechnology;
this.FrontEndFramework = FrontEndFramework;
this.FrontendLanguage = FrontendLanguage;
this.BackEndLanguage = BackEndLanguage;
this.BackEndFramework = BackEndFramework;
this.IsWebsiteActive = IsWebsiteActive;
this.HostingProvider = HostingProvider;
this.DomainRegistrar = DomainRegistrar;
this.WebsiteCategories = WebsiteCategories;
this.SocialMediaLinks = SocialMediaLinks;
this.LanguageSupported = LanguageSupported;
}
// Setter and Getter for "Name"
public void setName(String name) {
    this.Name = name;
}

public String getName() {
    return Name;
}

// Setter and Getter for "URL"
public void setURL(String URL) {
    this.URL = URL;
}

public String getURL() {
    return URL;
}

// Setter and Getter for "Description"
public void setDescription(String description) {
    this.Description = description;
}

public String getDescription() {
    return Description;
}

// Setter and Getter for "domainName"
public void setDomainName(String domainName) {
    this.domainName = domainName;
}

public String getDomainName() {
    return domainName;
}

// Setter and Getter for "hostingServer"
public void setHostingServer(String hostingServer) {
    this.hostingServer = hostingServer;
}

public String getHostingServer() {
    return hostingServer;
}

// Setter and Getter for "dataBaseTechnology"
public void setDataBaseTechnology(String dataBaseTechnology) {
    this.dataBaseTechnology = dataBaseTechnology;
}

public String getDataBaseTechnology() {
    return dataBaseTechnology;
}

// Setter and Getter for "CMS"
public void setCMS(boolean CMS) {
    this.CMS = CMS;
}

public boolean isCMS() {
    return CMS;
}

// Setter and Getter for "numberOfVisitors"
public void setNumberOfVisitors(int numberOfVisitors) {
    this.numberOfVisitors = numberOfVisitors;
}

public int getNumberOfVisitors() {
    return numberOfVisitors;
}

// Setter and Getter for "creationDate"
public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
}

public String getCreationDate() {
    return creationDate;
}

// Setter and Getter for "webPages"
public void setWebPages(WebPage webPages) {
    this.webPages = webPages;
}

public WebPage getWebPages() {
    return webPages;
}
// Setter and Getter for "LanguageSupported"
public void setLanguageSupported(ArrayList<String> languageSupported) {
    this.LanguageSupported = languageSupported;
}

public ArrayList<String> getLanguageSupported() {
    return LanguageSupported;
}

  //  Genral methods in every webiste must have

   public void displayHomepage() //   Display Homepage:
  {
    System.out.println(pages.getHomePage());
  }

  public void displayPage(String pageName) //   Display Page:
  {
    // if(Page.getPageName().equals(pageName))
    // {
    //     System.out.println("Page is displayed ");
    // }
    // else{
    //     System.out.println("Page not found");
    // }
  }

  public void registerUser(String username,String email, String password) //   User Registration:
  {
    // users.name=username;
    // users.email=email;
    // users.password=password;
  }
    // boolean loginUser(String username, String password): Method to allow users to log in to the website.
    public boolean loginUser(String username, String password)   // User Login:
    {
        for (int i = 0; i < users.size(); i++) {
            if(users.getUserName().get(i).equals(username))
            {
                return true;
            }
            return false;
            System.out.println("Login successfull"); 
        }

    }
    public void logoutUser()
    {
        System.out.println("Log out");
    }
   public void SearchFunctionality()
   {
    System.out.println("Search result : ");
   }
   public void displayPrivacyPolicy()
   {
    System.out.println(pages.getPrivacyPolicyPage);
   }
   public void displayTermsOfService()
   {
     System.out.println(pages.getTermsOfServicePage);
   }
   public void displaySocialMediaLinks()
   {
    for(int i=0;i<SocialMediaLinks.size();i++)
    {
        System.out.println("There are the Social Media Links : "+SocialMediaLinks.get(i));
    }
   }
   public void ChangeThemeMode(String mode)
   {
    System.out.println(mode+" mode is open");
   }

}

