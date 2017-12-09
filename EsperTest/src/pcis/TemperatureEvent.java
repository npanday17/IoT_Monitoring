package pcis;

public class TemperatureEvent 
{
	public double Temperature;
	
	public TemperatureEvent() 
	{
	}
	
	public TemperatureEvent(double temperature) 
	{
		this.Temperature = temperature;
	}

	public double getTemperature() 
	{
		return Temperature;
	}
	public void setTemperature(double temperature) 
	{
		Temperature = temperature;
	}
}
