import view.*;
import controller.*;

public class App {
    public static void main(String[] args) {
        Homepage homepage = new Homepage();

        Controller controller = new Controller(homepage);
        controller.initializeHomeframeWindowEvents();
    }
}
