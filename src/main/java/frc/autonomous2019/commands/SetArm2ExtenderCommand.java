package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.Arm2;

public class SetArm2ExtenderCommand implements Command {

    boolean out;
    Arm2 arm2;

    public SetArm2ExtenderCommand(boolean out, Arm2 arm2) {
        this.out = out;
        this.arm2 = arm2;

        reset();
    }

    @Override
    public boolean run() {
        arm2.setExtender(out);
        return true;
    }

    @Override
    public void reset() {
    }
}
