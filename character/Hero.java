package character;
public class Hero extends Player{
    private int tension = 0;


    public int choose(Player b,Player c){
	int i;
	if(b.getHp()==0&&c.getHp()==0&&this.getHp()<=this.MAX_HP/2){
	    do{
		System.out.println(this.getName() + "はどうする？");
		System.out.println("1.攻撃 2.休む 3.溜める 4.ギガスラッシュ");
		i = new java.util.Scanner(System.in).nextInt();
		if(i<1||4<i) System.out.println("error!");
	    }while(i<1||4<i);
	    return i;
	}else{
	    do{
		System.out.println(this.getName() + "はどうする？");
		System.out.println("1.攻撃 2.休む 3.溜める");
		i = new java.util.Scanner(System.in).nextInt();
		if(i<1||3<i) System.out.println("error!");
	    }while(i<1||3<i);
	    return i;
	}
    }
    public void attack(enemy.Monster m){
	int damage = new java.util.Random().nextInt(201) + 150;
	int temp = damage;
	System.out.println(this.getName() + "の攻撃！");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}

	if(tension != 0){
	    if(tension == 1) System.out.println("溜めていた力がダメージを増加させる！");
	    else System.out.println("溜めていた力が爆発し、ダメージを倍増させる！");
	    try{
		Thread.sleep(1000);
	    }catch(InterruptedException e){}
	    damage += damage*tension;
	    tension = 0;
	}
	if(Math.random() > 0.8){
	    System.out.print("会心の一撃！");
	    damage += temp;
	    try{
		Thread.sleep(1000);
	    }catch(InterruptedException e){}
	}
	System.out.println(m.getName() + m.getSuffix() + "に、" + damage + "ポイントのダメージを与えた！");
	m.setHp(m.getHp() - damage);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }

    public void charge(){
	System.out.println(this.getName() + "は力を溜めている！");
	tension = 1 + new java.util.Random().nextInt(2);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }
    public void giga(enemy.Monster m){
	System.out.println(this.getName() + "の怒りがオーラとなって体中を包み込む！");
	try{
		Thread.sleep(1000);
	}catch(InterruptedException e){}
	System.out.println(this.getName() + "のギガスラッシュ！！");
	try{
		Thread.sleep(1000);
	}catch(InterruptedException e){}
	int damage = new java.util.Random().nextInt(1001) + 1500;
	System.out.println(m.getName() + m.getSuffix() + "に、" + damage + "ポイントのダメージを与えた！");
	m.setHp(m.getHp() - damage);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException e){}
    }

    public Hero(String name){
	super(name,250,0);
    }
}
