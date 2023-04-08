/**
 * A class for testing the Circuit class.
 */
public class CircuitTester
{
    public static void main(String[] args)
    {
        Circuit myCircuit = new Circuit();

        // switch 1 = 0, s2 = 0
        System.out.println("switch 1: " + myCircuit.getSwitchState(1));
        System.out.println("expected: 0");
        System.out.println("switch 2: " + myCircuit.getSwitchState(2));
        System.out.println("expected: 0");
        System.out.println("lamp state: " + myCircuit.getLampState());
        System.out.println("expected: 0\n");

        // s1 = 1; s2 = 0
        myCircuit.toggleSwitch(1);
        System.out.println("switch 1: " + myCircuit.getSwitchState(1));
        System.out.println("expected: 1");
        System.out.println("lamp state: " + myCircuit.getLampState());
        System.out.println("expected: 1\n");

        // s1 = 1; s2 = 1
        myCircuit.toggleSwitch(2);
        System.out.println("switch 2: " + myCircuit.getSwitchState(2));
        System.out.println("expected: 1");
        System.out.println("lamp state: " + myCircuit.getLampState());
        System.out.println("expected: 1\n");

        // s1 = 0; s2 = 1
        myCircuit.toggleSwitch(1);
        System.out.println("switch 1: " + myCircuit.getSwitchState(1));
        System.out.println("expected: 0");
        System.out.println("lamp state: " + myCircuit.getLampState());
        System.out.println("expected: 1\n");
    }
}
