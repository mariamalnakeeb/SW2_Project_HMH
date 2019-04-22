package hello;

import java.util.Scanner;

public class controller {
    static database data=new database();
    static int admin_id=-1;
    static int company_id=-1;
   /* public static void main(String[] args)
    {

         Scanner q=new Scanner(System.in);
         int login_or_signup=1;
         int usertype=1;
         Scanner w=new Scanner(System.in);
         while(usertype!=0){
             System.out.println("1-applicant \n 2-admin \n 3-company \n 0-exit");
             usertype=w.nextInt();
             System.out.println("1-signup \n 2-login");
             login_or_signup=q.nextInt();
             if(login_or_signup==1){
                 System.out.println("to sign up please enter your information");
                 String[]arr=new String[2];
                 if(usertype==1 ||usertype==2) {
                     String[] arr1 = {"firstname:", "lastname:", "username:", "password:", "phonenumber:", "email:", "gender:", "age:"};
                     arr=arr1;
                 }
                 if(usertype==3){
                     String []arr2={"name:","username:","password:","phonenumber:","email:"};
                     arr=arr2;
                 }

                 String []info=new String[7];


                 int age=0;
                 for(int i=0;i<arr.length;i++){
                     System.out.println(arr[i]);
                     Scanner in =new Scanner(System.in);
                     Scanner in1=new Scanner(System.in);
                     if(i==arr.length-1 && (usertype==1||usertype==2)){
                         age=in1.nextInt();
                         break;
                     }
                     info[i]=in.nextLine();
                 }
                 if(usertype==1)
                  signup(info[0],info[1],info[2],info[3],info[4],info[5],info[6],age);
                 else if(usertype==2){
                     signupadmin(info[0],info[1],info[2],info[3],info[4],info[5],info[6],age);
                 }
                 else{
                     signupcompany(info[0],"",info[1],info[2],info[3],info[4],"",-1);
                 }
             }
             else if(login_or_signup==2){
                 System.out.println("to login please enter username or email and password");
                 System.out.println("username or email:");
                 Scanner in=new Scanner(System.in);
                 String useroremail=in.nextLine();
                 System.out.println("password:");
                 String pass=in.nextLine();
                 login(useroremail,pass,usertype);
             }
         }
    }*/
    public static int login(String usernameoremail,String password,int x){
        int result=data.selectuser(usernameoremail,password,x);
        if(x==2){
            admin_id=result;
        }
        else if(x==3)
            company_id=result;
        if(result==-1)
        {
            System.out.println("invalid name or password");
            return -1;
        }
        else{
            return result;
        }
    }
    public static applicant signup(String firstname, String lastname, String username, String password, String phone_number, String email, String gender, int age)
    {
        applicant x= new applicant(firstname,lastname,username,password,phone_number,email,gender,age);
        data.addnewapplicant(x);
        return x;
    }
    public static admin signupadmin(String firstname, String lastname, String username, String password, String phone_number, String email, String gender, int age){
        admin x=new admin(firstname,lastname,username,password,phone_number,email,gender,age);
        data.addnewadmin(x,admin_id);
        return x;
    }
    public static company signupcompany(String firstname, String lastname, String username, String password, String phone_number, String email, String gender, int age){
        company x=new company(firstname,username,password,phone_number,email);
        data.addnewcompany(x);
        return x;
    }

    //admin sha8al w applicant sha8al fadel el company w addintersets

}
