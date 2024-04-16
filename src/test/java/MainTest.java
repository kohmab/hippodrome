import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Disabled
    @Test
    @Timeout(value = 22, unit = TimeUnit.SECONDS)
    void timeout() {
        PrintStream originalSout = System.out;
        System.setOut(Mockito.mock(PrintStream.class));
        try {
            new Main().main(null);
        } catch (Exception ignore) {
        } finally {
            System.setOut(originalSout);
        }

    }
}