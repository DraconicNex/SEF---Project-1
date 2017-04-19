import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestToMoveOject 
{
	
	Player tempPlayer = new Player("A");
	Square objectSquare = new Square(1,1,tempPlayer);
	int boardSize =9;
	String direction;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception 
	{
		
		
		
	}
	

	@After
	public void tearDown()  
	{
	}	

	@Test (expected = outOfBoundsException.class)
	public void test() throws outOfBoundsException
	{
		assertEquals(objectSquare.getX(),1);
		assertEquals(objectSquare.getY(),1);
		direction = "Up";
		MovableItem.moveItem(direction, objectSquare, boardSize);
	}

	@Test 
	public void test1() throws outOfBoundsException
	{
		assertEquals(objectSquare.getX(),1);
		assertEquals(objectSquare.getY(),1);
		direction = "Down";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		assertEquals(objectSquare.getX(),1);
		assertEquals(objectSquare.getY(),2);
	}
	
	@Test 
	public void testGate() throws outOfBoundsException
	{
		assertEquals(objectSquare.getX(),1);
		assertEquals(objectSquare.getY(),1);
		direction = "Down";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		direction = "Down";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		direction = "Down";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		direction = "Down";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		direction = "Left";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		assertEquals(objectSquare.getX(),9);
		assertEquals(objectSquare.getY(),5);
	}
	
	
	@Test 
	public void testGate2() throws outOfBoundsException
	{
		assertEquals(objectSquare.getX(),1);
		assertEquals(objectSquare.getY(),1);
		direction = "Down";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		direction = "Down";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		direction = "Down";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		direction = "Down";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		direction = "Left";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		direction = "Right";
		MovableItem.moveItem(direction, objectSquare, boardSize);
		assertEquals(objectSquare.getX(),1);
		assertEquals(objectSquare.getY(),5);
	}


}
