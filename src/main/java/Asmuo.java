import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Locale;
import java.util.Scanner;


public class Asmuo extends WhiteBlack {
    public LocalDate gimimo_metai;
    int year, month, day;
    int amzius = get_age();
    private String vardas;
    private String pavarde;

    public Asmuo(String vardas, String pavarde) {

        this.vardas = vardas;
        this.pavarde = pavarde;
        //this.gimimo_metai = gimimo_metai;

    }

    public LocalDate getGimimo_metai() {
        return gimimo_metai;
    }

    public void setGimimo_metai(LocalDate gimimo_metai) {
        this.gimimo_metai = gimimo_metai;
    }

    public int getAmzius() {
        return amzius;
    }

    public void setAmzius(int amzius) {
        this.amzius = amzius;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    int get_age() {
        LocalDate dabartis = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Iveskite gimimo metus: ");
        year = scanner.nextInt();
        System.out.print("Iveskite menesi kuri gime asmuo: ");
        month = scanner.nextInt();
        System.out.print("Iveskite diena kuri gime asmuo: ");
        day = scanner.nextInt();
        //DateTimeFormatter formatter = new DateTimeFormatter();
        gimimo_metai = LocalDate.of(year, Month.of(month), day);
        //System.out.println(gimimo_metai);
        Period period = Period.between(gimimo_metai, dabartis);
        return period.getYears();

    }

    @Override
    public String toString() {
        return " Asmuo {" + System.lineSeparator() +
                " Vardas = '" + vardas + '\'' + System.lineSeparator() +
                " Pavarde = '" + pavarde + '\'' + System.lineSeparator() +
                " Amzius = " + amzius +
                "}";
    }

    public void printInfo() {
        System.out.println(toString());
    }

    public String formatMonth(int month, Locale locale) {
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] monthNames = symbols.getMonths();
        return monthNames[month - 1];
    }

}
