import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class moveMonsterUpDownTest {

	Monster monster = new Monster(5,5);
	
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
	public void tearDown() throws Exception {
	}

	@Test
	public void test() 

	{
		assertEquals(5,monster.getX());
		
		monster.moveItem("Down");
		assertEquals(6,monster.getX());
		System.out.println(monster.getX());
		
		monster.moveItem("Down");
		assertEquals(7,monster.getX());
		System.out.println(monster.getX());
		
		monster.moveItem("Up");
		assertEquals(6,monster.getX());
		System.out.println(monster.getX());
	}

}
