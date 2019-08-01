package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.Arm2;
import edu.wpi.first.wpilibj.Timer;

public class SetArm2ExtenderCommand implements Command {

    Timer timer;

    boolean out;
    double time;

    boolean needsToStart;
    boolean complete;

    Arm2 arm2;

    public SetArm2ExtenderCommand(boolean out, double time) {
        this.out = out;
        this.time = time;

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
            arm2.setExtender(!out);
            return true;
        }

        else
        {
            arm2.setExtender(out);

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
