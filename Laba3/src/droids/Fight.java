package droids;


import java.util.Random;

public class Fight {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static int roundCount;

    public static int getRandom(int MaxValue){
        Random random = new Random();
        return random.nextInt(MaxValue);
    }



    public static void startFightOnetoOne(Droid1 attacker, Droid1 defender) // Атакуючий дроїд атакує дроїда, який захищається
    {
        if(attacker == null || defender == null)
            return;
        if(!attacker.isAlive() || !defender.isAlive())
            return;
        int damageFromA = getRandom((int) attacker.getDamage());// визначаємо дамаг атакуючого дроїда

        if (defender.getShield() > 0) { //якщо щит є у дефендера і дамаг менший за щит, то віднімаємо від хп щита кі-сть дамагу
            if (damageFromA <= defender.getShield())
                defender.setShield(defender.getShield() - damageFromA);
            else
            {
                damageFromA = damageFromA - defender.getShield(); //якшо дамаг більший за щит, то щит нейтралізується
                defender.setShield(0); //щита вже нема
            }
        }
        if (defender.getShield() == 0) {
            defender.setHealth(defender.getHealth() - damageFromA); //якщо щита вже нема наступний дамаг забиратиме хпшку
            if (defender.getHealth() < 0) {
                defender.setHealth(0); //шоб не було від'ємного здоров'я, дроїд мертий, шкода його:(

            }
        }

        attacker.isCanFight = false; //побився і вистачить
        System.out.print(attacker.name  + " attack "
                + defender.name
                + ", after attack ") ;
        defender.showShieldAndHealthInfo(); //стан здоров'я після сутички
        System.out.println();
    }

    public static void startFight(Team t1, Team t2){
        roundCount = 0;
        while(true){
            roundCount++;
            System.out.println("Раунд: " + String.valueOf(roundCount));
            startFightTeamRound(t1, t2);
            if (!t1.isAlive())
            {
                System.out.println(ANSI_RED + "Команда " + t1.Name + " програла" + ANSI_RESET);
                return;
            }
            if (!t2.isAlive())
            {
                System.out.println(ANSI_BLUE + "Команда " + t2.Name + " програла" + ANSI_RESET);
                return;
            }
        }
    }

    public static void startFightTeamRound(Team t1, Team t2){
        t1.prepareToBattleRound();
        t2.prepareToBattleRound();

        Droid1 RedAttack, RedDef;
        Droid1 BlueAttack, BlueDef;
        while(true)
        {
            // б'є дроїд червоної команди живого дроїда з синьої
            RedAttack = t1.GetDroidReadyToAttack();  //шукаємо живого дроїда з червоної команди, який шукає дроїда з синьої команди,
            //шоб по ньому вдарити
            if(RedAttack != null && RedAttack.type == "Protector" && ((Droid3)RedAttack).getAura() > 0)
            {
                Droid1 pacient = t1.GetDroidReadyToAura(RedAttack);
                if (pacient!= null) {
                    ((Droid3) RedAttack).setAura(pacient);
                    System.out.println(ANSI_RED + RedAttack.name + " set Aura to " + pacient.name + ANSI_RESET);
                    RedAttack = null;   //робимо нул, шоб він не міг битися, коли полікує
                }
            }
            BlueDef = t2.GetDroidReadyToDefence(); //шукаємо живого дроїда з синьої команди, по якому може вдарити дроїд з червоної команди
            startFightOnetoOne(RedAttack, BlueDef);



            // б'є дроїд синьої команди по живому дроїду з червоної
            BlueAttack = t2.GetDroidReadyToAttack(); //шукаємо живого дроїда з синьої команди, який шукає дроїда з червоної  команди,
            //шоб по ньому вдарити

            if(BlueAttack != null && BlueAttack.type == "Protector" && ((Droid3)BlueAttack).getAura() > 0)
            {
                Droid1 pacient = t2.GetDroidReadyToAura(BlueAttack);
                if (pacient!= null) {
                    ((Droid3) BlueAttack).setAura(pacient);
                    System.out.println(ANSI_BLUE + BlueAttack.name + " set Aura to " + pacient.name + ANSI_RESET);
                    BlueAttack = null;   //робимо нул, шоб він не міг битися, коли полікує
                }
            }
            RedDef = t1.GetDroidReadyToDefence(); //шукаємо живого дроїда з червоної команди, по якому може вдарити дроїд з синьої команди
            startFightOnetoOne(BlueAttack, RedDef);

            if (RedAttack == null || BlueAttack == null)
                return;

        }


    }
}