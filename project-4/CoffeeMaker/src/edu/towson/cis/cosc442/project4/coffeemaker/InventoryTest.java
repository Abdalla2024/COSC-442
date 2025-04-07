package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 * Test class for Inventory
 */
public class InventoryTest extends TestCase {
    private Inventory inventory;
    private Recipe recipe;
    private Recipe recipe2;

    public void setUp() {
        inventory = new Inventory();
        recipe = new Recipe();
        recipe2 = new Recipe();
    }

    public void testGetChocolate() {
        assertEquals(15, inventory.getChocolate());
    }

    public void testSetChocolate() {
        inventory.setChocolate(20);
        assertEquals(20, inventory.getChocolate());
    }

    public void testSetChocolateNegative() {
        inventory.setChocolate(-1);
        assertEquals(15, inventory.getChocolate());
    }

    public void testSetChocolateZero() {
        inventory.setChocolate(0);
        assertEquals(0, inventory.getChocolate());
    }

    public void testGetCoffee() {
        assertEquals(15, inventory.getCoffee());
    }

    public void testSetCoffee() {
        inventory.setCoffee(20);
        assertEquals(20, inventory.getCoffee());
    }

    public void testSetCoffeeNegative() {
        inventory.setCoffee(-1);
        assertEquals(15, inventory.getCoffee());
    }

    public void testSetCoffeeZero() {
        inventory.setCoffee(0);
        assertEquals(0, inventory.getCoffee());
    }

    public void testGetMilk() {
        assertEquals(15, inventory.getMilk());
    }

    public void testSetMilk() {
        inventory.setMilk(20);
        assertEquals(20, inventory.getMilk());
    }

    public void testSetMilkNegative() {
        inventory.setMilk(-1);
        assertEquals(15, inventory.getMilk());
    }

    public void testSetMilkZero() {
        inventory.setMilk(0);
        assertEquals(0, inventory.getMilk());
    }

    public void testGetSugar() {
        assertEquals(15, inventory.getSugar());
    }

    public void testSetSugar() {
        inventory.setSugar(20);
        assertEquals(20, inventory.getSugar());
    }

    public void testSetSugarNegative() {
        inventory.setSugar(-1);
        assertEquals(15, inventory.getSugar());
    }

    public void testSetSugarZero() {
        inventory.setSugar(0);
        assertEquals(0, inventory.getSugar());
    }

    public void testEnoughIngredients() {
        recipe.setAmtCoffee(5);
        recipe.setAmtMilk(5);
        recipe.setAmtSugar(5);
        recipe.setAmtChocolate(5);
        assertTrue(inventory.enoughIngredients(recipe));
    }

    public void testNotEnoughCoffee() {
        recipe.setAmtCoffee(20);
        recipe.setAmtMilk(5);
        recipe.setAmtSugar(5);
        recipe.setAmtChocolate(5);
        assertFalse(inventory.enoughIngredients(recipe));
    }

    public void testNotEnoughMilk() {
        recipe.setAmtCoffee(5);
        recipe.setAmtMilk(20);
        recipe.setAmtSugar(5);
        recipe.setAmtChocolate(5);
        assertFalse(inventory.enoughIngredients(recipe));
    }

    public void testNotEnoughSugar() {
        recipe.setAmtCoffee(5);
        recipe.setAmtMilk(5);
        recipe.setAmtSugar(20);
        recipe.setAmtChocolate(5);
        assertFalse(inventory.enoughIngredients(recipe));
    }

    public void testNotEnoughChocolate() {
        recipe.setAmtCoffee(5);
        recipe.setAmtMilk(5);
        recipe.setAmtSugar(5);
        recipe.setAmtChocolate(20);
        assertFalse(inventory.enoughIngredients(recipe));
    }

    public void testEnoughIngredientsNullRecipe() {
        assertFalse(inventory.enoughIngredients(null));
    }

    public void testEnoughIngredientsExactAmounts() {
        recipe.setAmtCoffee(15);
        recipe.setAmtMilk(15);
        recipe.setAmtSugar(15);
        recipe.setAmtChocolate(15);
        assertTrue(inventory.enoughIngredients(recipe));
    }

    public void testEnoughIngredientsZeroAmounts() {
        recipe.setAmtCoffee(0);
        recipe.setAmtMilk(0);
        recipe.setAmtSugar(0);
        recipe.setAmtChocolate(0);
        assertTrue(inventory.enoughIngredients(recipe));
    }

    public void testEnoughIngredientsMultipleRecipes() {
        recipe.setAmtCoffee(5);
        recipe.setAmtMilk(5);
        recipe.setAmtSugar(5);
        recipe.setAmtChocolate(5);
        recipe2.setAmtCoffee(10);
        recipe2.setAmtMilk(10);
        recipe2.setAmtSugar(10);
        recipe2.setAmtChocolate(10);
        assertTrue(inventory.enoughIngredients(recipe));
        assertTrue(inventory.enoughIngredients(recipe2));
    }

    public void testToString() {
        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(expected, inventory.toString());
    }

    public void testToStringAfterModification() {
        inventory.setCoffee(10);
        inventory.setMilk(20);
        inventory.setSugar(30);
        inventory.setChocolate(40);
        String expected = "Coffee: 10\nMilk: 20\nSugar: 30\nChocolate: 40\n";
        assertEquals(expected, inventory.toString());
    }
}