package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.DriveBase;
import edu.wpi.first.wpilibj.Timer;

public class MoveStraightCommand implements Command {

    Timer timer;

    double power;
    double time;

    boolean needsToStart;
    boolean complete;

    DriveBase driveBase;
    boolean stop;

    public MoveStraightCommand(double power, double time, DriveBase driveBase, boolean stop) {
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
            driveBase.drive(power);
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
