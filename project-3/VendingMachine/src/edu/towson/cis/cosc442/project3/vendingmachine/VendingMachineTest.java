/**
 * 
 */
package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class VendingMachineTest {

	VendingMachine myVendingMachine;
	VendingMachineItem candy;
	VendingMachineItem soda;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myVendingMachine = new VendingMachine();
		candy = new VendingMachineItem("candy", 2.99);
		soda = new VendingMachineItem("soda", 1.99);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * Testing adding valid item to vending machine
	 */
	@Test
	public void testAddItem() {
		myVendingMachine.addItem(candy, "A");

		assertEquals(candy, myVendingMachine.getItem("A"));
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * Testing adding item in already occupied slot
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItemSameSlot() {
		myVendingMachine.addItem(candy, "C");
		myVendingMachine.addItem(soda, "C");
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * Testing adding item in invalid slot
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItemInvalidSlot() {
		myVendingMachine.addItem(candy, "E");
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 * Testing removing item
	 */
	@Test
	public void testRemoveItem() {
		myVendingMachine.addItem(candy, "D");
		myVendingMachine.removeItem("D");
		assertNull(myVendingMachine.getItem("D"));
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 * Testing removing from a slot that is already empty
	 */
	@Test(expected = VendingMachineException.class)
	public void removeEmptySlot() {
		myVendingMachine.removeItem("A");
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#insertMoney(double)}.
	 * Testing inserting valid amount into vending machine
	 */
	@Test
	public void testInsertMoney() {
		myVendingMachine.insertMoney(5);

		assertEquals(5, myVendingMachine.getBalance(), 0.001);
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#insertMoney(double)}.
	 * Testing inserting an invalid amount of money
	 */
	@Test(expected = VendingMachineException.class)
	public void testInsertInvalidMoney() {
		myVendingMachine.insertMoney(0.5);
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#getBalance()}.
	 * Testing getBalance() method to return correct balance
	 */
	@Test
	public void testGetBalance() {
		assertEquals(0, myVendingMachine.getBalance(), 0.001);
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Testing if you can make a valid purchase
	 */
	@Test
	public void testMakePurchase() {
		myVendingMachine.addItem(candy, "A");
		myVendingMachine.insertMoney(3);
		assertTrue(myVendingMachine.makePurchase("A"));
	}
	
	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Making sure you cannot make a purchase with insufficient funds
	 */
	@Test
	public void testMakePurchaseInsufficientFunds() {
		myVendingMachine.addItem(candy, "A");
		myVendingMachine.insertMoney(1);
		assertTrue(myVendingMachine.makePurchase("A"));
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Making sure you cannot purchase from an empty slot
	 */
	@Test
	public void testPurchaseEmptySlot() {
		assertFalse(myVendingMachine.makePurchase("B"));
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Making sure you cannot purchase from an invalid slot
	 */
	@Test(expected = VendingMachineException.class)
	public void testPurchaseInvalidSlot() {
		myVendingMachine.makePurchase("E");
	}

	/**
	 * Test method for
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#returnChange()}.
	 * Making sure machine returns correct change
	 */
	@Test
	public void testReturnChange() {
		myVendingMachine.addItem(candy, "A");
		myVendingMachine.insertMoney(5);
		myVendingMachine.makePurchase("A");

		assertEquals(2.01, myVendingMachine.returnChange(), 0.001);
	}

}
