package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setAge(age);
        setName(name);
        setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || !Character.isLetter(name.charAt(0))) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private void setGender(String gender) {
        if (gender.equals("Male") || gender.equals("Female")) {
            this.gender = gender;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public String produceSound(){
        return "";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        result.append(this.name).append(" ").append(this.age).append(" ").append(this.gender).append(System.lineSeparator());
        result.append(this.produceSound());
        return result.toString();
    }
}
