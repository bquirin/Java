package Lab10;

public class CannonSolution {

	private double angle, velocity;

	//Constructor
	public CannonSolution(double ang, double vel) {
		if(ang>=25 && ang<=55) 
		{
			angle = ang;
		} 
		else 
		{
			angle = CS2004_10.UR(25, 55);
		}
		if(vel >= 1500 && vel <= 1650) 
		{
			velocity = vel;
		} else 
		{
			velocity = CS2004_10.UR(1500, 1650);
		}
	}


	//provides random angle angle and velocity
	public CannonSolution()
	{
		angle = CS2004_10.UR(25, 55);
		velocity = CS2004_10.UR(1500, 1650);
	}


	//setters and getters
	public void setAngle(double ang) 
	{
		angle = ang;
	}


	public double getAngle()
	{
		return angle;
	}


	public void setVelocity(double vel) {
		velocity = vel;
	}


	public double getVelocity()
	{
		return velocity;
	}


	// returns the difference between the chosen range and the actual range; shows how close I am to the target range
	public static double getCannonRangeDiff(double range, double targetRange) 
	{
		return(Math.abs(range-targetRange));
	}


	//Makes a small change to velocity or angle depending on coin toss
	public void smallChange()
	{
		int tossCoin = CS2004_10.UI(0, 1);

		double smallChangeAngle = (angle *0.02);
		double smallChangeVel = (velocity *0.02);

		double randAddAngle = CS2004_10.UR(smallChangeAngle, -smallChangeAngle);
		double randAddVel = CS2004_10.UR(smallChangeVel, -smallChangeVel);

		if(tossCoin == 0) 
		{
			double newAngle = angle + randAddAngle;

			if(newAngle >= 25 && newAngle <=55) 
			{
				angle = newAngle;
			} 
			else 
			{
				angle = CS2004_10.UR(25, 55);
			}

		} 
		else 
		{
			double newVel = velocity + randAddVel;

			if(newVel >= 25 && newVel <=55)
			{
				velocity = newVel;
			} 
			else 
			{
				velocity = CS2004_10.UR(1500, 1650);
			}
		}


	}


	public void print()
	{
		System.out.println("Velocity = " + velocity);
		System.out.println("Angle = " + angle);
	}



}
