package character;
public class Cleric extends Player{
    public int choose(){
	int i;
	do{
	    System.out.println(this.getName() + "はどうする？");
	    System.out.println("1.攻撃 2.休む 3.回復魔法 4.祈る");
	    i = new java.util.Scanner(System.in).nextInt();
	    if(i<1||4<i) System.out.println("error!");
	}while(i<1||4<i);
	return i;
    }
    public void attack(enemy.Monster m){
	int damage = new java.util.Random().nextInt(51) + 50;
	System.out.print(this.getName() + "の攻撃！");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	System.out.println(m.getName() + m.getSuffix() + "に、" + damage + "ポイントのダメージを与えた！");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	m.setHp(m.getHp() - damage);
    }

    
    public void pray(){
	int recover = this.MAX_MP/3 + new java.util.Random().nextInt(this.MAX_MP/3);
	if(this.getMp() + recover > this.MAX_MP) recover = this.MAX_MP - this.getMp();
	System.out.print(this.getName() + "は祈った！");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	System.out.println(" MPが" + recover + "ポイント回復した！");
	this.setMp(this.getMp() + recover);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }
    
    public void heal(Player a){
	int i;
	int recover = a.MAX_HP /3 + new java.util.Random().nextInt(a.MAX_HP/3);
	if(!this.setMp(this.getMp() - 20)) System.out.println(this.getName() + "は、魔法を唱えようとしたがMPが足りなかった！");
	else{
	    System.out.println(this.getName() + "は、" + a.getName() + "に回復魔法を唱えた！");
	    if(Math.random() > 0.8){
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		System.out.println(this.getName() + "の魔法が強化された！");
		recover = a.MAX_HP;
	    }
	    try{
		Thread.sleep(1000);
	    }catch(InterruptedException e){}
	    if(a.getHp() + recover > a.MAX_HP) recover = a.MAX_HP - a.getHp();
	    if(a.getHp() == 0) System.out.println("しかし" + a.getName() + "はもう死んでいる！");
	    else{
		System.out.println(a.getName() + "のHPが、" + recover + "ポイント回復した！");
		a.setHp(a.getHp() + recover);
	    }
	}
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }
    
    
    public Cleric(String name){
	super(name,180,160);
    }
}
