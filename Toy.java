public class Toy {
    public int id;
    public String name;
    public int amount;
    public int weight;

    public Toy(int id, String name, int amount, int weight) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.weight = weight;
    }

    public String getInfo() {
        return "id:" + id + " " + name;
    }
}
