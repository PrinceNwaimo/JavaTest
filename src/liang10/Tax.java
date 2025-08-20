package liang10;

public class Tax {
    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus;
    private int[][] brackets;
    private double[] rates;
    private double taxableIncome;

    public Tax() {
    }

    public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTax() {
        double tax = 0;
        int i = 0;
        while (i < brackets[filingStatus].length && taxableIncome > brackets[filingStatus][i]) {
            tax += (brackets[filingStatus][i] - (i == 0 ? 0 : brackets[filingStatus][i - 1])) * rates[i];
            i++;
        }
        if (taxableIncome > brackets[filingStatus][i]) {
            tax += (taxableIncome - brackets[filingStatus][i]) * rates[i];
        } else {
            tax += (taxableIncome - (i == 0 ? 0 : brackets[filingStatus][i - 1])) * rates[i];
        }
        return tax;
    }

    public static void main(String[] args) {
        int[][] brackets2001 = {
                {27050, 65550, 136750, 297350},
                {45200, 109250, 166500, 297350},
                {22600, 54625, 83250, 148675},
                {36250, 93650, 151650, 297350}
        };
        double[] rates2001 = {0.15, 0.275, 0.305, 0.355, 0.391};

        int[][] brackets2009 = {
                {8350, 33950, 82250, 171550, 372950},
                {16700, 67900, 137050, 208850, 372950},
                {8350, 33950, 68525, 104425, 186475},
                {11950, 45500, 117450, 190200, 372950}
        };
        double[] rates2009 = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

        for (int filingStatus = 0; filingStatus < 4; filingStatus++) {
            System.out.println("Filing status: " + filingStatus);
            System.out.println("2001 tax table:");
            for (int income = 50000; income <= 60000; income += 1000) {
                Tax tax = new Tax(filingStatus, brackets2001, rates2001, income);
                System.out.println("Taxable income: " + income + ", Tax: " + tax.getTax());
            }
            System.out.println("2009 tax table:");
            for (int income = 50000; income <= 60000; income += 1000) {
                Tax tax = new Tax(filingStatus, brackets2009, rates2009, income);
                System.out.println("Taxable income: " + income + ", Tax: " + tax.getTax());
            }
        }
    }
}
