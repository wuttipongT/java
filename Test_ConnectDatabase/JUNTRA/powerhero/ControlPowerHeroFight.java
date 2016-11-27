package JUNTRA.powerhero;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.maingame.Main_JuntraGame;
import JUNTRA.map.Map;

public class ControlPowerHeroFight {//เป็นคลาสที่ควบคุมว่าผู้เล่นต้องการปล่อยพลังแบบไหน
	
	int powerliving;//กำลังชีวิต
	int powerattack;//พละกำลังต่อสู้
	int deform;//ค่าป้องกัน
	int way;//ทิศทางที่พลังจะมุ่งไป
	int property;//สมบัติ

	Map map;
	Hero hero;
	Power po=null;
	int sizearraypower;
	
	ImageSprite power;
	public ControlPowerHeroFight(Map map,Hero hero) {
		this.map=map;
		this.hero=hero;
		way=hero.getWAY();
		sizearraypower=hero.indexpower.size();
		if(sizearraypower>=1){//แสดงว่ามีพลังหลายแบบก็แรนด้อมใช้
			int ran=(int)(Math.random()*sizearraypower);
			Integer ranpower=(Integer)hero.indexpower.get(ran);
			if(ranpower==0){
				po=new Power_Fire(this.map,this.hero,this.way);
			}
			else if(ranpower==1){
				po=new Power_ice(this.map,this.hero,this.way);
			}
			else if(ranpower==2){
				po=new Power_emerald(this.map,this.hero,this.way);
			}
			else if(ranpower==3){
				po=new Power_Fire(this.map,this.hero,this.way);
			}
			else if(ranpower==4){
				po=new Power_violet(this.map,this.hero,this.way);
			}
			else if(ranpower==5){
				po=new Power_ring(this.map,this.hero,this.way);
			}
			else if(ranpower==6){
				po=new Power_sun(this.map,this.hero,this.way);
			}
			po.run();
		}
	}
}