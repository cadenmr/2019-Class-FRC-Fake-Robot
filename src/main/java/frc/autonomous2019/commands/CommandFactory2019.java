package frc.autonomous2019.commands;

import java.lang.reflect.Method;

import frc.autonomous.Command;

public class CommandFactory2019 extends CommandFactory {

    DriveBase driveBase;
    Arm4 arm4;
    public CommandFactory2019(DriveBase driveBase, Arm4 arm4){
        this.driveBase = driveBase;
        this.arm4 = arm4;
    }

    public Command DriveStraight(double power, double time, boolean stop) {
        return new DriveStraightCommand(power,  time,  driveBase,  stop);
    }

    public Command Arm4Rotate(double power, double time) {
        return new ArmRotateCommand(power,  time, arm4);
    }

    public Command Arm4Extend(boolean extend){
        return new Arm4ExtendCommand(extend, arm4);
    }

}
