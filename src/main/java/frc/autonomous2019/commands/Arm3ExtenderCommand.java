package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.Arm3;
import edu.wpi.first.wpilibj.Timer;

public class Arm3ExtenderCommand implements Command {

    Timer timer;

    double time;

    boolean needsToStart;
    boolean complete;
    boolean stop;
    boolean state;

    Arm3 arm3;

    public Arm3ExtenderCommand(boolean state, Arm3 arm3, double time) {
        this.state = state;

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
            if (stop) {
                arm3.setExtender(false);
            }
            return true;
        } else {
            arm3.setExtender(state);
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
