package ch06;

// 프로그래밍 문제 6-1
class Name
{
	String family_name;		// 성
	String first_name;		// 이름
	
	// 사람의 성과 이름을 넘겨받아 초기화하는 생성자 메소드
	public Name(String family, String first)
	{
		family_name = family;
		first_name = first;
	}
	
	Name(){//생성자메소드
		
	}
	
	// 성을 반환하는 메소드
	 String getFamilyName()
	{
		return family_name;
	}
	// 이름을 반환하는 메소드
	String getFirstName()
	{
		return first_name;
	}
	// 성과 이름 안에 포함된 문자들의 총 수를 반환하는 메소드
	int getNumber()
	{
		int num = family_name.length() + first_name.length();
		return num;
	}
}
