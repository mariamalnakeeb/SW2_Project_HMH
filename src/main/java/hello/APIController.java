package hello;

import java.util.Vector;

import org.springframework.web.bind.annotation.*;


@RestController
public class APIController
{
   private Vector<applicant> users=new Vector<>();

    @RequestMapping(value = "/hello.signupapplicant")
    public applicant signupapplicant(@RequestParam(value="firstname") String firstname,
                       @RequestParam(value="lastname")String lastname,@RequestParam(value="username")String username
        ,@RequestParam(value="password")String password,@RequestParam(value="phonenumber")String phonenumber
    ,@RequestParam(value="email")String email,@RequestParam(value="gender")String gender,@RequestParam(value="age")int age)
    {
       return controller.signup(firstname,lastname,username,password,phonenumber,email,gender,age);
    }

    @RequestMapping(value="/hello.loginapplicant")
    public int loginapplicant(@RequestParam (value="usernameoremail")String username,@RequestParam (value="password")String password){
       return controller.login(username,password,1);
    }
    @RequestMapping(value="/hello.loginadmin")
    public int loginadmin(@RequestParam (value="usernameoremail")String username,@RequestParam (value="password")String password){
        return controller.login(username,password,2);
    }
    @RequestMapping(value = "/hello.signupadmin")
    public admin signupadmin(@RequestParam(value="firstname") String firstname,
                                     @RequestParam(value="lastname")String lastname,@RequestParam(value="username")String username
            ,@RequestParam(value="password")String password,@RequestParam(value="phonenumber")String phonenumber
            ,@RequestParam(value="email")String email,@RequestParam(value="gender")String gender,@RequestParam(value="age")int age)
    {
        return controller.signupadmin(firstname,lastname,username,password,phonenumber,email,gender,age);
    }
    @RequestMapping(value="/hello.logincompany")
    public int logincompany(@RequestParam (value="usernameoremail")String username,@RequestParam (value="password")String password){
        return controller.login(username,password,3);
    }

    @RequestMapping(value = "/hello.signupcompany")
    public company signupcompany(@RequestParam(value="username")String username
            ,@RequestParam(value="password")String password,@RequestParam(value="phonenumber")String phonenumber
            ,@RequestParam(value="email")String email)
    {
        return controller.signupcompany("","",username,password,phonenumber,email,"",-1);
    }
}
