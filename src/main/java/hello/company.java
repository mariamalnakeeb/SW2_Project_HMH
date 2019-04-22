package hello;

public class company extends user {
    int company_id;
    public company(String firstname,String username, String password, String phone_number, String email) {
        super(firstname, null, username, password, phone_number, email, null, -1);
        company_id=0;

    }


    public int getCompany_id(){
        return company_id;
    }

    public void setCompany_id(int company_id){
        this.company_id = company_id;
    }

}
