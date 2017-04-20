import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class ToTest2DArrayMove
{
	private static Item[][] gameBoard;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		Board.initialiseGameBoard();
	    Board.PlayerNumbers();		
		Board.chooseStartPostion();
		
		Board.refreshGameBoard2();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBoard()
	{
		// test 7 right
 		Board.moveItem2(1,"Right");
 		Board.moveItem2(1,"Right");
 		Board.moveItem2(1,"Right");
 		Board.moveItem2(1,"Right");
 		Board.moveItem2(1,"Right");
 		Board.moveItem2(1,"Right");
 		Board.moveItem2(1,"Right");
 		System.out.println("After Move test one");
	}
		
	@Test
	public void testBoard2()
	{
		// then one more right a collision player no move
		Board.moveItem2(1,"Right");
 		
 		System.out.println("After Move Test 2");
	}
	
	@Test
	public void testBoard3()
	{
		// then a collision wall no move
        Board.moveItem2(1,"Down"); 		
 		System.out.println("After Move Test 3");
		
	}
	
	@Test//
	public void testBoard4() 
	{
		// move out of bonds no move
        Board.moveItem2(1,"Up"); 		
 		System.out.println("After Move Test 4");
 		//gameBoard[0][9] = new Monster("M");
		
	}
	
}
