package enemy;
public class Keruberosu extends Monster{
    public Keruberosu(int hp,char suffix){
	super("�P���x���X",suffix,hp);
    }
    public Keruberosu(int hp){
	super("�P���x���X",'\0',hp);
    }

    public void bless(character.Player a,character.Player b,character.Player c){
	System.out.println(this.getName() + this.getSuffix() + "�̃u���X�U���I");
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
		System.out.println(x.getName() + "�́A" + damage + "�|�C���g�̃_���[�W���󂯂��I");
		
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
