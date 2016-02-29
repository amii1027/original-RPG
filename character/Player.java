package character;

public class Player{
    private String name;
    private int hp;
    private int mp;
    public final int MAX_HP;
    public final int MAX_MP;

    public void rest(){
	int recover = this.MAX_HP / 4 + new java.util.Random().nextInt(this.MAX_HP / 16 + 2);
	if(this.hp + recover > this.MAX_HP) recover = this.MAX_HP - this.hp; 
	System.out.println(this.name + "は休んだ！");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	System.out.println("HPが、" + recover + "ポイント回復した！");
	this.hp += recover;
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }


    public Player(String name,int hp,int mp){
	this.name = name;
	this.hp = hp;
	this.MAX_HP = hp;
	this.mp = mp;
	this.MAX_MP = mp;
    }
    public String getName(){ return this.name; }
    public int getHp(){ return this.hp; }
    public int getMp(){ return this.mp; }

    public boolean setHp(int hp){
	if(this.hp==0) return false;
	else{
	    if(hp<0) {
		hp=0;
	    }
	    this.hp = hp;
	    return true;
	}
    }
    public boolean setMp(int mp){
	if(mp<0) return false;
	else{
	    this.mp = mp;
	    return true;
	}
    }
}
