package joyceInheritance;

public class ElectricBlanket extends Blanket{
    private int heatSettings;
    private boolean automaticShutoff;

    public ElectricBlanket() {
        super();
        this.heatSettings = 1;
        this.automaticShutoff = false;
    }

    public void setHeatSettings(int heatSettings) {
        if (heatSettings >= 1 && heatSettings <= 5) {
            this.heatSettings = heatSettings;
        } else {
            this.heatSettings = 1;
        }
    }

    public void setAutomaticShutoff(boolean automaticShutoff) {
        this.automaticShutoff = automaticShutoff;
        if (automaticShutoff) {
            this.price += 5.75;
        } else {
            this.price -= 5.75;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nHeat Settings: " + heatSettings +
                "\nAutomatic Shutoff: " + (automaticShutoff ? "Yes" : "No");
    }
}
