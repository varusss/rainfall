#include <iostream>
#include <cmath>
#include <algorithm>
#include <numeric>
#include <vector>
using namespace std;

int main() {

	int rainfall;
	int option = 0;
	vector<int> vec;

	cout << "Please enter daily rainfall data (-1 to quit):\n";
	while (true){
		cin >> rainfall;
		if (!cin) {
			cout << "BAD INPUT!\n";
			return 0;
		}
		if (rainfall == -1) break;
		

		if (rainfall >=0)
			vec.push_back(rainfall);
	}

	//for (int i : vec) cout << i << "\t";
	//cout << endl;

	while (rainfall == -1){
		cout << "1) Average daily rainfall\n";
		cout << "2) Average rainfall on rainy days\n";
		cout << "3) Count of days that had rain\n";
		cout << "4) Maximum rainfall\n";
		cout << "5) Top 5 days of rain\n";
		cout << "6) Quit\n";
		cin >> option;
		if (!cin){
			cout << "BAD INPUT!\n";
			return 0;
		}
		if (option == 6) break ;

		if (vec.size() == 0) {
			cout << "NO DATA\n";
			continue;
		}
		if (option == 1){
			const int SIZE = vec.size();
			int sum = 0;
			for (int i : vec) sum += i;
			cout<<sum/SIZE << endl;
		}	
		if (option == 2){
			int size =0;
			int sum =0;
			for (int i:vec){
				if (i){
					size++;
					sum+=i;
				}
			}
			if (!sum) cout << "NO DATA" << endl;
			else cout << sum/size << endl;
		}
		if (option == 3){
			int rainyDay = 0;
			for (int i: vec) 
				if (i) 
					rainyDay++;
			cout << rainyDay << endl;
		}
		if (option == 4){
			int max =  *max_element(vec.begin(), vec.end());
			if (!max) cout << "NO DATA\n";
			else cout << max << endl;
		}
		if (option == 5){
			sort(vec.begin(), vec.end(), greater<>());
			if (vec[0] == 0) cout << "NO DATA\n";
			else {
				for(size_t i =0; i< vec.size(); i++)
					if (i <5)
						cout << vec[i] << endl;
			}
		}
	}
}



