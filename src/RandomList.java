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

    public int[] randoms;
    private final Random rand;

    public RandomList(long seed) {
    	randoms = new int[1000];
        this.rand = new Random(seed);
    	randomFill();
    }

    public final void randomFill() {
    	for (int i=0; i<randoms.length; i++) {
            int randomNum = rand.nextInt(1000000);
            randoms[i] = randomNum;
    	}
    }

    public int getCount() {
    	return randoms.length;
    }

    public int getRandom(int i) {
    	return randoms[i];
    }

    public void print(){
        for(int n: randoms){
            System.out.println(n+" ");
        }
    }
}