package enemy;
public class Boss{
    private int hp;
    private String name;
    private int sd=0;


    public void attack(character.Hero a,character.Wizard b,character.Cleric c){
	sd=0;
	System.out.println(this.name + "�̍U���I");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}

	int damage = new java.util.Random().nextInt(21) + 30;
	int taisyou = new java.util.Random().nextInt(3);
	if(Math.random() > 0.9){
	    System.out.print("�ɍ��̈ꌂ�I");
	    damage *= 2;
	    try{
		Thread.sleep(1000);
	    }catch(InterruptedException e){}
	}
	while(sd!=-1){
	    if(taisyou==0){
		if(a.getHp()==0) taisyou = new java.util.Random().nextInt(1) + 1;
		else{
		    System.out.println(a.getName() + "�́A" + damage + "�|�C���g�̃_���[�W���󂯂��I");
		    a.setHp(a.getHp() - damage);
		    sd=-1;
		}
	    }
	    if(taisyou==1){
		if(b.getHp()==0){
		    int z = new java.util.Random().nextInt(1);
		    if(z==0) taisyou = 0;
		    if(z==1) taisyou = 2;
		}else{
		    System.out.println(b.getName() + "�́A" + damage + "�|�C���g�̃_���[�W���󂯂��I");
		    b.setHp(b.getHp() - damage);
		    sd=-1;
		}
	    }	    
	    if(taisyou==2){
		if(c.getHp()==0) taisyou = new java.util.Random().nextInt(1);
		else{
		    System.out.println(c.getName() + "�́A" + damage + "�|�C���g�̃_���[�W���󂯂��I");
		    c.setHp(c.getHp() - damage);
		    sd=-1;
		}
	    }
	}
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}

    }
    public void bless(character.Hero a,character.Wizard b,character.Cleric c){
	System.out.println(this.name + "�̃u���X�U���I");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	int damage = new java.util.Random().nextInt(11) + 20;
	if(a.getHp() != 0)
	    System.out.println(a.getName() + "�́A" + damage + "�|�C���g�̃_���[�W���󂯂��I");
	a.setHp(a.getHp() - damage);
	try{
	    Thread.sleep(100);
	}catch(InterruptedException e){}		
	damage = new java.util.Random().nextInt(11) + 20;
	if(b.getHp() != 0)
	    System.out.println(b.getName() + "�́A" + damage + "�|�C���g�̃_���[�W���󂯂��I");
	b.setHp(b.getHp() - damage);
	try{
	    Thread.sleep(100);
	}catch(InterruptedException e){}
	damage = new java.util.Random().nextInt(11) + 20;
	if(c.getHp() != 0)
	    System.out.println(c.getName() + "�́A" + damage + "�|�C���g�̃_���[�W���󂯂��I");
	c.setHp(c.getHp() - damage);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }
    public void rest(){
	System.out.println(this.name + "�́A�x��ő̗͂��񕜂������I");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	int recover = new java.util.Random().nextInt(101) + 200;
	if(this.hp + recover > 2500) recover = 2500 - this.hp;
	System.out.println(this.name + "��HP�́A" + recover + "�|�C���g�񕜂����I");
	this.hp += recover;
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }


    public Boss(int hp,String name){
	this.hp = hp; this.name = name;
    }
    public String getName(){ return name; }
    public int getHp(){ return hp; }
    public void setHp(int i){
	if(i<0) i = 0;
	this.hp = i;
    }
}
