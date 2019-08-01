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

    public Command moveStraight(double time, double power, boolean stop) {
        return new MoveStraightCommand(power, time, driveBase, stop);
    }
    
    public Command turnInPlace(double time, double power) {
        return turnInPlace(time, power, true);
    }

    public Command turnInPlace(double time, double power, boolean stop) {
        return new TurnInPlaceCommand(power, time, driveBase, stop);
    }
    
    public Command rotateArm1Command(double time, double power) {
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

    public Command rotateArm3(double speed, double time) {
        return new RotateArm3Command(speed, arm3, time);
    }

    public Command setArm3Extender(boolean state) {
        return new setArm3ExtenderCommand(state, arm3);
    }
}
