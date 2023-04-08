/**
 * A class which simulates a circuit with a lamp and two switches: number 1 and number 2.
 */
public class Circuit
{
    private String switchStates;

    /**
     * Constructs a circuit with two switches set to the off state, i.e., 0.
     */
    public Circuit ()
    {
        this.switchStates = "00";
    }

    /**
     * Gets the current state of the specified switch.
     * @param switchNum the number of the switch to get the current state of
     * @return the state of the specified switch
     */
    public int getSwitchState(int switchNum)
    {
        int switchState = Integer.parseInt(String.valueOf(switchStates.charAt(switchNum - 1)));
        return switchState;
    }

    /**
     * Gets the state of the lamp in the circuit.
     * @return the current state of the lamp in the circuit, 0 for off, 1 for on
     */
    public int getLampState()
    {
        int firstSwitchState = Integer.parseInt(String.valueOf(switchStates.charAt(0)));
        int secondSwitchState = Integer.parseInt(String.valueOf(switchStates.charAt(1)));
        int lampState = Math.max(firstSwitchState, secondSwitchState);
        return lampState;
    }

    /**
     * Toggles the specified switch in the circuit from on to off or vice versa.
     * @param switchNum the number of the switch to toggle the state of
     */
    public void toggleSwitch(int switchNum)
    {
        int indexOfToggleSwitch = switchNum - 1;
        int stateOfSwitchToToggleStateOf = Integer.parseInt(String.valueOf(switchStates.charAt(indexOfToggleSwitch)));
        String toggledSwitch = String.valueOf(Math.abs(stateOfSwitchToToggleStateOf - 1));
        this.switchStates = this.switchStates.substring(0, indexOfToggleSwitch).concat(toggledSwitch).concat(this.switchStates.substring(indexOfToggleSwitch + 1));
    }
}
