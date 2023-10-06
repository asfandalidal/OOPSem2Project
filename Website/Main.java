import java.io.IOException;
import java.util.ArrayList;

public class Main{
public static void main(String[] args) {
    try {
        ArrayList <String> skillSet=new ArrayList<>();
        ArrayList <String> projects=new ArrayList<>();
        // create an object of portfolio website
        Portfolio AsfandDal=new Portfolio("Asfand Dal", "asfand.azeemi@gmail.com", "https//:AsfandDal.com", "Asfand Ali , A professional Software Engineer.Proficient in Android Applications and also hybrid.Developed 100+ apps for big tech giants.Here is his portfolio website", "AsfandDal.com", "Hostinger", "MongoDB", false, "26 August 2009", "Apatche", "Angular", "HTML CSS JS", "JS", "Node.js", true,  "Firebase", "Go Daddy", skillSet, projects);
        // change theme mode of the website 
        AsfandDal.changeThemeMode("Dark");
        // display page functionality
        AsfandDal.displayPage("Homepage");
        // add social media links in the website
        AsfandDal.addSocialMediaLink("Gmail: asfand.azeemi@gmail.com");
        AsfandDal.addSocialMediaLink("Linkedin : Asfand Ali Dal");
        AsfandDal.writeArticle("IOT",true);
        AsfandDal.writeArticle("Cloud computing",true);
        
      

       



    
}
catch(Exception e)
{
    System.out.println("Error due to "+e.getMessage());
}
}
}

