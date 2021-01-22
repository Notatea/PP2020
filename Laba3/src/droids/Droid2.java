package droids;

public class Droid2 extends Droid1 {

        public Droid2() {

            healthStart = 80;
            setHealth(healthStart);
            shieldStart = 20;
            setShield(shieldStart);

            damage = 15;
            type = "Droid2";
        }
}
