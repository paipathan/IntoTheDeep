package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystem.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.Outtake;

public class RobotHardware {
    public Intake intake;
    public Outtake outtake;
    public Drivetrain drivetrain;

    public void init(HardwareMap hardwareMap) {
        intake = new Intake(hardwareMap);
        outtake = new Outtake(hardwareMap);
        drivetrain = new Drivetrain(hardwareMap);
    }
}
