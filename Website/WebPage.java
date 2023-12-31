public class WebPage {
     // Attributes
     private String pageUrl;
     private String title;
     private boolean isSecure; 
     private boolean isResponsive;
     public WebPage(String pageUrl,String title,String content,boolean isSecure,boolean isResponsive)
     {
        this.pageUrl =pageUrl;
        this.title = title;
        this.isSecure = isSecure;
        this.isResponsive = isResponsive;
     }
    public String getPageUrl() {
        return this.pageUrl;
    }

    public void setUrl(String url) {
        this.pageUrl=url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isSecure() {
        return isSecure;
    }

    public void setSecure(boolean secure) {
        isSecure = secure;
    }

    public boolean isResponsive() {
        return isResponsive;
    }

    public void setResponsive(boolean responsive) {
        isResponsive = responsive;
    }
    // functionalities of a webpage
    public void shareOnSocialMedia(String SocialPlatform)
    {
        System.out.println("Shared on "+SocialPlatform);
    }
    public void NavigatetoAnotherPage(String pageURL)
    {
        System.out.println("Page is navigated to "+pageURL);
    }
    public void AddtoBookmark()
    {
        System.out.println("Page is added to Bookmark");
    }
    public void SelectLanguage(String language)
    {
        System.out.println("Page "+title+" is converted to "+language);
    }
    public void HelpDesk()
    {
        System.out.println("Help desk is open");
    }

    
}

