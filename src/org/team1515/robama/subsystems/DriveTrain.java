package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class DriveTrain extends Subsystem {
	public abstract void drive();
	public abstract void forward(double speed);
	public abstract void backward(double speed);
	public abstract void stop();
	protected abstract double getThrottle();
	public abstract void resetEncoders();
	public abstract boolean turnLeft(int position, double speed);
	public abstract boolean turnRight(int position, double speed);
}
