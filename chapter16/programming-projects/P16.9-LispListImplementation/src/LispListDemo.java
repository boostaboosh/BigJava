public class LispListDemo
{
    public static void main(String[] args)
    {
        LispList list = LispList.NIL.cons("c").cons("b").cons("a");
        System.out.println(list);
    }
}
