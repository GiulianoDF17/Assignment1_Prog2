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

    public void removeOldest(String type){
        if(!Animal.TYPES.contains(type)){
            return;
        }

        int maxAge = -1;

        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getType().equals(type)){
                if(animals.get(i).getAge() > maxAge){
                    maxAge = animals.get(i).getAge();
                }
            }
        }

        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getType().equals(type) && animals.get(i).getAge() == maxAge){

                animals.remove(i);
                i--;
            }
        }

        updateValidTypes();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Zoo)) return false;

        Zoo other = (Zoo) obj;

        if (animals.size() != other.animals.size())
            return false;

        for (int i = 0; i < animals.size(); i++) {
            if (!animals.get(i).equals(other.animals.get(i)))
                return false;
        }

        return true;
    }

    @Override
    public String toString() {

        String result = "";

        int total = animals.size();
        int totalMales = 0;
        int totalFemales = 0;

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getGender().equalsIgnoreCase("Male"))
                totalMales++;
            else if (animals.get(i).getGender().equalsIgnoreCase("Female"))
                totalFemales++;
        }

        result += "Total Number of Animals: " + total + "\n";
        result += "Male: " + totalMales + "\n";
        result += "Female: " + totalFemales + "\n\n";

        for (int i = 0; i < Animal.TYPES.size(); i++) {

            String type = Animal.TYPES.get(i);

            int count = 0;
            int males = 0;
            int females = 0;
            int oldest = -1;

            for (int j = 0; j < animals.size(); j++) {

                Animal a = animals.get(j);

                if (a.getType().equals(type)) {

                    count++;

                    if (a.getGender().equalsIgnoreCase("Male"))
                        males++;
                    else if (a.getGender().equalsIgnoreCase("Female"))
                        females++;

                    if (a.getAge() > oldest)
                        oldest = a.getAge();
                }
            }

            if (count > 0) {

                result += type + ":\n";
                result += "    Number    : " + count + "\n";
                result += "    Female    : " + females + "\n";
                result += "    Male      : " + males + "\n";
                result += "    Balanced  : "
                        + (isGenderBalanced(type) ? "Yes" : "No") + "\n";
                result += "    Oldest age: " + oldest + "\n";
            }
        }

        return result;
    }




}
