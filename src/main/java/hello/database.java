package hello;

import java.sql.*;

public class database {
    Connection connection;
    String myUrl = "jdbc:jtds:sqlserver://HADEER:1433;instance=SQLEXPRESS";

    public database(){
        //System.out.println(java.lang.System.getProperty("java.library.path"));
        try {
            connection  = DriverManager.getConnection(myUrl);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private ResultSet getrs(String query){
        Statement st = null;
        try {
            st = connection.createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
        ResultSet rs=null;
        try{
            rs=st.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    public void addnewapplicant(applicant x){
        String query = "INSERT INTO project.[Applicant] (applicant_id,firstname, lastname, username,password,phonenumber,email,gender,age,score) " +
                "VALUES ("+x.getApplicant_id()+",\'"+x.getFirstname()+"\',\'"+x.getLastname()+"\',\'"+x.getUsername()+"\',\'"+x.getPassword()+"\',\'"+x.getPhone_number()+"\',\'"+x.getEmail()+"\',\'"+x.getGender()+"\',\'"+x.getAge()+"\',\'"+x.getScore()+"\')";
        executequery(query);
    }
    private void executequery(String query){
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
    }
    public void addnewadmin(admin x,int id){
        String checkquery="select * from sw_project.project.[admin] where admin_id="+id;
       ResultSet rs=getrs(checkquery);
        int counter=0;
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if(counter==0){
            System.out.println("you must login as admin first");
            return;
        }
        String query = "INSERT INTO sw_project.project.[admin] VALUES (\'"+x.getFirstname()+"\',\'"+x.getLastname()+"\',\'"+x.getUsername()+"\',\'"+x.getPassword()+"\',\'"+x.getPhone_number()+"\',\'"+x.getEmail()+"\',\'"+x.getGender()+"\',\'"+x.getAge()+"\')";
        //String query1 ="INSERT INTO project.new_schema.[use] (x,y) VALUES ("+x.score+","+x.score+") ";
        // create the java statement
       executequery(query);
    }//id is sent because admin must be logged in first
    public void addnewcompany(company x){
        String query="INSERT INTO sw_project.project.[company] VALUES (0,\'"+x.getFirstname()+"\',\'"+x.getUsername()+"\',\'"+x.getPassword()+"\',\'"+x.getPhone_number()+"\',\'"+x.getEmail()+"\')";
        executequery(query);
    }
    public int selectuser(String mailorusername,String password,int applicantoradmin){
        String query1="SELECT applicant_id from sw_project.project.[Applicant] where email=\'"+mailorusername+"\' AND password=\'"+password+"\'";
        String query="SELECT applicant_id from sw_project.project.[Applicant] where username=\'"+mailorusername+"\' AND password=\'"+password+"\'";
        String query2="SELECT admin_id from sw_project.project.[admin] where username=\'"+mailorusername+"\' AND password=\'"+password+"\'";
        String query3="SELECT admin_id from sw_project.project.[admin] where email=\'"+mailorusername+"\' AND password=\'"+password+"\'";
        String query4="SELECT company_id from sw_project.project.[company] where email=\'"+mailorusername+"\' AND password=\'"+password+"\'";
        String query5="SELECT company_id from sw_project.project.[company] where username=\'"+mailorusername+"\' AND password=\'"+password+"\'";
        Statement st = null;
        String q="SELECT * FROM sw_project.project.[Applicant]";
        System.out.println(query);


        try {
             st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs=null;
        try {
            if(mailorusername.contains("@") && applicantoradmin==1){
                rs = st.executeQuery(query1);
            }
            else if(applicantoradmin==1){
                rs = st.executeQuery(query);
            }else if(mailorusername.contains("@") && applicantoradmin==2){
                rs=st.executeQuery(query3);
            }
            else if(applicantoradmin==2)
            {
                rs=st.executeQuery(query2);
            }
            else if(mailorusername.contains("@") && applicantoradmin==3){
                rs = st.executeQuery(query4);
            }else{
                rs = st.executeQuery(query5);
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
                if(applicantoradmin==1)
                id=rs.getInt("applicant_id");
                else if(applicantoradmin==2)
                    id=rs.getInt("admin_id");
                else if(applicantoradmin==3)
                    id=rs.getInt("company_id");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(id==-1){
            System.out.println("invalid name or password");
        }
        return id;
    }
    public void addinterests(String interest,int id){
          String query="select interests from sw_project.project.[Applicant] where applicant_id="+id;
        ResultSet rs=getrs(query);
        String interests="-1";
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                interests=rs.getString("interests");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        String input="";

        if(interests=="-1"){
            System.out.println("invalid id");
            return;
        }
        if(interests==""){
           input+=interest;
        }
        String []split=interests.split(",");
        if(split.length==2 || split.length==1){
            input+=",";
            input+=interest;

        }
        else if(split.length==3){
            System.out.println("can't add another skill");
            return;
        }
    } //id is sent because user must be logged in first

}
