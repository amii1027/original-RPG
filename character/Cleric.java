package character;
public class Cleric extends Player{
    public int choose(){
	int i;
	do{
	    System.out.println(this.getName() + "�͂ǂ�����H");
	    System.out.println("1.�U�� 2.�x�� 3.�񕜖��@ 4.�F��");
	    i = new java.util.Scanner(System.in).nextInt();
	    if(i<1||4<i) System.out.println("error!");
	}while(i<1||4<i);
	return i;
    }
    public void attack(enemy.Monster m){
	int damage = new java.util.Random().nextInt(51) + 50;
	System.out.print(this.getName() + "�̍U���I");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	System.out.println(m.getName() + m.getSuffix() + "�ɁA" + damage + "�|�C���g�̃_���[�W��^�����I");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	m.setHp(m.getHp() - damage);
    }

    
    public void pray(){
	int recover = this.MAX_MP/3 + new java.util.Random().nextInt(this.MAX_MP/3);
	if(this.getMp() + recover > this.MAX_MP) recover = this.MAX_MP - this.getMp();
	System.out.print(this.getName() + "�͋F�����I");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	System.out.println(" MP��" + recover + "�|�C���g�񕜂����I");
	this.setMp(this.getMp() + recover);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }
    
    public void heal(Player a){
	int i;
	int recover = a.MAX_HP /3 + new java.util.Random().nextInt(a.MAX_HP/3);
	if(!this.setMp(this.getMp() - 20)) System.out.println(this.getName() + "�́A���@�������悤�Ƃ�����MP������Ȃ������I");
	else{
	    System.out.println(this.getName() + "�́A" + a.getName() + "�ɉ񕜖��@���������I");
	    if(Math.random() > 0.8){
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		System.out.println(this.getName() + "�̖��@���������ꂽ�I");
		recover = a.MAX_HP;
	    }
	    try{
		Thread.sleep(1000);
	    }catch(InterruptedException e){}
	    if(a.getHp() + recover > a.MAX_HP) recover = a.MAX_HP - a.getHp();
	    if(a.getHp() == 0) System.out.println("������" + a.getName() + "�͂�������ł���I");
	    else{
		System.out.println(a.getName() + "��HP���A" + recover + "�|�C���g�񕜂����I");
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
