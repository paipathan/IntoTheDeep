package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Encoder;
import org.firstinspires.ftc.teamcode.subsystem.Intake;

@TeleOp (name = "Field Centric")
public class FieldCentric extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("backRight");

        Encoder leftEncoder = new Encoder(hardwareMap.get(DcMotorEx.class, "frontLeft"));
        Encoder rightEncoder = new Encoder(hardwareMap.get(DcMotorEx.class, "backLeft"));
        Encoder strafeEncoder = new Encoder(hardwareMap.get(DcMotorEx.class, "frontLeft"));

        


        leftEncoder.setDirection(Encoder.FORWARD);
        rightEncoder.setDirection(Encoder.FORWARD);
        strafeEncoder.setDirection(Encoder.FORWARD);


        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        IMU imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.RIGHT, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {



            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;


            if (gamepad1.a) {
                imu.resetYaw();
            }

            double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);


            double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            rotX = rotX * 1.1;


            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            double frontLeftPower = (rotY + rotX + rx) / denominator;
            double backLeftPower = (rotY - rotX + rx) / denominator;
            double frontRightPower = (rotY - rotX - rx) / denominator;
            double backRightPower = (rotY + rotX - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            telemetry.addData("left encoder delta", leftEncoder.getDeltaPosition());
            telemetry.addData("right encoder delta",  rightEncoder.getDeltaPosition());
            telemetry.addData("strafe encoder delta", strafeEncoder.getDeltaPosition());


            telemetry.addData("left total pos", frontLeftMotor.getCurrentPosition());
            telemetry.addData("right total pos", backLeftMotor.getCurrentPosition());
            telemetry.addData("strafe total pos", frontRightMotor.getCurrentPosition());

            leftEncoder.update();
            rightEncoder.update();
            strafeEncoder.update();

            telemetry.update();
        }
    }
}