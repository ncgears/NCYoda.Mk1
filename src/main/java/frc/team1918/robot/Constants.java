
package frc.team1918.robot;

public class Constants {

    //Global Constants
    public final static int kTimeoutMs = 30; //Timeout for reporting in DS if action fails, set to 0 to skip confirmation
    public final static int PID_PRIMARY = 0;  //Talon PID slot for primary loop
	public final static int PID_TURN = 1; //Talon PID slot for auxillary loop

    //Joystick definitions
    public final static int JOYSTICK_LEFT = 0; //ID of left joystick
    public final static int JOYSTICK_RIGHT = 1; //ID of right joystick
    public final static int JOYSTICK_MOVE = JOYSTICK_LEFT; //Friendly name of movement joystick by function
    public final static int JOYSTICK_ROTATE = JOYSTICK_RIGHT; //Friendly name of rotation joystick by function
 
    //DriveTrain definitions
    public final static int DT_FL_DRIVE_MC_ID = 0; //Front Left Drive Motor Controller ID //SPARKMAX
    public final static int DT_FL_TURN_MC_ID = 1; //Front Left Turn Motor Controller ID //TALONSRX
    public final static int DT_FL_HOME = 0; //Front Left encoder value at home position
    
    public final static int DT_FR_DRIVE_MC_ID = 2; //Front Right Drive Motor Controller ID //SPARKMAX
    public final static int DT_FR_TURN_MC_ID = 3; //Front Right Turn Motor Controller ID //TALONSRX
    public final static int DT_FR_HOME = 0; //Front Right encoder value at home position

    public final static int DT_RL_DRIVE_MC_ID = 4; //Rear Left Drive Motor Controller ID //SPARKMAX
    public final static int DT_RL_TURN_MC_ID = 5; //Rear Left Turn Motor Controller ID //TALONSRX
    public final static int DT_RL_HOME = 0; //Rear Left encoder value at home position
    
    public final static int DT_RR_DRIVE_MC_ID = 6; //Rear Right Drive Motor Controller ID //SPARKMAX
    public final static int DT_RR_TURN_MC_ID = 7; //Rear Right Turn Motor Controller ID //TALONSRX
    public final static int DT_RR_HOME = 0; //Rear Right encoder value at home position


}