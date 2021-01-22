package droids;

public class Droid3 extends Droid1{


    public int aura = 100;
    public Droid3(){
        healthStart = 50;
        setHealth(healthStart);
        shieldStart = 5;
        setShield(shieldStart);
        damage = 5;
        type = "Droid3";
    }
    public void setAura(Droid1 droid)
    {
        int auraSet = 5;
        if(aura >= auraSet) {
            droid.setHealth(droid.getHealth() + auraSet);
            aura -= auraSet;
        }
    }

    public int getAura(){
        return aura;
    }



    @Override
    public void showInfo(){
        super.showInfo();
        System.out.print("; aura: " + aura);

    }
}