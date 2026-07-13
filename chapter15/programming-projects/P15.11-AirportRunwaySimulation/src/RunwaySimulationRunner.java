import java.io.IOException;
import java.util.Scanner;

public class RunwaySimulationRunner
{
    public static void main(String[] args)
    {
        showUserCommands();
        Scanner inputReader = new Scanner(System.in);

        Simulation simulation = new RunwaySimulation();
        boolean runningSimulation = true;
        while (runningSimulation)
        {
            try
            {
                SimulationCommand command = getCommand(inputReader); // takeoff a, land a, next, quit
                if (command.command == Command.QUIT)
                {
                    runningSimulation = false;
                    continue;
                }
                executeCommand(simulation, command);
            } catch (IOException ex)
            {
                System.out.println("invalid input");
            }
        }

    }

    private static void showUserCommands()
    {
        System.out.println("Airport runway simulation commands:");
        System.out.println("takeoff flightSymbol (e.g. takeoff FR123)"
                + "\nland flightSymbol (e.g. land BA352)"
                + "\nnext"
                + "\nquit");
    }

    private static SimulationCommand getCommand(Scanner inputReader) throws IOException
    {
        System.out.println("Enter airport runway simulation command: ");
        String input = inputReader.nextLine().trim();
        if (input.equalsIgnoreCase("quit")) return new SimulationCommand(Command.QUIT);
        if (input.equalsIgnoreCase("next")) return new SimulationCommand(Command.NEXT);
        if (input.startsWith("land")) {
            return new SimulationCommand(Command.LAND, getFlightSymbol(input));
        }
        if (input.startsWith("takeoff")) {
            return new SimulationCommand(Command.TAKEOFF, getFlightSymbol(input));
        }
        throw new IOException("Unexpected runway simulation command inputted");
    }

    private static class SimulationCommand
    {
        private final Command command;
        private final String flightSymbol;

        public SimulationCommand(Command command)
        {
            this.command = command;
            flightSymbol = null;
        }

        public SimulationCommand(Command command, String symbol)
        {
            this.command = command;
            this.flightSymbol = symbol;
        }

        public Command getSimulationCommand()
        {
            return command;
        }

        public String getFlightSymbol()
        {
            return flightSymbol;
        }
    }

    private enum Command {
        TAKEOFF,
        LAND,
        NEXT,
        QUIT,
    }

    private static String getFlightSymbol(String input) throws IOException
    {
        String[] words = input.split("\\s+");
        if (words.length != 2)
        {
            throw new IOException("Input command isn't 2 tokens long");
        }
        return words[1];
    }

    private static void executeCommand(Simulation simulation, SimulationCommand command)
    {
        // todo
    }
}
