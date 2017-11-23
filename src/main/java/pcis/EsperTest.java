package pcis;

import javax.swing.JOptionPane;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class EsperTest implements UpdateListener
{
	private EPServiceProvider engine;
	private EPStatement statement;
	private String query;
	
	public EsperTest()
	{
//		EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();
//		engine.getEPAdministrator().getConfiguration().addEventType(TemperatureEvent.class);
//		
//		query = "select temperature from TemperatureEvent";
//		
//		statement = engine.getEPAdministrator().createEPL(query);
//		
//		statement.addListener(this);
		
		/*statement.addListener(new StatementAwareUpdateListener() {
			
			@Override
			public void update(EventBean[] newData, EventBean[] oldData, EPStatement arg2, EPServiceProvider arg3) 
			{
				// TODO Auto-generated method stub
				double temperature = (double) newData[0].get("temperature");
				JOptionPane.showMessageDialog(null, "Temperature is : " + String.valueOf(temperature));
			}
		});*/
		
		/*statement.addListener( (newData, oldData) -> {
			double temperature = (double) newData[0].get("temperature");
			JOptionPane.showMessageDialog(null, "Temperature is : " + String.valueOf(temperature)); 
			});*/
		
		//engine.getEPRuntime().sendEvent(te);
		//engine.getEPRuntime().sendEvent(new TemperatureEvent(10.0));
	}

	@Override
	public void update(EventBean[] newData, EventBean[] oldData) 
	{
		// TODO Auto-generated method stub
		double temperature = (double) newData[0].get("temperature");
		JOptionPane.showMessageDialog(null, "Temperature is : " + String.valueOf(temperature));
	}
	

	public void testMethod(TemperatureEvent te) {
		// TODO Auto-generated method stub
		engine = EPServiceProviderManager.getDefaultProvider();
		engine.getEPAdministrator().getConfiguration().addEventType(TemperatureEvent.class);
		
		query = "select temperature from TemperatureEvent where temperature > 10";
		
		statement = engine.getEPAdministrator().createEPL(query);
		
		statement.addListener(this);
		
		engine.getEPRuntime().sendEvent(te);
	}
}
