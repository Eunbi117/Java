package ch06;

// ���α׷��� ���� 6-1
class Name
{
	String family_name;		// ��
	String first_name;		// �̸�
	
	// ����� ���� �̸��� �Ѱܹ޾� �ʱ�ȭ�ϴ� ������ �޼ҵ�
	public Name(String family, String first)
	{
		family_name = family;
		first_name = first;
	}
	
	Name(){//�����ڸ޼ҵ�
		
	}
	
	// ���� ��ȯ�ϴ� �޼ҵ�
	 String getFamilyName()
	{
		return family_name;
	}
	// �̸��� ��ȯ�ϴ� �޼ҵ�
	String getFirstName()
	{
		return first_name;
	}
	// ���� �̸� �ȿ� ���Ե� ���ڵ��� �� ���� ��ȯ�ϴ� �޼ҵ�
	int getNumber()
	{
		int num = family_name.length() + first_name.length();
		return num;
	}
}
