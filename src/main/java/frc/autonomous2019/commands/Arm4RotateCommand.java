package frc.autonomous2019.commands;

import frc.autonomous.Command;

import edu.wpi.first.wpilibj.Timer;

public class Arm4RotateCommand implements Command {

    boolean needsToStart;
    boolean complete;
    Timer timer;
    double power;
    double time;
    boolean stop;
    Arm4 arm4;

    public Arm4RotateCommand(double power, double time, Arm4 arm4, boolean stop) {
        this.power = power;
        this.time = time;
        this.arm4 = arm4;
        this.stop = stop;
    }

    @Override
    public boolean run() {
        if (needsToStart) {
           timer.reset();
           timer.start();
           needsToStart = false;
        }

        if (complete) {
            if(stop){
                arm4.setRotator(0);
            }
            return true;
        } else {
            if (timer.get()<time) {
                complete = true;
            }

            if(!arm4.getLimitSwitch()){
                arm4.setRotator(power);
            }
            else{
                arm4.setRotator(0);
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
