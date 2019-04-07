package hello;

import java.util.Scanner;

public class main2 {
    static database data=new database();
    public static void main(String[] args){
         System.out.println("1-signup \n 2-login");
         Scanner q=new Scanner(System.in);
         int x=q.nextInt();
         while(x!=0){
             System.out.println("1-signup \n 2-login");
             if(x==1){
                 System.out.println("to sign up please enter your information");
                 String []arr={"firstname:","lastname:","username:","password:","phonenumber:","email:","gender:","age:"};
                 String []info=new String[7];
                 int age=0;
                 for(int i=0;i<arr.length;i++){
                     System.out.println(arr[i]);
                     Scanner in =new Scanner(System.in);
                     Scanner in1=new Scanner(System.in);
                     if(i==arr.length-1){
                         age=in1.nextInt();
                         break;
                     }
                     info[i]=in.nextLine();
                 }
                 signup(info[0],info[1],info[2],info[3],info[4],info[5],info[6],age);
             }
             else if(x==2){
                 System.out.println("to login please enter username or email and password");
                 System.out.println("username or email:");
                 Scanner in=new Scanner(System.in);
                 String useroremail=in.nextLine();
                 System.out.println("password:");
                 String pass=in.nextLine();
                 login(useroremail,pass);
             }
         }


    }
    public static int login(String usernameoremail,String password){
       int result=data.selectuser(usernameoremail,password);
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
}
