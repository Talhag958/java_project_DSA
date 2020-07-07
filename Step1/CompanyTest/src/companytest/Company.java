package companytest;

import java.util.Collections;
import java.util.LinkedList;

class Project {

    int projectId;
    String projectName;
    int budget;

    public Project(int id, String name, int b) {
        this.projectId = id;
        this.projectName = name;
        this.budget = b;
    }

    void setId(int d) {
        this.projectId = d;
    }

    int getId() {
        return this.projectId;
    }

    void setName(String s) {
        this.projectName = s;
    }

    String getName() {
        return this.projectName;
    }

    void setBudget(int d) {
        this.budget = d;
    }

    int getBudget() {
        return this.budget;
    }

}

public class Company {

    LinkedList<Project> projectLinkList;
    Project project;
    int projectCount;
    helpingfunctions hf;

    Company() {
        projectLinkList = new LinkedList<>();
        projectCount = 0;
        hf = new helpingfunctions();
    }

    public void addProject() {
        System.out.print("Enter project Id:");
        int id = hf.getIntegerInput();
        for (int i = 0; i < projectLinkList.size(); i++) {
            if (id == projectLinkList.get(i).getId()) {
                System.out.println("System already exists with that id");
                hf.Pause();
                this.addProject();
            }
        }
        System.out.print("Enter Project Name: ");
        String name = hf.getStringInput();
        System.out.print("Enter Project Budget: ");
        int budget = hf.getIntegerInput();
        project = new Project(id, name, budget);
        projectLinkList.add(projectCount, project);
        projectCount++;
        System.out.println("\nProject added");
        hf.Pause();
    }

    public void findAndDisplay() {
        System.out.print("Enter project ID:");
        int id = hf.getIntegerInput();
        for (int i = 0; i < projectLinkList.size(); i++) {
            if (id == projectLinkList.get(i).getId()) {
                System.out.print("Project Id: ");
                System.out.println(project.getId());
                System.out.print("Project Name: ");
                System.out.println(project.getName());
                System.out.print("Project Budget: ");
                System.out.println(project.getBudget());
                hf.Pause();
                return;
            }
        }
        System.out.println("No project found for that id");
        hf.Pause();
    }

    public void removeProject() {
        System.out.print("Enter project ID:");
        int id = hf.getIntegerInput();
        for (int i = 0; i < projectLinkList.size(); i++) {
            if (id == projectLinkList.get(i).getId()) {
                projectLinkList.remove(projectLinkList.get(i));
                System.out.println("Removing th project");
                System.out.println("Project removed....");
                projectCount--;
                hf.Pause();
                return;
            }
        }
        System.out.println("No project found for that id");
        hf.Pause();

    }

    public void displayAll() {
        if (projectLinkList.size() <= 0) {
            System.out.println("*****No record found");
            hf.Pause();
            return;
        }
        LinkedList<String> names = new LinkedList<>();
        LinkedList<Project> displayAll = new LinkedList<>();

        for (int i = 0; i < projectLinkList.size(); i++) {
            names.add(projectLinkList.get(i).projectName);
        }
        Collections.sort(names);
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < projectLinkList.size(); j++) {
                if (names.get(i).equals(projectLinkList.get(j).projectName)) {
                    displayAll.add(projectLinkList.get(j));
                }
            }
        }
        for (int i = 0; i < displayAll.size(); i++) {
            System.out.print("Project Id: ");
            System.out.println(displayAll.get(i).getId());
            System.out.print("Project Name: ");
            System.out.println(displayAll.get(i).getName());
            System.out.print("Project Budget: ");
            System.out.println(displayAll.get(i).getBudget());
        }

        hf.Pause();

    }
}
