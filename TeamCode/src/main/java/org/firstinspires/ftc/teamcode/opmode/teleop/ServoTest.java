package org.firstinspires.ftc.teamcode.opmode.teleop;

import android.widget.Button;

import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.utils.Controller;
import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.ServoGroup;


@TeleOp(name = "Servo Tester")
public class ServoTest extends LinearOpMode {

    public Servo testServo;
    public Servo testServo2;
    public ServoGroup servoGroup;
    public GamepadEx gamepadex;



    @Override
    public void runOpMode() throws InterruptedException {

        while(opModeInInit()) {
            testServo = hardwareMap.get(Servo.class, "testServo");
            testServo2 = hardwareMap.get(Servo.class, "testServo2");
            servoGroup = new ServoGroup(testServo, testServo2);

            gamepadex = new GamepadEx(gamepad1);

        }



        waitForStart();

        while(opModeIsActive()) {

        if(gamepadex.wasJustPressed(GamepadKeys.Button.B)) {
            testServo2.setPosition(Globals.kclawClosed);
        }

        if(gamepadex.wasJustReleased(GamepadKeys.Button.B)) {
            testServo2.setPosition(Globals.kclawOpen);
        }

        gamepadex.readButtons();

        telemetry.update();



        }

    }
}
