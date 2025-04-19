package lib;

public class TaxFunction {

	private static final int BASE_NON_TAXABLE = 54000000;
	private static final int MARRIED_DEDUCTION = 4500000;
	private static final int CHILD_DEDUCTION = 4500000;
	private static final int MAX_CHILDREN = 3;
	private static final double TAX_RATE = 0.05;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,
										int deductible, boolean isMarried, int numberOfChildren) {
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 months working per year");
			return 0;
		}

		int annualIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
		int netIncome = annualIncome - deductible;
		int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);
		int taxableIncome = Math.max(0, netIncome - nonTaxableIncome);

		return (int)(taxableIncome * TAX_RATE);
	}

	private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
		int cappedChildren = Math.min(numberOfChildren, MAX_CHILDREN);
		int nonTaxable = BASE_NON_TAXABLE;
		if (isMarried) {
			nonTaxable += MARRIED_DEDUCTION;
		}
		nonTaxable += cappedChildren * CHILD_DEDUCTION;
		return nonTaxable;
	}
}
