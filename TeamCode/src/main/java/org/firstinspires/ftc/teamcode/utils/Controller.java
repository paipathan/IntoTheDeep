package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.Gamepad;

public class Controller {
    private final Gamepad gamepad;

    private boolean previousA, previousB, previousX, previousY;
    private boolean previousLeftBumper, previousRightBumper;
    private boolean previousDpadUp, previousDpadDown, previousDpadLeft, previousDpadRight;
    private boolean previousStart, previousBack;

    private float previousLeftTrigger, previousRightTrigger;

    public Controller(Gamepad gamepad) {
        this.gamepad = gamepad;
        reset();
    }

    public void reset() {
        previousA = gamepad.a;
        previousB = gamepad.b;
        previousX = gamepad.x;
        previousY = gamepad.y;
        previousLeftBumper = gamepad.left_bumper;
        previousRightBumper = gamepad.right_bumper;
        previousDpadUp = gamepad.dpad_up;
        previousDpadDown = gamepad.dpad_down;
        previousDpadLeft = gamepad.dpad_left;
        previousDpadRight = gamepad.dpad_right;
        previousStart = gamepad.start;
        previousBack = gamepad.back;

        previousLeftTrigger = gamepad.left_trigger;
        previousRightTrigger = gamepad.right_trigger;
    }

    public void update() {
        previousA = gamepad.a;
        previousB = gamepad.b;
        previousX = gamepad.x;
        previousY = gamepad.y;
        previousLeftBumper = gamepad.left_bumper;
        previousRightBumper = gamepad.right_bumper;
        previousDpadUp = gamepad.dpad_up;
        previousDpadDown = gamepad.dpad_down;
        previousDpadLeft = gamepad.dpad_left;
        previousDpadRight = gamepad.dpad_right;
        previousStart = gamepad.start;
        previousBack = gamepad.back;

        previousLeftTrigger = gamepad.left_trigger;
        previousRightTrigger = gamepad.right_trigger;
    }

    public boolean isAPressed() {
        return gamepad.a && !previousA;
    }

    public boolean isBPressed() {
        return gamepad.b && !previousB;
    }

    public boolean isXPressed() {
        return gamepad.x && !previousX;
    }

    public boolean isYPressed() {
        return gamepad.y && !previousY;
    }

    public boolean isLeftBumperPressed() {
        return gamepad.left_bumper && !previousLeftBumper;
    }

    public boolean isRightBumperPressed() {
        return gamepad.right_bumper && !previousRightBumper;
    }

    public boolean isDpadUpPressed() {
        return gamepad.dpad_up && !previousDpadUp;
    }

    public boolean isDpadDownPressed() {
        return gamepad.dpad_down && !previousDpadDown;
    }

    public boolean isDpadLeftPressed() {
        return gamepad.dpad_left && !previousDpadLeft;
    }

    public boolean isDpadRightPressed() {
        return gamepad.dpad_right && !previousDpadRight;
    }

    public boolean isStartPressed() {
        return gamepad.start && !previousStart;
    }

    public boolean isBackPressed() {
        return gamepad.back && !previousBack;
    }

    public boolean isAReleased() {
        return previousA && !gamepad.a;
    }

    public boolean isBReleased() {
        return previousB && !gamepad.b;
    }

    public boolean isXReleased() {
        return previousX && !gamepad.x;
    }

    public boolean isYReleased() {
        return previousY && !gamepad.y;
    }

    public boolean isLeftBumperReleased() {
        return previousLeftBumper && !gamepad.left_bumper;
    }

    public boolean isRightBumperReleased() {
        return previousRightBumper && !gamepad.right_bumper;
    }

    public boolean isDpadUpReleased() {
        return previousDpadUp && !gamepad.dpad_up;
    }

    public boolean isDpadDownReleased() {
        return previousDpadDown && !gamepad.dpad_down;
    }

    public boolean isDpadLeftReleased() {
        return previousDpadLeft && !gamepad.dpad_left;
    }

    public boolean isDpadRightReleased() {
        return previousDpadRight && !gamepad.dpad_right;
    }

    public boolean isStartReleased() {
        return previousStart && !gamepad.start;
    }

    public boolean isBackReleased() {
        return previousBack && !gamepad.back;
    }

    public boolean isLeftTriggerChanged() {
        return gamepad.left_trigger != previousLeftTrigger;
    }

    public boolean isRightTriggerChanged() {
        return gamepad.right_trigger != previousRightTrigger;
    }

    public float getLeftStickX() {
        return gamepad.left_stick_x;
    }

    public float getLeftStickY() {
        return gamepad.left_stick_y;
    }

    public float getRightStickX() {
        return gamepad.right_stick_x;
    }

    public float getRightStickY() {
        return gamepad.right_stick_y;
    }

    public float getLeftTrigger() {
        return gamepad.left_trigger;
    }

    public float getRightTrigger() {
        return gamepad.right_trigger;
    }
}
