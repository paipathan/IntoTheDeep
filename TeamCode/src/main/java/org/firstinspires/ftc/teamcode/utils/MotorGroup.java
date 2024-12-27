package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MotorGroup {
    DcMotor master;
    DcMotor slave;

    public MotorGroup(DcMotor master, DcMotor slave) {
        this.master = master;
        this.slave = slave;

        master.setPower(1);
        slave.setPower(1);

        master.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slave.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        master.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slave.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//        master.setDirection(DcMotorSimple.Direction.REVERSE);
//        slave.setDirection(DcMotorSimple.Direction.REVERSE);


    }

    public void setPosition(int targetPosition) {
        master.setTargetPosition(targetPosition);
        slave.setTargetPosition(master.getCurrentPosition());
    }

    public int getCurrentPosition() {
        return master.getCurrentPosition();
    }

}

// grah