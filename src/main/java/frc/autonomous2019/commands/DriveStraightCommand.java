package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.DriveBase;
import edu.wpi.first.wpilibj.Timer;

public class DriveStraightCommand implements Command {

    boolean needsToStart;
    boolean complete;
    Timer timer;
    double power;
    double time;
    boolean stop;
    DriveBase driveBase;

    public DriveStraightCommand(double power, double time, DriveBase driveBase, boolean stop) {
        this.power = power;
        this.time = time;
        this.driveBase = driveBase;
        this.stop = stop;
    }

    @Override
    public boolean run() {
        if (needsToStart) {
           timer.reset();
           timer.start();
           needsToStart = false;
        }

        if (complete) {
            if(stop){
                driveBase.drive(0);
            }
            return true;
        } else {
            driveBase.drive(power);
            if (timer.get()<time) {
                complete = true;
            }
            return false;
        }
    }

    @Override
    public void reset() {
        needsToStart = true;
        complete = false;
    }

}
