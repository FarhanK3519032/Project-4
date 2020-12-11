/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdatamahasiswa;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Acer
 */
public class DataMahasiswa {
    
    ArrayList<String> nama = new ArrayList<String>();
    ArrayList<String> nim = new ArrayList<String>();
    ArrayList<String> tglLahir = new ArrayList<String>();
    ArrayList<Integer> gender = new ArrayList<Integer>();
    
    
    void menu(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Main Menu :");
            System.out.println("1) Adding Data \n2) Remove Data \n3) Search Data \n4) Display Data");
            System.out.println("Choose menu number : ");
            int pilihMenu = input.nextInt();
            switch(pilihMenu){
                case 1 :
                    /*Masuk ke menu tambah data*/
                    addingData();
                    
                case 2 :
                    /*Masuk ke menu hapus data*/
                    removeData();
                    break;
                case 3 :
                    /*Masuk ke menu cari data*/
                    searchData();
                    break;
                case 4 :
                    /*Masuk ke menu tampil data*/
                    displayData();
                    break;
                default :
                    menu();
            }
        }
    }
    
    void addingData(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Student Name    : ");
            this.nama.add(input.nextLine());
            System.out.println("Student Nim     : ");
            this.nim.add(input.nextLine());
            System.out.println("Student Date of Birth (DD-MM-YYYY) : ");
            this.tglLahir.add(input.nextLine());
            System.out.println("Student Gender  : ");
            this.gender.add(input.nextInt());
            System.out.println("Name          : " + this.nama);
            System.out.println("Nim           : " + this.nim);
            System.out.println("Date of Birth : " + this.tglLahir);
            System.out.println("Gender        : " + this.gender);
            input.nextLine();
            System.out.println("Want to Add another data? (y/n) : ");
            char ans = input.nextLine().charAt(0);
            if (ans == 'n'){
                menu();
            }
            
        }
    }
    
    void removeData(){
        Scanner input = new Scanner(System.in);
        System.out.println("Name            : " + this.nama);
        System.out.println("Nim             : " + this.nim);
        System.out.println("Date of Birth   : " + this.tglLahir);
        System.out.println("Gender          : " + this.gender);
        if(this.nim.size() > 0){
            System.out.println("Insert data that you want to remove (by nim) : ");
            String erase = input.nextLine();
//            input.nextLine();
            int index = this.nim.indexOf(erase);
            if (index < 0){
                System.out.println("There is No Matching Data");
            }else {
                this.nim.remove(index);
                this.nama.remove(index);
                this.tglLahir.remove(index);
                this.gender.remove(index);
                System.out.println("Successfully Removed Data");
            }
        }else {
            System.out.println("Data Not Founs");
        }
        System.out.println("Name            : " + this.nama);
        System.out.println("Nim             : " + this.nim);
        System.out.println("Date of Birth   : " + this.tglLahir);
        System.out.println("Gender          : " + this.gender);
    }
    
    void searchData(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Sub-menu Search Data : ");
            System.out.println("1) by Nim \n2) by Gender \n3) back to main menu");
            System.out.println("choose menu : ");
            int pilihMenu2 = input.nextInt();
            switch(pilihMenu2){
                case 1 :
                    /*sub-menu search by nim*/
                    searchByNim();
                    break;
                case 2 :
                    /*sub-menu search by gender*/
                    searchByGender();
                    break;
                case 3 :
                    menu();
                default :
                    searchData();
            }
        }
    }
    
    void searchByNim(){
        Scanner input = new Scanner(System.in);
        System.out.println("insert nim : ");
        String find = input.nextLine();
        for (String n: this.nim){
            if (this.nim.contains(find)){
                int index = this.nim.indexOf(find);
                System.out.println("Student with Nim " + this.nim.get(index));
                System.out.println("=========================");
                System.out.println("Name            : " + this.nama.get(index));
                System.out.println("Nim             : " + this.nim.get(index));
                System.out.println("Date of Birth   : " + this.tglLahir.get(index));
                System.out.println("Gender          : " + this.gender.get(index));
            }
        }
    }
    
    void searchByGender(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Gender (0:female / 1:male) : ");
        int find2 = input.nextInt();
        for (int g = 0; g<this.gender.size(); g++){
            if (this.gender.get(g) == find2){
                System.out.println("Student with that Gender");
                System.out.println("=========================");
                System.out.println("Name            : " + this.nama.get(g));
                System.out.println("Nim             : " + this.nim.get(g));
                System.out.println("Date of Birth   : " + this.gender.get(g));
                System.out.println("Name            : " + this.nama.get(g));
            }
        }
    }
    
    void displayData(){
        if (this.nama.size()== 0){
            System.out.println("There is No Data");
        }else {
            for (int n = 0; n<this.nama.size(); n++){
                System.out.println("Student no " + (n+1));
                System.out.println("=========================");
                System.out.println("Nama            : " + this.nama.get(n));
                System.out.println("Nim             : " + this.nim.get(n));
                System.out.println("Date of Birth   : " + this.tglLahir.get(n));
                System.out.println("Gender          : " + this.gender.get(n));
            }
            System.out.println("The Total Number of Students is" + this.nama.size());
        }
    }
}
