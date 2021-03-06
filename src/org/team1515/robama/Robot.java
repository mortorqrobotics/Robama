package org.team1515.robama;

import org.team1515.robama.commands.auto.CDFAuto;
import org.team1515.robama.commands.auto.DriveForwardAuto;
import org.team1515.robama.commands.auto.LowbarAuto;
import org.team1515.robama.commands.auto.PortcullisAuto;
import org.team1515.robama.subsystems.BottomShooter;
import org.team1515.robama.subsystems.BoulderRamp;
import org.team1515.robama.subsystems.Intake;
import org.team1515.robama.subsystems.TopShooter;
import org.team1515.robama.subsystems.Wedge;
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
	
//	PigeonVision vision;
	
	public static final Gyro gyro = new ADXRS450_Gyro();
//	public static final PiConnection rpi = new PiConnection();
//	public static final SimpleVision vision = new SimpleVision();

    Command autonomousCommand;
//	SendableChooser chooser;
    
    Command streamCommand;
    
    Config config;
	
	private long teleopStartTime;
	private static final int TELEOP_LENGTH = 2 * 60 + 15; // seconds

    public void robotInit() {
		oi = new OI();
		
//		vision = new PigeonVision();
//		SmartDashboard.putData("vision", new ActionCommand(() -> {
//			vision.findGoal();
//		}));
		
		SmartDashboard.putBoolean("rampTilted", false);
        
//        SmartDashboard.putData("copyImages", new ActionCommand(() -> {
//        	rpi.sendCopyRequest();
//        }));
		
//		streamCommand = new Stream();
        
        // AUTONOMOUS
		
//        autonomousCommand = new DriveForwardAuto(2);
//        autonomousCommand = new LowbarAuto();
        autonomousCommand = new PortcullisAuto();
//        autonomousCommand = new CDFAuto();
		
//		chooser = new SendableChooser();
//		chooser.addDefault("DriveForward", new DriveForwardAuto(2));
//		chooser.addObject("Lowbar", new LowbarAuto());
//		chooser.addObject("Portcullis", new PortcullisAuto());
//		chooser.addObject("CDF", new CDFAuto());
//		SmartDashboard.putData("Autonomous", chooser);

		Config.init();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
//    	autonomousCommand = (Command) chooser.getSelected();
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
        
        if(driveTrain.isReversed()) {
        	driveTrain.reverse();
        }
        
        if (streamCommand != null) {
        	streamCommand.start();
        }
        
        teleopStartTime = System.currentTimeMillis();
    	stick2.setRumble(Joystick.RumbleType.kLeftRumble, 0);
    	stick2.setRumble(Joystick.RumbleType.kRightRumble, 0);
    }

    public void disabledInit(){

    }

//    boolean rumbling = false;
    public void teleopPeriodic() {    	
        Scheduler.getInstance().run();
        
        SmartDashboard.putData("gyroAngle", (ADXRS450_Gyro) gyro);
        
//        rpi.update();
        
//        System.out.println(driveTrain.getLeftEncoder() + "\t" + driveTrain.getRightEncoder());

        // Get ready to RUMBLE!!!!!
//        if(Math.random() < 0.01) {
//        	rumbling = !rumbling;
//        }
//        if(rumbling) {
//        	stick2.setRumble(Joystick.RumbleType.kLeftRumble, 1);
//        	stick2.setRumble(Joystick.RumbleType.kRightRumble, 1);
//        } else {
//        	stick2.setRumble(Joystick.RumbleType.kLeftRumble, 0);
//        	stick2.setRumble(Joystick.RumbleType.kRightRumble, 0);
//        }
        
        SmartDashboard.putNumber("topEncoder", Math.floor(topShooter.getEncoder()));
        
        if(System.currentTimeMillis() - teleopStartTime >= (TELEOP_LENGTH - 5) * 1000) {
        	stick2.setRumble(Joystick.RumbleType.kLeftRumble, 1);
        	stick2.setRumble(Joystick.RumbleType.kRightRumble, 1);
        }
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
