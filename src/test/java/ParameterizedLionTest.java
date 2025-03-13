import com.example.Lion;
import com.example.Predator;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.Before;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {

    private String gender;
    private boolean expectedHasMane;
    private Predator mockPredator;
    private Lion lion;

    public ParameterizedLionTest(String gender, boolean expectedHasMane) {
        this.gender = gender;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Before
    public void setUp() throws Exception {
        mockPredator = mock(Predator.class);
        when(mockPredator.eatMeat()).thenReturn(List.of("Мясо", "Курица"));
        when(mockPredator.getFamily()).thenReturn("Кошачьи");
        when(mockPredator.getKittens()).thenReturn(3);

        lion = new Lion(gender, mockPredator);
    }

    @Test
    public void testHasMane() throws Exception {
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMane);
    }
}