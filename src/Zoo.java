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

    }


}
