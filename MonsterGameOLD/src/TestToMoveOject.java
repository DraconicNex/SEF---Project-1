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
	int XCoord =0;
	int YCoord =0;
// hey Robbie push to branch master
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
	
	// Move down to gate -- move through gate
	
	
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
	
	// Move down to gate -- move through gate and back again
	
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

	@Test 
	public void test2DArray() throws outOfBoundsException
	{
		// Using 2D Array that returns X
		
		
		assertEquals(XCoord,0);
		assertEquals(YCoord,0);
		direction = "Down";
		XCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[0];
		YCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[1];
		assertEquals(XCoord,0);
		assertEquals(YCoord,1);
	}
	
	@Test (expected = outOfBoundsException.class)
	public void test2DArrayTwo() throws outOfBoundsException
	{
		// Out of Bounds Exception
		
		assertEquals(XCoord,0);
		assertEquals(YCoord,0);
		direction = "Up";
		
		XCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[0];
		YCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[1];
		
	}
	@Test 
	public void test2DArrayThree() throws outOfBoundsException
	{
		
		// Through the gate
		
		
		assertEquals(XCoord,0);
		assertEquals(YCoord,0);
		direction = "Down";
		XCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[0];
		YCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[1];
		assertEquals(XCoord,0);
		assertEquals(YCoord,1);
		XCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[0];
		YCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[1];
		XCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[0];
		YCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[1];
		XCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[0];
		YCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[1];
		direction ="Left";
		XCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[0];
		YCoord = MovableItem.moveItem2(XCoord, YCoord, direction, boardSize)[1];
		assertEquals(XCoord,9);
		assertEquals(YCoord,4);
	}

}
