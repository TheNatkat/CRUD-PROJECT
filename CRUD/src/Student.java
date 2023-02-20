import java.util.*;
class Student {
	private String sname;
	private int sroll;
	private int sclass;
	private String sstatus;
	
	Student(String sname, int sroll, int sclass, String sstatus){
		this.sname=sname;
		this.sroll=sroll;
		this.sclass=sclass;
		this.sstatus=sstatus;
	}
	
	public int getsroll() {
		return sroll;
	}
	public int getsclass() {
		return sclass;
	}
	public String getsname() {
		return sname;
	}
	public String getsstatus() {
		return sstatus;
	}
	public String inString() {
		return sroll + " " + sname + " " + sclass + " " + sstatus;
	}
	
	public static void main(String[] args) {
		List<Student> c = new ArrayList<Student>(); 
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1. INSERT");
			System.out.println("2. DISPLAY");
			System.out.println("3. SEARCH");
			System.out.println("4. DELETE");
			System.out.println("5. UPDATE");
			System.out.println("0. EXIT");
			System.out.println("ENTER YOUR CHOICE : ");
			ch= scn.nextInt();
			switch(ch) {
			case 1:
				System.out.print("ENTER STUDENT ROLL NO:");
				int roll= scn.nextInt();
				
				System.out.print("ENTER STUDENT NAME:");
				String name= scn2.nextLine();
				
				System.out.print("ENTER STUDENT CLASS:");
				int clas= scn.nextInt();
				
				System.out.print("ENTER STUDENT STATUS:");
				String status= scn2.nextLine();
				
				c.add(new Student(name,roll,clas,status));
			break;
			case 2:
				System.out.println("=================================");
				Iterator<Student> i = c.iterator();
				while(i.hasNext()) {
					Student s = i.next();
					System.out.println(s);
				}
				System.out.println("=================================");
			break;
			case 3:
				boolean found = false;
				System.out.println("ENTER STUDENT ROLL NO TO SEARCH:");
				int rol = scn.nextInt();
				System.out.println("=================================");
				i = c.iterator();
				while(i.hasNext()) {
					Student s = i.next();
					if(s.getsroll()==rol) {
						System.out.println(s);
						found=true;
					}
				}
				if (!found) System.out.println("RECORD NOT FOUND");
				System.out.println("=================================");
			break;
			case 4:
				found = false;
				System.out.println("ENTER STUDENT ROLL NO TO DELETE:");
				rol = scn.nextInt();
				System.out.println("=================================");
				i = c.iterator();
				while(i.hasNext()) {
					Student s = i.next();
					if(s.getsroll()==rol) {
						i.remove();
						found=true;
					}
					System.out.print(s);
				}
				if (!found) System.out.println("RECORD NOT FOUND");
				else System.out.println("RECORD IS DELETED SUCCESSFULLY");
				System.out.println("=================================");
			break;
			case 5:
				found = false;
				System.out.println("ENTER STUDENT ROLL NO TO UPDATE:");
				rol = scn.nextInt();
				System.out.println("=================================");
				ListIterator<Student> li = c.listIterator();
				while(li.hasNext()) {
					Student s = li.next();
					if(s.getsroll()==rol) {
						System.out.print("ENTER STUDENT NEW ROLL NO:");
						 roll= scn.nextInt();
						
						System.out.print("ENTER STUDENT NEW NAME:");
						 name= scn2.nextLine();
						
						System.out.print("ENTER STUDENT NEW CLASS:");
						clas= scn.nextInt();
						
						System.out.print("ENTER STUDENT NEW STATUS:");
						 status= scn2.nextLine();
						 li.set(new Student(name,roll,clas,status));
						found=true;
					}
				}
				if (!found) System.out.println("RECORD NOT FOUND");
				else System.out.println("RECORD IS UPDATED SUCCESSFULLY");
				System.out.println("=================================");
			break;
				
				
			}
		}while(ch!=0);
	}
}