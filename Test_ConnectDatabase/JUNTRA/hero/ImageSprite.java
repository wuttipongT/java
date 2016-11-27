package JUNTRA.hero;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public  class ImageSprite extends JLabel{
	ImageIcon []spriteImage;
	Timer timer;
	int max;
	int frameSequence[];
	int x,y,w=30,h=45;
	int delay=100;
	int diretion[][]=new int[34][4];
	public ImageSprite(String imageFile,int row,int colum) {
		Image im=createImage(imageFile);
		spriteImage=createSpriteFrame(im, row, colum);
		createFrameSequence();
		createdirection();
		setIcon(spriteImage[0]);
	}
	//--------------------------
	public ImageSprite(String imageFile,int row,int colum,int x,int y,int w,int h) {
		this.w=w;
		this.h=h;
		this.x=x;
		this.y=y;
		Image im=createImage(imageFile);
		spriteImage=createSpriteFrame(im, row, colum);
		createFrameSequence();
		createdirection();
		setIcon(spriteImage[0]);
	}
	public void createdirection(){
		int b=0;
		for(int i=0;i<34;i++){
			for(int a=0;a<4;a++){
				diretion[i][a]=b;
				b++;
			}
		}	
	}
	private void createFrameSequence(){
		frameSequence=new int[max];
		for(int i=0;i<frameSequence.length;i++){
			frameSequence[i]=i;
		}
	}
	public void setFrameSequence(int sequence){
		frameSequence=diretion[sequence];
	}
	ImageIcon[] createSpriteFrame(Image image,int row,int colum){
		int n=row*colum;
		ImageIcon []icon=new ImageIcon[n];
		int imWidth=image.getWidth(this);
		int imHeith=image.getHeight(this);
		while(imWidth<=0){
			imWidth=image.getWidth(this);
			imHeith=image.getHeight(this);
		}
		int imx=imWidth/colum;
		int imy=imHeith/row;
		
		int sx,sy;
		for(int i=0;i<n;i++){
			sx=imx*(i%colum);
			sy=imy*(i/row);
			Image im=createImage(new FilteredImageSource(image.getSource(),
					new CropImageFilter(sx,sy,imx,imy)));
			icon[i]=new ImageIcon(im);
		}
		return icon;
	}
	Image createImage(String imageFile){
		Image im=Toolkit.getDefaultToolkit().createImage(imageFile);
		return im;
	}
	public void setPosition(int x,int y){
		this.x=x;this.y=y;
	}
	public void stop() {
		timer.cancel();	
	}
	public void run(){
		timer=new Timer();
		timer.schedule(new RunningTake(),0,delay);
	}
	class RunningTake extends TimerTask{
		int i=0;
		int n=frameSequence.length;
		public void run() {
			if(i==n)i=0;
			setIcon(spriteImage[frameSequence[i]]);
			setBounds(x, y, w, h);
			i++;
		}
	}
}
