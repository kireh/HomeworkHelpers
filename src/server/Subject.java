package server;

import java.util.HashSet;

class Subject
{
	private String sid; //the subject ID
	private String subName; //the subject name
	private HashSet<User> tutors; //the list of tutors for a subject
	private HashSet<Club> clubs; //the list of clubs specializing in a subject

	//changeDetective variables
	private boolean tutorsChanged;
	private boolean clubsChanged;

	public Subject(String id, String name, HashSet<User> newMentors, HashSet<Club> groups)
	{

	}

	public String getSID()
	{
		return this.sid;
	}

	public String getSubName()
	{
		return this.subName;
	}

	public HashSet<User> getTutors()
	{
		return this.tutors;
	}

	public HashSet<Club> getClubs()
	{
		return this.clubs;
	}
}
