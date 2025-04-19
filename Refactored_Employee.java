package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	private int yearJoined;
	private int monthJoined;
	private int dayJoined;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;

	private Employee(Builder builder) {
		this.employeeId = builder.employeeId;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.idNumber = builder.idNumber;
		this.address = builder.address;
		this.yearJoined = builder.yearJoined;
		this.monthJoined = builder.monthJoined;
		this.dayJoined = builder.dayJoined;
		this.isForeigner = builder.isForeigner;
		this.gender = builder.gender;
		this.childNames = new LinkedList<>();
		this.childIdNumbers = new LinkedList<>();
	}

	public static class Builder {
		private String employeeId;
		private String firstName;
		private String lastName;
		private String idNumber;
		private String address;
		private int yearJoined;
		private int monthJoined;
		private int dayJoined;
		private boolean isForeigner;
		private boolean gender;

		public Builder setEmployeeId(String employeeId) { this.employeeId = employeeId; return this; }
		public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
		public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
		public Builder setIdNumber(String idNumber) { this.idNumber = idNumber; return this; }
		public Builder setAddress(String address) { this.address = address; return this; }
		public Builder setJoinedDate(int year, int month, int day) {
			this.yearJoined = year;
			this.monthJoined = month;
			this.dayJoined = day;
			return this;
		}
		public Builder setIsForeigner(boolean isForeigner) { this.isForeigner = isForeigner; return this; }
		public Builder setGender(boolean gender) { this.gender = gender; return this; }

		public Employee build() {
			return new Employee(this);
		}
	}
}
