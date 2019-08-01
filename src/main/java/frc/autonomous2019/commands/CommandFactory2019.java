package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.autonomous.commands.CommandFactory;
import frc.robot.DriveBase;

public class CommandFactory2019 extends CommandFactory {

    DriveBase driveBase;

    public CommandFactory2019 (DriveBase driveBase) {
        this.driveBase = driveBase;
    }

    public Command moveStraight(double time, double power, boolean stop) {
        return new MoveStraightCommand(power, time, driveBase, stop);
    }

    public Command turnInPlace(double time, double power, boolean stop) {
        return new TurnInPlaceCommand(power, time, driveBase, stop);
    }
}
