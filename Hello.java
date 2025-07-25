public class Hello{
	public String value = "Hello InMemoryDexClassLoader!";
	public Hello(){

	}
	public Hello(String value){
		this.value = value;
	}

	public String hi(){
		return this.value;
	}
}
