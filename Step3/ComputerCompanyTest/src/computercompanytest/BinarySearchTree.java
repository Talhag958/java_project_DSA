/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computercompanytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Adam
 */
public class BinarySearchTree {

    public static Node root;
    Project project;
    LinkedList<Project> pll;
    ArrayList count;
    LinkedList<String> names;
    helpingfunctions hf;
    HashMap<Integer, Integer> map;
    HashMap<Integer, TeamMember> map1;

    //constructor
    public BinarySearchTree() {
        hf = new helpingfunctions();
        count = new ArrayList();
        BinarySearchTree.root = null;
        pll = new LinkedList();
        names = new LinkedList<>();
        map = new HashMap<>();
        map1 = new HashMap<>();

    }
    
    //find node is present or not
    public boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (current.data.getId() == id) {
                return true;
            } else if (current.data.getId() > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }
    
    //get successor
    public Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    // add project to structure
    public void addProject() {
        System.out.print("Enter project Id:");
        int id = hf.getIntegerInput();
        if (this.find(id)) {
            System.out.println("Project already exists with that id");
            hf.Pause();
            this.addProject();
        }
        System.out.print("Enter Project Name: ");
        String name = hf.getStringInput();
        System.out.print("Enter Project Budget: ");
        int budget = hf.getIntegerInput();
        project = new Project(id, name, budget);
        Node newNode = new Node(project);
        if (root == null) {
            root = newNode;
            System.out.println("\nProject added");
            hf.Pause();
            return;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            if (project.getId() < current.data.getId()) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    System.out.println("\nProject added");
                    hf.Pause();
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    System.out.println("\nProject added");
                    hf.Pause();
                    return;
                }
            }
        }
    }

    //add team members to project
    public void addTeamMember() {
        System.out.println("Enter Project Id in which you want to add member");
        int id = hf.getIntegerInput();
        if (!this.find(id)) {
            System.out.println("No project exists with that id");
            hf.Pause();
            this.addTeamMember();
        }
        Node node = findNode(id);
        if (node.member.findTeamMember(id)) {
            System.out.println("Member alread Exist");
        }
        node.member.addTeamMember();
    }

    public void removeTeamMember() {
        System.out.println("***** Enter Project Id in which you want to remove member");
        int id = hf.getIntegerInput();
        if (!this.find(id)) {
            System.out.println("***** No project exists with that id");
            hf.Pause();
            this.removeTeamMember();
        }
        System.out.println("***** Enter Member Id you want to remove");
        int memberid = hf.getIntegerInput();
        Node node = findNode(id);
        node.member.RemoveMember(memberid);
    }

    public void removeProject() {
        System.out.print("***** Enter project ID:");
        int id = hf.getIntegerInput();
        if (this.delete(id)) {
            System.out.println("***** Project removed....\n");
            hf.Pause();
            return;
        }
        System.out.println("***** No project found for that id");
        hf.Pause();
    }

    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data.getId() != id) {
            parent = current;
            if (current.data.getId() > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            //now we have found the minimum element in the right sub tree
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    //display all projects
    public void displayAll() {
        pll = new LinkedList();
        names = new LinkedList<>();
        System.out.println("***** Displaying all Projects");
        display(root);
        Collections.sort(names);
        LinkedList<Project> displayAll = new LinkedList<>();
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < pll.size(); j++) {
                if (names.get(i).equals(pll.get(j).projectName)) {
                    displayAll.add(pll.get(j));
                }
            }
        }
        for (int i = 0; i < displayAll.size(); i++) {
            System.out.print("***** Project Id: ");
            System.out.println(displayAll.get(i).getId());
            System.out.print("***** Project Name: ");
            System.out.println(displayAll.get(i).getName());
            System.out.print("***** Project Member Count: ");
            TeamMember mm = map1.get(displayAll.get(i).getId());
            mm.displayAll();
        }

        hf.Pause();
    }

    public void display(Node root) {
        if (root != null) {
            display(root.left);
            names.add(root.data.getName());
            pll.add(root.data);
            map1.put(root.data.getId(), root.member);
            this.display(root.right);
        }
    }

    public Node findNode(int id) {
        Node current = root;
        while (current != null) {
            if (current.data.getId() == id) {
                return current;
            } else if (current.data.getId() > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void ProjectWithCount(Node root) {
        if (root != null) {
            display(root.left);
            names.add(root.data.getName());
            pll.add(root.data);
            map.put(root.data.getId(), root.member.getCount());
            this.display(root.right);
        }
    }
    
    // displaty project with count of memebers
    public void displayNoOfMembers() {
        pll = new LinkedList();
        names = new LinkedList<>();
        map = new HashMap<>();
        System.out.println("***** Displaying all Projects");
        ProjectWithCount(root);
        Collections.sort(names);
        LinkedList<Project> displayAll = new LinkedList<>();
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < pll.size(); j++) {
                if (names.get(i).equals(pll.get(j).projectName)) {
                    displayAll.add(pll.get(j));
                }
            }
        }
        for (int i = 0; i < displayAll.size(); i++) {
            System.out.print("***** Project Id: ");
            System.out.println(displayAll.get(i).getId());
            System.out.print("***** Project Name: ");
            System.out.println(displayAll.get(i).getName());
            System.out.print("***** Project Member Count: ");
            System.out.println(map.get(displayAll.get(i).getId()));
        }

        hf.Pause();
    }

    // Display specific project
    public void findAndDisplay() {
        System.out.print("***** Enter project Id:");
        int id = hf.getIntegerInput();
        if (!this.find(id)) {
            System.out.println("***** No project exists with that id");
            hf.Pause();
            this.addProject();
        }
        Node n = findNode(id);
        System.out.print("***** Project Name: ");
        System.out.println(n.data.getName());
        System.out.print("***** Project Budget: ");
        System.out.println(n.data.getBudget());
        System.out.print("***** Project Team Members: ");
        n.member.displayAll();
        hf.Pause();
    }

}

class Node {

    Project data;
    Node left;
    Node right;
    TeamMember member;
    
    //constructor
    public Node(Project project) {
        this.data = project;
        left = null;
        right = null;
        member = new TeamMember();
    }
}

class Project {

    int projectId;
    String projectName;
    int budget;

    // Constructor
    public Project(int id, String name, int b) {
        this.projectId = id;
        this.projectName = name;
        this.budget = b;
    }

    //getter and setters
    
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
