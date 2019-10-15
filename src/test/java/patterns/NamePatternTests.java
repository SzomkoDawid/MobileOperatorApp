package patterns;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class NamePatternTests {

    @Test
    @DisplayName("Should return true if first char - upperCase, rest of string - lowerCase, string.length() >= 3 ")
    public void firstNameMatcher(){
        Pattern pattern = Pattern.compile("^[\\p{Lu}][\\p{Ll}]{2,}$");
        assertTrue(pattern.matcher("Dawid").matches());
        assertFalse(pattern.matcher("dAwId").matches());
        assertFalse(pattern.matcher("Da").matches());
    }
    @Test
    @DisplayName("Should return true if first char - upperCase, rest of string " +
            "- lowerCase, string.length >= 3, and two string are available")
    public void lastNameMatcher(){
        Pattern pattern = Pattern.compile("^[\\p{Lu}][\\p{Ll}]{2,}(-[\\p{Lu}][\\p{Ll}]{2,})?$");
        assertTrue(pattern.matcher("Doe").matches());
        assertTrue(pattern.matcher("Doe-John").matches());
        assertFalse(pattern.matcher("dO").matches());
        assertFalse(pattern.matcher("DoE").matches());
    }
}