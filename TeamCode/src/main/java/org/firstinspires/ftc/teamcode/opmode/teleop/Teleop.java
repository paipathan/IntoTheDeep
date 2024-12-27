package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.Outtake;
import org.firstinspires.ftc.teamcode.utils.Controller;
import org.opencv.video.TrackerNano;

@TeleOp(name = "Teleop")
public class Teleop extends OpMode {
    RobotHardware robot = new RobotHardware();
    public Intake intake;
    public Outtake outtake;

    public Controller driver;
    public Controller operator;

    @Override
    public void init() {

        robot.init(hardwareMap);
        intake = robot.intake;
        outtake = robot.outtake;

        driver = new Controller(gamepad1);
        operator = new Controller(gamepad2);

        driver.reset();
        operator.reset();
    }

    @Override
    public void loop() {
        driver.update();
        operator.update();

        if(driver.isAPressed()) {
            intake.setState(Intake.State.INTAKE);
            outtake.setState(Outtake.State.PASSIVE);
        } else if (driver.isAReleased()) {
            intake.setState(Intake.State.TRANSFER);
        }

        if(intake.currentState == Intake.State.TRANSFER && intake.linkageServos.getCurrentPosition() == 0) { // TODO: replace 0 with min linkage pos
            outtake.setState(Outtake.State.TRANSFER);
        }

        if(driver.isYPressed()) {
            outtake.setState(Outtake.State.HIGH);
        } else if (driver.isYReleased()) {
            outtake.setState(Outtake.State.PASSIVE);
        }

        if(driver.isBPressed()) {
            outtake.setState(Outtake.State.MID);
        } else if (driver.isBReleased()) {
            outtake.setState(Outtake.State.PASSIVE);
        }

        if(driver.isXPressed()) {
            outtake.setState(Outtake.State.SPECIMEN);
        }

        outtake.slideMotors.setPosition(outtake.slideMotors.getCurrentPosition() + Math.round(-driver.getLeftStickY()));

    }
}
