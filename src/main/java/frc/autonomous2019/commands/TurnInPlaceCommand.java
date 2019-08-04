package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.DriveBase;
import edu.wpi.first.wpilibj.Timer;

public class TurnInPlaceCommand implements Command {

    double power;
    double time;
    boolean stop;
    
    boolean needsToStart;
    boolean complete;
    
    DriveBase driveBase;

    Timer timer;

    public TurnInPlaceCommand(double power, double time, boolean stop, DriveBase driveBase) {
        this.power = power;
        this.time = time;
        this.stop = stop;

        this.driveBase = driveBase;

        timer = new Timer();

        reset();
    }

    @Override
    public boolean run() {
        if (needsToStart) {
            timer.reset();
            timer.start();
            needsToStart = false;
        }

        if (complete) {
            if (stop) {
                driveBase.drive(0);
            }
            return true;
        } else {
            driveBase.drive(power, -power);
            if (timer.get() >= time) {
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