//OI = Operator Interface
package frc.team1918.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    private Joystick dj = new Joystick(OIConstants.OI_JOY_DRIVE);
    private Joystick oj = new Joystick(OIConstants.OI_JOY_OPER);
    public static enum driveDpadDirection {UP,DOWN,IDLE};

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
    public double getStrafeAxisValue(boolean useDeadband) {
        return (useDeadband) ? applyDeadband(dj.getRawAxis(OIConstants.DRIVE_AXIS_STRAFE)) : dj.getRawAxis(OIConstants.DRIVE_AXIS_STRAFE);
    }

    /**
     * @param useDeadband Boolean value indicating whether to apply deadband to output
     * @return double precision -1 to 1 of the fwd axis 
     */
    public double getFwdAxisValue(boolean useDeadband) {
        return (useDeadband) ? applyDeadband(dj.getRawAxis(OIConstants.DRIVE_AXIS_FWD)) : dj.getRawAxis(OIConstants.DRIVE_AXIS_FWD);
    }

    /**
     * @param useDeadband Boolean value indicating whether to apply deadband to output
     * @return double precision -1 to 1 of the turn axis 
     */
    public double getTurnAxisValue(boolean useDeadband) {
        return (useDeadband) ? applyDeadband(dj.getRawAxis(OIConstants.DRIVE_AXIS_TURN)) : dj.getRawAxis(OIConstants.DRIVE_AXIS_TURN);
    }

    /**
     * @return integer value of Drive DPAD
     */
    public int getDrivePOV() {
        return dj.getPOV(0);
    }

    //DRIVER HELPERS
    /**
     * This function determines if we are pressing any of the top half of the driver DPAD.
     * @return boolean indicating top half of Driver DPAD is pressed
     */
    public boolean isDriveDpadUp() {
        switch (getDrivePOV()) {
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
        switch (getDrivePOV()) {
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
        switch (getDrivePOV()) {
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