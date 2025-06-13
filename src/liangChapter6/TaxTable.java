package liangChapter6;

public class TaxTable {
    public static void main(String[] args) {
        System.out.println("Taxable Income\tSingle\tMarried Joint\tMarried Separate\tHead of a House");
        for (int income = 50000; income <= 6000; income += 50) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\n", income,
                    Math.round(computeTax(0, income)),
                    Math.round(computeTax(1, income)),
                    Math.round(computeTax(2, income)),
                    Math.round(computeTax(3, income)));
        }
    }

    public static double computeTax(int status, double taxableIncome) {
        double tax = 0;
        if (status == 0) { // Single filer
            if (taxableIncome <= 9275) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 37650) {
                tax = 9275 * 0.10 + (taxableIncome - 9275) * 0.15;
            } else if (taxableIncome <= 91150) {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (taxableIncome - 37650) * 0.25;
            } else if (taxableIncome <= 190150) {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (91150 - 37650) * 0.25 + (taxableIncome - 91150) * 0.28;
            } else if (taxableIncome <= 413350) {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (91150 - 37650) * 0.25 + (190150 - 91150) * 0.28 + (taxableIncome - 190150) * 0.33;
            } else if (taxableIncome <= 415050) {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (91150 - 37650) * 0.25 + (190150 - 91150) * 0.28 + (413350 - 190150) * 0.33 + (taxableIncome - 413350) * 0.35;
            } else {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (91150 - 37650) * 0.25 + (190150 - 91150) * 0.28 + (413350 - 190150) * 0.33 + (415050 - 413350) * 0.35 + (taxableIncome - 415050) * 0.396;
            }
        } else if (status == 1) { // Married jointly or qualifying widow(er)
            if (taxableIncome <= 18550) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 75300) {
                tax = 18550 * 0.10 + (taxableIncome - 18550) * 0.15;
            } else if (taxableIncome <= 151900) {
                tax = 18550 * 0.10 + (75300 - 18550) * 0.15 + (taxableIncome - 75300) * 0.25;
            } else if (taxableIncome <= 231450) {
                tax = 18550 * 0.10 + (75300 - 18550) * 0.15 + (151900 - 75300) * 0.25 + (taxableIncome - 151900) * 0.28;
            } else if (taxableIncome <= 413350) {
                tax = 18550 * 0.10 + (75300 - 18550) * 0.15 + (151900 - 75300) * 0.25 + (231450 - 151900) * 0.28 + (taxableIncome - 231450) * 0.33;
            } else if (taxableIncome <= 466950) {
                tax = 18550 * 0.10 + (75300 - 18550) * 0.15 + (151900 - 75300) * 0.25 + (231450 - 151900) * 0.28 + (413350 - 231450) * 0.33 + (taxableIncome - 231450) * 0.35;
            } else {
                tax = 18550 * 0.10 + (75300 - 18550) * 0.15 + (151900 - 75300) * 0.25 + (231450 - 151900) * 0.28 + (413350 - 231450) * 0.33 + (466950 - 413350) * 0.35 + (taxableIncome - 466950) * 0.396;
            }
        } else if (status == 2) { // Married separately
            if (taxableIncome <= 9275) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 37650) {
                tax = 9275 * 0.10 + (taxableIncome - 9275) * 0.15;
            } else if (taxableIncome <= 75950) {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (taxableIncome - 37650) * 0.25;
            } else if (taxableIncome <= 115725) {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (75950 - 37650) * 0.25 + (taxableIncome - 75950) * 0.28;
            } else if (taxableIncome <= 206675) {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (75950 - 37650) * 0.25 + (115725 - 75950) * 0.28 + (taxableIncome - 115725) * 0.33;
            } else if (taxableIncome <= 233475) {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (75950 - 37650) * 0.25 + (115725 - 75950) * 0.28 + (206675 - 115725) * 0.33 + (taxableIncome - 206675) * 0.35;
            } else {
                tax = 9275 * 0.10 + (37650 - 9275) * 0.15 + (75950 - 37650) * 0.25 + (115725 - 75950) * 0.28 + (206675 - 115725) * 0.33 + (233475 - 206675) * 0.35 + (taxableIncome - 233475) * 0.396;
            }
        } else if (status == 3) { // Head of household
            if (taxableIncome <= 13250) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 50400) {
                tax = 13250 * 0.10 + (taxableIncome - 13250) * 0.15;
            } else if (taxableIncome <= 129600) {
                tax = 13250 * 0.10 + (50400 - 13250) * 0.15 + (taxableIncome - 50400) * 0.25;
            } else if (taxableIncome <= 212500) {
                tax = 13250 * 0.10 + (50400 - 13250) * 0.15 + (129600 - 50400) * 0.25 + (taxableIncome - 129600) * 0.28;
            } else if (taxableIncome <= 411500) {
                tax = 13250 * 0.10 + (50400 - 13250) * 0.15 + (129600 - 50400) * 0.25 + (212500 - 129600) * 0.28 + (taxableIncome - 212500) * 0.33;
            } else if (taxableIncome <= 439000) {
                tax = 13250 * 0.10 + (50400 - 13250) * 0.15 + (129600 - 50400) * 0.25 + (212500 - 129600) * 0.28 + (411500 - 212500) * 0.33 + (taxableIncome - 411500) * 0.35;
            } else {
                tax = 13250 * 0.10 + (50400 - 13250) * 0.15 + (129600 - 50400) * 0.25 + (212500 - 129600) * 0.28 + (411500 - 212500) * 0.33 + (439000 - 411500) * 0.35 + (taxableIncome - 439000) * 0.396;
            }
        }
        return tax;
    }



}

