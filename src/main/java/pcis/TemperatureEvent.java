package pcis;

public class TemperatureEvent 
{
	private double Temperature;
	private String query;
	public TemperatureEvent(double temperature) 
	{
		this.Temperature = temperature;
	}

	public double getTemperature() 
	{
		return Temperature;
	}

}
