package Resources;

public class Sensor {
	String value = "up";
	int i = 0;
	public Sensor() {}
	public String next() {
		i++;
		return i%2>0?"down":"up";
	}
}
