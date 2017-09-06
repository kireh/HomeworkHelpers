package server;

import java.util.HashSet;

/**
 * Encapsulates a tutorable Subject as would be held in the database
 * @author kireh
 * @version 0.1
 *
 */
class Subject
{
    
    private String sid; //the subject ID
	private String subName; //the subject name
    private String treeEnum; //will be changed to an enum to allow for related subjects to appear together
	private HashSet<User> tutors; //the list of tutors for a subject
	private HashSet<Club> clubs; //the list of clubs specializing in a subject
    
    
	//changeDetective variables
	private boolean tutorsChanged;
	private boolean clubsChanged;
    private boolean treeChanged; //useless for now but possibly useful depending on how the related subjects work

	public Subject(String id, String tree, String name, HashSet<User> newMentors, HashSet<Club> groups)
	{
        
	}

    /**
    *Accesses the subjectID
    *@return SubjectID as a String
    */
	public String getSID()
	{
		return this.sid;
	}

    /**
    *Accesses the Subject Name
    *@return Subject name as a String
    */
	public String getSubName()
	{
		return this.subName;
	}

    /**
    *Accesses the set of tutors for a Subject
    *@return set of tutors as a HasSet<User>
    */
	public HashSet<User> getTutors()
	{
		return this.tutors;
	}

    /**
    *Accesses the list of clubs related to a Subject
    *@return set of clubs as a HashSet<Club>
    */
	public HashSet<Club> getClubs()
	{
		return this.clubs;
	}
	
    /**
    *Read a JSONSubject and instantiates its fields as a Subject object
    *@return the subject as a Java Subject object
    */
	public static Subject read(JSONObject JSONSubject)
	{
		
	}
    
    /**
    *Determines if a Subject is equivalent to another object
    *@return equality as a bolean
    */
    public boolean equals(Object b)
    {
        if (b instanceOf Subject)
        {
            Subject c = (Subject)(b);
            return (c.getSID()==this.getSID);
        }
        else
        {
            return false;
        }
    }
}
