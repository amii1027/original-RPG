package character;
public class Wizard extends Player{
    public int choose(){
	int i;
	do{
	    System.out.println(this.getName() + "はどうする？");
	    System.out.println("1.魔法攻撃 2.休む 3.特殊攻撃（MP回復）");
	    i = new java.util.Scanner(System.in).nextInt();
	    if(i<1||3<i) System.out.println("error!");
	}while(i<1||3<i);
	return i;
    }

    public void attack(enemy.Monster m){
	if(!this.setMp(this.getMp() - 30))
	    System.out.println(this.getName() + "は、魔法を放とうとしたがMPが足りなかった！");
	else{
	    System.out.print(this.getName() + "は、");
	    if(Math.random() > 0.8){
		System.out.println("流星群を呼び出した！");
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		for(int i=0;i<new java.util.Random().nextInt(6)+5;i++){
		    int damage = new java.util.Random().nextInt(21) + 80;
		    System.out.println(m.getName() + m.getSuffix() + "に、" + damage + "ポイントのダメージ！");
		    m.setHp(m.getHp() - damage);
		    try{
			Thread.sleep(100);
		    }catch(InterruptedException e){}
		}
	    }else{
		int i = new java.util.Random().nextInt(3);
		switch(i){
		case 0 : System.out.print("火球を");
		    break;
		case 1 : System.out.print("雷撃を");
		    break;
		case 2 : System.out.print("氷の礫を");
		    break;
		}
		System.out.print("放った！");
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		int damage = new java.util.Random().nextInt(201) + 200;
		System.out.println(m.getName() + m.getSuffix() + "に、" + damage + "ポイントのダメージ！");
		m.setHp(m.getHp() - damage);
	    }
	}
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}

    }
    
    public void special(enemy.Monster m){
	System.out.println(this.getName() + "は、特殊攻撃を行った！");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	int damage = new java.util.Random().nextInt(51) + 100;
	int recover = damage / 2;
	if(this.getMp() + recover > this.MAX_MP) recover = this.MAX_MP - this.getMp();
	System.out.println(m.getName() + m.getSuffix() + "に、" + damage + "ポイントのダメージを与え、" + recover + "ポイントのMPに変換した！");
	m.setHp(m.getHp() - damage);
	this.setMp(this.getMp() + recover);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }
    
    public Wizard(String name){
	super(name,150,180);
    }
}
