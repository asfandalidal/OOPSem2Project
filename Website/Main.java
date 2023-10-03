import java.io.IOException;
import java.util.ArrayList;

public class Main{
public static void main(String[] args) {
    try {
        ArrayList <String> skillSet=new ArrayList<>();
        ArrayList <String> projects=new ArrayList<>();
        
        Portfolio AsfandDal=new Portfolio("Asfand Dal", "asfand.azeemi@gmail.com", "https//:AsfandDal.com", "Asfand Ali , A professional Software Engineer.Proficient in Android Applications and also hybrid.Developed 100+ apps for big tech giants.Here is the his portfolio website", "AsfandDal.com", "Hostinger", "MongoDB", false, "26 August 2009", "Apatche", "Angular", "HTML CSS JS", "JS", "Node.js", true,  "Firebase", "Go Daddy", skillSet, projects);

        WebPage Home= new WebPage("https://www.AsfandDal.com/home", "Homepage", "This is the HomePage of Asfand Dal Web portfolio , content here....", true, true);
        WebPage AboutMe = new WebPage("https://www.AsfandDal.com/AboutMe", "About Us", "Learn more about Asfand Dal,Software Engineer & public Speaker", true, true);
         
        WebPage contactMe=new WebPage("https:www.AsfandDal.com/contactMe","Contact Me", "Contact to Asfand Dal", true, true);
        AsfandDal.addWebPage(Home);
        AsfandDal.addWebPage(contactMe);
        AsfandDal.addWebPage(AboutMe);
        AsfandDal.changeThemeMode("Dark");
        AsfandDal.displayPage("Homepage");
        AsfandDal.addSocialMediaLink("Gmail: asfand.azeemi@gmail.com");
        AsfandDal.addSocialMediaLink("Linkedin : Asfand Ali Dal");
       System.out.println("The name of the Website is "+AsfandDal.getWebsiteName()); 
    //    AsfandDal.LogoutUser("Aijaz");
    // AsfandDal.SetAdminLogin(false);
    // AsfandDal.addProject("contribute in spotify UI");
    // AsfandDal.addProject("Book Management System");
    // AsfandDal.addProject("Netflify app");
    // AsfandDal.addProject("British Encyclopedia app");
    // AsfandDal.DisplayProject();
    // AsfandDal.setSkills("Java");
    // AsfandDal.ReadArticles();
    // AsfandDal.SetAdminLogin(false);
    // AsfandDal.LoginUser();
    // AsfandDal.writeArticles("Aijaz Ahmed");
    // AsfandDal.deleteArticle("Aijaz Ahmed");
    //    AsfandDal.LoginUser();
    // AsfandDal.ReadArticles();
    //    AsfandDal.registerUser();

    Thread thread1 = new Thread(AsfandDal);
Thread thread2 = new Thread(AsfandDal);

thread1.start(); // Starts the first thread
thread2.start(); // Starts the second thread
    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
}
