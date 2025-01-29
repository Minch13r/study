package fighting.model;

public class CoffeeDTO {
	private int num;
	private String name;
	private String detail;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "CoffeeDTO [num=" + num + ", name=" + name + ", detail=" + detail + "]";
	}
}
