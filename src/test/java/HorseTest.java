import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HorseTest {

    @Test
    void nullNameConstructor() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 10, 10));
        assertEquals("Name cannot be null.", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "       ", "\t", "\n", "\t\t", "\t\n"})
    void blankNameConstructor(String string) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Horse(string, 10, 10));
        assertEquals("Name cannot be blank.", ex.getMessage());

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, Integer.MIN_VALUE,-150000})
    void negativeSpeedConstructor(int speed) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Horse("name", speed, 10));
        assertEquals("Speed cannot be negative.", ex.getMessage());

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, Integer.MIN_VALUE,-150000})
    void negativeDistanceConstructor(int distance) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Horse("name", 1, distance));
        assertEquals("Distance cannot be negative.", ex.getMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {"КОЛЯ","あいこ","张","John","..."})
    void getName(String name){
        assertEquals(name,new Horse(name,10,10).getName());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,10,20,Integer.MAX_VALUE})
    void getSpeed(int speed){
        assertEquals(speed,new Horse("...",speed,10).getSpeed());
    }


}