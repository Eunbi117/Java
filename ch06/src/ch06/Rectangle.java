package ch06;

//���α׷��� ���� 6-5
class Rectangle
{
	int width;//����
	int length;//����
	int area;//����
	int circumference;//�ѷ�
	
	//�����ڸ޼ҵ�
	public Rectangle()
	{
		width = 1;
		length = 1;
	}
	
/*	public Rectangle(int wid, int len)
	{
		// �� �Ӽ��� ���� 1�� �ϴ� �Ű������� ������ �ʴ� ������ �޼ҵ�
		if (wid != 1 && len != 1)
		{
			width = wid;
			length = len;
		}
	}*/
/*	void setArea()				// ���� ���
	{
		area = width * length;
	}
	void setCircumference()		// �ѷ� ���
	{
		circumference = (width + length) * 2;
	}*/
	
	
	int getArea()				// ���� ��ȯ
	{
		area = width * length;
		return area;
	}
	int getCircumference()		// �ѷ� ��ȯ
	{
		circumference = (width + length) * 2;
		return circumference;
	}
	
	
	int getWidth()				// ���� ���� ��ȯ�ϴ� ������ �޼ҵ�
	{
		return width;
	}
	int getLength()				// ���� ���� ��ȯ�ϴ� ������ �޼ҵ�
	{
		return length;
	}
	
	
	void setWidth(int newW)		// ���� ���� �����ϴ� ������ �޼ҵ�
	{
		if (newW > 0 && newW < 20)
			width = newW;
		else{
			System.out.println("������ ���� ������ 0~20 �����Դϴ�.");
			System.out.println("�������� ����� �ʱ�ȭ ���� 1�� ���˴ϴ�.");
		}
	}
	void setLength(int newL)	// ���� ���� �����ϴ� ������ �޼ҵ�
	{
		if (newL > 0 && newL < 20)
			length = newL;
		else{
			System.out.println("������ ���� ������ 0~20 �����Դϴ�.");
			System.out.println("�������� ����� �ʱ�ȭ ���� 1�� ���˴ϴ�.");
		}
	}
}
