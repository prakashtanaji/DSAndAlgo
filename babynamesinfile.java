import java.util.Scanner;
import java.io.*;
import java.util.*;

class babynamesinfile {

    public static void main(String[] args) 
    {
        System.out.println("BabyNames");

        Graph graph = new Graph();

        readSynIntoGraph(graph);

        getCountOnMainSyn(graph);
    }

    static void getCountOnMainSyn(Graph graph) {
        HashMap<String, Integer> result = new HashMap<>();
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(new File("babynamecounts.txt")));

            String str = null;
            while((str = br.readLine())!=null) {
                String[] maps = str.split(" ");
                int count = Integer.parseInt(maps[1]);

                String strMain = strMainSyn(result, graph, maps[0], new HashSet<String>());

                if(strMain == null) {
                    strMain = maps[0];
                }
        
                result.put(strMain, count + result.getOrDefault(strMain, 0));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();

        }
        finally {
            //
        }

        System.out.println("The MainName and their count:");
        Set<Map.Entry<String, Integer>> st = result.entrySet();
        Iterator it = st.iterator();
        while(it.hasNext()) {
            Map.Entry<String,Integer> en = (Map.Entry<String, Integer>)it.next();

            System.out.println(en.getKey() + ":"+ en.getValue());
        }
    }

    static String strMainSyn(HashMap<String, Integer> result, Graph g, String str, Set<String> visited) {

        if(result.containsKey(str)) return str;

        visited.add(str);

        ArrayList<String> arList = g.names.get(str);

        String strRes = null;
        for(String s: arList) {
            if(!visited.contains(s)) {
                strRes = strMainSyn(result, g, s, visited);

                if(strRes!=null){break;}
            }
        }

        return strRes;


    }

    static void addEdge(Graph g, String left, String right) {
        if (g.names.containsKey(left)) {
            // add right if not exists
            ArrayList<String> strList = g.names.get(left);
            if (!strList.contains(right)) {
                strList.add(right);
            }
        }
        else {
            ArrayList<String> lst = new ArrayList<>();
            lst.add(right);
            g.names.put(left, lst);
        }
    }

    static void readSynIntoGraph(Graph g) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("babysyn.txt")));

            String str;
            while ((str=br.readLine())!=null) {
                String[] strArray = str.split(" ");
                // skip if -
                // if(strArray[0] == "-") continue;

                System.out.print("Name: "+ strArray[0]);
                System.out.println(" Syn:" + strArray[1]);

                addEdge(g, strArray[0], strArray[1]);
                addEdge(g, strArray[1], strArray[0]);
            
            }
        }
        catch(Exception ex) {
            System.out.print("stacktrace:");
            ex.printStackTrace();
        }
        finally {
            //if(br != null) br.close();
        }

        g.print();

    }
}

class Graph {
    //int vSize;
    HashMap<String, ArrayList<String>> names = new HashMap<>();

    public Graph() {
        //vSize = size;
    }

    public void print() {

        Set<Map.Entry<String,ArrayList<String>>> st =  names.entrySet();

        Iterator it = st.iterator();

        while(it.hasNext()) {
            Map.Entry<String, ArrayList<String>> en = (Map.Entry<String,ArrayList<String>>)it.next();

            System.out.print(" entry:" + (String)en.getKey());
            ArrayList<String> arr = (ArrayList<String>)en.getValue();
            for(String str: arr) {
                System.out.print(":" + str);
            }

            System.out.println();
        }
    }
}
