/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadetransition;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Angel Medina Cantos
 */
public class FadeTransitionMain extends Application { //LE pongo el nombre de FadeTransitionMAin porque sino me daba conflicto con el  import javafx.animation.FadeTransition;
    
    @Override
    public void start(Stage primaryStage) 
    {
        Pane panel = new Pane();
        Scene scene = new Scene(panel, 300,300);
   
        // Creamos la elipse
        Ellipse elipse = new Ellipse(150, 125, 50, 25);
        elipse.setFill(Color.BLUE);
        panel.getChildren().add(elipse); // Añadimos la elipse al pnael
       
        FadeTransition fade = new FadeTransition(Duration.seconds(3), elipse);
        fade.setFromValue(1.0);
        fade.setToValue(0.2);
        fade.play();
        
  
        elipse.setOnMousePressed(e ->{ // se mantiene la animacion mientras lo tengamos pulsado
            
            fade.pause();
        });
        
        
        elipse.setOnMouseReleased(e ->{ //Soltamos el raton se vuelve al principio
            
            fade.playFromStart();
        });
        
  
        primaryStage.setTitle("Fade Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
