package frc.team1918.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;


public class DriveTrain {

	private static DriveTrain instance;
	private static SwerveModule dtFL, dtFR, dtRL, dtRR;
	private static AHRS gyro;

	public static DriveTrain getInstance() {
		if (instance == null)
			instance = new DriveTrain();
		return instance;
	}

	private DriveTrain() {
	    dtFL = new SwerveModule(Constants.DT_FL_DRIVE_MC_ID,
				Constants.DT_FL_TURN_MC_ID, 4.20, 0.01, 0, 200); // Front Left
		dtFR = new SwerveModule(Constants.DT_FR_DRIVE_MC_ID,
				Constants.DT_FR_TURN_MC_ID, 4.20, 0.01, 0, 200); // Front Right
		dtRL = new SwerveModule(Constants.DT_RL_DRIVE_MC_ID,
				Constants.DT_RL_TURN_MC_ID, 4.20, 0.01, 0, 200); // Rear Left
		dtRR = new SwerveModule(Constants.DT_RR_DRIVE_MC_ID,
                Constants.DT_RR_TURN_MC_ID, 4.20, 0.01, 0, 200); // Rear Right

		gyro = new AHRS(SPI.Port.kMXP);
	}

	public static AHRS getgyro() {
        return gyro;
	}

	public static void setDrivePower(double bbPower, double bhPower,
		double bgPower, double bsPower) {
	    dtFL.setDrivePower(bbPower);
		dtFR.setDrivePower(bhPower);
		dtRL.setDrivePower(bgPower);
		dtRR.setDrivePower(bsPower);
	}

	public static void setTurnPower(double bbPower, double bhPower,
		double bgPower, double bsPower) {
	    dtFL.setTurnPower(bbPower);
		dtFR.setTurnPower(bhPower);
		dtRL.setTurnPower(bgPower);
		dtRR.setTurnPower(bsPower);
	}

	public static void setLocation(double bbLoc, double bhLoc, double bgLoc,
		double bsLoc) {
	    dtFL.setTurnLocation(bbLoc);
		dtFR.setTurnLocation(bhLoc);
		dtRL.setTurnLocation(bgLoc);
		dtRR.setTurnLocation(bsLoc);
	}

	public static void setAllTurnPower(double power) {
		setTurnPower(power, power, power, power);
	}

	public static void setAllDrivePower(double power) {
		setDrivePower(power, power, power, power);
	}

	public static void setAllLocation(double loc) {
		setLocation(loc, loc, loc, loc);
	}

	private static double l = 21, w = 21, r = Math.sqrt((l * l) + (w * w));

	public static boolean isdtLFTurnEncConnected() {
		return dtFL.isTurnEncConnected();
	}

	public static boolean isdtFRTurnEncConnected() {
		return dtFR.isTurnEncConnected();
	}

	public static boolean isdtRLTurnEncConnected() {
		return dtRL.isTurnEncConnected();
	}

	public static boolean isBigSushiTurnEncConnected() {
		return dtRR.isTurnEncConnected();
	}

	public static void resetAllEnc() {
	    dtFL.resetTurnEnc();
		dtFR.resetTurnEnc();
		dtRL.resetTurnEnc();
		dtRR.resetTurnEnc();
	}

	public static void stopDrive() {
	    dtFL.stopDrive();
		dtFR.stopDrive();
		dtRL.stopDrive();
		dtRR.stopDrive();
	}

	private static double angleToLoc(double angle) {
		if (angle < 0) {
			return .5d + ((180d - Math.abs(angle)) / 360d);
		} else {
			return angle / 360d;
		}
	}

	private static boolean offSetSet = false;

