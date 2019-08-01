package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.autonomous.commands.CommandFactory;
import frc.robot.Arm2;
import frc.robot.DriveBase;

public class CommandFactory2019 extends CommandFactory {

    DriveBase driveBase;
    Arm2 arm2;

    public CommandFactory2019 (DriveBase driveBase, Arm2 arm2) {
        this.driveBase = driveBase;
        this.arm2 = arm2;
    }
    
    public Command moveStraight(double time, double power, boolean stop) {
        return new MoveStraightCommand(power, time, driveBase, stop);
    }

    public Command rotateArm2(double power, double time)
    {
        return new RotateArm2Command(power, time, arm2);
    }

    public Command setArm2Extender(boolean out)
    {
        return new SetArm2ExtenderCommand(out, arm2);
    }
}
