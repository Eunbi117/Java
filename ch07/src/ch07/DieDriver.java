package ch07;

//���� 5��
class Die{
	int die_fir;//ù��° �ֻ����� ���� ���� ��
	int die_sec;//�ι�° �ֻ����� ���� ���� ��
	int sum;//�� �ֻ����� ���� ���� ��
	
	public Die(){//���� �� ������ ���� ������
		int first = (int) (Math.random() * 6) + 1; //1~6������ ���� ����
		int second = (int) (Math.random() * 6) + 1; //1~6������ ���� ����
		die_fir = first;
		die_sec = second;
		
	}
	
	public void setDie(){//���� 14���� ����//�ֻ��� �ΰ��� ���� ȿ��
		int first
		= (int) (Math.random() * 6) + 1; //1~6������ ���� ����
		int second = (int) (Math.random() * 6) + 1; //1~6������ ���� ����
		die_fir = first;
		die_sec = second;
		
	}
	
	public int round(){//�� ���� ���� sum�� ��ȯ�Ѵ�.
		sum = die_fir + die_sec;
		
		return sum;
	}
}

class DieDriver{
	public static void main(String[] args) {
		int count = 0;//�ֻ��� ������ ���� 7�̳� 11�� ���� Ƚ�� �����ϴ� ����
		
		for(int i = 0; i < 100; i++){
			Die d = new Die();//100�� �����ؾ� ��
			int round = d.round();//round�Լ��� ����Ͽ� �� �ֻ����� ���� �����´�.
			
			if(round == 7 || round == 11){
				count++;
			}
		}//end for
		
		System.out.println("�ֻ����� ������ ���� ���� 7�̳� 11�� Ƚ��: " + count);
	}
}