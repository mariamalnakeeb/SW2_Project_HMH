package hello;

public class applicant extends user {
    int applicant_id;
    int score;
    String interests;

    public applicant(String firstname, String lastname, String username, String password, String phone_number, String email, String gender, int age) {
        super(firstname, lastname, username, password, phone_number, email, gender, age);
        this.applicant_id = 0;
        this.score = 0;

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

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }


}
