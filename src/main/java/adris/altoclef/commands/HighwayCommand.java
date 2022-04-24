package adris.altoclef.commands;

import adris.altoclef.AltoClef;
import adris.altoclef.commandsystem.ArgParser;
import adris.altoclef.commandsystem.Command;
import adris.altoclef.tasks.misc.Highway;

public class HighwayCommand extends Command {
    public HighwayCommand() {
        super("highway", "Repairs the highways");
    }

    @Override
    protected void call(AltoClef mod, ArgParser parser) {
        mod.runUserTask(new Highway(), this::finish);
    }
}
