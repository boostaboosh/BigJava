public class StringExpressions
{
    public static void main(String[] args)
    {
        String s = "Hello";
        String t = "World";

        System.out.println(s.length() + t.length());
        System.out.println("Expected: 10");

        System.out.println(s.substring(1, 2));
        System.out.println("Expected: e");

        System.out.println(s.substring(s.length() / 2, s.length()));
        System.out.println("Expected: llo");

        System.out.println(s + t);
        System.out.println("Expected: HelloWorld");

        System.out.println(t + s);
        System.out.println("Expected: WorldHello");
    }
}
