package chicken;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double egs = 0;
        if (this.getAge() >= 0 && this.getAge() <= 5) {
            egs = 2;
        } else if (this.getAge() > 5 && this.getAge() < 12) {
            egs = 1;
        } else {
            egs = 0.75;
        }
        return egs;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.getName(),
                this.getAge(),
                this.productPerDay()
        );
    }
}
