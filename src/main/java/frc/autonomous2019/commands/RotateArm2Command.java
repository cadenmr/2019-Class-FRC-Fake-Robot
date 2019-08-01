package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.Arm2;
import edu.wpi.first.wpilibj.Timer;

public class RotateArm2Command implements Command {

    Timer timer;

    double power;
    double time;

    boolean needsToStart;
    boolean complete;

    Arm2 arm2;

    public RotateArm2Command(double power, double time, Arm2 arm2) {
        this.power = power;
        this.time = time;
        this.arm2 = arm2;

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
        
        if (complete)
        {
            arm2.setRotator(0);
            return true;
        }

        else
        {
            arm2.setRotator(power);

            if (timer.get() >= time)
            {
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
