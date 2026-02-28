import java.util.Arrays;

import static java.util.Collections.min;

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

        Zoo zoo = new Zoo();

        zoo.getAnimals().add(new Animal("Flicken", "Male", 7, "Dog"));
        zoo.getAnimals().add(new Animal("Cage", "Female", 7, "Dog"));
        zoo.getAnimals().add(new Animal("Max", "Male", 12, "Dog"));

        zoo.getAnimals().add(new Animal("Goode", "Female", 5, "Cat"));
        zoo.getAnimals().add(new Animal("Luna", "Male", 5, "Cat"));
        zoo.getAnimals().add(new Animal("Charles", "Male", 5, "Cat"));

        zoo.getAnimals().add(new Animal("Punch", "Male", 5, "Monkey"));
        zoo.getAnimals().add(new Animal("George", "Male", 5, "Monkey"));
        zoo.getAnimals().add(new Animal("Lookie", "Female", 5, "Monkey"));

        System.out.println(zoo);

        System.out.println("Number of dogs: " + zoo.countAnimals("Dog"));
        System.out.println("Number of Cats: " + zoo.countAnimals("Cat"));
        System.out.println("Number of Monkeys: " + zoo.countAnimals("Monkey"));

        System.out.println("Are dogs balanced? " + zoo.isGenderBalanced("Dog"));
        System.out.println("Are cats balanced? " + zoo.isGenderBalanced("Cat"));

        zoo.removeOldest("Dog");
        System.out.println(zoo);

        System.out.println(zoo);

        Zoo zooCopy = new Zoo(zoo);

        zooCopy.getAnimals().add(new Animal("Rocky", "Male", 2, "Dog"));

        //Task1 test

        double[][] arr1 = {
                {1, 2, 3},
                {4, 5}
        };

        double[][] arr2 = {
                {1, 2},
                {3, 4, 5},
                {6, 7}
        };

        double[][] arr3 = {
                {1, 2},
                {3, 4, 5},
                {6}
        };

        double[][] arr4 = {
                {7},
                {8, 9}
        };

        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println(Task1.min(arr1));

        System.out.println(Arrays.toString(Task1.minOfRow(arr1)));

        System.out.println(Arrays.toString(Task1.minOfCol(arr1)));

        double[][] added = Task1.add(arr1, arr2);
        System.out.println("Added arrays:");
        print2DArray(added);

        double[][] deleted = Task1.deleteRow(arr1, 0);
        System.out.println("After deleting:");
        print2DArray(deleted);

        double[][] appended = Task1.appendArray(arr3, arr4);
        System.out.println("Appended arrays:");
        print2DArray(appended);

        double[][] expanded = Task1.expendArray(arr3, arr4);
        System.out.println("Expanded arrays:");
        print2DArray(expanded);

        double[][] transposed = Task1.transposeMatrix(matrix);
        System.out.println("Transposed matrix:");
        print2DArray(transposed);
    }

    public static void print2DArray(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}
