package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.Arm1;

public class SetArm1ExtenderCommand implements Command {

    boolean out;
    Arm1 arm1;

    public SetArm1ExtenderCommand(boolean out, Arm1 arm1) {
        this.out = out;
        this.arm1 = arm1;

        reset();
    }

    @Override
    public boolean run() {
        arm1.setExtender(out);
        return true;
    }

    @Override
    public void reset() {
    }
}