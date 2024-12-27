package org.firstinspires.ftc.teamcode.utils;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoGroup {
    Servo master;
    Servo slave;

    public ServoGroup(Servo master, Servo slave) {
        this.master = master;
        master.setDirection(Servo.Direction.REVERSE);
        this.slave = slave;

    }

    public void setPosition(double targetPosition) {
        master.setPosition(targetPosition);
        slave.setPosition(master.getPosition());
    }

    public double getCurrentPosition() {
        return master.getPosition();
    }

}
