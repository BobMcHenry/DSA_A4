package ad325.test.data_structures;

import org.junit.*;
import org.junit.Assert.*;
import ad325.data_structures.*;

public class PQUnitTest{

    PrioritizedWords spq;

	@Before
	public void setUp() throws Exception {
        spq = new PrioritizedWords();
        spq.add("1", 1);
        //System.out.println(spq);
        spq.add("2", 2);
        //System.out.println(spq);
        spq.add("-1", -1);
        //System.out.println(spq);
        spq.add("4", 4);
        //System.out.println(spq);
        spq.add("5", 5);
        //System.out.println(spq);
        spq.add("-8", -8);
        //System.out.println(spq);
        spq.add("9", 9);
        //System.out.println(spq);
        spq.add("3", 3);
        //System.out.println(spq);
        spq.add("-16", -16);
        //System.out.println(spq);
        spq.add("6", 6);
        //System.out.println(spq);
        spq.add("7", 7);
        //System.out.println(spq);
        spq.add("8", 8);
        //System.out.println(spq);
        spq.add("50", 50);
        //System.out.println(spq);
        spq.add("-24", -24);
        //System.out.println(spq);
        spq.add("-4", -4);
        //System.out.println(spq);
        spq.add("11", 11);
        //System.out.println(spq);
        spq.add("23", 23);
        //System.out.println(spq);
        spq.add("64", 64);
        //System.out.println(spq);
        spq.add("20", 20);
        //System.out.println(spq);
        spq.add("-14", -14);
        //System.out.println(spq);
        spq.add("-8", -8);
        //System.out.println(spq);
        spq.add("4", 4);
        //System.out.println(spq);
        spq.add("5", 5);
        //System.out.println(spq);
        spq.add("-8", -8);
        //System.out.println(spq);

        spq.add("100", 100);
        spq.add("101", 101);
        while (spq.size() >= 1){
            System.out.println("Size: " + spq.size() + " : Removing " + spq.remove());

            if (spq.size() == 8){
                //System.out.println("Break here for debugging");

               // System.out.println("Remaining structure: \n" + spq);
            }
        }
    }

    @Test
    public void test1(){
        //Assert.assertTrue(spq.peek().equals("-24"));
    }

}