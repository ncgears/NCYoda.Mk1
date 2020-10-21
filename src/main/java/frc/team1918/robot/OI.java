//OI = Operator Interface
package frc.team1918.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.JoystickButton;

public class OI {
    //Driver Controller
    public static enum driveDpadDirection {UP,DOWN,IDLE};
    private Joystick dj = new Joystick(OIConstants.OI_JOY_DRIVE);
    private JoystickButton  btn_ALLUP = new JoystickButton(dj, OIConstants.DRIVE_BTN_ALLUP),
                            btn_ANTIGRAV = new JoystickButton(dj, OIConstants.DRIVE_BTN_ANTIGRAV),
                            btn_ABSZERO_KEY1 = new JoystickButton(dj, OIConstants.DRIVE_BTN_ABSZERO_KEY1),
                            btn_HOMESWERVE = new JoystickButton(dj, OIConstants.DRIVE_BTN_HOMESWERVE),
                            btn_MIXER_FEED = new JoystickButton(dj, OIConstants.DRIVE_BTN_MIXER_FEED),
                            btn_MIXER_FEEDSTUCK = new JoystickButton(dj, OIConstants.DRIVE_BTN_MIXER_FEEDSTUCK);
    //Operator Controller
    private Joystick oj = new Joystick(OIConstants.OI_JOY_OPER);
    private JoystickButton  btn_SHOOT_WALL = new JoystickButton(oj, OIConstants.OPER_BTN_SHOOT_WALL),
                            btn_SHOOT_LINE = new JoystickButton(oj, OIConstants.OPER_BTN_SHOOT_LINE),
                            btn_SHOOT_SHORT = new JoystickButton(oj, OIConstants.OPER_BTN_SHOOT_SHORT),
                            btn_SHOOT_TRENCH = new JoystickButton(oj, OIConstants.OPER_BTN_SHOOT_TRENCH),
                            btn_TOG_MIDDOWN = new JoystickButton(oj, OIConstants.OPER_BTN_TOG_MIDDOWN),
                            btn_COLLECTOR_IN = new JoystickButton(oj, OIConstants.OPER_BTN_COLLECTOR_IN),
                            btn_ABSZERO_KEY2 = new JoystickButton(oj, OIConstants.OPER_BTN_ABSZERO_KEY2);


    btn_ALLUP.whenPressed() Collector.moveArmUp();
    btn_ANTIGRAV.whenPressed() Climber.engageAntiBackdrive();
    btn_ANTIGRAV.whenReleased() Climber.disengageAntiBackdrive();



    //DRIVER CONTROLS
    /**
     * @param inVal double precision input value to apply deadband
     * @return double precision -1 to 1 after applying deadband calculation 
     */
    public double applyDeadband(double inVal) {
        return ( Math.abs(inVal) < OIConstants.OI_JOY_DEADBAND ) ? 0.0 : inVal;
    }

    /**
     * @param useDeadband Boolean value indicating whether to apply deadband to output 
     * @return double precision -1 to 1 of the strafe axis 
     */
    public double getAxisStrafeValue(boolean useDeadband) {
        return (useDeadband) ? applyDeadband(dj.getRawAxis(OIConstants.DRIVE_AXIS_STRAFE)) : dj.getRawAxis(OIConstants.DRIVE_AXIS_STRAFE);
    }

    /**
     * @param useDeadband Boolean value indicating whether to apply deadband to output
     * @return double precision -1 to 1 of the fwd axis 
     */
    public double getAxisFwdValue(boolean useDeadband) {
        return (useDeadband) ? applyDeadband(dj.getRawAxis(OIConstants.DRIVE_AXIS_FWD)) : dj.getRawAxis(OIConstants.DRIVE_AXIS_FWD);
    }

    /**
     * @param useDeadband Boolean value indicating whether to apply deadband to output
     * @return double precision -1 to 1 of the turn axis 
     */
    public double getAxisTurnValue(boolean useDeadband) {
        return (useDeadband) ? applyDeadband(dj.getRawAxis(OIConstants.DRIVE_AXIS_TURN)) : dj.getRawAxis(OIConstants.DRIVE_AXIS_TURN);
    }

    /**
     * @return integer value of Drive DPAD
     */
    public int getPOVDrive() {
        return dj.getPOV(0);
    }


    //DRIVER HELPERS
    /**
     * This function determines if we are pressing any of the top half of the driver DPAD.
     * @return boolean indicating top half of Driver DPAD is pressed
     */
    public boolean isDriveDpadUp() {
        switch (getPOVDrive()) {
            case OIConstants.DRIVE_DPAD_UPLEFT:
            case OIConstants.DRIVE_DPAD_UP:
            case OIConstants.DRIVE_DPAD_UPRIGHT: return true;
        }
        return false;
    }

    /**
     * This function determines if we are pressing any of the bottom half of the driver DPAD.
     * @return boolean indicating bottom half of Drive DPAD is pressed
     */
    public boolean isDriveDpadDown() {
        switch (getPOVDrive()) {
            case OIConstants.DRIVE_DPAD_DNLEFT:
            case OIConstants.DRIVE_DPAD_DN:
            case OIConstants.DRIVE_DPAD_DNRIGHT: return true;
        }
        return false;
    }

    /**
     * This function returns the direction of the Drive DPAD
     * @return enum OI.driveDpadDirection containing one of UP, DOWN, IDLE
     */
    public driveDpadDirection getDriveDpadDirection() {
        switch (getPOVDrive()) {
            //Top half of Drive DPAD
            case OIConstants.DRIVE_DPAD_UPLEFT:
            case OIConstants.DRIVE_DPAD_UP:
            case OIConstants.DRIVE_DPAD_UPRIGHT: return driveDpadDirection.UP;
            //Bottom half of Drive DPAD
            case OIConstants.DRIVE_DPAD_DNLEFT:
            case OIConstants.DRIVE_DPAD_DN:
            case OIConstants.DRIVE_DPAD_DNRIGHT: return driveDpadDirection.DOWN;
        }
        return driveDpadDirection.IDLE;
    }

    //OPERATOR CONTROLS
    /**
     * @param useDeadband Boolean value indicating whether to apply deadband to output
     * @return double precision -1 to 1 of the fwd axis 
     */
    public double getClimbAxisValue(boolean useDeadband) {
        return (useDeadband) ? applyDeadband(dj.getRawAxis(OIConstants.OPER_AXIS_CLIMB)) : dj.getRawAxis(OIConstants.OPER_AXIS_CLIMB);
    }

    /**
     * @return integer value of Operator DPAD
     */
    public int getOperPOV() {
        return oj.getPOV(0);
    }

    //OPERATOR HELPERS
}