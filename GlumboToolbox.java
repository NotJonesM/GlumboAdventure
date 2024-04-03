public class GlumboToolbox {
    public static boolean matchStart(String s, String target) {
        return (s.substring(0, target.length()).toUpperCase().equals(target.toUpperCase()));
    }
}
