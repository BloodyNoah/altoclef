package adris.altoclef.commands;

import adris.altoclef.AltoClef;
import adris.altoclef.commandsystem.ArgParser;
import adris.altoclef.commandsystem.Command;
import adris.altoclef.commandsystem.CommandException;

public class tutorialTask extends Command {
    public tutorialTask() {
        super("example", "wtf");
    }

    @Override
    protected void call(AltoClef altoClef, ArgParser argParser) throws CommandException {
        altoClef.log("Hello World!");
        altoClef.runUserTask(new adris.altoclef.tasks.misc.tutorialTask(), this::finish);
    }
}