import com.example.Animal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AnimalTest {
    @Test
    public void testGetFoodWithUnknownAnimal() {
        Animal animal = new Animal();
        try {
            animal.getFood("Неизвестный");
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
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
