package enemy;
public class Keruberosu extends Monster{
    public Keruberosu(int hp,char suffix){
	super("ケルベロス",suffix,hp);
    }
    public Keruberosu(int hp){
	super("ケルベロス",'\0',hp);
    }

    public void bless(character.Player a,character.Player b,character.Player c){
	System.out.println(this.getName() + this.getSuffix() + "のブレス攻撃！");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	character.Player[] party = new character.Player[3];
	party[0] = a;
	party[1] = b;
	party[2] = c;

	for(character.Player x:party){
	    int damage = new java.util.Random().nextInt(11) + 25;
	    if(x.setHp(x.getHp() - damage)){
		System.out.println(x.getName() + "は、" + damage + "ポイントのダメージを受けた！");
		
		try{
		    Thread.sleep(100);
		}catch(InterruptedException e){}
	    }
	}
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }
    
}
