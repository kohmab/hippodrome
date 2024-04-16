import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import java.util.ArrayList;

class HippodromeTest {

    @Test
    void nullHorsesConstructor() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", ex.getMessage());
    }

    @Test
    void emptyHorsesConstructor() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<Horse>()));
        assertEquals("Horses cannot be empty.", ex.getMessage());
    }

    @Test
    void getHorses() {
        final int N_HORSES = 30;
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < N_HORSES; i++) {
            horses.add(new Horse(String.valueOf(i), i * 2 + 1));
        }
        assertEquals(horses, new Hippodrome(horses).getHorses());

    }

    @Test
    void move() {
        final int N_HORSES = 50;
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < N_HORSES; i++) {
            horses.add(Mockito.mock(Horse.class));
        }
        new Hippodrome(horses).move();
        for (Horse h:horses)
            Mockito.verify(h).move();
    }

    @Test
    void getWinner() {
        List<Horse> horses = new ArrayList<>(){{
            add(new Horse("0",100,1));
            add(new Horse("0",0,4.999));
            add(new Horse("0",100,0));
            add(new Horse("0",100,2));
        }};
        assertSame(horses.get(1),new Hippodrome(horses).getWinner());

    }
}