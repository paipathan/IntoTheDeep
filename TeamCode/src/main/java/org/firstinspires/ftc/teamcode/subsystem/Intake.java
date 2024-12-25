package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.utils.ServoGroup;

public class Intake extends SubsystemBase {
    public Servo leftLinkage;
    public Servo rightLinkage;
    public ServoGroup linkageServos;

    public Servo leftClaw;
    public Servo rightClaw;
    public ServoGroup clawServos;

    public Servo clawGrip;
    HardwareMap hardwareMap;


    // TODO: Figure out these values
    public enum State {
        PASSIVE(0, 0, 0),
        INTAKE(0, 0, 0),
        TRANSFER(0, 0, 0);

        private double linkagePosition;
        private double clawPosition;
        private double clawGrip;

        State(double linkagePosition, double clawPosition, double clawGrip) {
            this.linkagePosition = linkagePosition;
            this.clawPosition = clawPosition;
            this.clawGrip = clawGrip;
        }
    }

    public Intake(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
        leftLinkage = hardwareMap.get(Servo.class, "leftLinkage");
        rightLinkage = hardwareMap.get(Servo.class, "rightLinkage");
        linkageServos = new ServoGroup(leftLinkage, rightLinkage);


        leftClaw = hardwareMap.get(Servo.class, "leftClaw");
        rightClaw = hardwareMap.get(Servo.class, "rightClaw");
        clawServos = new ServoGroup(leftClaw, rightClaw);

        clawGrip = hardwareMap.get(Servo.class, "intakeClawGrip");
    }


    public void setState(State state) {
        linkageServos.setPosition(state.linkagePosition);
        clawServos.setPosition(state.clawPosition);
        clawGrip.setPosition(state.clawGrip);
    }
}