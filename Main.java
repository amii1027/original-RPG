import character.*;
import enemy.*;

public class Main{
    public static void main(String[] args){
	int ai,bi,ci,z;
	int numberOfEnemy;
	System.out.print("戦士の名前を入力してください→");
	String s = new java.util.Scanner(System.in).nextLine();	
	Hero a = new Hero(s);
	System.out.print("魔法使いの名前を入力してください→");
	s = new java.util.Scanner(System.in).nextLine();
	Wizard b = new Wizard(s);
	System.out.print("僧侶の名前を入力してください→");
	s = new java.util.Scanner(System.in).nextLine();
	Cleric c = new Cleric(s);
	Player[] party = new Player[3];
	party[0] = a;
	party[1] = b;
	party[2] = c;
	
	Keruberosu d1 = new Keruberosu(5000);
	Monster[] enemyParty = new Monster[1];
	enemyParty[0] = d1;
	numberOfEnemy = 1;
	
	System.out.println("");
	System.out.println("");
	try{
	    Thread.sleep(500);
	}catch(InterruptedException e){}
	for(Monster m : enemyParty){
	    System.out.print(m.getName() + m.getSuffix());
	    if(numberOfEnemy!=1)
		System.out.print(" ");
	}
	System.out.println("が現れた！");
	try{
	    Thread.sleep(500);
	}catch(InterruptedException e){}

	while(true){
	    int clericTaisyou;
	    int heroTaisyou;
	    int wizardTaisyou;
	    int enemyTemp = 0;
	    ai=-1;
	    bi=-1;
	    ci=-1;
	    System.out.println("");
	    for(Player p : party)
		System.out.println(p.getName() + " HP:" + p.getHp() + "/" + p.MAX_HP + " MP:" + p.getMp() + "/" + p.MAX_MP);
	    System.out.println("");

	    // System.out.println(d.getName() + d.getSuffix() + " HP:" + d.getHp() + "/" + d.MAX_HP);
	    //System.out.println("");
	    

	    if(a.getHp()>0) ai = a.choose(b,c);
	    if(b.getHp()>0) bi = b.choose();
	    if(c.getHp()>0) ci = c.choose();
	    if(ci == 3){
		do{
		    System.out.println("誰を回復する？");
		    System.out.println("1."+a.getName() +" 2."+b.getName() + " 3."+c.getName());
		    clericTaisyou = new java.util.Scanner(System.in).nextInt();
		    if(clericTaisyou<1||3<clericTaisyou) System.out.println("error!");
		}while(clericTaisyou<1||3<clericTaisyou);
	    }else clericTaisyou = new java.util.Random().nextInt(numberOfEnemy);

	    heroTaisyou = new java.util.Random().nextInt(numberOfEnemy);
	    wizardTaisyou = new java.util.Random().nextInt(numberOfEnemy);
	    
	    switch(ai){
	    case 1 : a.attack(enemyParty[heroTaisyou]);
		break;
	    case 2 : a.rest();
		break;
	    case 3 : a.charge();
		break;
	    case 4 : a.giga(enemyParty[heroTaisyou]);
		break;
	    }

	    for(Monster m : enemyParty)
		if(m.getHp() == 0) enemyTemp++;
	    if(enemyTemp == numberOfEnemy){
		System.out.println(a.getName() + "たちは、" + enemyParty[0].getName()+enemyParty[0].getSuffix() + "との戦闘に勝利した！");
		return;
	    }
	    switch(bi){
	    case 1 : b.attack(enemyParty[wizardTaisyou]);
		break;
	    case 2 : b.rest();
		break;
	    case 3 : b.special(enemyParty[wizardTaisyou]);
		break;
	    }
	    for(Monster m : enemyParty)
		if(m.getHp() == 0) enemyTemp++;
	    if(enemyTemp == numberOfEnemy){
		System.out.println(a.getName() + "たちは、" + enemyParty[0].getName()+enemyParty[0].getSuffix() + "との戦闘に勝利した！");
		return;
	    }
	    switch(ci){
	    case 1 : c.attack(enemyParty[clericTaisyou]);
		break;
	    case 2 : c.rest();
		break;
	    case 3 : clericTaisyou--;
		c.heal(party[clericTaisyou]);
		break;
	    case 4 : c.pray();
		break;
	    }
	    for(Monster m : enemyParty)
		if(m.getHp() == 0) enemyTemp++;
	    if(enemyTemp == numberOfEnemy){
		System.out.println(a.getName() + "たちは、" + enemyParty[0].getName()+enemyParty[0].getSuffix() + "との戦闘に勝利した！");
		return;
	    }

	    System.out.println("");	    

	    for(Monster m : enemyParty){
		z = new java.util.Random().nextInt(3);
		if(z==0) m.attack(a,b,c);
		if(z==1) {
		    Keruberosu k = (Keruberosu)m;
		    k.bless(a,b,c);
		}
		if(z==2) m.rest();
		if(a.getHp()==0&&b.getHp()==0&&c.getHp()==0){
		    System.out.println(a.getName() + "たちは全滅してしまった！");
		    System.out.println("GAME OVER");
		    return;
		}
		z = new java.util.Random().nextInt(3);
		if(z==0) m.attack(a,b,c);
		if(z==1) {
		    Keruberosu k = (Keruberosu)m;
		    k.bless(a,b,c);
		}
		if(z==2) m.rest();
		if(a.getHp()==0&&b.getHp()==0&&c.getHp()==0){
		    System.out.println(a.getName() + "たちは全滅してしまった！");
		    System.out.println("GAME OVER");
		    return;
		}
	    }
	    
	    
	   
	}
    }
} 
