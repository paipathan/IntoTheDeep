package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.MotorGroup;
import org.firstinspires.ftc.teamcode.utils.ServoGroup;

public class Outtake extends SubsystemBase {
    public DcMotor leftSlide;
    public DcMotor rightSlide;
    public MotorGroup slideMotors;

    public Servo leftArm;
    public Servo rightArm;
    public ServoGroup armServos;

    public Servo clawGrip;

    // TODO: Figure out these values
    public enum State {
        HIGH(0, 0, 0),
        MID(0, 0, 0),
        TRANSFER(0, 0, 0),
        HANG(0, 0, 0);


        private int slidePosition;
        private double clawPosition;
        private double clawGrip;

        State(int slidePosition, double clawPosition, double clawGrip) {
            this.slidePosition = slidePosition;
            this.clawPosition = clawPosition;
            this.clawGrip = clawGrip;
        }
    }



    public Outtake(HardwareMap hardwareMap) {
        leftSlide = hardwareMap.get(DcMotor.class, "leftSlide");
        rightSlide = hardwareMap.get(DcMotor.class, "rightSlide");
        slideMotors = new MotorGroup(leftSlide, rightSlide);

        leftArm = hardwareMap.get(Servo.class, "leftArm");
        rightArm = hardwareMap.get(Servo.class, "rightArm");
        armServos = new ServoGroup(leftArm, rightArm);

        clawGrip = hardwareMap.get(Servo.class, "outtakeClawGrip");
    }


    public void setState(State state) {
        slideMotors.setPosition(state.slidePosition);
        armServos.setPosition(state.clawPosition);
        clawGrip.setPosition(state.clawGrip);
    }
}
