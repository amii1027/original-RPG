package character;
public class Hero extends Player{
    private int tension = 0;


    public int choose(Player b,Player c){
	int i;
	if(b.getHp()==0&&c.getHp()==0&&this.getHp()<=this.MAX_HP/2){
	    do{
		System.out.println(this.getName() + "�͂ǂ�����H");
		System.out.println("1.�U�� 2.�x�� 3.���߂� 4.�M�K�X���b�V��");
		i = new java.util.Scanner(System.in).nextInt();
		if(i<1||4<i) System.out.println("error!");
	    }while(i<1||4<i);
	    return i;
	}else{
	    do{
		System.out.println(this.getName() + "�͂ǂ�����H");
		System.out.println("1.�U�� 2.�x�� 3.���߂�");
		i = new java.util.Scanner(System.in).nextInt();
		if(i<1||3<i) System.out.println("error!");
	    }while(i<1||3<i);
	    return i;
	}
    }
    public void attack(enemy.Monster m){
	int damage = new java.util.Random().nextInt(201) + 150;
	int temp = damage;
	System.out.println(this.getName() + "�̍U���I");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}

	if(tension != 0){
	    if(tension == 1) System.out.println("���߂Ă����͂��_���[�W�𑝉�������I");
	    else System.out.println("���߂Ă����͂��������A�_���[�W��{��������I");
	    try{
		Thread.sleep(1000);
	    }catch(InterruptedException e){}
	    damage += damage*tension;
	    tension = 0;
	}
	if(Math.random() > 0.8){
	    System.out.print("��S�̈ꌂ�I");
	    damage += temp;
	    try{
		Thread.sleep(1000);
	    }catch(InterruptedException e){}
	}
	System.out.println(m.getName() + m.getSuffix() + "�ɁA" + damage + "�|�C���g�̃_���[�W��^�����I");
	m.setHp(m.getHp() - damage);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }

    public void charge(){
	System.out.println(this.getName() + "�͗͂𗭂߂Ă���I");
	tension = 1 + new java.util.Random().nextInt(2);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }
    public void giga(enemy.Monster m){
	System.out.println(this.getName() + "�̓{�肪�I�[���ƂȂ��đ̒����ݍ��ށI");
	try{
		Thread.sleep(1000);
	}catch(InterruptedException e){}
	System.out.println(this.getName() + "�̃M�K�X���b�V���I�I");
	try{
		Thread.sleep(1000);
	}catch(InterruptedException e){}
	int damage = new java.util.Random().nextInt(1001) + 1500;
	System.out.println(m.getName() + m.getSuffix() + "�ɁA" + damage + "�|�C���g�̃_���[�W��^�����I");
	m.setHp(m.getHp() - damage);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }

    public Hero(String name){
	super(name,250,0);
    }
}
