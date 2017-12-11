package pcis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.StatementAwareUpdateListener;

public class EsperTest implements StatementAwareUpdateListener
{
	public EPServiceProvider engine;
	private static TemperatureEvent tempEvent = null;
	
	public EsperTest()
	{
		engine = EPServiceProviderManager.getDefaultProvider();
		engine.getEPAdministrator().getConfiguration().addEventType(TemperatureEvent.class);
	}
	
	public void addStatement(String query)
	{
		EPAdministrator cepAdm = engine.getEPAdministrator(); 
        EPStatement statement = cepAdm.createEPL(query);
        statement.addListener(this);
	}
	
	public void removeStatement(String statement)
	{
		engine.getEPAdministrator().getStatement(statement).destroy();
	}
	
	public String[] getStatementsNames()
	{
		return engine.getEPAdministrator().getStatementNames();
	}
	
	public void destroyAllStatements()
	{
		engine.getEPAdministrator().destroyAllStatements();
	}
	
	public String getStatementText(String name)
	{
		return engine.getEPAdministrator().getStatement(name).getText();
	}
	
	public static TemperatureEvent getTemperatureEventObject()
	{
		if(tempEvent == null)
		{
			tempEvent = new TemperatureEvent();
		}
		return tempEvent;		
	}
	
	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents, EPStatement statement, EPServiceProvider epServiceProvider) {
		
		switch(statement.getName())
		{
		case "stmt_1":
			JOptionPane.showMessageDialog(null, "stmt_1 : " + statement.getText());
			break;
		case "stmt_2":
			JOptionPane.showMessageDialog(null, "stmt_2 : " + statement.getText());
			break;
		default:
			break;
		}	
		
		//double temperature = (double) newEvents[0].get("temperature");
		//JOptionPane.showMessageDialog(null, "Temperature is : " + String.valueOf(temperature));
	}
	
	public static void main(String[] args) 
	{
		Logger.getRootLogger().setLevel(Level.OFF);
		
		TemperatureEvent event = EsperTest.getTemperatureEventObject();

		EsperTest esper = new EsperTest();
		
		esper.addStatement("SELECT * from TemperatureEvent where temperature > 25");
		esper.addStatement("SELECT * from TemperatureEvent where temperature < 15");
		
		//test.removeStatement("stmt_1");
		
		//test.destroyAllStatements();
		
		event.setTemperature(12);
		esper.engine.getEPRuntime().sendEvent(event);
		event.setTemperature(30);
		esper.engine.getEPRuntime().sendEvent(event);
		
		String[] statements = esper.getStatementsNames();
		for(int i=0; i<statements.length; i++)
		{
			//JOptionPane.showMessageDialog(null, statements[i] + " : " + esper.getStatementText(statements[i]));
		}
	}
}
