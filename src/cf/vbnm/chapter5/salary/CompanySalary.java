package cf.vbnm.chapter5.salary;

abstract class Employee {
	public abstract double earnings();
}

class YearWorker extends Employee {
	@Override
	public double earnings() {
		return 2500 * 12;
	}
}

class MonthWorker extends Employee {
	@Override
	public double earnings() {
		return 2300 * 12;
	}
}

class WeekWorker extends Employee {
	@Override
	public double earnings() {
		return 2000 * 12;
	}
}

class TemporaryWorker extends Employee {
	@Override
	public double earnings() {
		return 1500 * 12;
	}
}

class Company {
	Employee[] employees;
	double salaries = 0;

	Company(Employee[] employees) {
		this.employees = employees;
	}

	public double salariesPay() {
		for (int i = 0; i < employees.length; i++) {
			salaries += employees[i].earnings();
		}
		return salaries;
	}

}

public class CompanySalary {
	public static void main(String[] args) {
		Employee[] employees = new Employee[29];
		for (int i = 0; i < employees.length; i++) {
			if (i % 3 == 0) {
				employees[i] = new WeekWorker();
			}
			if (i % 3 == 1) {
				employees[i] = new MonthWorker();
			}
			if (i % 3 == 2) {
				employees[i] = new YearWorker();
			}
		}
		Company company = new Company(employees);
		System.out.println("公司薪水总额:$" + company.salariesPay());
	}
}
