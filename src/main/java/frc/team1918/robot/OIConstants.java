
package frc.team1918.robot;

public class OIConstants {
    /**
     * This class is based on 2 Logitech controllers, a driver and an operator, setup for swerve drive
     */
    public final static int OI_JOY_DRIVE = 0; //ID of Driver Joystick
    public final static int OI_JOY_OPER = 1; //ID of Operator Joystick
    public final static double OI_JOY_DEADBAND = 0.1; //Deadband for analog joystick axis
    
    //Logitech Controller buttons
    private final static int LOGITECH_BTN_A = 0; //A Button
    private final static int LOGITECH_BTN_B = 1; //B Button
    private final static int LOGITECH_BTN_X = 2; //X Button
    private final static int LOGITECH_BTN_Y = 3; //Y Button
    private final static int LOGITECH_BTN_LB = 4; //Left Bumper (L1)
    private final static int LOGITECH_BTN_RB = 5; //Right Bumper (R1)
    private final static int LOGITECH_BTN_BACK = 6; //Back Button (Select)
    private final static int LOGITECH_BTN_START = 7; //Start Button
    private final static int LOGITECH_BTN_L = 8; //Left Stick Press (L3)
    private final static int LOGITECH_BTN_R = 9; //Right Stick Press (R3)
    private final static int LOGITECH_AXIS_LH = 0; //Left Analog Stick horizontal
    private final static int LOGITECH_AXIS_LV = 1; //Left Analog Stick vertical
    private final static int LOGITECH_AXIS_LT = 2; //Analog Left Trigger
    private final static int LOGITECH_AXIS_RT = 3; //Analog Right Trigger
    private final static int LOGITECH_AXIS_RH = 4; //Right Analog Stick horizontal
    private final static int LOGITECH_AXIS_RV = 5; //Right Analog Stick vertical
    private final static int LOGITECH_DPAD_UP = 0;
    private final static int LOGITECH_DPAD_UPRIGHT = 45;
    private final static int LOGITECH_DPAD_RIGHT = 90;
    private final static int LOGITECH_DPAD_DNRIGHT = 135;
    private final static int LOGITECH_DPAD_DN = 180;
    private final static int LOGITECH_DPAD_DNLEFT = 225;
    private final static int LOGITECH_DPAD_LEFT = 270;
    private final static int LOGITECH_DPAD_UPLEFT = 315;
    private final static int LOGITECH_DPAD_IDLE = -1; 

    public final static int DRIVE_AXIS_STRAFE = LOGITECH_AXIS_LH; //Axis that moves the robot side to side on the field
    public final static int DRIVE_AXIS_FWD = LOGITECH_AXIS_LV; //Axis that moves the robot up and down the field
    public final static int DRIVE_AXIS_TURN = LOGITECH_AXIS_RH; //Axis that controls the rotation of the robot
    public final static int DRIVE_BTN_ALLUP = LOGITECH_BTN_A; //Move collector to Up position
    public final static int DRIVE_BTN_ANTIGRAV = LOGITECH_BTN_B; //Engage anti-backdrive for climber
    public final static int DRIVE_BTN_MIXER_FEED = LOGITECH_BTN_X; //Run the mixer in the forward direction
    public final static int DRIVE_BTN_MIXER_FEEDSTUCK = LOGITECH_BTN_LB; //Reverse the mixer direction to unstick power cells
    public final static int DRIVE_BTN_HOMESWERVE = LOGITECH_BTN_Y; //Home the swerve modules
    public final static int DRIVE_BTN_ABSZERO_KEY1 = LOGITECH_BTN_BACK; //DRIVER KEY1 and OPER KEY2 are required for this
    public final static int DRIVE_DPAD_UPLEFT = LOGITECH_DPAD_UPLEFT;
    public final static int DRIVE_DPAD_UP = LOGITECH_DPAD_UP;
    public final static int DRIVE_DPAD_UPRIGHT = LOGITECH_DPAD_UPRIGHT;
    public final static int DRIVE_DPAD_DNLEFT = LOGITECH_DPAD_DNLEFT;
    public final static int DRIVE_DPAD_DN = LOGITECH_DPAD_DN;
    public final static int DRIVE_DPAD_DNRIGHT = LOGITECH_DPAD_DNRIGHT;
    //Drive controller DPAD used as range selector for shooter speed (top half and bottom half)
    
    public final static int OPER_AXIS_CLIMB = LOGITECH_AXIS_LV; //Axis that controls the climber up and down
    public final static int OPER_AXIS_COLLECTOR_OUT = LOGITECH_AXIS_RT; //Axis that runs the collector out (actually a trigger button)
    public final static int OPER_BTN_SHOOT_WALL = LOGITECH_BTN_A; //Shoot from at the wall
    public final static int OPER_BTN_SHOOT_SHORT = LOGITECH_BTN_B; //Shoot from close to the wall
    public final static int OPER_BTN_SHOOT_LINE = LOGITECH_BTN_X; //Shoot from the initiation line
    public final static int OPER_BTN_SHOOT_TRENCH = LOGITECH_BTN_Y; //Shoot from the trench
    public final static int OPER_BTN_TOG_MIDDOWN = LOGITECH_BTN_LB; //Toggle collector arm between middle and down position
    public final static int OPER_BTN_COLLECTOR_IN = LOGITECH_BTN_RB; //Run the collector in
    public final static int OPER_BTN_ABSZERO_KEY2 = LOGITECH_BTN_BACK; //DRIVER KEY1 and OPER KEY2 are required for this
    public final static int OPER_DPAD_COLLECTOR_UP = LOGITECH_DPAD_LEFT; //Move collector to up
    public final static int OPER_DPAD_COLLECTOR_MID = LOGITECH_DPAD_RIGHT; //Move collector to middle
    //We get dpad values with joystick.getPOV(0);

    /*
    switch (value){
        case 315:
        case 0:
        case 45:
            {
                 //do stuff
                 break;
            }
        case 180:
            {
                //do other stuff
                break;
            }
        case default:
        { do nothing }
    }
    */
}
