

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args){

        //Animal Class Tests

        Animal a1 = new Animal("Milo", "Female", 3, "Dog");
        System.out.println(a1);

        Animal a2 = new Animal(a1);
        System.out.println(a2);

        System.out.println(a1.equals(a2));

        a2.setName("Chicken");
        System.out.println(a1.equals(a2));

        Animal a3 = new Animal();
        a3.setName("Kilo");
        a3.setAge(7);
        a3.setType("Dog");
        a3.setGender("Male");
        System.out.println(a3);

        Animal.TYPES.add("Kangaroo");

        for(int i = 0; i < Animal.TYPES.size(); i++){
            System.out.println(Animal.TYPES.get(i));
        }

        //Zoo Class Tests



    }
}
