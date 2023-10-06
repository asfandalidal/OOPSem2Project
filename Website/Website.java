import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class Website {
    private String Name;
    private String URL;
    private String Description;
    private String domainName;
    private String dataBaseTechnology;
    private boolean CMS;
    private String creationDate;
    private ArrayList<WebPage> pages;
    private String webServerTechnology;
    private String FrontEndFramework;
    private String FrontendLanguage;
    private String BackEndLanguage;
    private String BackEndFramework;
    private boolean IsWebsiteActive;
    private String HostingProvider;
    private String DomainRegistrar;
    private ArrayList<String> SocialMediaLinks;
    private ArrayList<String> LanguageSupported;
    protected WebLogin login; // association
    public Website(String Name, String URL, String Description, String domainName,
                   String dataBaseTechnology, boolean CMS,String creationDate,
                   String webServerTechnology, String FrontEndFramework, String FrontendLanguage,
                   String BackEndLanguage, String BackEndFramework, boolean IsWebsiteActive,
                   String HostingProvider, String DomainRegistrar) throws IOException {
        this.Name = Name;
        this.URL = URL;
        this.Description = Description;
        this.domainName = domainName;
        this.dataBaseTechnology = dataBaseTechnology;
        this.CMS = CMS;
        this.creationDate = creationDate;
        this.pages = new ArrayList<>();
        this.webServerTechnology = webServerTechnology;
        this.FrontEndFramework = FrontEndFramework;
        this.FrontendLanguage = FrontendLanguage;
        this.BackEndLanguage = BackEndLanguage;
        this.BackEndFramework = BackEndFramework;
        this.IsWebsiteActive = IsWebsiteActive;
        this.HostingProvider = HostingProvider;
        this.DomainRegistrar = DomainRegistrar;
        this.SocialMediaLinks = new ArrayList<>();
        this.LanguageSupported = new ArrayList<>();
        this.login=new WebLogin();
    }
    public void setDescription(String description)
    {
        this.Description=description;
    }
    public String getDescription()
    {
        return Description;
    }
    public void ChangeWebsiteName(String Name)
    {
        this.Name=Name;
    }
    public String getWebsiteName()
    {
        return Name;
    }
    public void ChangeDomainName(String domain)
    {
        this.domainName=domain;
    }
    public String getDomainName()
    {
        return domainName;
    }
    public void ShiftHosting(String hoster)
    {
        this.HostingProvider=hoster;
    }
    public String getWebServerTechnology() {
        return webServerTechnology;
    }

    public String getFrontEndFramework() {
        return FrontEndFramework;
    }

    public String getFrontEndLanguage() {
        return FrontendLanguage;
    }

    public String getBackEndLanguage() {
        return BackEndLanguage;
    }

    public String getBackEndFramework() {
        return BackEndFramework;
    }

    public boolean isWebsiteActive() {
        return IsWebsiteActive;
    }
    public void setWebServerTechnology(String webServerTechnology) {
        this.webServerTechnology = webServerTechnology;
    }

    public void setFrontEndFramework(String frontEndFramework) {
        this.FrontEndFramework = frontEndFramework;
    }

    public void setFrontEndLanguage(String frontEndLanguage) {
        this.FrontendLanguage = frontEndLanguage;
    }

    public void setBackEndLanguage(String backEndLanguage) {
        this.BackEndLanguage = backEndLanguage;
    }

    public void setBackEndFramework(String backEndFramework) {
        this.BackEndFramework = backEndFramework;
    }

    public void setWebsiteActive(boolean isWebsiteActive) {
        this.IsWebsiteActive = isWebsiteActive;
    }

    public void addWebPage(WebPage page) {
        pages.add(page);
    }

    public void displayHomepage() {
        System.out.println("Welcome to our website! Here's the homepage content.");
    }

    public void displayPage(String pageName) {
        for (WebPage page : pages) {
            if (page.getTitle().equals(pageName)) {
                System.out.println(page.getTitle() + " Page is displayed");
                return;
            }
        }
        System.out.println("Page not found (404)");
    }

    public void registerUser() throws IOException {
        login.Register();
    }
    public void LoginUser() throws IOException
    {   
        login.CheckCredentials();
    }
    public void logoutUser(String uname) throws IOException {
        login.logoutUser(uname);
    }

    public void searchBar() {
        System.out.println("Search result: ");
    }

    public void displaySocialMediaLinks() {
        for (String link : SocialMediaLinks) {
            System.out.println("Social Media Link: " + link);
        }
    }
    public void changeThemeMode(String mode) {
        System.out.println(mode + " mode is open");
    }
      public void addSocialMediaLink(String link)
      {
          SocialMediaLinks.add(link);
          System.out.println("Link Added");
      }
      public void removeSocialMediaLink(String platform)
      {
          boolean found=false;
          String links="";
          for (int index = 0; index < SocialMediaLinks.size(); index++) {
              links=SocialMediaLinks.get(index);
              if(links.contains(platform))
              {
                  SocialMediaLinks.remove(index);
                  found=true;
                  index--;
              }
          }
          if(found)
          {
              System.out.println("Link removed from the website");
          }
          else{
              System.out.println("Error in removing");
          }
      }
}
