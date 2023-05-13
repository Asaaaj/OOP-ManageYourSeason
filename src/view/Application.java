package view;

public interface Application {
    default void start() {
        Object frame = logInFrame();   
    }

    Object logInFrame();
}
