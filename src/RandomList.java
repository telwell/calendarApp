import java.util.Random;

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