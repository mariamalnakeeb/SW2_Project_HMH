package hello;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller
{
   private Vector<applicant> users=new Vector<>();

    @RequestMapping(value = "/hello.signup")
    public applicant signupapplicant(@RequestParam(value="firstname") String firstname,
                       @RequestParam(value="lastname")String lastname,@RequestParam(value="username")String username
        ,@RequestParam(value="password")String password,@RequestParam(value="phonenumber")String phonenumber
    ,@RequestParam(value="email")String email,@RequestParam(value="gender")String gender,@RequestParam(value="age")int age)
    {
       return main2.signup(firstname,lastname,username,password,phonenumber,email,gender,age);
    }

    @RequestMapping(value="/hello.login")
    public int loginapplicant(@RequestParam (value="usernameoremail")String username,@RequestParam (value="password")String password){
       return main2.login(username,password);
    }

}
