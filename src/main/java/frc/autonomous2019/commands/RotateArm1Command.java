package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.Arm1;
import edu.wpi.first.wpilibj.Timer;

public class RotateArm1Command implements Command {

    double power;
    double time;

    boolean needsToStart;
    boolean complete;

    Arm1 arm1;

    Timer timer;

    public RotateArm1Command(double power, double time, Arm1 arm1) {
        this.power = power;
        this.time = time;

        this.arm1 = arm1;

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
            arm1.setRotator(0);
            return true;
        } else {
            arm1.setRotator(power);
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