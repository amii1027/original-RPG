package character;

public class Sorcerer extends Player{
        public int choose(){
	int i;
	do{
	    System.out.println(name + "�͂ǂ�����H");
	    System.out.println("1.���@�U�� 2.���߂� 3.����U���iMP�񕜁j");
	    i = new java.util.Scanner(System.in).nextInt();
	    if(i<1||3<i) System.out.println("error!");
	}while(i<1||3<i);
	return i;
    }
    public void attack(enemy.Monster m){
	if(!this.setMp(this.getMp() - 20)) System.out.println(this.name + "�́A���@�������悤�Ƃ�����MP������Ȃ������I");
	else{
	    System.out.print(this.name + "�́A");
	    if(Math.random > 0.8){
		System.out.print("�����Q���Ăяo�����I");
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		int damage = this.atk/2 - m.getDef()/4;
		int d;
		for(int i = 0;i < 5;i++){
		    d = new java.util.Random().nextInt(damage/16 + 2);
		    System.out.println(m.getName() + "�ɁA" + damage + d + "�|�C���g�̃_���[�W�I");
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
		case 0 : System.out.print("�΋���������I");
		    break;
		case 1 : System.out.print("������������I");
		    break;
		case 2 : System.out.print("�X���I��������I");
		    break;
		}
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
		System.out.println(m.getName() + "�ɁA" + damage + "�|�C���g�̃_���[�W��^�����I");
		m.setHp(m.getHp() - damage);
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException e){}
	    }
	}
    }
