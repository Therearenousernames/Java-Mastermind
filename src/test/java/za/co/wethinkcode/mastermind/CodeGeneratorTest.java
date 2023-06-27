package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CodeGeneratorTest {
    private CodeGenerator gen = new CodeGenerator();
    @Test
    public void returnsAStringLengthFour() {
        String code = gen.generateCode();

        assertEquals(4, code.length());
    }

    @Test
    public void returnsAStringWithNumbersInSpecifiedRange() {
        String code = gen.generateCode();

        for (int i = 0; i < code.length(); i++) {
            assertTrue(code.charAt(i) >= '1' && code.charAt(i) < '9');
            }
        }

    @Test
    public void doesNotHaveZero() {
        String code = gen.generateCode();

        for (int i = 0; i < code.length(); i++) {
            assertTrue(code.charAt(i) != '0');
        }
    }

    @Test
    public void doesNotHaveNine() {
        String code = gen.generateCode();

        for (int i = 0; i < code.length(); i++) {
            assertTrue(code.charAt(i) != '9');
        }
    }


}