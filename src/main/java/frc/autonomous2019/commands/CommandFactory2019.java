package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.autonomous.commands.CommandFactory;
import frc.robot.Arm3;
import frc.robot.DriveBase;

public class CommandFactory2019 extends CommandFactory {

    DriveBase driveBase;
    Arm3 arm3;

    public CommandFactory2019 (DriveBase driveBase) {
        this.driveBase = driveBase;
    }
    public Command moveStraight(double time, double power, boolean stop) {
        return new MoveStraightCommand(power, time, driveBase, stop);
    }

    public Command Arm3Rotate(double speed, double time) {
        return new Arm3RotateCommand(speed, arm3, time);
    }

    public Command Arm3Extender(boolean state, double time) {
        return new Arm3ExtenderCommand(state, arm3, time);
    }
}
