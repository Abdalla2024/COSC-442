/**
 * 
 */
package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class VendingMachineItemTest {

	VendingMachineItem candy;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		candy = new VendingMachineItem("candy", 2.99);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 * Testing the constructor to make sure it gets correct values
	 */
	@Test
	public void testVendingMachineItem() {
		// test oracle
		assertEquals("candy", candy.getName());
		assertEquals(2.99, candy.getPrice(), 0.001);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getName()}.
	 * Testing that the getName method returns the correct name of the item
	 */
	@Test
	public void testGetName() {
		// test oracle
		assertEquals("candy", candy.getName());
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getPrice()}.
	 * Testing that getPrice gets the right price of the item
	 */
	@Test
	public void testGetPrice() {
		assertEquals(2.99, candy.getPrice(), 0.001);
	}

}
