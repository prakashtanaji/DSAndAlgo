import java.util.Scanner;
import java.util.Stack;
import java.util.Iterator;

class towerofhanaoi {

    static Stack<Integer> tower1 = new Stack<>();
    static Stack<Integer> tower2 = new Stack<>();
    static Stack<Integer> tower3 = new Stack<>();

    public static void main(String[] args) 
    {
        System.out.println("Tower of Hanoi");

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter number of discs:");
        int iDiscs = 3;
        System.out.println("Entered discs:" + iDiscs);

        scn.close();

        for(int i=iDiscs; i>0; i--) {
            tower1.push(i);
        }

        printTower(1);
        printTower(2);
        printTower(3);

        hanoiIt(iDiscs, 1,3,2);

        printTower(1);
        printTower(2);
        printTower(3);
    }

    static void hanoiIt(int iDiscs, int src,int dest,int temp) {
        int loops = (int)(Math.pow(2, iDiscs) - 1);

        for(int i = 0; i< loops; i++) {

            if(i%3 == 0) {
                int idisc = getTower(src).peek();

                getTower(dest).push(getTower(src).pop());
            }
            else if(i%3 == 1) {
                getTower(temp).push(getTower(src).pop());
            }
            else {
                getTower(temp).push(getTower(dest).pop());
            }
        }
    }

    static Stack<Integer> getTower(int towerId) {

        switch(towerId) {
            case 1: return tower1;
            case 2: return tower2;
            default: return tower3;
        }

    }
    static void printTower(int towerId) {
        Stack<Integer> tower = null;
        
        tower = getTower(towerId);

        Iterator it = tower.iterator();
        
        System.out.println("Printing Tower: "+ towerId);

        if(tower.size() > 0){
            printTowerRecursive(it);
        }
        else {
            System.out.println("\t No items to print");
        }
    }
    static void printTowerRecursive(Iterator it) {
        int iCurr = (int)it.next();
        if(it.hasNext()) {
            printTowerRecursive(it);   
        }
        System.out.println("\t" +  iCurr);
    }
    static void hanoi(int noOfDiscs, int sourceTower, int targetTower, int tempTower) {

        if (noOfDiscs == 1) {
            getTower(targetTower).push(getTower(sourceTower).pop());

            return;
        }
        
        hanoi(noOfDiscs-1, sourceTower, tempTower, targetTower);
        hanoi(1, sourceTower, targetTower, tempTower);
        hanoi(noOfDiscs-1, tempTower, targetTower, sourceTower);
    }
}