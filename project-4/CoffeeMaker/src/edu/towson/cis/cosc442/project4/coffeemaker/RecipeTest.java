package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 * Test class for Recipe
 */
public class RecipeTest extends TestCase {
    private Recipe recipe;
    private Recipe recipe2;

    public void setUp() {
        recipe = new Recipe();
        recipe2 = new Recipe();
    }

    public void testGetAmtChocolate() {
        assertEquals(0, recipe.getAmtChocolate());
    }

    public void testSetAmtChocolate() {
        recipe.setAmtChocolate(5);
        assertEquals(5, recipe.getAmtChocolate());
    }

    public void testSetAmtChocolateNegative() {
        recipe.setAmtChocolate(-1);
        assertEquals(0, recipe.getAmtChocolate());
    }

    public void testSetAmtChocolateZero() {
        recipe.setAmtChocolate(0);
        assertEquals(0, recipe.getAmtChocolate());
    }

    public void testGetAmtCoffee() {
        assertEquals(0, recipe.getAmtCoffee());
    }

    public void testSetAmtCoffee() {
        recipe.setAmtCoffee(5);
        assertEquals(5, recipe.getAmtCoffee());
    }

    public void testSetAmtCoffeeNegative() {
        recipe.setAmtCoffee(-1);
        assertEquals(0, recipe.getAmtCoffee());
    }

    public void testSetAmtCoffeeZero() {
        recipe.setAmtCoffee(0);
        assertEquals(0, recipe.getAmtCoffee());
    }

    public void testGetAmtMilk() {
        assertEquals(0, recipe.getAmtMilk());
    }

    public void testSetAmtMilk() {
        recipe.setAmtMilk(5);
        assertEquals(5, recipe.getAmtMilk());
    }

    public void testSetAmtMilkNegative() {
        recipe.setAmtMilk(-1);
        assertEquals(0, recipe.getAmtMilk());
    }

    public void testSetAmtMilkZero() {
        recipe.setAmtMilk(0);
        assertEquals(0, recipe.getAmtMilk());
    }

    public void testGetAmtSugar() {
        assertEquals(0, recipe.getAmtSugar());
    }

    public void testSetAmtSugar() {
        recipe.setAmtSugar(5);
        assertEquals(5, recipe.getAmtSugar());
    }

    public void testSetAmtSugarNegative() {
        recipe.setAmtSugar(-1);
        assertEquals(0, recipe.getAmtSugar());
    }

    public void testSetAmtSugarZero() {
        recipe.setAmtSugar(0);
        assertEquals(0, recipe.getAmtSugar());
    }

    public void testGetName() {
        assertNull(recipe.getName());
    }

    public void testSetName() {
        recipe.setName("Test Recipe");
        assertEquals("Test Recipe", recipe.getName());
    }

    public void testSetNameNull() {
        recipe.setName(null);
        assertNull(recipe.getName());
    }

    public void testGetPrice() {
        assertEquals(0, recipe.getPrice());
    }

    public void testSetPrice() {
        recipe.setPrice(5);
        assertEquals(5, recipe.getPrice());
    }

    public void testSetPriceNegative() {
        recipe.setPrice(-1);
        assertEquals(0, recipe.getPrice());
    }

    public void testSetPriceZero() {
        recipe.setPrice(0);
        assertEquals(0, recipe.getPrice());
    }

    public void testEqualsNull() {
        assertFalse(recipe.equals(null));
    }

    public void testEqualsSameObject() {
        assertTrue(recipe.equals(recipe));
    }

    public void testEqualsDifferentClass() {
        assertFalse(recipe.equals(new Object()));
    }

    public void testEqualsBothNamesNull() {
        assertTrue(recipe.equals(recipe2));
    }

    public void testEqualsOneNameNull() {
        recipe.setName("Test");
        assertFalse(recipe.equals(recipe2));
    }

    public void testEqualsDifferentNames() {
        recipe.setName("Test1");
        recipe2.setName("Test2");
        assertFalse(recipe.equals(recipe2));
    }

    public void testEqualsSameNames() {
        recipe.setName("Test");
        recipe2.setName("Test");
        assertTrue(recipe.equals(recipe2));
    }

    public void testToString() {
        recipe.setName("Test Recipe");
        assertEquals("Test Recipe", recipe.toString());
    }

    public void testToStringNullName() {
        assertEquals("", recipe.toString());
    }
}