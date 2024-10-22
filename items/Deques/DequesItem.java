package items.Deques;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;

import javax.imageio.ImageIO;

import engine.abstractclasses.GraphicsItem;
import engine.util.GraphicsPanel;
import engine.variables.Vector2;
import items.ZoomScale;

public class DequesItem extends GraphicsItem{

    public Deque<String> deque = new ArrayDeque<String>();
    public ZoomScale zoomScale = new ZoomScale();
    private Vector2 position = new Vector2();
    private Vector2 size = new Vector2(200, 300);
    private static final int SPACEMENT = 10;

    public ArrayList<Image> allImgs = new ArrayList<>();

    public Deque<Image> imgsOfDeque = new ArrayDeque<>();

    public static int tamanho;

    DequesItem(){
        position.y = (GraphicsPanel.getPanelHeight() / 2) - (size.y / 2);

        try {
			allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\aguentaFirme.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\analise.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\biridimRusbe.png"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\blackLotus.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\BlzVei.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\bolinaDeGorfe.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\buzzTestador.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\calaBoca.jpeg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\capitaoNascimento.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\ceifadorIfunny.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\chuckNorris.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\darthVader.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\destruidorDeCototas.jpeg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\dogProtetor.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\eminem.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\Felpinho.jpeg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\grandeHacker.png"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\gru.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\lotWords.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\madruga.jpeg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\magicalTutor.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\memeRenasce.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\mrT.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\nao.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\ninjaMoreira.png"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\oloquinhoMeu.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\paraComEssaPorra.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\reginaCazeDeOlho.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\rickRolled.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\stonks.jpg"))));
            allImgs.add(getScaledImage(ImageIO.read(new File("assets\\randomcards\\urMom.jpg"))));
		} catch (IOException e) {
			e.printStackTrace();
            System.exit(-1);
		}
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void draw(Graphics2D g2) {
        for (int i = 0; i < deque.toArray().length; i++) {
            position.x = (size.x * i) + SPACEMENT * (i + 1);
            g2.setColor(Color.BLUE);
            g2.drawString("Index: " + Integer.toString(i), (int) position.x, (int) (position.y - 2));
            g2.setColor(Color.BLACK);
            g2.drawString("Valor: " + deque.toArray()[i], (int) position.x, (int) (position.y + size.y + SPACEMENT));
            g2.setColor(Color.DARK_GRAY);
            g2.drawImage((Image) imgsOfDeque.toArray()[i], (int) position.x, (int) position.y, null);
            // g2.fillRoundRect((int) position.x, (int) position.y, (int) size.x, (int) size.y, 
                // (int) (size.x * 0.1), (int) (size.y * 0.1));
        }
    }

    public void addFirstCard(String value){
        deque.addFirst(value);
        imgsOfDeque.addFirst(getRandomImage());
    }

    public void addLastCard(String value){
        deque.addLast(value);
        imgsOfDeque.addLast(getRandomImage());
    }

    public void removeFirstCard(){
        deque.removeFirst();
        imgsOfDeque.removeFirst();
    }

    public void removeLastCard(){
        deque.removeLast();
        imgsOfDeque.removeLast();
    }

    public void clearCards(){
        deque.clear();
        imgsOfDeque.clear();
    }

    public Image getRandomImage(){
        Random rng = new Random();
        return allImgs.get(rng.nextInt(allImgs.size()));
    }

    private Image getScaledImage(Image image){
        return image.getScaledInstance((int) size.x, (int) size.y, Image.SCALE_DEFAULT);
    }

}
