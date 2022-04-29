import java.util.Scanner;

public class TowerGame {
	public static void main(String[] args) {
		char skill;
		char yesOrNo;
		int usedSkill = 0;
		int towersCounter = 0;
		int counter = 0;
		double skillDamage;
		double countDamage = 0;
		double countDamageTotal = 0;
		int month = 12;
		try (Scanner s = new Scanner(System.in)) {
			do {
				towersCounter = 0;
				for(int i = 0; i<5; i++) {
					counter = 0;
					countDamage = 0;
					do{
						System.out.println("Digite a habilidade:");
						skill = s.nextLine().charAt(0);
						while((skill != 'q' && skill != 'w' && skill != 'e' && skill != 'r')||(skill == 'r' && counter > 0)) {
							System.out.println("Habilidade não encontrada. Digite outra tecla");
							skill = s.nextLine().charAt(0);
						}
						skillDamage = 0;
						if(skill == 'q') {
							System.out.println("Sentença");
							skillDamage = 1.5*month;
						}else if(skill == 'w') {
							skillDamage = 2.5*month;
						}else if(skill == 'e') {
							skillDamage = 3.5*month;
						}else if(skill == 'r') {
							skillDamage = 5*month;
							counter++;
					}
					countDamage = countDamage + skillDamage;
					usedSkill++;
					}while(countDamage < 100);
					countDamageTotal += countDamage;
					if(usedSkill <=10) {
						System.out.println("Tower destroyed");
						towersCounter++;
					}else {
						System.out.println("Tower was not destroyed");
					}
				}
				if(towersCounter>=3) {
					System.out.println("You Win!");
				}else {
					System.out.println("You Loose");
				}
				System.out.println("Do you want to play again?");
				yesOrNo = s.nextLine().charAt(0);
			    }while(yesOrNo == 's');
		}
		
		if(countDamageTotal>=1000) {
			System.out.println("Você está no ranque Ouro!Parabéns");
		}else if(countDamageTotal>=500) {
			System.out.println("Você está no ranque Prata!Parabéns");
		}else{
			System.out.println("Você está no ranque Bronze!Parabéns");
		}
	  }
	}
