package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.Arm3;
import edu.wpi.first.wpilibj.Timer;

public class Arm3RotateCommand implements Command {

    Timer timer;

    double time;

    boolean needsToStart;
    boolean complete;

    Arm3 arm3;

    double speed;

    public Arm3RotateCommand(double speed, Arm3 arm3, double time) {
        this.speed = speed;

        this.arm3 = arm3;

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
                arm3.setRotator(0);
                return true;
            }
         else {
            arm3.setRotator(speed);
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
