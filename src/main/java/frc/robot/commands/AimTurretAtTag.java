package frc.robot.commands;

import org.photonvision.simulation.VisionSystemSim;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.swervedrive.Vision;

public class AimTurretAtTag extends Command {
     
    private final TurretSubsystem  turret;
    private final Vision vision;

    //pid constants D:
    private static final double kP = 0.02;
    private static final double deadband = 1.0;
    private static final double maxPower = 0.30;

    public AimTurretAtTag(TurretSubsystem turret, Vision vision){
        this.turret = turret;
        this.vision = vision;

        addRequirements(turret);
    }

    @Override
    public void execute() {

        if(!vision.hasTargets()){
            turret.stop();
            return;
        }

        double error = vision.getTx();
        double power = kP * error;

        //deadzone implement :)
        if(Math.abs(error) < deadband){
            power = 0.0;
        }

        //clamp output
        power = Math.max(-maxPower, Math.min(maxPower, power));

        turret.setPower(power);

    }

    @Override
    public void end(boolean interrupted){
        turret.stop();
    }

    @Override
    public boolean isFinished(){
        return false; 
    }


}
