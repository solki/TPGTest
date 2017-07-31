import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** 
* <p>Title: Q2 </p> 
* <p>Description: </p> 
* <p>Copyright: Copyright (c) 2017</p> 
* <p>Company: </p> 
* @author Xi Zhang 
* @version 1.0
*/ 
public class Student {

	private int id;
	private String name;
	private Double gpa;

	public Student(int id, String name, Double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public static void main(String[] args) {

		List<Student> listedStudents = new ArrayList<>();
		/*
		 * Comparator is working according to the spec. First, sort against GPA
		 * in descending order. Secondly, if GPAs are same, sort against name in
		 * alphabetical order. Last, if both GPA and name are same, sort them
		 * according to the ID in ascending order.
		 */
		Comparator<Student> c = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if ((o2.getGpa() - o1.getGpa()) > 0)
					return 1;
				else if ((o2.getGpa() - o1.getGpa()) == 0) {
					if (o1.getName().compareToIgnoreCase(o2.getName()) > 0)
						return 1;
					else if (o1.getName().compareToIgnoreCase(o2.getName()) == 0) {
						return o1.getId() - o2.getId();
					} else
						return -1;
				} else
					return -1;
			}

		};
		try {
			File file = new File(System.getProperty("user.dir") + "\\" + args[0]);
			if (file.isFile() && file.exists()) {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
				BufferedReader bfreader = new BufferedReader(reader);

				String line = null;
				bfreader.readLine();
				while ((line = bfreader.readLine()) != null) {
					// System.out.println(line);
					line = line.trim();
					String[] stuText = line.split("\\s+");
					listedStudents
							.add(new Student(Integer.parseInt(stuText[0]), stuText[1], Double.parseDouble(stuText[2])));
				}
				// resource released
				bfreader.close();
				reader.close();

				Collections.sort(listedStudents, c);

				for (Student s : listedStudents) {
					System.out.println(s.getName());
				}
			} else {
				System.out.println("error: no such file");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
