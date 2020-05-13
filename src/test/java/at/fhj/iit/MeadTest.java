package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Mead implementation")
class MeadTest {
    private Mead lM,ZM;

    /**
     * inits an alcoholic and nonalcoholic liquid for EACH test
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        List<Liquid> ingredients1 = new ArrayList<>();
        ingredients1.add(new Liquid("Water", 0.4, 0));
        ingredients1.add(new Liquid("Honey", 0.1, 0));
        ingredients1.add(new Liquid("Wine", 0.5,12));

        List<Liquid> ingredients2 = new ArrayList<>();
        ingredients2.add(new Liquid("Water", 0.7, 0));
        ingredients2.add(new Liquid("Honey", 0.3, 0));
        ingredients2.add(new Liquid("Grapejuice", 0.8, 0));
        ingredients2.add(new Liquid("Muskat", 0.1, 0));
        ingredients2.add(new Liquid("Zimt", 0.1, 0));

        lM = new Mead("Honeymead", ingredients1);
        ZM = new Mead("Childrenmead", ingredients2);
    }

    @Test
    @DisplayName("Testing constructor")
    void testConstructor() {
        assertEquals(lM.getName(), "Honeymead");
        assertEquals(lM.getIngredients().size(), 3);
    }

    @Test
    @DisplayName("Testing Ingredients getter")
    void testIngredientsGetter() {
        assertEquals(lM.getIngredients().size(), 3);
        assertEquals(lM.getIngredients().get(0).getName(), "Water");
        assertEquals(lM.getIngredients().get(0).getVolume(), 0.4);
        assertEquals(lM.getIngredients().get(0).getAlcoholPercent(), 0);
        assertEquals(lM.getIngredients().get(1).getName(), "Honey");
        assertEquals(lM.getIngredients().get(1).getVolume(), 0.1);
        assertEquals(lM.getIngredients().get(1).getAlcoholPercent(), 0);
        assertEquals(lM.getIngredients().get(2).getName(), "Wine");
        assertEquals(lM.getIngredients().get(2).getVolume(), 0.5);
        assertEquals(lM.getIngredients().get(2).getAlcoholPercent(), 12);
    }

    @Test
    @DisplayName("Testing Ingredients setter")
    void testIngredientSetter() {
        List<Liquid> ingredientsNew = new ArrayList<>();
        ingredientsNew.add(new Liquid("Water", 0.5, 0));
        lM.setIngredients(ingredientsNew);
        assertEquals(lM.getIngredients().size(), 1);
        assertEquals(lM.getIngredients().get(0).getName(), "Water");
        assertEquals(lM.getIngredients().get(0).getVolume(), 0.5);
        assertEquals(lM.getIngredients().get(0).getAlcoholPercent(), 0);
    }

    @Test
    @DisplayName("Testing Volume getter")
    void testVolumeGetter() {
        assertEquals(lM.getVolume(), 1, 0.001);
    }

    @Test
    @DisplayName("Testing AlcoholPercent getter")
    void testAlcoholPercentGetter() {
        assertEquals(lM.getAlcoholPercent(), 6, 0.001);
    }

    @Test
    @DisplayName("Testing if Drink is alcoholic")
    void testIsAlcoholic() {
        assertEquals(lM.isAlcoholic(), true);
        assertEquals(ZM.isAlcoholic(), false);
    }

    @Test
    @DisplayName("Testing drink function")
    void testDrink() {
        assertEquals(lM.getVolume(), 1, 0.001);
        lM.drink(0.1);
        assertEquals(lM.getVolume(), 0.9, 0.001);
        assertEquals(lM.getIngredients().get(2).getVolume(), 0.450, 0.001);
    }
    @Test
    @DisplayName("Testing Exception from drink function")
    void testDrinkWithException() {
        assertThrows(BringTheSpritzwineException.class, () -> lM.drink(1.1));
    }

    @Test
    @DisplayName("Testing ingredient adder")
    void testAddIngredient() {
        assertEquals(lM.getIngredients().size(), 3);
        lM.addIngredient(new Liquid("Cherryjuice", 0.2, 0));
        assertEquals(lM.getIngredients().size(), 4);
        assertEquals(lM.getIngredients().get(3).getName(), "Cherryjuice");
    }

    @Test
    @DisplayName("Testing ingredient remove")
    void testRemoveIngredient() {
        assertEquals(lM.getIngredients().size(), 3);
        assertEquals(lM.removeIngredient("Honey"), true);
        assertEquals(lM.getIngredients().size(), 2);
        assertEquals(lM.removeIngredient("Honey"), false);
    }
}