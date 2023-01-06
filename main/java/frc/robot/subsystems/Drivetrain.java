/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;

public class Drivetrain extends SubsystemBase {

  //define Spark Maxes with IDs and as brushless controllers
  private final VictorSPX backLeft = new VictorSPX(Constants.BACK_LEFT_SPARKMAX_ID, MotorType.kBrushless);
  private final VictorSPX frontLeft = new VictorSPX(Constants.FRONT_LEFT_SPARKMAX_ID, MotorType.kBrushless);
  private final VictorSPX backRight = new VictorSPX(Constants.BACK_RIGHT_SPARKMAX_ID, MotorType.kBrushless);
  private final VictorSPX frontRight = new VictorSPX(Constants.FRONT_RIGHT_SPARKMAX_ID, MotorType.kBrushless);

	// define left and right side controller groups
	private final SpeedControllerGroup left = new SpeedControllerGroup(backLeft, frontLeft);
	private final SpeedControllerGroup right = new SpeedControllerGroup(backRight, frontRight);

	// define drive
	private final DifferentialDrive drive = new DifferentialDrive(left, right);

	public Drivetrain() {
		backLeft.setOpenLoopRampRate(.2);
		frontLeft.setOpenLoopRampRate(.2);
		backRight.setOpenLoopRampRate(.2);
		frontRight.setOpenLoopRampRate(.2);
	}

	public void arcadeDrive(double fwd, double rot) {
		drive.arcadeDrive(fwd, rot);
	}

	public void curvatureDrive(double fwd, double rot, boolean isQuickTurn) {
		drive.curvatureDrive(fwd, rot, isQuickTurn);
	}

	public void setMaxOutput(double maxOutput) {
		drive.setMaxOutput(maxOutput);
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
