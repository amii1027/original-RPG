package character;

public class Sorcerer extends Player{
        public int choose(){
	int i;
	do{
	    System.out.println(name + "はどうする？");
	    System.out.println("1.魔法攻撃 2.溜める 3.特殊攻撃（MP回復）");
	    i = new java.util.Scanner(System.in).nextInt();
	    if(i<1||3<i) System.out.println("error!");
	}while(i<1||3<i);
	return i;
    }
    public void attack(enemy.Monster m){
	if(!this.setMp(this.getMp() - 20)) System.out.println(this.name + "は、魔法を唱えようとしたがMPが足りなかった！");
	else{
	    System.out.print(this.name + "は、");
	    if(Math.random > 0.8){
		System.out.print("流星群を呼び出した！");
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		int damage = this.atk/2 - m.getDef()/4;
		int d;
		for(int i = 0;i < 5;i++){
		    d = new java.util.Random().nextInt(damage/16 + 2);
		    System.out.println(m.getName() + "に、" + damage + d + "ポイントのダメージ！");
		    m.setHp(m.getHp() - damage - d);
		    try{
			Thread.sleep(100);
		    }catch(InterruptedException e){}
		}
	    }else{
		int i = new java.util.Random().nextInt(3);
		int damage = this.atk/2 - m.getDef()/4 + 20;
		damage += new java.util.Random().nextInt(damage/16 + 2);
		switch(i){
		case 0 : System.out.print("火球を放った！");
		    break;
		case 1 : System.out.print("雷撃を放った！");
		    break;
		case 2 : System.out.print("氷の礫を放った！");
		    break;
		}
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		System.out.println(m.getName() + "に、" + damage + "ポイントのダメージを与えた！");
		m.setHp(m.getHp() - damage);
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
	    }
	}
    }
