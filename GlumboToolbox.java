public class GlumboToolbox {
    
    public static boolean matchStart(String s, String target) {
        return (s.substring(0, target.length()).toUpperCase().equals(target.toUpperCase()));
    }

    /**
     * Returns random int from min to max inclusive
     * @param min
     * @param max
     */
    public static int randInt(int min, int max){
        int range = max - min + 1;
        return (int) (Math.random() * range) + 1;

    }

    // Testing
    public static void main(String[] args) {
        System.out.println(randInt(1,4));
    }
}
