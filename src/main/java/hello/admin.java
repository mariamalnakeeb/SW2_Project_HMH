package hello;

public class admin extends user{
    private static int counter=0;
    int admin_id;

    public admin(String firstname, String lastname, String username, String password, String phone_number, String email, String gender, int age) {
        super(firstname, lastname, username, password, phone_number, email, gender, age);

    }

    public static int getCounter(){
        return counter;
    }

    public static void setCounter(int counter){
        admin.counter = counter;
    }

    public int getAdmin_id(){
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
