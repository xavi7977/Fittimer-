

package eu.xavi797.fx.timer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.util.Locale;


/**
 * User: Xavi797
 * Date: 10.07.20
 * Time: 16:57
 */
public class Demo extends Application {
    private Timer timer;
    private Label label;


    @Override public void init() {
        timer = TimerBuilder.create()
                            .playButtonVisible(false)
                            .waitingColor(Color.GRAY)
                            .duration(Duration.seconds(30))
                            .prefSize(38, 38)
                            .build();
        timer.setOnTimerEvent(event -> {
            switch(event.getType()) {
                case STARTED  : break;
                case CONTINUED: break;
                case STOPPED  : timer.setPlayButtonVisible(true);break;
                case FINISHED : label.setText("0 s"); break;
                case WAITING  : break;
                case SECOND   : label.setText(String.format(Locale.US, "%.1f s", timer.getCurrentTime().toSeconds()));
            }
            System.out.println(event.getType());
        });
        label = new Label();
    }

    @Override public void start(Stage stage) {
        VBox pane = new VBox(10, timer, label);
        pane.setPadding(new Insets(30));

        Scene scene = new Scene(pane);

        stage.setTitle("Timer");
        stage.setScene(scene);
        stage.show();

        timer.waiting();
    }

    @Override public void stop() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
