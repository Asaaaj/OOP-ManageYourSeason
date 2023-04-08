import model.Administrator;
import model.TeamManager;
import model.User;

public aspect UserLogin {
    pointcut loginPointcut(User user) :
            execution(* ApplicationControl.checkLogIn(String, String)) && args(user.username, user.password) && target(user);

    after(User user) returning(Object result) : loginPointcut(user) {
        if (user instanceof Administrator) {
            System.out.println("Administrator logged in.");
        } else if (user instanceof TeamManager) {
            System.out.println("Team manager logged in.");
        }
    }
}