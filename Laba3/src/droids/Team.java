package droids;

import java.util.ArrayList;
import java.util.Scanner;

    public class Team {
        public ArrayList<Droid1> DroidsList;
        public String Name;
        public Team(String name){
            Name = name;
            DroidsList = new ArrayList<Droid1>();
        }

        public boolean isAlive(){
            for(int i = 0; i < DroidsList.size(); i++)
            {
                if(DroidsList.get(i).isAlive())
                    return true;
            }

            return false;

        }

        public Droid1 GetDroidReadyToAura(Droid1 pro)
        {
            Droid1 d = null;
            for(int i = 0; i < DroidsList.size(); i++)
            {
                d = DroidsList.get(i);
                if (d!= pro && d.isAlive() && d.getHealth() < d.getStartHealth())
                    return d;
            }
            return null;
        }

        public Droid1 GetDroidReadyToAttack()
        {
            Droid1 d = null;
            for(int i = 0; i < DroidsList.size(); i++)
            {
                d = DroidsList.get(i);
                if (d.isAlive() && d.isCanFight)
                    return d;
            }
            return null;
        }

        public Droid1 GetDroidReadyToDefence()
        {
            Droid1 d = null;
            for(int i = 0; i < DroidsList.size(); i++)
            {
                d = DroidsList.get(i);
                if (d.isAlive())
                    return d;
            }
            return null;
        }


        public void prepareToBattleRound(){
            for(int i = 0; i < DroidsList.size(); i++)
            {
                DroidsList.get(i).isCanFight = DroidsList.get(i).getHealth() > 0;
            }

        }

        public void addDroid(Droid1 droid){

            DroidsList.add(droid);
        }

        public void addDroid(){
            Droid1 droid = createDroid();
            DroidsList.add(droid);
        }

        public void showInfo(){
            System.out.println(Name + ":");
            for(int i = 0; i < DroidsList.size(); i++)
            {
                System.out.print(String.valueOf(i+1) + ". ");
                DroidsList.get(i).showInfo();
                System.out.println();
            }
        }

        public  Droid1 createDroid()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Виберіть тип дроіда , що додається в команду: 1 - Chubaka ; 2 - Sith; 3 - Protector;");
            int i = scanner.nextInt();
            Droid1 droid = null;

            switch(i)
            {
                case 1:
                    droid = new Droid2();

                    break;
                case 2:
                    droid = new Droid4();
                    break;
                case 3:
                    droid = new Droid3();

            }
            droid.setName(Name.substring(0,1) + "_" + droid.type.substring(0,3) + String.valueOf(DroidsList.size() + 1));

            return droid;
        }


    }

