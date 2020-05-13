# 20-Abgabe01-Suekar-Heiling A repository to manage Konfig Assignment.  

## Description:        
This is a Project focused about different Drinks. The base structure consists of the 3 Java classes `Drink.java`, `Liquid.java` and `SimpleDrink.java` which is extended from `Drink.java`. From the Testing side of things there is already the `LiquidTest.java` class given. 
The purpose of this Project is to practice the handling with git, writing useful JavaDoc and testing with JUnit5.

## Contributors:
* Michael Sükar
* Marco Heiling

## Planned Extension: 
`Mead.java` extends the class `SimpleDrink.java`. It will use a Collection to vary the flavours.
For example if you mix mead with water it will have a health promoting
effect. The class will contain a method `drink()`. This methods let you drink the Drink,
until it's empty. In case there is nothing left to drink it will throw an execption.
(`BringTheSpritzwineException`).

As Michael Häupl said:
> "Man bringe den Spritzwein!"
    
## Relevant Code Sniped:  
```java
    public void drink(double sipAmount) {
        double totalVolume = getVolume();

        if(totalVolume < sipAmount) {
            throw new BringTheSpritzwineException("Too little Volume left!");
        }

        for (Liquid ingredient : ingredients) {
            ingredient.setVolume(ingredient.getVolume() - (ingredient.getVolume()/totalVolume * sipAmount));
        }
    }
```

## Tests with JUNIT

### Test of `Mead.java` with `MeadTest.java`
`MeadTest.java`tests all functions and Constructor from `Mead.java`. To reach
the 100% test coverage we started with the `testConstructor()` to check if the
setup is correct. After that we move on to test all getter/setter. At least but not
last we checked the given/selfmade functions. Through out the check the selfmade 
(BringTheSpritzwineException) is also thrown and checked in `testDrinkWithException()`


### Test of `SimpleDrink.java` with `SimpleDrinkTest.java`
This test file is very similiar to the `LiquidTest.java`, since an instance
of `SimpleDrink.java` has only one variable, which is an instance of `Liquid.java`
So since in `Liquid.java` most of the functionallity is tested, we just tested
the `isAlcoholic()` function. 