import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final List<String> expectedFood;
    private final boolean shouldThrowException;

    public AnimalTest(String animalKind, List<String> expectedFood, boolean shouldThrowException) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.shouldThrowException = shouldThrowException;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения"), false},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), false},
                {"Неизвестный", null, true}
        });
    }

    @Test
    public void testGetFood() {
        Animal animal = new Animal();
        try {
            List<String> food = animal.getFood(animalKind);
            assertEquals(expectedFood, food);
            if (shouldThrowException) {
                fail("Ожидалось исключение, но его не было");
            }
        } catch (Exception e) {
            if (!shouldThrowException) {
                fail("Неожиданное исключение: " + e.getMessage());
            }
        }
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String actualFamily = animal.getFamily();

        assertEquals(expectedFamily, actualFamily);
    }
}