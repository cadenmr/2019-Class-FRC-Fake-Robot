package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.autonomous.commands.CommandFactory;
import frc.robot.Arm1;
import frc.robot.DriveBase;

public class CommandFactory2019 extends CommandFactory {

    DriveBase driveBase;
    Arm1 arm1;

    public CommandFactory2019 (DriveBase driveBase, Arm1 arm1) {
        this.driveBase = driveBase;
        this.arm1 = arm1;
    }
    public Command moveStraight(double time, double power, boolean stop) {
        return new MoveStraightCommand(power, time, driveBase, stop);
    }

    public Command rotateArm1Command(double time, double power) {
        return new RotateArm1Command(power, time, arm1);
    }

    public Command setArm1Extender(boolean out) {
        return new SetArm1ExtenderCommand(out, arm1);
    }
}
