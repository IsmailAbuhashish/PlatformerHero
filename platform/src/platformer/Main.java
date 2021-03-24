package platformer;

//Faris Al-Natsheh,Ismail AbuHashish, Nadeem Jouaneh
//Ms. Bdour AlZeer
//Group project

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main 
extends JFrame
implements KeyListener, ActionListener{
	public int tileWidth = 32;
	public int tileHeight = 32;
	public int gridHeight=15;
	public int gridWidth=27;
	JPanel drawing;
	BufferedImage[][] textures;
	BufferedImage[][] charSheet;
	int[][][] map = new int[100][100][2];
	int mapX=1;
	int mapY=1;
	int camX = 0;
	int camY = 0;
	double charX;
	double charY;
	double speedX;
	double speedY;
	double accY;
	double accX;
	int charState=2;
	double charAnim = 0;
	double animSpeed = 0.3;
	boolean animSwitch = false;
	boolean mUp,mDown,mLeft,mRight;
	int sprint=0;
	Timer jumpTimer = new Timer(100, this);
	double seconds;
	int jumpTime = 0;
	double error;
	boolean stopLeft, stopRight;
	double slip = 1.3;
	int ticks, TPS;
	int delay = 0;
	int targetFPS=60;
	double startSecs;
	boolean ready = false;
	int xStart, yStart;
	boolean dead,win;
	int deathAnim;
	int alpha = 0;
	double jumpAnim;
	boolean nextLevel;
	public Main(int[][][] map, int xStart, int yStart, int userWidth, int UserHeight) {
		this.xStart = xStart- gridWidth/2;
		this.yStart= yStart- gridHeight/2;
		mapX = xStart- gridWidth/2;
		mapY = yStart- gridHeight/2;
		this.map = map;
		this.addKeyListener(this);
		jumpTimer.start();
		initializeChar();
		initializeTextures();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
		setSize(userWidth, UserHeight);
		setLocationRelativeTo(null);       
		setBackground(Color.RED);
		setLayout(new GridLayout());
		setVisible(true); 

		drawing = new JPanel() {

			public void paint(Graphics g) {
				ticks++;
				super.paint(g);
				drawGrid(g, gridWidth,gridHeight);
				//drawMenus(g);
				drawChar(g);
				try {Thread.sleep(delay);} 
				catch (InterruptedException e) {}
				getContentPane().repaint();
				g.setColor(Color.white);

				g.drawString("TPS: "+TPS, 0, tileHeight*3);
				g.drawString("CharX: "+charX, 0, tileHeight*4);
				g.drawString("CharY: "+charY, 0, tileHeight*5);
				if(ready) {
					if(!dead) {
						xMovements();
					}
					yMovements();
					checkBlock(g);
				}
				else {
					if(!dead)
						loading(g);
				}
			}
		};
		this.add(drawing);
	}  
	public Main(int[][][] map, int xStart, int yStart) {
		this.xStart = xStart- gridWidth/2;
		this.yStart= yStart- gridHeight/2;
		mapX = xStart- gridWidth/2;
		mapY = yStart- gridHeight/2;
		this.map = map;
		this.addKeyListener(this);
		jumpTimer.start();
		initializeChar();
		initializeTextures();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); //maximize frame
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);       
		setBackground(Color.RED);
		setLayout(new GridLayout());
		setVisible(true); 

		drawing = new JPanel() {

			public void paint(Graphics g) {
				ticks++;
				super.paint(g);
				drawGrid(g, gridWidth,gridHeight);
				//drawMenus(g);
				drawChar(g);
				try {Thread.sleep(delay);} 
				catch (InterruptedException e) {}
				getContentPane().repaint();
				g.setColor(Color.white);
				g.drawString("TPS: "+TPS, 0, tileHeight*3);
				g.drawString("CharX: "+charX, 0, tileHeight*4);
				g.drawString("CharY: "+charY, 0, tileHeight*5);
				if(ready) {
					if(!dead) {
						xMovements();
					}
					yMovements();
					checkBlock(g);
				}
				else {
					if(!dead)
						loading(g);
				}
			}
		};
		this.add(drawing);
	}

	public void checkBlock(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(map[(int)Math.round(charX)][(int)Math.round(charY)][1] == 2){
			mapX = xStart;
			mapY = yStart;
			alpha = 255;
			dead = true;
			ready = false;
			speedX = 0;
			speedY = 0;
			jumpTime = 0;
			sprint = 0;
		}
		if(alpha  > 0 && dead) {
			charState = 20;
			charAnim = alpha/51;
			g2.setColor(new Color(255,0,0, alpha));
			g2.fillRect(0, 0, drawing.getWidth(),drawing.getHeight());
			alpha-=4;
		}
		else {
			ready = true;
			dead = false;
		}

		if(map[(int)Math.round(charX)][(int)Math.round(charY)][1] == 3){
			mapX = 3;
			mapY = 3;
			alpha = 0;
			win = true;
			ready = false;
			speedX = 0;
			speedY = 0;
			jumpTime = 0;
			sprint = 0;
		}
		if(alpha  < 254 && win) {
			charState = 17;
			charAnim = alpha/51;
			g2.setColor(new Color(0,204,204, alpha));
			g2.fillRect(0, 0, drawing.getWidth(),drawing.getHeight());
			alpha+=1;
		}
		if(win) {
			g2.setColor(new Color(0,204,204, alpha));
			g2.fillRect(0, 0, drawing.getWidth(),drawing.getHeight());
			g2.setColor(new Color(255,255,255, alpha));
			g.setFont(new Font("Futura", Font.BOLD, 32));
			g.drawString("You won! Press space to continue", drawing.getWidth()/2-270, drawing.getHeight()/2);
		}
		else {


		}

	}

	public void loading(Graphics g) {
		if(!ready) {
			g.setFont(new Font("Showcard Gothic", Font.PLAIN, 32));
			g.drawString("Loading", drawing.getWidth()/2, drawing.getHeight()/2);
			g.setFont(new Font("Showcard Gothic", Font.PLAIN, 8));
		}
	}


	public void initializeChar() {
		BufferedImage sheet = null;
		try {
			sheet = ImageIO.read(new File("main2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int scale = 64;
		int sheetHeight = sheet.getHeight(null)/scale;
		int sheetWidth = sheet.getWidth(null)/scale;
		charSheet = new BufferedImage[sheetWidth][sheetHeight];
		for(int i = 0; i < sheetWidth; i++) {
			for(int i2 = 0; i2 < sheetHeight; i2++) {
				charSheet[i][i2] = sheet.getSubimage(i * scale,  i2 * scale, scale,scale );
			}
		}
	}

	public void initializeTextures() {
		BufferedImage sheet = null;
		try {
			sheet = ImageIO.read(new File("texturess.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int scale = 32;
		int sheetHeight = sheet.getHeight(null)/scale;
		int sheetWidth = sheet.getWidth(null)/scale;
		textures = new BufferedImage[sheetWidth][sheetHeight];
		for(int i = 0; i < sheetWidth; i++) {
			for(int i2 = 0; i2 < sheetHeight; i2++) {
				textures[i][i2] = sheet.getSubimage(i * scale,  i2 * scale, scale,scale );
			}
		}

	}


	public void drawMenus(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, drawing.getWidth(), tileHeight*2);
	}

	public void drawGrid(Graphics g, int width, int height) {
		g.setColor(Color.blue);
		tileWidth = (int)Math.ceil((double)drawing.getWidth()/width);
		tileHeight = (int)Math.ceil((double)drawing.getHeight()/height);
		for(int i = -1; i <= width+1; i++) //width
			for(int i2 = -1; i2 <= height+1; i2++) { //height
				int currentLoc = map[mapX+i][mapY+i2][0];
				if(currentLoc == 0)
					g.drawImage(textures[5][3], i*(tileWidth)+camX, i2*(tileHeight)+camY,tileWidth, tileHeight,  null);
				else if(currentLoc == 1)
					g.drawImage(textures[0][3], i*(tileWidth)+camX, i2*(tileHeight)+camY,tileWidth, tileHeight,  null);
				else if(currentLoc == 2)
					g.drawImage(textures[0][5], i*(tileWidth)+camX, i2*(tileHeight)+camY,tileWidth, tileHeight,  null);

			}
	}

	public void drawChar(Graphics g) {
		int winCharX = drawing.getWidth()/2;
		int winCharY = drawing.getHeight()/2;
		g.drawImage(charSheet[(int)charAnim][charState], winCharX , winCharY, tileWidth, tileHeight,  null);
		charY = ((double)winCharY-camY)/tileHeight + mapY;

		charX = ((double)(winCharX-camX)/tileWidth + mapX);

		//System.out.println("CharX: "+charX + "\tCharY:  "+(int)charY + "\tmapX: " + mapX + "\tmapY: " + mapY);
	}


	public void yMovements() {
		accY = tileHeight/210.0;


		camY += speedY;
		if(camY <= tileHeight*-1) {
			camY = 0;
			mapY++;
		}
		if(camY >= tileHeight) {
			camY = 0;
			mapY--;
		}


		if(mUp) {
			jumpAnim+=0.23;
			charAnim = (int)jumpAnim;
			if(charAnim >= 6) { 
				charAnim = 0;
				jumpAnim = 0;
			}
			speedY = tileHeight/4;
			if(jumpTime >= 30) {
				if(map[(int)Math.round(charX)][(int)Math.floor(charY)+1][1] == 1) {mUp = false; charAnim = 0;}

			}
			if(map[(int)Math.round(charX)][(int)Math.ceil(charY)-1][1] == 1) {mUp = false; charAnim = 0;}
			speedY -= accY*jumpTime;
			charState = 2; 
		}
		else {
			speedY = 0;
			speedY -= accY*jumpTime;
		}

		jumpTime++;


		if((map[(int)Math.round(charX)][(int)charY+1][1] == 1 && !mUp)) {
			accY = 0;
			speedY= 0;
			jumpTime = 0;
			error = (charY-Math.round(charY))*(double)tileHeight;
			camY += error;
			jumpAnim = 0;
		}


	}


	public void xMovements() {
		accX = tileWidth/210.0;
		if(mLeft) {
			if(mRight) {
				stopRight = true;
				return;
			}
		}
		if(mRight) {
			if(mLeft) {
				stopLeft = true;
				return;
			}
		}
		if(mLeft && map[(int)Math.ceil(charX)-1][(int)Math.floor(charY)][1] != 1 && !stopRight) {
			speedX = 0;
			sprint++;
			speedX += accX*sprint; 
			camX+= speedX;
			charState = 9;
			if(charAnim >= 6) 
				charAnim = 0;
			charAnim += animSpeed;
			if(camX >= tileWidth) {
				camX = 0;
				mapX--;
			}
		}
		if(mRight && map[(int)Math.floor(charX)+1][(int)Math.floor(charY)][1] != 1 && !stopLeft) {
			speedX = 0;
			sprint--;
			speedX -= accX*sprint; 
			camX -= speedX;
			charState = 11;

			if(charAnim >= 6) 
				charAnim = 0;
			charAnim += animSpeed;

			if(camX <= -1*tileWidth) {
				camX = 0;
				mapX++;
			}
		}
		if(stopRight) {
			if(map[(int)Math.ceil(charX)+1][(int)charY][1] == 1) {
				stopRight = false;
			}
			else {

				sprint--;
				speedX += accX*sprint/slip; 
				camX -= speedX;


				if(camX <= -1*tileWidth) {
					camX = 0;
					mapX++;
				}		

				if(speedX<=0) { speedX = 0; sprint=0;stopRight = false; }
			}
		}
		if(stopLeft) {
			if(map[(int)Math.floor(charX)-1][(int)charY][1] == 1) {
				stopLeft = false;
			}
			else {
				sprint++;
				speedX -= accX*sprint/slip; 
				camX += speedX;


				if(camX >= tileWidth) {
					camX = 0;
					mapX--;
				}
				if(speedX<=0) { speedX = 0; sprint=0;stopLeft = false;}
			}
		}

	}

	public void capFPS(){
		if(!(ticks <= targetFPS)) {
			ready=false;
			delay++;
			return;
		}
		if(startSecs > 2)
			ready = true;
	}

	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_W && !mUp && !dead) {
			jumpTime = 0;
			mUp = true;
		}
		if(e.getKeyCode()== KeyEvent.VK_A) {
			mLeft = true;
		}
		if(e.getKeyCode()== KeyEvent.VK_D) {
			mRight = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_0) {
			gridWidth--;
			gridHeight--;
		}
		if(e.getKeyCode() == KeyEvent.VK_9) {
			gridWidth++;
			gridHeight++;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(win) {
				setVisible(false);
				new Main_Menu();
				win = false;
				dispose();
			}
		}
	}


	@Override

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_A) {
			mLeft = false;
			sprint =0;
			stopLeft = true;
			stopRight = false;
			if(!dead)
				charAnim = 0;
		}
		if(e.getKeyCode()== KeyEvent.VK_D) {
			mRight = false;
			sprint = 0;
			stopRight = true;
			stopLeft = false;
			if(!dead)
				charAnim = 0;
		}


	}


	@Override
	public void keyTyped(KeyEvent e) {
	}


	public void actionPerformed(ActionEvent arg0) {
		jumpTime+=1;
		seconds+=0.1;
		startSecs+=0.1;
		if((int)seconds == 1) {
			TPS = ticks;
			ticks= 0;
			seconds = 0;
		}
		capFPS();
	}


}