package server;

import java.awt.Dimension;
import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
//import com.mongodb.ServerAddress;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The executable class for the HomeworkHelpers server, includes a GUI and connects to MongoDB 
 * @author kireh
 * @version 0.1
 */
public class Server extends JFrame
{
	 //GUI instance variables
    private JTextArea logs; /*The server log which will show meesages and/or errors*/
    private Date now; /*A date to timestamp each of the messages*/
    private JScrollPane logPane; /*The scrolling pane which will show the server logs*/

    //MongoDB client connection variables
    private MongoClient mongoClient = null;
    
    //Internet Connection variables
    
    //Canvas API connection variables
    
    //Security variables

    /**
     * Constructs a new Server, connects it to the database
     */
	public Server()
	{
		//set up the GUI
		super("HomeworkHelpers Server Software");
		this.setSize(new Dimension(500, 600));
		this.setResizable(false);
		logs = new JTextArea(300,600);
		this.add(new JScrollPane(logs));
				
		//attempt a connection to the database
		update("Connecting to database");
		mongoClient = new MongoClient();//connection for the database
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("unicorns");
		update("Connected to database");
	}

	/**
	 * Appends an update message to the server logs for users
	 * @param s The new message to be appended as a String
	 */
	private void update(String s)
    {
        //The following lines get the proper time
        Calendar c = Calendar.getInstance(TimeZone.getDefault());
        String time ="[" +c.get(Calendar.MONTH)+"/"+c.get(Calendar.DATE)+"/"+c.get(Calendar.YEAR)+"@" +c.get(Calendar.HOUR_OF_DAY)+":" +c.get(Calendar.MINUTE) +"] ";

        logs.append("\n" +time +s);
    }


	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}

}
