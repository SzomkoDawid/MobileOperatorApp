package patterns;
import exceptions.NameException;
import java.util.Scanner;
public class NamePattern {

    public String firstName() {
        String firstName = "";
        Scanner scanner = new Scanner(System.in);
        try {
            firstName = scanner.next("^[\\p{Lu}][\\p{Ll}]{2,}");
        } catch (Exception e) {
            throw new NameException("3 characters are required (first letter upper case, the rest lower case)");
        }
        return firstName;
    }
    public String lastName() {
        String lastName = "";
        Scanner scanner = new Scanner(System.in);
        try {
            lastName = scanner.next("^[\\p{Lu}][\\p{Ll}]{2,}(-[\\p{Lu}][\\p{Ll}]{2,})?$");
        } catch (Exception e) {
            throw new NameException("3 characters are required (first letter upper case, the rest lower case," +
                    " avalible a two-part surname)");
        }
        return lastName;
    }
}