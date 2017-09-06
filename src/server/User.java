package server;

import java.util.ArrayList;
import java.util.HashSet;

/**
* Data Structure to be used when the users' information is pulled from the database
 * !!For new users, see the NewUser subclass
 * @author kireh
 * @version 0.1
 *
 */
class User
{
	//personal info fields, should not be expected to change often
	private String fName; //user first name
	private String lName; //user last name
	private String email; //user contact email
	private String uid; //user identification token
	private byte admin; //user adminLevel: 0 for student, 1 for professor, 2 for higher administrator

	//tutor info, will be more variable
	private byte tutorWeight; //tutor preference based on campus affiliation, 2 for learning center, 1 for club, 0 for unaffiliated
	private HashSet<String> topics; //the set of topics in which a tutor is confident

	//club info, variable
	private HashSet<Club> clubs;

	//changeDetective booleans to trigger database updates
	private boolean userInfoChanged; //signifies changes in the user info fields, as grouped above
	private boolean topicsChanged; //signifies change in the topics set
	private boolean clubsChanged; //signifies change in clubs list
	private boolean tutorWeightChanged; //signifies change in tutor display priority
	private boolean newUser; //signifies user is new to the database
	private boolean removeUser; //signifies user wants to be removed from the extension

	/**
	 * Creates a new User object based on information received from the database
	 * @param fn First Name as a String
	 * @param ln Last Name as a String
	 * @param uid UID as a long
	 * @param admin AdminLevel as a Byte
	 * @param topics Topic set as a String[]
	 */
	public User(String fn, String ln, String email, long uid, byte admin, String[] topics, boolean isNew)
	{
		setFName(fn);
		setLName(ln);
		setEmail(email);
		setUID(uid);
		setAdminLevel(admin);
	}

	/**
	 * Determines which types of changes have occured since the object was last compared to the database version
	 * @return Necessary updates as a String[]
	 */
	public ArrayList<String> getChangeType()
	{
	   ArrayList<String> ans = new ArrayList<>();
        if (newUser)
        {
        	ans.add("New User");
        	return ans;
        }
        if (removeUser)
        {
            ans.add("Remove User");
        	return ans;
        }
       if (userInfoChanged)
           ans.add("User Info");
       if (topicsChanged)
           ans.add("Topics");
        if(clubsChanged)
            ans.add("Clubs");
        if(tutorWeightChanged)
            ans.add("Tutor Weight");
        return ans;    
	}
    
    /**
    *Resets the detective variables so that unneccessary data is not sent to the database
    *@return successful reset as a boolean
    */
    public boolean resetDetectives()
    {
        userInfoChanged=false;
        topicsChanged = false;
        clubsChanged=false;
        tutorWeightChanged=false;
        return (!userInfoChanged && !topicsChnged && !clubsChanged && !tutorWeightChanged) //check individually that each is reset and has not been altered
    }

	/**
	 * Accesses a user's full name
	 * @return Full Name as a String
	 */
	public String getName()
	{
		return this.fName + " " +this.lName;
	}

	/**
	 * Accesses a user's first name
	 * @return First Name as a String
	 */
	public String getFName()
	{
		return this.fName;
	}

	/**
	 * Accesses a user's last name
	 * @return Last Name as a string
	 */
	public String getLName()
	{
		return this.lName;
	}

	/**
	 * Accesses a user's email
	 * @return Email as a String
	 */
	public String getEmail()
	{
		return this.email;
	}

	/**
	 * Accesses a user's ID token
	 * @return ID as a String
	 */
	public String getUID()
	{
		return this.uid;
	}

	/**
	 * Checks a user's privilege
	 * @return AdminLevel as a byte
	 */
	public byte getAdminLevel()
	{
		return this.admin;
	}

	/**
	 * Accesses a tutor's relative priority for display
	 * See User.setTutorweight() for guidelines
	 * @return tutorWeight as a byte
	 */
	public byte getTutorWeight()
	{
		return this.tutorWeight;
	}

	/**
	 * Accesses the set of topics in which the tutor is willing to mentor
	 * @return set of Topics as a HashSet<String>
	 */
	public HashSet<String> getTopics()
	{
		return this.topics;
	}

	/**
	 * Updates the first name of a user
	 * @param fN new First Name of the user
	 */
	public void setFName(String fN)
	{
		this.fName=fN;
	}

	/**
	 * Updates the last name of a user
	 * @param lN new Last Name as a String
	 */
	public void setLName(String lN)
	{
		this.lName=lN;
	}

	/**
	 * Updates the email of a user
	 * @param newMail new Email as a String
	 */
	public void setEmail(String newMail)
	{
		this.email=newMail;
	}

	/**
	 * Updates the student ID of a user
	 * @param newUID new ID a long
	 */
	public void setUID(long newUID)
	{
		this.uid=newUID;
	}

	/**
	 * Sets the adminLevel of a user
	 * Should require the permission of another admin
	 * @param newAdmin new AdminLevel of a user
	 */
	public void setAdminLevel(byte newAdmin)
	{
		this.admin = newAdmin;
	}

	/**
	 * Updates the display priority of a user
	 * @param newTutorWeight the new display priority as a byte
	 */
	public void setTutorWeight(byte newTutorWeight)
	{
		this.tutorWeight = newTutorWeight;
	}

	/**
	 * Allows the user to add new Topics to their set
	 * Must trigger an update to the database if called
	 * @param newTopics new Topics to be added as a String[]
	 */
	public void addTopics(String[] newTopics)
	{
		int count = 0;
		for(String x: newTopics)
		{
			if(topics.add(x))
			{
				count++;
                this.topicsChanged=true;
				System.out.println("Added " +x +" to topic list");
			}
			else
			{
				System.out.println(x +" was not added to topic list");
			}
		}
		System.out.println("Total subjects added: " +count);
	}

	/**
	 * Allows the user to remove topics from their set
	 * Must trigger an update to the database if called
	 * @param remTopics topics to be removed as a String[]
	 */
	public void removeTopics(String[] remTopics)
	{
		for (String x: remTopics)
		{
            if(topics.remove(x))
			//remove it from the database
			
		}
	}

	/**
	 * Allows a User to join a club and also has the club list the user on their roster
	 * Must call the club to have it add the user also
	 * @param newClub the Club object the user is joining
	 * @return successfully joined club as a boolean
	 */
	public boolean joinClub(Club newClub)
	{
		if (newClub.addStudent(this) && clubs.add(newClub))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Allows a User to leave a club and checks that they are removed from the club's roster
	 * Must call to the club
	 * @param remClub
	 * @return
	 */
	public boolean leaveClub(Club remClub)
	{
		if (remClub.remStudent(this) && clubs.remove(remClub))
		{
			return true;
		}
		else
		{
			return false;
		}
	}




}
