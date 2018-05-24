package ch07;

//문제 5번
class Die{
	int die_fir;//첫번째 주사위를 돌려 나온 수
	int die_sec;//두번째 주사위를 돌려 나온 수
	int sum;//두 주사위의 수를 더한 수
	
	public Die(){//생성 할 때마다 난수 생성함
		int first = (int) (Math.random() * 6) + 1; //1~6사이의 난수 생성
		int second = (int) (Math.random() * 6) + 1; //1~6사이의 난수 생성
		die_fir = first;
		die_sec = second;
		
	}
	
	public void setDie(){//문제 14번을 위해//주사위 두개를 돌린 효과
		int first
		= (int) (Math.random() * 6) + 1; //1~6사이의 난수 생성
		int second = (int) (Math.random() * 6) + 1; //1~6사이의 난수 생성
		die_fir = first;
		die_sec = second;
		
	}
	
	public int round(){//두 수를 더한 sum을 반환한다.
		sum = die_fir + die_sec;
		
		return sum;
	}
}

class DieDriver{
	public static void main(String[] args) {
		int count = 0;//주사위 숫자의 합이 7이나 11이 나온 횟수 저장하는 변수
		
		for(int i = 0; i < 100; i++){
			Die d = new Die();//100번 생성해야 함
			int round = d.round();//round함수를 사용하여 두 주사위의 합을 가져온다.
			
			if(round == 7 || round == 11){
				count++;
			}
		}//end for
		
		System.out.println("주사위를 돌려서 나온 값이 7이나 11인 횟수: " + count);
	}
}