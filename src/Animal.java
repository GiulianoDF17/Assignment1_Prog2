import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Animal {

    private String name;
    private String gender;
    private int age;
    private String type;

    public static final ArrayList<String> TYPES = new ArrayList<>(Arrays.asList("Cat", "Dog", "Monkey"));

    public Animal(){
        this.name = "";
        this.gender = "";
        this.age = 0;
        this.type = "";
    }

    public Animal(String name, String gender, int age, String type){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.type = type;
    }

    public Animal(Animal other){
        this.name = other.name;
        this.gender = other.gender;
        this.age = other.age;
        this.type = other.type;
    }

    public boolean isTypeValid(String type){
        for(int i = 0; i < TYPES.size(); i++){
            if(TYPES.get(i).equals(type)){
                return true;
            }
        }
        return false;
    }

    public String getName(){
        return name;
    }

    public String getGender(){
        return gender;
    }

    public int getAge(){
        return age;
    }

    public String getType(){
        return type;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setType(String type){
        if(isTypeValid(type)){
            this.type = type;
        } else {
            System.out.println("Invalid Animal type.");
        }
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Animal)) return false;

        Animal other = (Animal) obj; //creating other as animal -> saying that obj is Animal downcasting

        return age == other.age &&
                Objects.equals(name, other.name) &&
                Objects.equals(gender, other.gender) &&
                Objects.equals(type, other.type);
    }

    @Override
    public String toString(){
        return "Name   : " + name + "\n" +
               "Gender : " + gender + "\n" +
               "Age    : " + age + "\n" +
               "Type   : " + type;
    }

}
