package frc.robot.subsystems;
import edu.wpi.first.units.measure.Power;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase{
    //placeholder PWM motor on channel 0
    private final MotorController motor = new PWMSparkMax(0);

    public TurretSubsystem(){}

        public void setPower(double power){
            motor.set(power);
        }

        public void stop(){
            motor.stopMotor();
        }

    
    
    
}
