public class StoreOneA extends StoreToRent {
    private boolean specialCustomer;
    private double monthlyPayment;
    private static final double DISCOUNT_RATE = 0.1;

    public StoreOneA(boolean loanRequired, double loanAmount, int loanPaymentTerm, boolean specialCustomer) {
        super(loanRequired, loanAmount, loanPaymentTerm);
        this.specialCustomer = specialCustomer;
    }

    public void showStoreInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append("\nLOAN DETAILS (if applicable):\n");
        result.append("Loan Amount: ").append(getLoanAmount()).append("\n");
        result.append("Loan Payment Term: ").append(getLoanPaymentTerm()).append("\n");
        result.append("Interest Rate: ").append(getINTEREST_RATE()).append("\n");
        result.append("Special Customer: ").append(specialCustomer).append("\n");
        monthlyPayment = calculateLoanFinancing();
        result.append("Monthly Loan Payment: ").append(monthlyPayment).append("\n");
        return result.toString();
    }

    @Override
    public double calculateLoanFinancing() {
        double parentResult = super.calculateLoanFinancing();
        if (specialCustomer) {
            return parentResult * (1 - DISCOUNT_RATE);
        }
        return parentResult;
    }
}    