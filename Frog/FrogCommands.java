package Frog;

public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        FrogCommand command = new FrogCommand() {
            @Override
            public boolean doit() {
                    frog.position = frog.position + steps;
                    return true;
            }

            @Override
            public boolean undo() {
                    frog.position = frog.position - steps;
                return true;
            }
        };

        return command;
        // возвращаете объект команды, у которого
        // если вызвать .doit(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
    }
}
