## Spring MVC Film C.R.U.D. Project
### Team Members: David Norris & Adam Onwan

### Overview

This program simulates a film database CRUD.

### How to run
1. Open the file on Eclipse
2. Click the play button or click anywhere in the code and right click Run on Server

#### Installation
1. Download JDK8
2. Download Eclipse STS
3. Download JDBC
4. Download MAMP
5. Download the zip files
6. Unzip into a working set on Eclipse
7. Get SQL database file from Skills Distillery to communicate with database

#### Using the app
1. Upon startup the user will be prompted 2 button choices
2. Choice 1 is to communicate to the SQL database and add a film
3. Choice 2 is to communicate to the SQL database and lookup films via searching or ID
4. After making a film or adding a film, the display screen appears and you can go back to the index page or update/delete the film using the buttons with the correct labels.

### Technologies/topics used
1. Annotations - Used @Controller, @Autowired, @RequestMapping, @Component, @Override, @Valid, @NotNull, @Size, @Min, @Max
2. Tomcat 8.5 Server - Server used to run the program on
3. Web Applications - Used GET requests and WEB INF folder to store JSPs and servlets to help with encapsulation as in not being accessible from web server everyone can view. Used web.xml for servlet mapping. HTML file outside of WEB INF folder for visibility.
4. JSP Expression Language - Used expression language to access data from database and display onto a page
5. JSTL, JSP Standard Tag Libraries - Used foreach tag to grab multiple actors from the database and display onto a page
6. DAO, Data Access Objects - Used DAO to store and retrieve information from database and server
7. Try/Catch - to catch SQL errors on the application, and prevent the program from crashing
8. Gradle - Manages dependencies
9. Eclipse STS, Spring Tool Suite - IDE that specializes in Spring
10. JDBC SQL - Used SQL commands to communicate CRUD actions with the database

### Lessons learned
1. A lot was learned this week and it feels like there's a ton of ways to go about doing something now. As in using a pattern matcher to find and prevent the errors or using errors annotations or both. Also, doing a GET or a POST or both. Doing an IF statement or using try/catch. Doing something in an HTML file or a JSP file. Having just a standard form field or turning it into a checkbox or something else. To use a @RequestParams or prepopulate values in the JSP. So just goes to show there is a lot of ways to go about a problem now.
2. Merge conflicts - Usually occured when trying to solve an issue together. Best thing to do is let the other person know a merge conflict is likely to happen so they fix the issues rather than keep working and wonder why its not working properly. Also to work on seperate files, which is tough for beginners because waiting for something to be done before trying to do something on a different file, not yet skilled enough to prepopulate data without having something to test it on. 
3. A lot of error pages, a few fixes were using wrapper classes to avoid 500 errors and making default values
4. Timezone change really messed us up too, for awhile we was trying to figure out why the data from database would not register properly so checking something simple as the URL String is a big deal
5. Annotations seem to work only when a page has key values in it, if certain values are blank it will crash, we prepopulated the fields that should have a value in them and used try catch blocks.
