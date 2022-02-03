package riosfernandez.antoniojuan.bubbleshot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class App extends Application {
   //VARIABLES
    final int SCENE_TAM_X = 400;
    final int SCENE_TAM_Y = 600;
    Pane root = new Pane();
    ImageView fondo1;
    ImageView fondo2;
    int fondo1PositionY =0;
    int fondo2PositionY =600;
    ImageView personaje1;
    int personajePositionX = 150;
    int personajePositionY = 500;
    int velocidad = 24;
    ImageView alimento;
    int alimentoPositionY = 150;
    ImageView alimento1;
    ImageView alimento2;
    ImageView alimento3;
    int alimento1PositionX =0;
    int alimento1PositionY =0;
    int alimento2PositionX =170;
    int alimento2PositionY =0;
    int alimento3PositionX =350;
    int alimento3PositionY =0;
    Group pizza = new Group();
    Group pelota = new Group();
    Group donut = new Group();
    Group pou = new Group();
    Rectangle rectPou;
    Rectangle rectAlimento;
    Rectangle rectAlimento2;
    Rectangle rectAlimento3;

    @Override
      public void start(Stage stage) {
          //Crear escena de la pantalla
          Scene scene = new Scene(root, SCENE_TAM_X, SCENE_TAM_Y, Color.BLACK);
          stage.setTitle("PouS");
          stage.setScene(scene);
          stage.show();
          
          //AÑADIENDO LA IMAGEN DE FONDO
          Image fondoImg = new Image(getClass().getResourceAsStream("/images/fondo.png"));
          fondo1 = new ImageView(fondoImg);
          fondo2 = new ImageView(fondoImg);
          root.getChildren().add(fondo1);
          root.getChildren().add(fondo2);
          fondo1.setLayoutY(fondo1PositionY);
          fondo2.setLayoutY(fondo2PositionY);
         
          //AÑADIENDO LA IMAGEN DEL PERSONAJE y Creación del grupo , rectangulo.
          Image personaje = new Image(getClass().getResourceAsStream("/images/pou.png"));//Creacion de la imagen
          personaje1 = new ImageView(personaje);
          rectPou = new Rectangle(150, 500, 80, 80);//Creacion de un rectangulo
          rectPou.setFill(Color.WHITE);
          pou.getChildren().addAll(personaje1, rectPou);//Añadimos al grupo el personaje y el rectangulo
          root.getChildren().add(personaje1);//Añadimos en el root la imagen
          root.getChildren().add(pou);
          personaje1.setLayoutX(personajePositionX);//Asignamos la posicionX
          personaje1.setLayoutY(personajePositionY);//Asignamos la posicionY
          
          //AÑADIENDO LA IMAGEN DE LOS ALIMENTOS y Creación del grupo, rectangulo.
          //Alimento 1
          Image alimento1Img = new Image(getClass().getResourceAsStream("/images/alimento.png"));
          alimento1 = new ImageView(alimento1Img);
           rectAlimento= new Rectangle(40, 50);
           rectAlimento.setFill(Color.WHITE);
           pizza.getChildren().addAll(alimento1, rectAlimento);
           root.getChildren().add(pizza);
          //Alimento 2
          Image alimento2Img = new Image(getClass().getResourceAsStream("/images/alimento2.png"));
          alimento2 = new ImageView(alimento2Img);
          rectAlimento2= new Rectangle(170, 0, 40, 41);
          rectAlimento2.setFill(Color.WHITE);
          donut.getChildren().addAll(alimento2, rectAlimento2);
          root.getChildren().add(donut);
          //Alimento 3
          Image alimento3Img = new Image(getClass().getResourceAsStream("/images/alimento3.png"));
          alimento3 = new ImageView(alimento3Img);
          rectAlimento3= new Rectangle(350, 0, 40, 39);
          rectAlimento3.setFill(Color.WHITE);
          pelota.getChildren().addAll(alimento3, rectAlimento3);
          root.getChildren().add(pelota);
           
          root.getChildren().add(alimento1);
          root.getChildren().add(alimento2);
          root.getChildren().add(alimento3);
          alimento1.setLayoutX(alimento1PositionX);
          alimento2.setLayoutX(alimento2PositionX);
          alimento3.setLayoutX(alimento3PositionX);
          
          //SCROLL DEL FONDO DE PANTALLA
          Timeline scrollFondo = new Timeline(
                  new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                      fondo1PositionY = fondo1PositionY -1;
                      fondo1.setLayoutY(fondo1PositionY);
                      fondo2PositionY = fondo2PositionY -1;
                      fondo2.setLayoutY(fondo2PositionY);
                      if(fondo1PositionY == -600){
                          fondo1PositionY = 600;
                      }else if(fondo2PositionY == -600){
                          fondo2PositionY = 600;
                      }
                  })
          );
          //SCROLL DE LA CAÍDA DE LAS FRUTAS
          Timeline scrollAlimento = new Timeline(
                  new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                      alimento1PositionY = alimento1PositionY +2;
                      pizza.setLayoutY(alimento1PositionY);
                      alimento2PositionY = alimento2PositionY +2;
                      donut.setLayoutY(alimento2PositionY);
                      alimento3PositionY = alimento3PositionY +2;
                      pelota.setLayoutY(alimento3PositionY);
                      if(alimento1PositionY >= 600){
                          alimento1PositionY = 0;
                      }else if(alimento2PositionY >= 600){
                          alimento2PositionY = 0;
                      }else if(alimento3PositionY >= 600) {
                          alimento3PositionY = 0;
                      }
                  })
          );
          
          //MOVIMIENTO DEL PERSONAJE
          scene.setOnKeyPressed((KeyEvent event) -> {
            if(event.getCode() == KeyCode.RIGHT) {
                if (personajePositionX <= 300){
                    personajePositionX += velocidad;
                    personaje1.setLayoutX(personajePositionX);
                }
            } 
            if (event.getCode() == KeyCode.LEFT) {
                if (personajePositionX > 0){
                    personajePositionX -= velocidad;
                    personaje1.setLayoutX(personajePositionX);
                }
                
            } 
        });
          //Colisionado de los objetos
          
          
          
          // Parte del código para detectar la colisión de los rectángulos
            //Shape zonaColision = Shape.intersect(rectPou, rectZona2);
          scrollFondo.setCycleCount(Timeline.INDEFINITE);
          scrollFondo.play();
          scrollAlimento.setCycleCount(Timeline.INDEFINITE);
          scrollAlimento.play();
          
    }      
     
      
      public static void main(String[] args) {
          launch();
      }
}
