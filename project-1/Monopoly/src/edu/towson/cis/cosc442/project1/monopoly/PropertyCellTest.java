
package edu.towson.cis.cosc442.project1.monopoly;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyCellTest.
 */
public class PropertyCellTest extends TestCase {

	/** The game master. */
	GameMaster gameMaster;
	
	/**
	 * Sets the up.
	 */
	protected void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new SimpleGameBoard());
		gameMaster.setNumberOfPlayers(2);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
	}
	
	/**
	 * Test player action.
	 */
	public void testPlayerAction() {
		PropertyCell cell =
			(PropertyCell) gameMaster.getGameBoard().queryCell("Blue 3");
		int cellIndex = gameMaster.getGameBoard().queryCellIndex("Blue 3");
		gameMaster.movePlayer(0, cellIndex);
		gameMaster.getPlayer(0).purchase();
		gameMaster.switchTurn();
		gameMaster.movePlayer(1, cellIndex);
		cell.playAction("");
		assertEquals(
				1500 - cell.getRent(),
				gameMaster.getPlayer(1).getMoney());
		assertEquals(
				1380 + cell.getRent(),
				gameMaster.getPlayer(0).getMoney());
	}
}
