import java.util.Random;

/**
 * Generate an array of Random
 * numbers which we'll use to test
 * our application. 
 * TODO: Right now this just builds 
 * an array of 1_000 random ints, we
 * should convert this to a CONST in 
 * the next version.
 * 
 * @author David McLellan
 * @author Trevor Elwell
 * @version 12 April 2016
 */

public class RandomList {

    public static int[] randoms;

    public RandomList() {
    	randoms = new int[1000];
    	randomFill();
    }

    public static void randomFill() {
    	for (int i=0; i<randoms.length; i++) {
    		Random rand = new Random();
		    int randomNum = rand.nextInt(1000000);
		    randoms[i] = randomNum;
    	}
    }

    public static int getCount() {
    	return randoms.length;
    }

    public static int getRandom(int i) {
    	return randoms[i];
    }

    public static void print(){
			for(int n: randoms){
				System.out.println(n+" ");
			}
    }

    public static void main( String[] args ) {
    }
}