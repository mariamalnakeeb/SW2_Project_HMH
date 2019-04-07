package hello;

import java.util.Scanner;
import java.util.Vector;

public class applicant extends user{
     private static int counter=100;
     Vector<String> skills;
     int applicant_id;
     int score;
     String []interests=new String[5];


    public applicant(String firstname, String lastname, String username, String password, String phone_number, String email, String gender, int age) {
        super(firstname, lastname, username, password, phone_number, email, gender, age);
        applicant_id=counter;
        counter++;
        score=0;
        skills=new Vector<>();
        for(int i=0;i<interests.length;i++){
            interests[i]="";
        }
    }
    public void putinterests(String[] interset){
        for(int i=0;i<interests.length && i<interset.length;i++){
            interests[i]=interset[i];
        }
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        applicant.counter = counter;
    }

    public Vector<String> getSkills() {
        return skills;
    }

    public void setSkills(Vector<String> skills) {
        this.skills = skills;
    }

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void putskills()
    {
        do{
            Scanner in=new Scanner(System.in);
            System.out.println("please enter your skills and 0 to exit");
            String skill=in.nextLine();
            if(skill.equals("0"))
            {
                break;
            }
            //skills.add(skill);
        }while(true);
    }
}
