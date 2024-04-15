import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;

import java.util.ArrayList;

class HippodromeTest {

    @Test
    void nullHorsesConstructor(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals( "Horses cannot be null.",ex.getMessage());
    }

    @Test
    void emptyHorsesConstructor(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<Horse>()));
        assertEquals( "Horses cannot be empty.",ex.getMessage());
    }

    @Test
    void getHorses() {
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}