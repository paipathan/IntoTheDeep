package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystem.Intake;

@TeleOp(name = "Teleop")
public class Teleop extends OpMode {
    RobotHardware robot = new RobotHardware();
    Intake intake = robot.intake;

    @Override
    public void init() {
        robot.init(hardwareMap);

    }

    @Override
    public void loop() {
        intake.setState(Intake.State.TRANSFER);
    }
}
