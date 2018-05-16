package VO;

public class ChickenVO {

	private String chicken_seq;
	private String chicken_kind;
	private String chicken_grade;
	private String chicken_age;
	private String indate;

	public ChickenVO() {
		super();
	}

	public ChickenVO(String chicken_seq, String chicken_kind, String chicken_grade, String chicken_age, String indate) {
		super();
		this.chicken_seq = chicken_seq;
		this.chicken_kind = chicken_kind;
		this.chicken_grade = chicken_grade;
		this.chicken_age = chicken_age;
		this.indate = indate;
	}

	public String getChicken_seq() {
		return chicken_seq;
	}

	public void setChicken_seq(String chicken_seq) {
		this.chicken_seq = chicken_seq;
	}

	public String getChicken_kind() {
		return chicken_kind;
	}

	public void setChicken_kind(String chicken_kind) {
		this.chicken_kind = chicken_kind;
	}

	public String getChicken_grade() {
		return chicken_grade;
	}

	public void setChicken_grade(String chicken_grade) {
		this.chicken_grade = chicken_grade;
	}

	public String getChicken_age() {
		return chicken_age;
	}

	public void setChicken_age(String chicken_age) {
		this.chicken_age = chicken_age;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "[ġŲ] ��Ϲ�ȣ=" + chicken_seq + ", ǰ��=" + chicken_kind + ", ���="
				+ chicken_grade + ", ����=" + chicken_age + ", �����=" + indate;
	}

}
