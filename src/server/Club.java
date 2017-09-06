package server;

import java.util.HashSet;

/**
 * This class is designed to encapsulate the fields and behaviors of a campus club.
 * @author kireh
 *
 */
class Club
{
	private long clubID;
	private String clubName;
	private HashSet<User> members;
	private HashSet<Subject> topics;

	//changeDetective variables
	private boolean rosterChanged;
	private boolean topicsChanged;

	public Club()
	{

	}

	public boolean addStudent(User newMember)
	{
		return false;
	}

	public boolean remStudent(User remMember)
	{
		return false;
	}


}
