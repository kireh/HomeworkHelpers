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

public class Server extends JFrame
{
	 //GUI instance variables
    private JTextArea logs;
    private Date now;
    private JScrollPane logPane;



	public Server()
	{
		super("EvalEvolved Server Software");
		this.setSize(new Dimension(500, 600));
		this.setResizable(false);
		logs = new JTextArea(300,600);
		this.add(new JScrollPane(logs));
		this.setAlwaysOnTop(true);
			update("Connecting to database");
			MongoClient mongoClient = new MongoClient();//connection for the database
		    @SuppressWarnings("deprecation")
			DB db = mongoClient.getDB("unicorns");
		    update("Connected to database");



	}

	private void update(String s)
    {
        //The following lines get the proper time
        Calendar c = Calendar.getInstance(TimeZone.getDefault());
        String time ="[" +c.get(Calendar.MONTH)+"/"+c.get(Calendar.DATE)+"/"+c.get(Calendar.YEAR)+"@" +c.get(Calendar.HOUR_OF_DAY)+":" +c.get(Calendar.MINUTE) +"] ";

        logs.append("\n" +time +s);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
