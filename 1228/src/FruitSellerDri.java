
class FruitSeller {
	int numofapple;
	int mymoney;
	
	//�����ڸ޼ҵ�
	FruitSeller(){
		numofapple=20;
		mymoney = 0;
	}
	
	public int SaleApple(int money){
		int num = money/1000;
		numofapple -= num;
		mymoney += money;
		
		return num;
	}

}


public class FruitSellerDri{
	public static void main(String[] args) {
		FruitSeller fs = new FruitSeller();
		
		int num = fs.SaleApple(10000);
		System.out.println(num);
	}
}