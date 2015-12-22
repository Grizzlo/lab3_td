/**
 * Created by grizzly on 23-Nov-15.
 */

import java.util.*;
import java.io.*;

public class lab3_td {
    private void pr(ArrayList<Container> con){
        System.out.println("Number of containers:"+con.size());
        for( int i = 0;  i < con.size(); i++) {
            Container con2;
            con2 = con.get(i);
            System.out.println("Num of con:"+(i+1));
            System.out.println("Goods:");
            for( int j = 0;  j < con2.goods.size(); j++){
                System.out.println(con2.goods.get(j));
            }
        }
    }
    private  void sort(ArrayList<Integer> numbers1){

        Collections.sort(numbers1);
        Collections.reverse(numbers1);
    }
    private  ArrayList<Container> nfa(ArrayList<Integer> numbers, boolean sort){

        ArrayList<Integer> Nfa = new ArrayList (numbers);
        ArrayList<Container> containers = new ArrayList<>();
        Container use_con = new Container();
        System.out.println(Nfa.size());

        if (sort == true) {
            sort(Nfa);
            System.out.println("Sorted.First element=" + Nfa.get(0));
        }
        //System.out.println(con.size());
        use_con.setGoods(Nfa.get(0));
        containers.add(use_con);
        for(int i = 1; i < Nfa.size();i++){
            int j = containers.size() - 1;
                use_con= new Container(containers.get(containers.size()-1));

                if ((Nfa.get(i) + use_con.size)> 100 )
                {
                    System.out.println("Goods Pushed in NEW con");
                    use_con=new Container();
                    use_con.setGoods(Nfa.get(i));
                    containers.add(use_con);
                }
                else
                {
                    System.out.println("Goods=" + Nfa.get(i));
                    System.out.println("Goods num="+(i+1));
                    System.out.println("Size=" + use_con.size);
                    System.out.println("Goods Pushed in con");
                    System.out.println("Number of con="+(1+j));
                    use_con.setGoods(Nfa.get(i));
                    containers.set(j, use_con);
                }
        }
        return  containers;
    }
    private  ArrayList<Container> ffa(ArrayList<Integer> numbers, boolean sort){
        ArrayList<Integer> Ffa = new ArrayList (numbers);
        ArrayList<Container> containers = new ArrayList<>();
        Container use_con = new Container();
        int itr=-1;
        int numbs=0;
        System.out.println(Ffa.size());
        if (sort == true) {
            sort(Ffa);
            System.out.println("Sorted.First element=" + Ffa.get(0));
        }
        //System.out.println(con.size());
        use_con.setGoods(Ffa.get(0));
        containers.add(use_con);
        for(int i = 1; i < Ffa.size();i++){
            int j = containers.size() - 1;
            use_con= new Container(containers.get(containers.size()-1));
            numbs++;
            if ((Ffa.get(i) + use_con.size)<= 100 )
            {
                System.out.println("Goods=" + Ffa.get(i));
                System.out.println("Goods num=" + (i + 1));
                System.out.println("Size=" + use_con.size);
                System.out.println("Goods Pushed in con");
                System.out.println("Number of con=" + (1 + j));
                use_con.setGoods(Ffa.get(i));
                containers.set(j, use_con);
                //break;
            }
            else {
                for (int k = 0; k < containers.size() - 1; k++) {
                    use_con = new Container(containers.get(k));
                    numbs++;
                    if ((Ffa.get(i) + use_con.size) <= 100) {
                        itr = k;
                        System.out.println("itr=" + itr);
                        break;
                    }

                }
                //}
                numbs++;
                if (itr != -1) {
                    System.out.println("Goods=" + Ffa.get(i));
                    System.out.println("Goods num=" + (i + 1));
                    System.out.println("Size=" + use_con.size);
                    System.out.println("Goods Pushed in con");
                    System.out.println("Number of con=" + (itr + 1));
                    use_con.setGoods(Ffa.get(i));
                    containers.set(itr, use_con);
                } else {
                    System.out.println("Goods Pushed in NEW con");
                    use_con = new Container();
                    use_con.setGoods(Ffa.get(i));
                    containers.add(use_con);
                }
                itr = -1;
            }
        }
        System.out.println("iteration= "+numbs);
        return  containers;
    }
    private  ArrayList<Container> wfa(ArrayList<Integer> numbers, boolean sort){
        ArrayList<Integer> Wfa = new ArrayList (numbers);
        ArrayList<Container> containers = new ArrayList<>();
        Container use_con = new Container();
        Container use_con2 = new Container();
        int itr=-1;
        int maxfr_size=-1;
        int numbs=0;
        numbs++;
        System.out.println(Wfa.size());
        if (sort == true) {
            sort(Wfa);
            System.out.println("Sorted.First element=" + Wfa.get(0));
        }
        //System.out.println(con.size());
        use_con.setGoods(Wfa.get(0));
        containers.add(use_con);
        for(int i = 1; i < Wfa.size();i++) {
            int j = containers.size() - 1;
            use_con = new Container(containers.get(containers.size() - 1));
            numbs++;
            if ((Wfa.get(i) + use_con.size) <= 100) {
                System.out.println("Goods=" + Wfa.get(i));
                System.out.println("Goods num=" + (i + 1));
                System.out.println("Size=" + use_con.size);
                System.out.println("Goods Pushed in con");
                System.out.println("Number of con=" + (1 + j));
                use_con.setGoods(Wfa.get(i));
                containers.set(j, use_con);
                //break;
            } else {
                numbs++;
                if (containers.size() >= 2) {
                    System.out.println(containers.size());
                    use_con = new Container(containers.get(0));
                    for (int l = 1; l < containers.size(); l++) {
                        use_con2 = new Container(containers.get(l));
                        numbs++;
                        if (use_con.size >= use_con2.size) {
                            use_con = new Container(use_con2);
                            maxfr_size = l;
                        }
                    }
                    numbs++;
                    if (use_con.size == containers.get(0).size) {
                        maxfr_size = 0;
                    }
                    System.out.println("max=" + (maxfr_size + 1));
                    use_con = new Container(containers.get(maxfr_size));
                    numbs++;
                    if ((Wfa.get(i) + use_con.size) <= 100) {
                        System.out.println("Goods=" + Wfa.get(i));
                        System.out.println("Goods num=" + (i + 1));
                        System.out.println("Size=" + use_con.size);
                        System.out.println("Goods Pushed in con");
                        System.out.println("Number of con=" + (maxfr_size + 1));
                        use_con.setGoods(Wfa.get(i));
                        containers.set(maxfr_size, use_con);
                    } else {
                        System.out.println("Goods Pushed in NEW con");
                        use_con = new Container();
                        use_con.setGoods(Wfa.get(i));
                        containers.add(use_con);
                    }
                } else {
                    System.out.println("Goods Pushed in NEW con");
                    use_con = new Container();
                    use_con.setGoods(Wfa.get(i));
                    containers.add(use_con);
                }
            }
        }
        System.out.println("iteration= "+numbs);
        return  containers;
    }
    private  ArrayList<Container> bfa(ArrayList<Integer> numbers, boolean sort){
        ArrayList<Integer> Bfa = new ArrayList (numbers);
        ArrayList<Container> containers = new ArrayList<>();
        Container use_con = new Container();
        Container use_con2 = new Container();
        //int itr=-1;
        int maxfr_size=-1;
        int numbs=0;
        System.out.println(Bfa.size());
        if (sort == true) {
            sort(Bfa);
            System.out.println("Sorted.First element=" + Bfa.get(0));
        }
        //System.out.println(con.size());
        use_con.setGoods(Bfa.get(0));
        containers.add(use_con);
        for(int i = 1; i < Bfa.size();i++) {
            // System.out.println("iter=" + maxfr_size);
            int j = containers.size() - 1;
            use_con = new Container(containers.get(containers.size() - 1));
            numbs++;
            if ((Bfa.get(i) + use_con.size) <= 100) {
                System.out.println("Goods=" + Bfa.get(i));
                System.out.println("Goods num=" + (i + 1));
                System.out.println("Size=" + use_con.size);
                System.out.println("Goods Pushed in con");
                System.out.println("Number of con=" + (1 + j));
                use_con.setGoods(Bfa.get(i));
                containers.set(j, use_con);
                //break;
            } else {
                numbs++;
                if (containers.size() >= 2) {
                    System.out.println(containers.size());
                    use_con = new Container(containers.get(0));
                    System.out.println("Use_con=" + (use_con.size));
                    for (int k = 1; k < containers.size(); k++) {
                        use_con2 = new Container(containers.get(k));
                        //System.out.println("Use_con[k]=" + (use_con2.size));
                        //System.out.println("min=" + (use_con.size));
                        numbs++;
                        if ((use_con.size > use_con2.size)) {
                            //use_con = new Container(use_con2);
                            // maxfr_size=k;
                            numbs++;
                            if ((Bfa.get(i) + use_con.size) > 100) {
                                numbs++;
                                if ((Bfa.get(i) + use_con2.size) <= 100) {
                                    maxfr_size = k;
                                    use_con = new Container(use_con2);
                                    //System.out.println("min_a=" + (maxfr_size + 1));
                                }
                            }
                        } else {
                            numbs++;
                            if ((Bfa.get(i) + use_con2.size) <= 100) {
                                maxfr_size = k;
                                use_con = new Container(use_con2);
                                //System.out.println("min_bbbbbbb=" + (maxfr_size + 1));
                            }
                        }
                        //System.out.println("min=" + (use_con.size));
                    }
                    numbs++;
                    if (maxfr_size != -1) {
                        use_con = new Container(containers.get(maxfr_size));
                        System.out.println("Goods=" + Bfa.get(i));
                        System.out.println("Goods num=" + (i + 1));
                        System.out.println("Size=" + use_con.size);
                        System.out.println("Goods Pushed in con");
                        System.out.println("Number of con=" + (maxfr_size + 1));
                        use_con.setGoods(Bfa.get(i));
                        containers.set(maxfr_size, use_con);
                    } else {
                        System.out.println("Goods Pushed in NEW con:");
                        use_con = new Container();
                        use_con.setGoods(Bfa.get(i));
                        containers.add(use_con);
                    }
                } else {
                    System.out.println("Goods Pushed in NEW con");
                    use_con = new Container();
                    use_con.setGoods(Bfa.get(i));
                    containers.add(use_con);
                }
            }
            maxfr_size=-1;
        }
        System.out.println("iteration= " + numbs);
        return  containers;
    }
        lab3_td() {
            for(int j=0;j<4;j++){
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            try {
                Scanner sc = new Scanner(new File("D:\\projects\\lab3_td\\data\\numbers"+j+".txt"));
                while (sc.hasNextInt()) {
                    numbers.add(sc.nextInt());
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            ArrayList<Container> cont = new ArrayList<Container>();
            cont = nfa(numbers, false);
            ArrayList<Container> cont1 = new ArrayList<Container>();
            cont1 = ffa(numbers, false);
            ArrayList<Container> cont2 = new ArrayList<Container>();
            cont2 = wfa(numbers, false);
            ArrayList<Container> cont3 = new ArrayList<Container>();
            cont3 = bfa(numbers, false);
            pr(cont);
            pr(cont1);
            pr(cont2);
            pr(cont3);
        }
    }
}
