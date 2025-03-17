import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {

    private Cat cat;

    @Before
    public void setUp() throws Exception {
        Feline mockFeline = mock(Feline.class);

        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        when(mockFeline.getFamily()).thenReturn("Кошачьи");
        when(mockFeline.getKittens()).thenReturn(1);

        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals("Звук, который должен издавать кот, не соответствует ожидаемому", expectedSound, actualSound);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = cat.getFood();
        assertEquals("Еда, которую должен есть кот, не соответствует ожидаемой", expectedFood, actualFood);
    }
}
