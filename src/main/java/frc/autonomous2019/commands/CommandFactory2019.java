package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.autonomous.commands.CommandFactory;
import frc.robot.Arm1;
import frc.robot.Arm2;
import frc.robot.Arm3;
import frc.robot.DriveBase;

public class CommandFactory2019 extends CommandFactory {

    DriveBase driveBase;
    Arm1 arm1;
    Arm2 arm2;
    Arm3 arm3;

    public CommandFactory2019 (DriveBase driveBase, Arm1 arm1, Arm2 arm2, Arm3 arm3) {
        this.driveBase = driveBase;
        this.arm1 = arm1;
        this.arm2 = arm2;
        this.arm3 = arm3;
    }

    public Command moveStraight(double power, double time, boolean stop) {
        return new MoveStraightCommand(power, time, stop, driveBase);
    }
    
    public Command turnInPlace(double power, double time) {
        return turnInPlace(power, time, true);
    }

    public Command turnInPlace(double power, double time, boolean stop) {
        return new TurnInPlaceCommand(power, time, stop, driveBase);
    }
    
    public Command rotateArm1Command(double power, double time) {
        return new RotateArm1Command(power, time, arm1);
    }

    public Command setArm1Extender(boolean out) {
        return new SetArm1ExtenderCommand(out, arm1);
    }
    

    public Command rotateArm2(double power, double time)
    {
        return new RotateArm2Command(power, time, arm2);
    }

    public Command setArm2Extender(boolean out)
    {
        return new SetArm2ExtenderCommand(out, arm2);
    }

    public Command rotateArm3(double power, double time) {
        return new RotateArm3Command(power, arm3, time);
    }

    public Command setArm3Extender(boolean out) {
        return new setArm3ExtenderCommand(out, arm3);
    }
}