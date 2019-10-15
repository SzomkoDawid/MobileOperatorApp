package operators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperatorServiceImplTest {

    private OperatorServiceImpl operatorService;

    @BeforeEach
    void setUp() {
        operatorService = new OperatorServiceImpl();
    }


    @Test
    @DisplayName("Should return 9 digits")
    void PhoneNumberLength() {
        //when
        long orange = operatorService.orange();
        long play = operatorService.play();
        long plus = operatorService.plus();
        long tmobile = operatorService.tMobile();

        String[] numbers = new String[]{String.valueOf(orange), String.valueOf(play),
                String.valueOf(plus), String.valueOf(tmobile)};
        //then
        assertEquals(9, numbers[0].length(), "ORANGE - checked");
        assertEquals(9, numbers[1].length(), "PLAY - checked");
        assertEquals(9, numbers[2].length(), "PLUS - checked");
        assertEquals(9, numbers[3].length(), "T-MOBILE - checked");
    }

    @Test
    @DisplayName("ORANAGE generates numbers starting with 5")
    void orangeFirstDigitofNumber() {
        //when
        int i = 0;
        long result = operatorService.orange();
        String stringNumber = String.valueOf(result);
        String[] firstCharValidate = stringNumber.split("");
        //given
        assertEquals("5", firstCharValidate[i]);
    }

    @Test
    @DisplayName("PLAY generates numbers starting with 8")
    void playFirstDigitofNumber() {
        //when
        int i = 0;
        long result = operatorService.play();
        String stringNumber = String.valueOf(result);
        String[] firstCharValidate = stringNumber.split("");
        //given
        assertEquals("8", firstCharValidate[i]);
    }

    @Test
    @DisplayName("T-MOBILE generates numbers starting with 7")
    void tmobileFirstDigitofNumber() {
        //when
        int i = 0;
        long result = operatorService.tMobile();
        String stringNumber = String.valueOf(result);
        String[] firstCharValidate = stringNumber.split("");
        //given
        assertEquals("7", firstCharValidate[i]);
    }

    @Test
    @DisplayName("PLUS generates numbers starting with 6")
    void plusFirstDigitofNumber() {
        //when
        int i = 0;
        long result = operatorService.plus();
        String stringNumber = String.valueOf(result);
        String[] firstCharValidate = stringNumber.split("");
        //given
        assertEquals("6", firstCharValidate[i]);
    }

}
