package org.firstinspires.ftc.teamcode.teamcode.Labs.Lab1.Lab1_4;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.teamcode.Hardware.Controls.Controller;


@TeleOp(name="LAB 1.4: Switch Demo 3", group="Iterative Opmode")
public class Demo4ArmStateMachine extends com.qualcomm.robotcore.eventloop.opmode.OpMode {
	
	Controller controller1;
	com.qualcomm.robotcore.hardware.Servo armServo;
	
	
	private ArmState currentArmState = ArmState.DOWN;
	
	
	@Override
	public void init() {
		armServo = hardwareMap.get(com.qualcomm.robotcore.hardware.Servo.class, "armservo");
		controller1 = new Controller(gamepad1);
	}
	
	
	@Override
	public void loop() {
		
		switch (currentArmState){
			
			case DOWN:
				armServo.setPosition(0.1);
				
				if(controller1.LB.press()) currentArmState = ArmState.UP;
				if(controller1.LS.press()) currentArmState = ArmState.FOLDED;
				
				break;
			
				
			case UP:
				armServo.setPosition(0.4);
				
				if(controller1.LB.press()) currentArmState = ArmState.DOWN;
				if(controller1.LS.press()) currentArmState = ArmState.FOLDED;
				
				break;
			
				
			case FOLDED:
				armServo.setPosition(0.9);
				
				if(controller1.LB.press()) currentArmState = ArmState.UP;
				if(controller1.LS.press()) currentArmState = ArmState.DOWN;
				
				break;
				
		}
		
	}
	
	
	private enum ArmState {
		DOWN,
		UP,
		FOLDED
	}
	
}