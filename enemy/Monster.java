package enemy;

public class Monster{
    private int hp;
    private String name;
    private char suffix;
    private boolean sd = true;
    public final int MAX_HP;

    public Monster(String name, char suffix, int hp){
	this.name = name;
	this.suffix = suffix;
	this.hp = hp;
	this.MAX_HP = hp;
    }

    public void attack(character.Player a,character.Player b,character.Player c){
	sd = true;
	System.out.println(this.getName() + this.getSuffix() + "の攻撃！");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	character.Player[] party = new character.Player[3];
	party[0] = a;
	party[1] = b;
	party[2] = c;
	int damage = new java.util.Random().nextInt(21) + 45;
	int taisyou = new java.util.Random().nextInt(3);

	if(Math.random() > 0.9){
	    System.out.print("痛恨の一撃！");
	    damage *= 2;
	    try{
		Thread.sleep(1000);
	    }catch(InterruptedException e){}
	}
	while(sd){
	    if(party[taisyou].setHp(party[taisyou].getHp() - damage)){
		System.out.println(party[taisyou].getName() + "は、" + damage + "ポイントのダメージをうけた！");
		sd = false;
	    }else taisyou = new java.util.Random().nextInt(3);
	}
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }
    public void rest(){
	System.out.println(this.getName() + this.getSuffix() +  "は、休んで体力を回復させた！");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	int recover = new java.util.Random().nextInt(this.MAX_HP/25) + this.MAX_HP/16;
	if(this.hp + recover > this.MAX_HP) recover = this.MAX_HP - this.hp;
	System.out.println(this.getName() + this.getSuffix() + "のHPは、" + recover + "ポイント回復した！");
	this.hp += recover;
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }

    public String getName(){ return this.name; }
    public int getHp(){ return this.hp; }
    public char getSuffix(){ return this.suffix; }
    public void setHp(int hp){
	if(hp<0) hp = 0;
	this.hp = hp;
    }
}
