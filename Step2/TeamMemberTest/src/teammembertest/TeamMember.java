/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammembertest;

import java.util.ArrayList;

class Member {

    int id;
    String name;
    int sallary;

    public Member(int id, String name, int sallary) {
        this.id = id;
        this.name = name;
        this.sallary = sallary;
    }

    void setId(int id) {
        this.id = id;
    }

    int getId() {
        return this.id;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setSallary(int sallary) {
        this.sallary = sallary;
    }

    int getSallary() {
        return this.sallary;
    }
}

public class TeamMember {

    ArrayList<Member> teamMemberList;
    helpingfunctions hf;
    Member member;

    public TeamMember() {
        teamMemberList = new ArrayList<Member>();
        hf = new helpingfunctions();
    }

    public void addTeamMember() {
        System.out.print("Member's id: ");
        int id = hf.getIntegerInput();
        for (int i = 0; i < teamMemberList.size(); i++) {
            if (id == teamMemberList.get(i).id) {
                System.out.print("Member already registered with that id ");
                hf.Pause();
                addTeamMember();
            }
        }
        System.out.print("Member's Name: ");
        String name = hf.getStringInput();
        System.out.print("Member's Sallary: ");
        int sallary = hf.getIntegerInput();
        member = new Member(id, name, sallary);
        teamMemberList.add(member);
        System.out.println("Member added");
        hf.Pause();
    }

    public void findAndDisplay() {
        System.out.print("Enter Team Members's ID:");
        int id = hf.getIntegerInput();
        for (int i = 0; i < teamMemberList.size(); i++) {
            System.out.println(teamMemberList.get(i).getId());
            if (id == teamMemberList.get(i).getId()) {
                System.out.print("Member's id: ");
                System.out.println(teamMemberList.get(i).getId());
                System.out.print("Member's Name: ");
                System.out.println(teamMemberList.get(i).getName());
                System.out.print("Member's Sallary: ");
                System.out.println(teamMemberList.get(i).getSallary());
                hf.Pause();
                return;
            }
        }
        System.out.println("No Team member found for that id");
        hf.Pause();
    }

    public void RemoveMember() {
        System.out.print("Enter Team Member's ID:");
        int id = hf.getIntegerInput();
        for (int i = 0; i < teamMemberList.size(); i++) {
            if (id == teamMemberList.get(i).id) {
                System.out.println("Removing Member...\n");
                teamMemberList.remove(i);
                System.out.println("Member Removed...");
                hf.Pause();
                return;
            }
        }
        System.out.println("No member with this id");
        hf.Pause();
    }

    public void displayAll() {
        if (teamMemberList.size() <= 0) {
            System.out.println("No team member registered...");
            hf.Pause();
            return;
        }
        System.out.println("Displaying all Members");
        for (int i = 0; i < teamMemberList.size(); i++) {
            System.out.println("Member Number => " + (i + 1));
            System.out.print("\nMember's Id: ");
            System.out.println(teamMemberList.get(i).getId());
            System.out.print("Member's Name: ");
            System.out.println(teamMemberList.get(i).getName());
            System.out.print("Member's Sallary: ");
            System.out.println(teamMemberList.get(i).getSallary());
        }
        hf.Pause();
    }
}
