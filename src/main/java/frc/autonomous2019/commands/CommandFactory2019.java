package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.autonomous.commands.CommandFactory;
import frc.robot.Arm2;
import frc.robot.DriveBase;

public class CommandFactory2019 extends CommandFactory {

    DriveBase driveBase;

    public CommandFactory2019 (DriveBase driveBase) {
        this.driveBase = driveBase;
    }
    public Command moveStraight(double time, double power, boolean stop) {
        return new MoveStraightCommand(power, time, driveBase, stop);
    }

    public Command rotateArm2(double power, double time)
    {
        return new RotateArm2Command(power, time);
    }

    public Command setArm2Extender(boolean out, Arm2 arm2)
    {
        return new SetArm2ExtenderCommand(out, arm2);
    }
}
