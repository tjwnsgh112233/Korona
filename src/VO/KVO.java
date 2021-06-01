package VO;

public class KVO {
	private String name;
	private int h;
	private int o;
	private int k;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getO() {
		return o;
	}
	public void setO(int o) {
		this.o = o;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	@Override
	public String toString() {
		return "KVO [name=" + name + ", h=" + h + ", o=" + o + ", k=" + k + "]";
	}
	
}
