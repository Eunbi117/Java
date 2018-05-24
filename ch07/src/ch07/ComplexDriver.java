package ch07;

//12번 문제
class Complex{
	double sil;
	double hu;
	String out;
	
	//생성자 오버로딩: 메소드 이름은 똑같은데 매개변수의 갯수, 형이 다른 메소드
	public Complex(){
		sil = 0.0;
		hu = 0.0;
	}

	public Complex(double sil, double hu) {
		this.sil = sil;
		this.hu = hu;
	}
	
	public double getSil() {
		return sil;
	}

	public double getHu() {
		return hu;
	}

	public String getOut(){
		out =  "("+getSil()+", " + getHu() +  ")";
		return out;
	}
	
	//뺄샘공식
	public void minus(Complex fir, Complex sec){
		sil = fir.getSil() - sec.getSil();
		hu = fir.getHu() - sec.getHu();
		
	}
	
}


public class ComplexDriver{
	public static void main(String[] args) {
		Complex x = new Complex(2, 3);
		Complex y = new Complex(-3, 7);
		Complex z = new Complex();
		
		z.minus(x, y);
		
		System.out.println(x.getOut());
		System.out.println(y.getOut());
		System.out.println(z.getOut());
		
	}
}