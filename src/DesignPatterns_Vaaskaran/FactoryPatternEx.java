package DesignPatterns_Vaaskaran;

interface IAnimal {
	
	void Speak();
}

class Duck implements IAnimal {

	@Override
	public void Speak() {
		System.out.println("Duck says Pack-pack");
	}
}

class Tiger implements IAnimal {

	@Override
	public void Speak() {
		System.out.println("Tiger says: Halum..Halum");
	}
}

abstract class IAnimalFactory {

	/*if we cannot instantiate in later stage, we’ll throw exception*/
	public abstract IAnimal GetAnimalType(String type) throws Exception;
}

class ConcreteFactory extends IAnimalFactory {

	@Override
	public IAnimal GetAnimalType(String type) throws Exception {
		switch (type) {
			case "Duck":
				return new Duck();
			case "Tiger":
				return new Tiger();
			default:
				throw new Exception("Animal type : " + type + " cannot be instantiated");
		}
	}
}

public class FactoryPatternEx {

	public static void main(String[] args) throws Exception {
		System.out.println("***Factory Pattern Demo***\n");
		IAnimalFactory animalFactory = new ConcreteFactory();
		IAnimal DuckType = animalFactory.GetAnimalType("Duck");
		DuckType.Speak();
		IAnimal TigerType = animalFactory.GetAnimalType("Tiger");
		TigerType.Speak();
		//There is no Lion type. So, an exception will be thrown
		IAnimal LionType = animalFactory.GetAnimalType("Lion");
		LionType.Speak();
	}
}
