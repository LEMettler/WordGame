import com.sun.org.apache.xml.internal.resolver.readers.TextCatalogReader;
import org.newdawn.slick.*;
import org.lwjgl.*;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.gui.TextField;
import sun.applet.Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Meerlu on 04.06.2017.
 */
public class Game extends BasicGame{


    Input input;
    ArrayList<Word> words = new ArrayList<>();
    ArrayList<String> vocabulary = new ArrayList<>();
    int vocabMax;
    int vocabIndex;
    int wave;
    int x,y;
    Random rnd;
    Rectangle inputBox;
    ShapeFill recFill;
    Line inputLine;
    String userInput;
    StringBuilder stringBuilder = new StringBuilder();
    int numbWords;
    boolean waveWon = false;
    boolean waveNext = false;
    Image nextWave;
    int j = 0;
    boolean speed = false;
    Music soundBackground;
    SpriteSheet explosion;
    Animation explosionAnimation;
    int wX,wY;
    boolean isExp = false;



    public Game(String title) throws SlickException {
        super(title);
    }



    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        rnd = new Random();
        input = gameContainer.getInput();
        loadVocabulary("src/vocab.txt");
        inputBox = new Rectangle(0,619,1080,100);
        inputLine = new Line(240,680,840,680);
        nextWave = new Image("src/pics/pic_nextWave.png");
        explosion = new SpriteSheet("src/pics/sprite_explosion.png", 500, 500);
        explosionAnimation = new Animation(explosion, 100);
        userInput = "";
        soundBackground = new Music("src/sounds/music_bg.ogg");


        Image exp[] = new Image[8];
        exp[0] = new Image("src/pics/e0.png");
        exp[1] = new Image("src/pics/e0.png");
        exp[2] = new Image("src/pics/e1.png");
        exp[3] = new Image("src/pics/e1.png");
        exp[4] = new Image("src/pics/e2.png");
        exp[5] = new Image("src/pics/e2.png");
        exp[6] = new Image("src/pics/e3.png");
        exp[7] = new Image("src/pics/e3.png");
        explosionAnimation = new Animation(exp, 1);


        soundBackground.loop();

                // 1 Wave
                wave = 1;
                x = y = 100;
                for(int i = 0; i <wave; i++){
                    vocabIndex = rnd.nextInt(vocabMax);
                    words.add(new Word(vocabulary.get(vocabIndex - 1),x, y));
                    x+= 100;
                    numbWords = wave;

                }
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        userInput = stringBuilder.Build(userInput, input);

        for (Word w : words){
            if (speed)
                w.setY(w.getY() + 1);

            if (userInput.equals(w.getText() + " ")) {
                w.setText("");
                userInput = "";
                numbWords--;
                wX = w.getX();
                wY = w.getY();
                isExp = true;
                if (numbWords == 0)
                    waveWon= true;
            }
        }

        if (waveNext){
            waveNext = false;
            wave++;
            x = y = 100;
            for(int k = 0; k < wave; k++){
                vocabIndex = rnd.nextInt(vocabMax);
                words.add(new Word(vocabulary.get(vocabIndex - 1),x, y));
                x+= 100;
                numbWords = wave;

            }
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Word w : words){
            graphics.drawString(w.getText(),w.getX(),w.getY());
        }

        if (isExp){
            graphics.drawAnimation(explosionAnimation, wX, wY);
            isExp = false;
        }

        graphics.draw(inputBox);
        graphics.draw(inputLine);
        graphics.drawString(userInput, 500,650);

        if (waveWon){
            j++;
            //graphics.drawString("NEXT WAVE", 500, 340);
            graphics.drawImage(nextWave, 290,270);
            if(j== 60){
                waveWon = false;
                j = 0;
                waveNext = true;
            }
        }

        graphics.drawString("Wave: " + wave, 950, 650);
        speed = !speed;
    }


    public static void main(String [] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game("WordGame"));
        app.setDisplayMode(1080,720,false);
        app.setTargetFrameRate(60);
        app.setVSync(true);
        app.start();

    }

    private void loadVocabulary(String data){
       vocabMax = 0;

       File file = new File(data);

       // if (!file.canRead() || !file.isFile())



            BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(data));
            String line = null;
            while ((line = in.readLine()) != null) {
                vocabulary.add(line);
                vocabMax++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }

    }

}