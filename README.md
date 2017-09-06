# HomeworkHelpers
A tool designed to help both students and mentors

--Who This Tool Is For--
  HomeworkHelpers is designed to offer an alternative meeting place for students seeking help with school(-related) work and 
  those who are able to offer assistance with those topics. It is also to function as an extension of the existing knowledge hubs 
  on campus including the Learning Center, Cyber Battle Lab, Fusion Lab, and various specialty groups that operate on campus. Any 
  administrative work or moderation is to be left to the Director of the Learning Center. 
  
 --About The Tool--
   	Although there are billions of search results for any given homework problem, sometimes looking at a screen will not suffice. 
   But for many students unable to make it to the Learning Center or Cyber Battle Lab, or who are in advanced studies with small
   class sizes, this is the most help they can rely upon. HomeworkHelpers is meant to make the benefits of the Learning Center 
   and other campus resources more accessible to those who may need it such as distance learning students or those with 
   complicated schedules. As a web interface/extension, it has the advantage of being more available to students without regard 
   to time or location, and because the educational resources/helpers are physical and within the school, these students will 
   have a more effective option than a simple online search. This tool will not replace the existing online presence of any group 
   or individual on campus, but rather present the full breadth of learning resources available within our school, in this case 
   by giving the contact information of those who consent to the platform. While most of our knowledge hubs will be operating in 
   a physical location on campus and some may have deployed an online component, there is no go-to resource that aligns all of 
   these meeting places together. As a reference for possible mentors, HomeworkHelpers may provide new opportunities for students 
   looking to learn skills and even provide the encouragement to advance in related skill sets.
  
--What This Tool Offers--
   	THIS EXTENSION WILL BE ACTIVE ONLY ON THE CAPTECHU CANVAS SITE MAP! All person-to-person communication will occur outside of 
   HomeworkHelpers, whether it takes place on an existing online resource (like Slack), over e-mail, or in person. No forum-like 
   posts or threads will be available as chat moderation presents an issue at this time. In order to appropriately distribute the 
   efforts of our volunteer pool, weight will be given to those affiliated with campus knowledge hubs, most especially, the 
   Learning Center and Cyber Battle Lab. Secondary importance will go to clubs and chapter groups. Independent mentors are 
   certainly welcome to join but seeing as there is no offer of paid mentorship or other minimum requirements for joining, it may 
   be less overwhelming to stack the distribution this way.
   	HomeworkHelpers could also benefit clubs by directing curious minds to their meetings and/or members. The close nature of our 
   school's programs encourages students to work together and find intersections in their studies and skill sets. Therefore, if 
   someone is interested in learning about something (such as robotics), there's a great likelihood that there is already a 
   resource on campus devoted to, or specializing in it. This would give our clubs more exposure and fresh initiative to pursue 
   greater efforts.
   
--Access Control--
	Access will be controlled by the Canvas API, which will offer security without users needing to memorize a second password. 
	The HomeworkHelpers database will be stored on school servers and encrypted in accordance with FERPA. So far, only students 
	who can still log in to Canvas are included in the users.
	
--Security--
	The client will be enabled with OAuth2 security measures, meaning that students' passwords are never given to our extension, 
	server, or database.

--Login Flow--
	If the user navigates to Canvas and is not able to log in as a student, the admin login will still be available to activate 
	the extension.

--Program Architecture--
		The Front end of this utility will be an extension which we plan to make available in Firefox initially, perhaps other 
	browsers pending response and/or demand. This will involve HTML, CSS, and JavaScript. The front-end will send JSONRequests 
	to the server. This client will login with the given student user instance or provided admin login, which will then be handed 
	off to the server for verification. 
		The back-end of the program will run on a multi-threaded Java server and latch into the database. It will be responsible 
	for maintaining the data structures obtained from the database, as well as updating database records upon change (such as a 
	new topic or new help site associated with a topic). The server will receive JSONRequests from the clients and return 
	JSONResponses.
	The database will store the topics, available help sources, and feed those data to the server.  

--People to Contact--
	+Approval from the Learning Center (Washington)
	+Approval from the Cyber Battle Lab
	+Robotics Club
	+Institute of Electrical and Electronics Engineers
	+Rocketry Club
	+Society of Women Engineers
	+NSBE
	+STEMM

--Question Section--
	-Would an admin be able to remove mentors/topics?
		Suggested answer: Admin would be able to see new topics as they are added and can receive warnings of topics that 
		are too closely related, duplicate, etc.

	-How would the admin gain access without canvas? Admin responsibility has to be easy to pass around and/or distribute.
		Suggested answer: See if the registrar can add them to the class for these circumstances.
	-Define the Granularity of Supported Topics: Will we be working with Full courses? If not, how to break up topics?

	-Potentially allow users to suggest topics? (manual or automatic)

	-Research FERPA and other legal requirements

	-Who can see what Canvas pages?

--Project Breakdown--
-Web Face Team handles:
	-UI Mockup (Perhaps we should allow users to self-rate their experience/availability on a sliding scale)
	-The HTML modifications for our page to appear
	-Integrating said modifications with  a way to speak to the backend (the web face needs to know where on the page a user is so that relevant data is shown)
	+Look up the JavaSecurity Class
	+Look up OAuth2, Angular.js, and the Canvas API
-Security Team
	-OAuth modules
	-Transmission Encryption
	+Look up OAuth2 and Canvas API
	-Should we use Canvas-provided info or allow users to populate fields?
-Server
	-The Server Functionality 
	-The Server GUI
	+Look up MongoDB, how it works with Java
	+Lookup the JavaSecurity Class
-Database
	-MongoDB (JS shell, JSON)
	-Entity Relation Diagram
	+Look up MongoDB and available Security measures for it