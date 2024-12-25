package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.utils.Globals;


@TeleOp(name = "Working Teleop")
public class TestOpMode extends LinearOpMode {

//    public Servo leftLinkageServo;
    public Servo rightLinkageServo;


    public DcMotor leftVerticalMotor;
    public DcMotorEx rightVerticalMotor;



    @Override
    public void runOpMode() throws InterruptedException {

        while(opModeInInit()) {
//            leftLinkageServo = hardwareMap.servo.get("leftLinkageServo");
//            rightLinkageServo = hardwareMap.servo.get("rightLinkageServo");

            leftVerticalMotor = hardwareMap.get(DcMotor.class, "leftVerticalMotor");
//            rightVerticalMotor = hardwareMap.get(DcMotorEx.class, "rightVerticalMotor");


            leftVerticalMotor.setPower(1);
//            rightVerticalMotor.setPower(0.4);



            leftVerticalMotor.setDirection(DcMotorSimple.Direction.FORWARD);

            leftVerticalMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

            leftVerticalMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            rightVerticalMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);




//            leftLinkageServo.setDirection(Servo.Direction.REVERSE);
//            rightLinkageServo.setDirection(Servo.Direction.FORWARD);
//
//            leftLinkageServo.setPosition(Globals.MAX_LENGTH);
//            rightLinkageServo.setPosition(Globals.MIN_LENGTH);





            telemetry.addData("Status", "Initialized");
            telemetry.update();
        }

        waitForStart();

        while(opModeIsActive()) {
            telemetry.addData("motor pos", leftVerticalMotor.getCurrentPosition());
            telemetry.addData("motor target pos", leftVerticalMotor.getTargetPosition());

            telemetry.update();



//            if(gamepad1.left_bumper) {
//                leftVerticalMotor.setTargetPosition(leftVerticalMotor.getCurrentPosition() - 100);
//            }

//            if(gamepad1.y) {
//                leftLinkageServo.setPosition(Globals.MAX_LENGTH);
//            } else {
//                leftLinkageServo.setPosition(Globals.MIN_LENGTH);
//            }
//            rightLinkageServo.setPosition(leftLinkageServo.getPosition());



//
            if(gamepad1.dpad_up) {
                leftVerticalMotor.setTargetPosition(Globals.kMaxHeight);
            } else {
                leftVerticalMotor.setTargetPosition(Globals.kMinHeight);
            }



//            if(gamepad1.y) {
//                leftLinkageServo.setPosition(Globals.MAX_LENGTH);
//            } else {
//                leftLinkageServo.setPosition(Globals.MIN_LENGTH);
//            }

//            rightVerticalMotor.setTargetPosition(leftVerticalMotor.getTargetPosition());

        }
    }
}
