package droids;

public class Droid1 {


    protected int healthStart;
    protected int shieldStart;



    protected String name;
    protected int health;
    protected int shield;
    protected int damage;

    public  boolean isCanFight;

    protected String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartHealth() {
        return healthStart;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {

        if (health > healthStart)
            this.health = healthStart;
        else
            this.health = health;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {

        if (this.shield > shieldStart)
            this.shield = shieldStart;
        else
            this.shield = shield;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



    public void showInfo(){
        System.out.print(name + "; hl:" + health + "; st:" + "; sh:" + shield + "; dm:" + damage);

    }

    public void showShieldAndHealthInfo(){
        System.out.print(name + "; hl:" + health + "/" + healthStart + "; sh:" + shield + "/" + shieldStart);

    }

    public boolean isAlive() {

        if (getHealth() <= 0)
            return false;
        return true;
    }
}