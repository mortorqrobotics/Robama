package org.team1515.robama.subsystems.driveTrain;

import org.team1515.robama.Config;
import org.team1515.robama.commands.ActionCommand;
import org.team1515.robama.commands.test.TestForward;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDTest {
	
	MotorModule motors;
	PIDController pid;
	
	public PIDTest(MotorModule motors) {
		this.motors = motors;
		this.pid = motors.getPIDController();
		
		Config.setDefault("pidP", 0);
		Config.setDefault("pidI", 0);
		Config.setDefault("pidD", 0);
		
		SmartDashboard.putData("updatePID", new ActionCommand(() -> {
			pid.setPID(Config.getDouble("pidP"), Config.getDouble("pidI"), Config.getDouble("pidD"));
		}));
		
		SmartDashboard.putData("testForward", new TestForward(this));
	}
	
	public MotorModule getMotors() {
		return motors;
	}
	
	public PIDController getPIDController() {
		return pid;
	}

}
