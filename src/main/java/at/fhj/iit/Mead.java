package at.fhj.iit;

import java.util.List;

/**
 * Class for instancing the Drink Mead extends Drink.
 */
public class Mead extends Drink{

    //----------------------------------------------------------------Attributes
    /**
     * list of ingredients of the Mead
     */
    private List<Liquid> ingredients;

    //---------------------------------------------------------------Constructor
    /**
     * Creates a Mead object with given name and given ingredients list.
     *
     * @param name name of the drink
     * @param ingredients list of ingredients
     *
     */
    public Mead(String name, List<Liquid> ingredients) {
        super(name);
        this.ingredients = ingredients;
    }

    //--------------------------------------------------------------------Getter
    /**
     * Getter for ingredients
     *
     * @return list of ingredients
     */
    public List<Liquid> getIngredients() {
        return ingredients;
    }

    //--------------------------------------------------------------------Setter
    /**
     * Setter for ingredients
     *
     * @param ingredients list with ingredients
     */
    public void setIngredients(List<Liquid> ingredients) {
        this.ingredients = ingredients;
    }

    //-------------------------------------------------------------------Methods
    /**
     * Calculates and returns volume of drink
     *
     * @return the volume of drink in liter
     */
    @Override
    public double getVolume() {
        double volume = 0;
        for (Liquid ingredient : ingredients) {
            volume += ingredient.getVolume();
        }
        return volume;
    }

    /**
     * Calculates and returns the alcohol percentage
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {
        double totalVolume = getVolume();
        double alcPercentage = 0;
        for (Liquid ingredient : ingredients) {
            alcPercentage += ingredient.getVolume()/totalVolume * ingredient.getAlcoholPercent();
        }
        return alcPercentage;
    }

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() > 0;
    }

    /**
     * A function to drink the Mead
     * throws BringTheSpritzwineException if Drink is empty.
     *
     * @param sipAmount the amount you want to drink with one sip in liter.
     *
     */
    public void drink(double sipAmount) {
        double totalVolume = getVolume();

        if(totalVolume < sipAmount) {
            throw new BringTheSpritzwineException("Too little Volume left!");
        }

        for (Liquid ingredient : ingredients) {
            ingredient.setVolume(ingredient.getVolume() - (ingredient.getVolume()/totalVolume * sipAmount));
        }
    }

    /**
     * Function to add an Ingredient to the mead
     * @param l liquid to add
     */
    public void addIngredient(Liquid l) {
        ingredients.add(l);
    }

    /**
     * Function to remove an Ingredient to the mead
     * @param l Liquid to remove
     * @return successful
     */
    public boolean removeIngredient(Liquid l) {
        return ingredients.remove(l);
    }
}
