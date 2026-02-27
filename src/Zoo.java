import java.util.ArrayList;

public class Zoo {

    private ArrayList<Animal> animals;

    public Zoo(){
        animals = new ArrayList<>();
    }

    public Zoo(ArrayList<Animal> animals){
        this.animals = new ArrayList<>(animals);
    }

    public Zoo(Zoo other){
        this.animals = new ArrayList<>();
        for(int i = 0; i < other.animals.size(); i++){
            this.animals.add(new Animal(other.animals.get(i)));
        }
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals){
        this.animals = animals;
    }

    public int countAnimals(String type){
        int count = 0;

        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getType().equals(type)){
                count++;
            }
        }
        return count;
    }

    public void updateValidTypes(){
        for(int i = 0; i < Animal.TYPES.size(); i++){

            String type = Animal.TYPES.get(i);
            boolean exists = false;

            for(int j  = 0; j < animals.size(); j++){
                if(animals.get(j).getType().equals(type)){
                    exists = true;
                }
            }

            if(!exists){
                Animal.TYPES.remove(i);
                i--;
            }
        }
    }

    public boolean isGenderBalanced(String type){

        int males = 0;
        int females = 0;

        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getType().equals(type)){
                if(animals.get(i).getGender().equalsIgnoreCase("Male"))
                    males++;
                else if(animals.get(i).getGender().equalsIgnoreCase("Female"))
                    females++;
            }
        }

        int total  = males + females;

        if(total == 0)
            return false;

        int difference = Math.abs(males-females);

        return difference < 0.2 * total;
    }


}
