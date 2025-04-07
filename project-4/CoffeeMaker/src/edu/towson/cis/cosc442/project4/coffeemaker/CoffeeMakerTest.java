package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 * Test class for CoffeeMaker
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Recipe r5;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		// Setup first recipe
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);

		// Setup second recipe
		r2 = new Recipe();
		r2.setName("Latte");
		r2.setPrice(75);
		r2.setAmtCoffee(8);
		r2.setAmtMilk(2);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(0);

		// Setup third recipe
		r3 = new Recipe();
		r3.setName("Mocha");
		r3.setPrice(100);
		r3.setAmtCoffee(8);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(2);

		// Setup fourth recipe
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setPrice(75);
		r4.setAmtCoffee(0);
		r4.setAmtMilk(2);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(3);

		// Setup fifth recipe (for testing max capacity)
		r5 = new Recipe();
		r5.setName("Extra");
		r5.setPrice(50);
		r5.setAmtCoffee(6);
		r5.setAmtMilk(1);
		r5.setAmtSugar(1);
		r5.setAmtChocolate(0);
	}

	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}

	public void testAddRecipe2() {
		cm.addRecipe(r1);
		assertFalse(cm.addRecipe(r1)); // Test adding duplicate recipe
	}

	public void testAddRecipe3() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		assertFalse(cm.addRecipe(r5)); // Test adding when full
	}

	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	public void testDeleteRecipe2() {
		assertFalse(cm.deleteRecipe(null)); // Test deleting null recipe
	}

	public void testDeleteRecipe3() {
		assertFalse(cm.deleteRecipe(r1)); // Test deleting non-existent recipe
	}

	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}

	public void testEditRecipe2() {
		assertFalse(cm.editRecipe(r1, r2)); // Test editing non-existent recipe
	}

	public void testEditRecipe3() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		assertFalse(cm.editRecipe(r1, r2)); // Test editing with duplicate recipe
	}

	public void testAddInventory1() {
		assertTrue(cm.addInventory(5, 5, 5, 5));
	}

	public void testAddInventory2() {
		assertFalse(cm.addInventory(-1, 5, 5, 5)); // Test negative coffee
	}

	public void testAddInventory3() {
		assertFalse(cm.addInventory(5, -1, 5, 5)); // Test negative milk
	}

	public void testAddInventory4() {
		assertFalse(cm.addInventory(5, 5, -1, 5)); // Test negative sugar
	}

	public void testAddInventory5() {
		assertFalse(cm.addInventory(5, 5, 5, -1)); // Test negative chocolate
	}

	public void testMakeCoffee1() {
		cm.addRecipe(r1);
		cm.addInventory(10, 10, 10, 10);
		assertEquals(0, cm.makeCoffee(r1, 50)); // Test exact payment
	}

	public void testMakeCoffee2() {
		cm.addRecipe(r1);
		cm.addInventory(10, 10, 10, 10);
		assertEquals(50, cm.makeCoffee(r1, 25)); // Test insufficient payment
	}

	public void testMakeCoffee3() {
		cm.addRecipe(r1);
		cm.addInventory(10, 10, 10, 10);
		assertEquals(25, cm.makeCoffee(r1, 75)); // Test excess payment
	}

	public void testMakeCoffee4() {
		cm.addRecipe(r1);
		// Reset inventory to 0
		Inventory inv = cm.checkInventory();
		inv.setCoffee(0);
		inv.setMilk(0);
		inv.setSugar(0);
		inv.setChocolate(0);
		// Add just 5 units of each
		cm.addInventory(5, 5, 5, 5);
		assertEquals(50, cm.makeCoffee(r1, 50)); // Test insufficient inventory
	}

	public void testMakeCoffee5() {
		cm.addRecipe(r1);
		// Reset inventory to 0
		Inventory inv = cm.checkInventory();
		inv.setCoffee(0);
		inv.setMilk(0);
		inv.setSugar(0);
		inv.setChocolate(0);
		// Add just enough for one coffee
		cm.addInventory(6, 1, 1, 0);
		assertEquals(0, cm.makeCoffee(r1, 50)); // Test exact inventory
	}

	public void testMakeCoffee6() {
		cm.addRecipe(r1);
		// Reset inventory to 0
		Inventory inv = cm.checkInventory();
		inv.setCoffee(0);
		inv.setMilk(0);
		inv.setSugar(0);
		inv.setChocolate(0);
		// Add more than enough
		cm.addInventory(10, 10, 10, 10);
		assertEquals(25, cm.makeCoffee(r1, 75)); // Test excess payment with sufficient inventory
	}

	public void testMakeCoffee7() {
		cm.addRecipe(r1);
		// Reset inventory to 0
		Inventory inv = cm.checkInventory();
		inv.setCoffee(0);
		inv.setMilk(0);
		inv.setSugar(0);
		inv.setChocolate(0);
		// Add just enough for one coffee
		cm.addInventory(6, 1, 1, 0);
		assertEquals(50, cm.makeCoffee(r1, 25)); // Test insufficient payment with exact inventory
	}

	public void testMakeCoffee8() {
		cm.addRecipe(r1);
		// Reset inventory to 0
		Inventory inv = cm.checkInventory();
		inv.setCoffee(0);
		inv.setMilk(0);
		inv.setSugar(0);
		inv.setChocolate(0);
		// Add just enough for one coffee
		cm.addInventory(6, 1, 1, 0);
		// Make one coffee
		cm.makeCoffee(r1, 50);
		// Try to make another coffee
		assertEquals(50, cm.makeCoffee(r1, 50)); // Test insufficient inventory after making coffee
	}

	public void testMakeCoffeeNullRecipe() {
		assertEquals(50, cm.makeCoffee(null, 50)); // Test null recipe
	}

	public void testAddRecipeNull() {
		assertFalse(cm.addRecipe(null)); // Test adding null recipe
	}

	public void testEditRecipeNull() {
		assertFalse(cm.editRecipe(null, r1)); // Test editing with null old recipe
		assertFalse(cm.editRecipe(r1, null)); // Test editing with null new recipe
	}

	public void testGetRecipeForNameNull() {
		Recipe r = cm.getRecipeForName(null);
		assertNull(r.getName()); // Test getting recipe with null name
	}

	public void testGetRecipeForNameEmpty() {
		Recipe r = cm.getRecipeForName("");
		assertNull(r.getName()); // Test getting recipe with empty name
	}

	public void testAddInventoryZero() {
		assertTrue(cm.addInventory(0, 0, 0, 0)); // Test adding zero inventory
	}

	public void testAddInventoryMax() {
		assertTrue(cm.addInventory(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
	}

	public void testAddInventoryMixed() {
		assertTrue(cm.addInventory(1, 0, 0, 0)); // Test adding mixed inventory
		assertTrue(cm.addInventory(0, 1, 0, 0));
		assertTrue(cm.addInventory(0, 0, 1, 0));
		assertTrue(cm.addInventory(0, 0, 0, 1));
	}

	public void testGetRecipes() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		Recipe[] recipes = cm.getRecipes();
		assertEquals("Coffee", recipes[0].getName());
		assertEquals("Latte", recipes[1].getName());
	}

	public void testGetRecipeForName1() {
		cm.addRecipe(r1);
		Recipe r = cm.getRecipeForName("Coffee");
		assertEquals("Coffee", r.getName());
	}

	public void testGetRecipeForName2() {
		Recipe r = cm.getRecipeForName("NonExistent");
		assertNull(r.getName()); // Test non-existent recipe
	}

	public void testCheckInventory() {
		Inventory inv = cm.checkInventory();
		assertNotNull(inv);
	}
}