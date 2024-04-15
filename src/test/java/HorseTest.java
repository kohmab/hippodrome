import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;

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
    @ValueSource(ints = {-1, Integer.MIN_VALUE, -150000})
    void negativeSpeedConstructor(int speed) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Horse("name", speed, 10));
        assertEquals("Speed cannot be negative.", ex.getMessage());

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, Integer.MIN_VALUE, -150000})
    void negativeDistanceConstructor(int distance) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Horse("name", 1, distance));
        assertEquals("Distance cannot be negative.", ex.getMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {"КОЛЯ", "あいこ", "张", "John", "..."})
    void getName(String name) {
        assertEquals(name, new Horse(name, 10, 10).getName());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 20, Integer.MAX_VALUE})
    void getSpeed(int speed) {
        assertEquals(speed, new Horse("...", speed, 10).getSpeed());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 20, Integer.MAX_VALUE})
    void getDistance(int distance) {
        assertEquals(distance, new Horse("...", 1, distance).getDistance());
    }

    @Test
    void getDistanceTwoParamConstructor() {
        assertEquals(0, new Horse(",,,", 0).getDistance());
    }

    @Test
    void moveUsesGetRandom(){
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
            new Horse("name",10,0).move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2,0.9));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0,0.1,10.0,1000.0})
    void move(double val){
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
            Horse h = new Horse("name",10,0);
            mockedStatic.when(() -> Horse.getRandomDouble(anyDouble(),anyDouble())).thenReturn(val);
            h.move();
            assertEquals(10*val,h.getDistance());
        }
    }
}