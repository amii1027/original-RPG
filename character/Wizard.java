package character;
public class Wizard extends Player{
    public int choose(){
	int i;
	do{
	    System.out.println(this.getName() + "�͂ǂ�����H");
	    System.out.println("1.���@�U�� 2.�x�� 3.����U���iMP�񕜁j");
	    i = new java.util.Scanner(System.in).nextInt();
	    if(i<1||3<i) System.out.println("error!");
	}while(i<1||3<i);
	return i;
    }

    public void attack(enemy.Monster m){
	if(!this.setMp(this.getMp() - 30))
	    System.out.println(this.getName() + "�́A���@����Ƃ��Ƃ�����MP������Ȃ������I");
	else{
	    System.out.print(this.getName() + "�́A");
	    if(Math.random() > 0.8){
		System.out.println("�����Q���Ăяo�����I");
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		for(int i=0;i<new java.util.Random().nextInt(6)+5;i++){
		    int damage = new java.util.Random().nextInt(21) + 80;
		    System.out.println(m.getName() + m.getSuffix() + "�ɁA" + damage + "�|�C���g�̃_���[�W�I");
		    m.setHp(m.getHp() - damage);
		    try{
			Thread.sleep(100);
		    }catch(InterruptedException e){}
		}
	    }else{
		int i = new java.util.Random().nextInt(3);
		switch(i){
		case 0 : System.out.print("�΋���");
		    break;
		case 1 : System.out.print("������");
		    break;
		case 2 : System.out.print("�X���I��");
		    break;
		}
		System.out.print("�������I");
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		int damage = new java.util.Random().nextInt(201) + 200;
		System.out.println(m.getName() + m.getSuffix() + "�ɁA" + damage + "�|�C���g�̃_���[�W�I");
		m.setHp(m.getHp() - damage);
	    }
	}
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}

    }
    
    public void special(enemy.Monster m){
	System.out.println(this.getName() + "�́A����U�����s�����I");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
	int damage = new java.util.Random().nextInt(51) + 100;
	int recover = damage / 2;
	if(this.getMp() + recover > this.MAX_MP) recover = this.MAX_MP - this.getMp();
	System.out.println(m.getName() + m.getSuffix() + "�ɁA" + damage + "�|�C���g�̃_���[�W��^���A" + recover + "�|�C���g��MP�ɕϊ������I");
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
