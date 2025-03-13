import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class CatTest {

    private Cat cat;

    @Before
    public void setUp() throws Exception {
        Feline mockFeline = mock(Feline.class);

        when(mockFeline.eatMeat()).thenReturn(List.of("Мышь", "Птица"));
        when(mockFeline.getFamily()).thenReturn("Кошачьи");
        when(mockFeline.getKittens()).thenReturn(2);

        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() throws Exception {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мышь", "Птица");
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
}