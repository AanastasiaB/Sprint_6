import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LionTest {

    private Predator mockPredator;
    private Lion maleLion;
    private Lion femaleLion;

    @Before
    public void setUp() throws Exception {
        mockPredator = mock(Predator.class);
        when(mockPredator.eatMeat()).thenReturn(List.of("Мясо", "Курица"));
        when(mockPredator.getFamily()).thenReturn("Кошачьи");
        when(mockPredator.getKittens()).thenReturn(3);

        maleLion = new Lion("Самец", mockPredator);
        femaleLion = new Lion("Самка", mockPredator);
    }

    @Test
    public void testHasManeForMale() throws Exception {
        assertTrue(maleLion.doesHaveMane());
    }

    @Test
    public void testNoManeForFemale() throws Exception {
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Курица");
        List<String> actualFood = maleLion.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetKittens() throws Exception {
        int expectedKittens = 3;
        int actualKittens = maleLion.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testInvalidSexThrowsException() throws Exception {
        try {
            new Lion("Неправильное значение", mockPredator);
            fail("Ожидалось исключение, но его не было.");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}