package draw1;
import static org.junit.Assert.*;


import org.junit.Test;
import junit.framework.TestCase;


public class RectanlgeShapeTest extends TestCase  {


	@Test
	  public void testrect() {
      CircleShape testShape = new CircleShape();
      testShape.setEnds(25,35, 45, 50);
      assertEquals(25, testShape.x1);
      assertEquals(45, testShape.x2);
      assertEquals(35, testShape.y1);
      assertEquals(50, testShape.y2);
		  }

	@Test
	  public void testTria() {
    TriangleShape testShape1 = new TriangleShape();
    testShape1.setEnds(25,35, 45, 50);
    assertEquals(25, testShape1.x1);
    assertEquals(45, testShape1.x2);
    assertEquals(35, testShape1.y1);
    assertEquals(50, testShape1.y2);
		  }
	
	
}
