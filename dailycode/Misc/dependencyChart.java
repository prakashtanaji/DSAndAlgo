import java.util;
import java.lang.String;

class Solution {
        public static void main(String[] args) {

        //read input from stdin
        Scanner scan = new Scanner(System.in);

        while (true) {
            String line = scan.nextLine();

            //no action for empty input
            if (line == null || line.length() == 0) {
                continue;
            }

            //the END command to stop the program
            if ("END".equals(line)) {
                System.out.println("END");
                break;
            }

            //Please provide your implementation here
            
        }

    }

}

class ComponentDependency {
    public List<String> dependsOn = new ArrayList<>();
    public List<String>  dependedBy = new ArrayList<>()
}

class ComponentGraph {

    private static final String INCORRECT_COMMAND = "Incorret command";
    Map<String, ComponentDependency> dependencyGraph = new TreeMap<>();
    List<String> installedComponents = new SortedList<>();

    private String[] splitCommand(String cmd) {
        return cmd.split(" ");
    }

    private void printCommand(String cmd) {
        return cmd;
    }

    public List<String> executeDEPEND(String cmd) {
        List<String> result = new ArrayList<>();

        String[] comps = splitCommand(cmd);

        if(comps.length<2) return INCORRECT_COMMAND;

        if(!dependencyGraph.contains(comps[1])) {
            result.add("    Checking for lower components to add");
            dependencyGraph.add(comps[1], new ComponentDependency());
        }
        else {
            result.add("    Component " + comps[1] " already exists, checking for lower components to add");
        }

        // check if the depending on components list is provided other return;
        if(comps.length==2) {
            result.add("    No more lower components to add");
            return result;
        }

        ComponentDependency cd = dependencyGraph.get(comps[1]);
        ComponentDependency cd = dependencyGraph.get(comps[1]);
        List<String> dependsOnList = cd.dependsOn;
        //List<String> dependedByList = cd.dependedBy;

        for(int i=2; i<comps.length; i++) {
            dependsOnList.contains(comps[i]) {
                result.add("    " + comps[1] + " already depends on " + comps[i]);
            }
            else {
                // In complex systems might to need to handle synchronization here to avoid adding 
                // only one way of dependency, in case of any system failure.
                dependsOnList.add(comps[i])
                // add new dependency upwards from the lower component
                addDependency(comps[1], comps[i]);
                result.add("    Added "+ comps[1] + " dependency on " + comps[i]);
            }

        }
    }

    private void addDependency(String upperComp, String lowerComponent) {
        ComponentDependency compDep = new ComponentDependency();
        compDep.dependedByList.add(upperComp);
        dependencyGraph.add(lowerComponent, compDep);
    }

    public List<String> executeLIST() {
        return installedComponents;
    }

    public List<String> executeINSTALL(String cmd) {
        List<String> result = new ArrayList<>();

        String[] comps = splitCommand(cmd);
        if(installedComponents.contains(comps[1]))
        {
            result.add("Already installed " + comps[1]);
            return result;
        }
        else {
            // first verify if the dependency exist, if not create it
            if(!dependencyGraph.contains(comps[1])) {
                result.add(executeDEPEND("DEPEND " + comps[1]);
            }

            installComp(comps[1]), result);
        }

        return result;

    }

    private void installComp(String upperComp, List<String> result) {

        ComponentDependency compDep = dependencyGraph.get(upperComp);
        for(String comp: compDep.dependsOn) {
            installComp(comp, result);
        }

        // install the upper component last after all lower/child components are installed
        installedComponents.add(upperComp);
        result.add("    Installed component "+ comp);
    }

    public List<String> executeREMOVE(String cmd) {
        List<String> result = new ArrayList<>();

        String[] comps = splitCommand(cmd);
        if(installedComponents.contains(comps[1]))
        {
            // May also check if the dependency exist at all and print message accordingly
            result.add("    Not installed " + comps[1]);
            return result;
        }
        else {
            // first verify if the upper dependency exist, the only remove it

            removeComp(comps[1]), result);
        }

        return result;
    }

    private void removeComp(String compToRemove, List<String> result) {

        ComponentDependency compDep = dependencyGraph.get(upperComp);
        // the component can only be removed in there is no parent component using it(installed)
        boolean isParentUsing = false;
        for(String comp: compDep.dependedByList) {
            if(installedComponents.contains(comp)) {
                isParentUsing = true;
                break;
            }
        }

        if(isParentUsing == true) {
            result.add("    Cannot remove "+compToRemove+ " as its being depended on by other installed component");
            return result;
        }

        // If we here means components can be removed
        installedComponents.remove(compToRemove);
        result.add("    Removed "+compToRemove);

        // recurse for other child components to try reove them if they have no other dependency
        ComponentDependency compDep = dependencyGraph.get(upperComp);
        for(String comp: compDep.dependsOn) {
            removeComp(comp, result);
        }
        return result;
    }
}

amazo=n fex like uber

last mile
ag logistics border fulfillment


[ERROR] /run-pzrFStkBQiEDH1mUJqwd/Solution/src/test/java/com/salesforce/tests/dependency/YourUnitTest.java:[9,29] illegal start of type
[ERROR] /run-pzrFStkBQiEDH1mUJqwd/Solution/src/test/java/com/salesforce/tests/dependency/YourUnitTest.java:[9,36] ';' expected
[ERROR] /run-pzrFStkBQiEDH1mUJqwd/Solution/src/test/java/com/salesforce/tests/dependency/YourUnitTest.java:[11,33] ';' expected
[ERROR] /run-pzrFStkBQiEDH1mUJqwd/Solution/src/test/java/com/salesforce/tests/dependency/YourUnitTest.java:[11,43] not a statement
[ERROR] /run-pzrFStkBQiEDH1mUJqwd/Solution/src/test/java/com/salesforce/tests/dependency/YourUnitTest.java:[11,54] ';' expected
[ERROR] /run-pzrFStkBQiEDH1mUJqwd/Solution/src/test/java/com/salesforce/tests/dependency/YourUnitTest.java:[20,2] reached end of file while parsing