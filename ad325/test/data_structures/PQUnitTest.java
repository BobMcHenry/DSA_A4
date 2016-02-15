package ad325.test.data_structures;

import org.junit.*;
import ad325.data_structures.*;

public class PQUnitTest{

    PrioritizedWords spq;

	@Before
	public void setUp() throws Exception {
        spq = new PrioritizedWords();
	}

	@Test
	public void testGetParent(){

        for (int i = 2; i < 100; i++){
            System.out.println(i + " child of " + spq.getParentIndex(i));
        }

    }
	

}