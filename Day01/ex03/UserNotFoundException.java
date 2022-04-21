package ex03;
public class UserNotFoundException extends InterruptedException {
    UserNotFoundException() {
        super("User not found");
    }
}
