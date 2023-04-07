/**
 * A class which simulates a circuit with a lamp and switches.
 */
public class Circuit
{
    private int firstSwitchState;
    private int secondSwitchState;

    public Circuit ()
    {
        firstSwitchState = 0;
        secondSwitchState = 0;
    }

    /**
     * Gets the current state of the first switch.
     * @return the current state of the first switch: 0 for down, 1 for up
     */
    public int getFirstSwitchState()
    {
        return this.firstSwitchState;
    }

    /**
     * Gets the state of the second switch.
     * @return the current state of the second switch: 0 for down, 1 for up
     */
    public int getSecondSwitchState()
    {
        return this.secondSwitchState;
    }

    /**
     * Gets the state of the lamp in the circuit.
     * @return the current state of the lamp in the circuit, 0 for off, 1 for on
     */
    public int getLampState()
    {
        int lampState = Math.max( this.firstSwitchState, this.secondSwitchState );
        return lampState;
    }

    /**
     * Toggles the first switch in the circuit from on to off or vice versa.
     */
    public void toggleFirstSwitch()
    {
        int currentState = this.getFirstSwitchState();
        int oppositeState = Math.abs( currentState - 1 );
        firstSwitchState = oppositeState;
    }

    /**
     * Toggles the second switch in the circuit from on to off or vice versa.
     */
    public void toggleSecondSwitch()
    {
        int currentState = this.getSecondSwitchState();
        int oppositeState = Math.abs( currentState - 1);
        secondSwitchState = oppositeState;
    }
}
