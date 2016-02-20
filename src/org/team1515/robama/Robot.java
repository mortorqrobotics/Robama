
package org.team1515.robama;

import org.team1515.robama.commands.PrepShooter;
import org.team1515.robama.commands.Shoot;
import org.team1515.robama.subsystems.BottomShooter;
import org.team1515.robama.subsystems.BoulderRamp;
import org.team1515.robama.subsystems.Intake;
import org.team1515.robama.subsystems.TopShooter;
import org.team1515.robama.subsystems.Wedge;
import org.team1515.robama.subsystems.WedgeIntake;
import org.team1515.robama.subsystems.driveTrain.DecentDrive;
import org.team1515.robama.subsystems.driveTrain.WestCoastDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	
	public static final Joystick stick1 = new Joystick(RobotMap.JOYSTICK_DRIVE);
	public static final Joystick stick2 = new Joystick(RobotMap.JOYSTICK_AUX);
	
	public static final WestCoastDrive driveTrain = new DecentDrive(stick1);
	public static final TopShooter topShooter = new TopShooter();
	public static final BottomShooter bottomShooter = new BottomShooter();
	public static final Intake intake = new Intake();
	public static final BoulderRamp ramp = new BoulderRamp();
	public static final Wedge wedge = new Wedge();
	public static final WedgeIntake wedgeIntake = new WedgeIntake();
	
	Gyro gyro;

    Command autonomousCommand;
    
    Config config;

    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
		gyro = new ADXRS450_Gyro();
		
		SmartDashboard.putBoolean("rampTilted", false);
		
		Config.init();

		// add command to change shooting speed
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        
        driveTrain.resetEncoders();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	// Stop autonomous when teleop starts
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        driveTrain.resetEncoders();
        
        ramp.setTilted(SmartDashboard.getBoolean("isTilted", false));
        
        new Shoot(1);
        new PrepShooter(1);
    }

    public void disabledInit(){

    }

    boolean rumbling = false;
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putData("gyroAngle", (ADXRS450_Gyro) gyro);
        
//        System.out.println(driveTrain.getLeftEncoder() + "\t" + driveTrain.getRightEncoder());

        //Get ready to RUMBLE!!!!!
        if(Math.random() < 0.01) {
        	rumbling = !rumbling;
        }
        if(rumbling) {
//        	stick2.setRumble(Joystick.RumbleType.kLeftRumble, 1);
//        	stick2.setRumble(Joystick.RumbleType.kRightRumble, 1);
        } else {
//        	stick2.setRumble(Joystick.RumbleType.kLeftRumble, 0);
//        	stick2.setRumble(Joystick.RumbleType.kRightRumble, 0);
        }
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
