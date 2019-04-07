package hello;

import java.sql.*;

public class database {
    Connection connection;
    String myUrl = "jdbc:jtds:sqlserver://HADEER:1433;instance=SQLEXPRESS";

    public database() {
        //System.out.println(java.lang.System.getProperty("java.library.path"));
        try {
            connection  = DriverManager.getConnection(myUrl);
        } catch (SQLException e){
            e.printStackTrace();
        }


    }
    public void addnewapplicant(applicant x){
        String query = "INSERT INTO sw_project.project.[Applicant] (applicant_id,firstname, lastname, username,password,phonenumber,email,gender,age,score) " +
                "VALUES ("+x.applicant_id+",\'"+x.firstname+"\',\'"+x.lastname+"\',\'"+x.username+"\',\'"+x.password+"\',\'"+x.phone_number+"\',\'"+x.email+"\',\'"+x.gender+"\',\'"+x.age+"\',\'"+x.score+"\')";
       //String query1 ="INSERT INTO project.new_schema.[use] (x,y) VALUES ("+x.score+","+x.score+") ";
        // create the java statement
        System.out.println(query);
        PreparedStatement st = null;
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            st = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // execute the query, and get a java resultset



    }

    public int selectuser(String mailorusername,String password){
        String query1="SELECT applicant_id from sw_project.project.[Applicant] where email=\'"+mailorusername+"\' AND password=\'"+password+"\'";
        String query="SELECT applicant_id from sw_project.project.[Applicant] where username=\'"+mailorusername+"\' AND password=\'"+password+"\'";
        Statement st = null;
        String q="SELECT * FROM sw_project.project.[Applicant]";
        System.out.println(query);


        try {
             st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }







        ResultSet rs=null;
        // execute the query, and get a java resultset
        try {
            if(mailorusername.contains("@")){
                rs = st.executeQuery(query1);
            }
            else{
                rs = st.executeQuery(query);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        int id=-1;
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                id=rs.getInt("applicant_id");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(id==-1){
            System.out.println("invalid name or password");
        }
        return id;
    }


}
