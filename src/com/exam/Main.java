package com.exam;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
	String id;
	String name;
	int num;
	int a=1;

	boolean order = true;
	List<Course> course =new ArrayList<>();
	public Main(){
		if(order){
			readCourse();
			for(Course c :course){
				System.out.println(c.getId()+")"+" "+c.getName());
			}
			System.out.println("0)"+" "+"結算");
			System.out.println("q)"+" "+"離開(結束程式)");
			Scanner scanner = new Scanner(System.in);
			System.out.println("請輸入餐點:");
			String id = scanner.nextLine();
			
			switch(id){
			case "q":
				order = false;
				break;
			case "0":
				
			}
			System.out.println("請輸入數量:");
			int num = scanner.nextInt();
			Course name = (Course)course.get(Integer.parseInt(id));
			System.out.println("目前餐點: ");
			System.out.println(a +"."+name+" "+num+"份");
			
		}
		
	}
	
public void readCourse() {
		
		try {
			FileReader fr = new FileReader("menu.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				String token[] = line.split(",");
				String id =token[0];
				String name = token[1];
				int price = Integer.parseInt(token[2]);
				int cal = Integer.parseInt(token[3]);
				Course c = new Course(id, name, price, cal);
				course.add(c);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new Main();
	}

}
