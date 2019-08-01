package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.Arm3;

public class setArm3ExtenderCommand implements Command {
    boolean state;

    Arm3 arm3;

    public setArm3ExtenderCommand(boolean state, Arm3 arm3) {
        this.state = state;

        this.arm3 = arm3;

        reset();
    }

    @Override
    public boolean run() {
        arm3.setExtender(state);
        return true;
    }

    @Override
    public void reset() {
    }

}
