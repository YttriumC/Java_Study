package cf.vbnm.chapter12.book_attendclass;

class Student extends Thread {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	public void sleep(int second) {
		System.out.println("学生" + name + "准备睡觉" + second / 60 + "分钟");
		try {
			wait(second * 1000);
			System.out.println("学生" + name + "睡醒了");
		} catch (Exception e) {
			System.out.println("学生" + name + "被叫醒了");
		}

	}

}

class Teacher extends Thread {
	private final String name;

	public Teacher(String name) {
		this.name = name;
	}

	public void attendClass() {
		for (int i = 0; i < 3; i++) {
			System.out.println(name+"上课");
		}

	}


}

public class Characteristic {
	public static void main(String[] args) {
		Student stu1 = new Student("student1"), stu2 = new Student("student2");
		Teacher teacher = new Teacher("teacher");
		new Thread(() -> {
			stu1.sleep(600);
			stu2.interrupt();
		}).start();
		new Thread(() -> {
			stu2.sleep(3600);
		}).start();
		new Thread(() -> {
			teacher.attendClass();
			stu1.interrupt();
		}).start();
	}
}