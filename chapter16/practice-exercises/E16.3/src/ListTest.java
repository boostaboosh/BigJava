public class ListTest
{
    public static void main(String[] args)
    {
        LinkedList staff = new LinkedList();
        staff.addFirst("Tom");
        staff.addFirst("Romeo"); // Romeo -> Tom -> null
        ListIterator iterator = staff.listIterator();
        boolean hasNext = iterator.hasNext();
        String output = "";
        if (!hasNext) { output = "Error. Doesn't have next but should."; }
        else { output = "Success. Has next."; }
        System.out.println(output);
    }
}
