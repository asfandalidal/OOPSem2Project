import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WebLogin {
    private String name, emailAddress, DOB, phoneNo, password, paymentinfo;
    private boolean isAdmin;
    private Scanner sc = new Scanner(System.in);
    private File file = new File("Form.txt");

    public WebLogin() throws IOException {
        file.createNewFile();
        if (file.exists()) {
            // System.out.println("Your file has been created!");
        } else {
            System.out.println("File creation failed.");
        }
    }

    public void Register() throws IOException {
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your Email Address: ");
        emailAddress = sc.nextLine();
        System.out.print("Enter your DOB: ");
        DOB = sc.nextLine();
        // System.out.print("Enter your payment method for shipping: ");
        // paymentinfo = sc.nextLine();
        System.out.print("Enter your phone No: ");
        phoneNo = sc.nextLine();
        System.out.print("Enter password: ");
        password = sc.nextLine();
        FileWriter fin = new FileWriter(file, true);
        fin.write("Name: " + name + "\n");
        fin.write("Email Address: " + emailAddress + "\n");
        fin.write("DOB: " + DOB + "\n");
        // fin.write("Payment Method: " + paymentinfo + "\n");
        fin.write("Phone number: " + phoneNo + "\n");
        fin.write("Password: " + password + "\n");
        System.out.println("Sign Up Successfull!");
        fin.close();
    }

    public boolean CheckCredentials() throws IOException {
        FileReader fout = new FileReader(file);
        String findn = "";
        String e;
        String p;
        int i;
        boolean found = false;
        System.out.print("Enter your Email Address: ");
        e = sc.nextLine();
        System.out.print("Enter your password: ");
        p = sc.nextLine();
        while ((i = fout.read()) != -1) {
            findn += (char) i;
        }
        if (findn.contains(e) && findn.contains(p)) {
            found = true;
        } else {
        }
        return found;
    }

    public void logoutUser(String name) throws IOException {
        FileReader fout = new FileReader(file);
        String findn = "";
        int i;
        boolean found = false;
        while ((i = fout.read()) != -1) {
            findn += (char) i;
        }
        if (findn.contains(name)) {
            found = true;
            System.out.println("Logout Successful!");
        } else {
            System.out.println("Login user not found!");
        }
    }
    public void setIsAdmin(boolean isAdmin)
    {
        this.isAdmin=isAdmin;
    }
    public boolean getIsAdmin()
    {
        return this.isAdmin;
    }
}
