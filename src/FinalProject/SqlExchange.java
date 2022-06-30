package FinalProject;

import java.sql.*;

import oracle.jdbc.pool.*;

import java.util.*;


public class SqlExchange {



    public ResultSet rs;
    //ArrayList<Volunteer> volunteerArrayList = new ArrayList<>();
    ArrayList<VolunteerApplication> volunteerApplicationArrayList = new ArrayList<>();
    ArrayList<Event> eventArrayList = new ArrayList<>();
    ArrayList<SocialPost> socialPostArrayList = new ArrayList<>();
    ArrayList<Pet> petArrayList = new ArrayList<>();



    public static void sendDBCommand(String sqlQuery) {
        // Set up your connection strings
        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "javauser"; // Change to YOUR Oracle username
        String userPASS = "javapass"; // Change to YOUR Oracle password
        OracleDataSource ds;
        Connection dbConn;
        Statement commStmt;
        ResultSet dbResults;

        // Clear Box Testing - Print each query to check SQL syntax
        //  sent to this method.
        // You can comment this line out when your program is finished
        System.out.println(sqlQuery);

        // Lets try to connect
        try {
            // instantiate a new data source object
            ds = new OracleDataSource();
            // Where is the database located? Web? Local?
            ds.setURL(URL);
            // Send the user/pass and get an open connection.
            dbConn = ds.getConnection(userID, userPASS);
            // When we get results
            //  -TYPE_SCROLL_SENSITIVE means if the database data changes we
            //   will see our resultset update in real time.
            //  -CONCUR_READ_ONLY means that we cannot accidentally change the
            //   data in our database by using the .update____() methods of
            //   the ResultSet class - TableView controls are impacted by
            //   this setting as well.
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // We send the query to the DB. A ResultSet object is instantiated
            //  and we are returned a reference to it, that we point to from
            // dbResults.
            // Because we declared dbResults at the datafield level
            // we can see the results from anywhere in our Class.
            dbResults = commStmt.executeQuery(sqlQuery); // Sends the Query to the DB
            // The results are stored in a ResultSet structure object
            // pointed to by the reference variable dbResults
            // Because we declared this variable globally above, we can use
            // the results in any method in the class.
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void sendString(String string){
        sendDBCommand(string);
    }


    public static void populateArrayLists() {
        ArrayList<Volunteer> volunteerArrayList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "javauser", "javapass");
            // volunteer application arraylist population
            Statement stmt = null;
            stmt = connection.createStatement();
            ResultSet rs = null;
            if (stmt != null) {
                rs = stmt.executeQuery("select * from volunteerapplication");
            }
            while (rs.next()){

                VolunteerApplication.volunteerApplicationArrayList.add(new VolunteerApplication(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(6),
                        rs.getString(13), rs.getString(14), rs.getString(15)));
            }

            // volunteer arraylist population
            stmt = null;
            stmt = connection.createStatement();
            rs = null;
            if (stmt != null) {
                rs = stmt.executeQuery("select * from Volunteer");
            }
            while (rs.next()){

                Volunteer.volunteerArrayList.add(new Volunteer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getString(11),rs.getString(12),  rs.getString(13), rs.getString(14),
                        rs.getDouble(15), rs.getString(16), rs.getString(17),  rs.getInt(18)));
            }

            // social post arraylist population
            stmt = null;
            stmt = connection.createStatement();
            rs = null;
            if (stmt != null) {
                rs = stmt.executeQuery("select * from socialposts");
            }
            while (rs.next()){

                SocialPost.socialPostArrayList.add(new SocialPost(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }

            // event arraylist population
            stmt = null;
            stmt = connection.createStatement();
            rs = null;
            if (stmt != null) {
                rs = stmt.executeQuery("select * from event");
            }
            while (rs.next()){

                Event.eventArrayList.add(new Event(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getInt(10)));
            }

            // pet arraylist population
            stmt = null;
            stmt = connection.createStatement();
            rs = null;
            if (stmt != null) {
                rs = stmt.executeQuery("select * from pet");
            }
            while (rs.next()){

                Pet.petArrayList.add(new Pet(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14),
                        rs.getString(15)));
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}