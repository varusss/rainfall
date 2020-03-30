import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Rainfall {
	public static void main(String[] args) {
		System.out.println("Welcome to Java Rainfall!");
		
		int rainfall;
		int option = 0;
		ArrayList<Integer> vec = new ArrayList<Integer>();

		System.out.println("Please enter daily rainfall data (-1 to quit):");
		Scanner cin = new Scanner(System.in);

		while (true){
			//cin >> rainfall;
			rainfall = cin.nextInt();

			if (rainfall == -1) break;


			if (rainfall >=0)
				vec.add(rainfall);
		}

		//for (int i : vec) cout << i << "\t";
		//cout << endl;

		while (rainfall == -1){
			System.out.println("1) Average daily rainfall");
			System.out.println("2) Average rainfall on rainy days"); 
			System.out.println("3) Count of days that had rain");
			System.out.println("4) Maximum rainfall");
			System.out.println("5) Top 5 days of rain");
			System.out.println("6) Quit");
			
			option = cin.nextInt();
			
			if (option == 6) break ;

			if (vec.size() == 0) {
				System.out.println("NO DATA");
				continue;
			}
			if (option == 1){
				int SIZE = vec.size();
				int sum = 0;
				for (int i : vec) sum += i;
				System.out.println(sum/SIZE);
			}	
			if (option == 2){
				int size =0;
				int sum =0;
				for (int i:vec){
					if (i != 0){
						size++;
						sum+=i;
					}
				}
				if (sum == 0) System.out.println("NO DATA"); 
				else System.out.println(sum/size);
			}
			if (option == 3){
				int rainyDay = 0;
				for (int i: vec) 
					if (i != 0) 
						rainyDay++;
				System.out.println(rainyDay);
			}
			if (option == 4){
				int max =  Collections.max(vec);
				if (max != 0) System.out.println("NO DATA"); 
				else System.out.println(max); 
			}
			if (option == 5){
				vec.sort(Collections.reverseOrder());
				if (vec.get(0) == 0) System.out.println("NO DATA");
				else {
					for(int i =0; i< vec.size(); i++)
						if (i <5)
							System.out.println(vec.get(i));	
				}
			}
		}
	}
}



