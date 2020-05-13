package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing SimpleDrink implementation")
class SimpleDrinkTest {

    private SimpleDrink sA;
    private SimpleDrink sN;

    /**
     * inits an alcoholic and nonalcoholic SimpleDrink for EACH test
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        sN = new SimpleDrink("Cola", new Liquid("Pepsi", 0.5, 0));
        sA = new SimpleDrink("Jägermeister", new Liquid("Jägermeister", 0.02, 35));
    }

    @Test
    @DisplayName("Testing Volume Getter")
    void testGetterVolume() {
        assertEquals(sN.getVolume(), 0.5, 0.001);
        assertEquals(sA.getVolume(), 0.02, 0.001);
    }

    @Test
    @DisplayName("Testing Alcohol Percent Getter")
    void testGetterAlcoholPercent() {
        assertEquals(sN.getAlcoholPercent(), 0, 0.001);
        assertEquals(sA.getAlcoholPercent(), 35, 0.001);
    }

    @Test
    @DisplayName("Testing is Alcoholic")
    void testIsAlcoholic() {
        assertEquals(sN.isAlcoholic(), false);
        assertEquals(sA.isAlcoholic(), true);
    }
}