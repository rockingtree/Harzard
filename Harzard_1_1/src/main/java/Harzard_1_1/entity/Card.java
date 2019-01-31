package Harzard_1_1.entity;

public class Card {
    int id;
    String name;
    String type;
    int cost;
    String description;
    int attack;
    int defence;
    int totalDefence;
    int statement;
    String comment;
    Player owner;
    Player controller;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getStatement() {
        return statement;
    }

    public void setStatement(int statement) {
        this.statement = statement;
    }

    public Card() {
        id = 100;
        name = "戴安娜";
        type = "随从";
        cost = 0;
        description = "";
        attack = 99;
        defence = 99;
        statement = 1;
        comment = "宛如蔷薇";
    }

    void showCreatureInfo() {
        System.out.println();
        System.out.println("\t\t" + cost);
        System.out.println("<" + name + ">");
        System.out.println(description);
        System.out.println(attack + "\t\t" + defence);
    }
}