	public static void setOffSets() {
		if (!offSetSet) {
			double flOff = 0, frOff = 0, rlOff = 0, rrOff = 0;
		    dtFL.setTurnPower(0);
			dtRL.setTurnPower(0);
			dtFR.setTurnPower(0);
			dtRR.setTurnPower(0);

			flOff = DriveTrain.dtFL.getTurnAbsPos();
			frOff = DriveTrain.dtFR.getTurnAbsPos();
			rlOff = DriveTrain.dtRL.getTurnAbsPos();
			rrOff = DriveTrain.dtRR.getTurnAbsPos();

			System.out.println("flOff: " + flOff);
			System.out.println("frOff: " + frOff);
			System.out.println("rlOff: " + rlOff);
			System.out.println("rrOff: " + rrOff);

			resetAllEnc();
		    dtFL.setEncPos((int) (locSub(flOff, Constants.DT_FL_HOME) * 4095d));
			dtFR.setEncPos((int) (locSub(frOff, Constants.DT_FR_HOME) * 4095d));
			dtRL.setEncPos((int) (locSub(rlOff, Constants.DT_RL_HOME) * 4095d));
			dtRR.setEncPos((int) (locSub(rrOff, Constants.DT_RR_HOME) * 4095d));
			offSetSet = true;
		}
	}

	public static void resetOffSet() {
		offSetSet = false;
	}

	private static double locSub(double v, double c) {
		if (v - c > 0) {
			return v - c;
		} else {
			return (1 - c) + v;
		}
	}

	public static double getgyroAngle() {
		return gyro.getAngle();
	}

	public static double getgyroAngleInRad() {
		return gyro.getAngle() * (Math.PI / 180d);
	}

	public static void setDriveBrakeMode(boolean b) {
	    dtFL.setBrakeMode(b);
		dtFR.setBrakeMode(b);
		dtRL.setBrakeMode(b);
		dtRR.setBrakeMode(b);
	}

	public static double getAverageError() {
		return (Math.abs(dtFL.getError()) + Math.abs(dtFR.getError())
				+ Math.abs(dtRL.getError()) + Math.abs(dtRR
				.getError())) / 4d;
	}

	/*
	 * Drive methods
	 */
	public static void swerveDrive(double fwd, double str, double rot) {
		double a = str - (rot * (l / r));
		double b = str + (rot * (l / r));
		double c = fwd - (rot * (w / r));
		double d = fwd + (rot * (w / r));

		double ws1 = Math.sqrt((b * b) + (c * c));
		double ws2 = Math.sqrt((b * b) + (d * d));
		double ws3 = Math.sqrt((a * a) + (d * d));
		double ws4 = Math.sqrt((a * a) + (c * c));

		double wa1 = Math.atan2(b, c) * 180 / Math.PI;
		double wa2 = Math.atan2(b, d) * 180 / Math.PI;
		double wa3 = Math.atan2(a, d) * 180 / Math.PI;
		double wa4 = Math.atan2(a, c) * 180 / Math.PI;

		double max = ws1;
		max = Math.max(max, ws2);
		max = Math.max(max, ws3);
		max = Math.max(max, ws4);
		if (max > 1) {
			ws1 /= max;
			ws2 /= max;
			ws3 /= max;
			ws4 /= max;
		}
		DriveTrain.setDrivePower(ws4, ws2, ws1, ws3);
		DriveTrain.setLocation(angleToLoc(wa4), angleToLoc(wa2),
				angleToLoc(wa1), angleToLoc(wa3));
	}

	public static void humanDrive(double fwd, double str, double rot) {
		if (Math.abs(rot) < 0.01)
			rot = 0;

		if (Math.abs(fwd) < .15 && Math.abs(str) < .15 && Math.abs(rot) < 0.01) {
			// setOffSets();
			setDriveBrakeMode(true);
			stopDrive();
		} else {
			setDriveBrakeMode(false);
			swerveDrive(fwd, str, rot);
			// resetOffSet();
		}
	}

	public static void fieldCentricDrive(double fwd, double str, double rot) {
		double temp = (fwd * Math.cos(getgyroAngleInRad()))
				+ (str * Math.sin(getgyroAngleInRad()));
		str = (-fwd * Math.sin(getgyroAngleInRad()))
				+ (str * Math.cos(getgyroAngleInRad()));
		fwd = temp;
		humanDrive(fwd, str, rot);
	}

	public static void tankDrive(double left, double right) {
		setAllLocation(0);
		setDrivePower(right, left, right, left);
	}
}