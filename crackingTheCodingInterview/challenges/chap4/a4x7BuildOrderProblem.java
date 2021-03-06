package chap4;

import java.util.ArrayList;
import java.util.HashSet;

public class a4x7BuildOrderProblem {

    public ArrayList buildOrder(ArrayList<ArrayList> dependencies, ArrayList project){

        HashSet currentDependencies = new HashSet();
        ArrayList path = new ArrayList();
        HashSet pathSet = new HashSet();

        fillAllInitialDependencies(currentDependencies, dependencies,project, path,pathSet);
        HashSet nextDependencies = new HashSet();
        while(!currentDependencies.isEmpty()){
            nextDependencies = new HashSet();
            for(int i = 0 ; i<dependencies.size(); i++){
                if(currentDependencies.contains(dependencies.get(i).get(0)) && !pathSet.contains(dependencies.get(i).get(1))){
                    nextDependencies.add(dependencies.get(i).get(1));
                    path.add(dependencies.get(i).get(1));
                    pathSet.add(dependencies.get(i).get(1));
                }
            }
            currentDependencies = nextDependencies;
        }

        return path;
    }

    /**
     * this is going to find the dependencies that we can start working on without
     * worrying about other dependencies
     *
     */
    public void fillAllInitialDependencies(HashSet currentDependencies, ArrayList<ArrayList> dependencies, ArrayList project, ArrayList path, HashSet pathset){
        HashSet dependentDependenciesSet = new HashSet();
        for(int i = 0 ; i<dependencies.size() ; i++){
            dependentDependenciesSet.add(dependencies.get(i).get(1));
        }
        for(int i = 0 ; i<project.size(); i++){
            if(!dependentDependenciesSet.contains(project.get(i))){
                currentDependencies.add(project.get(i));
                path.add(project.get(i));
                pathset.add(project.get(i));
            }
        }
    }


}
