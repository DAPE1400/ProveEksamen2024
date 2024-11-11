package Oppgave4;

class SmartLight {
    private int brightnessPercentage;
    private boolean isOn;

    public SmartLight(int brightnessPercentage, boolean isOn) {
        this.brightnessPercentage = brightnessPercentage;
        this.isOn = isOn;
    }

    public int getBrightnessPercentage() {
        return brightnessPercentage;
    }

    public void setBrightnessPercentage(int brightnessPercentage) {
        if (brightnessPercentage >= 0 && brightnessPercentage <= 100) {
            this.brightnessPercentage = brightnessPercentage;
        } else {// throwing an IllegalArgumentException would also be a better solution, but is not expected.
            System.out.println("Brightness must be between 0 and 100.");
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }
}

class SmartLamp {
    private SmartLight installedBulb;
    private String wifiName;

    public SmartLamp(String wifiName) {
        this.wifiName = wifiName;
        this.installedBulb = null; // No bulb installed by default
    }

    public SmartLamp(String wifiName, SmartLight installedBulb) {
        this.wifiName = wifiName;
        this.installedBulb = installedBulb;
    }

    public SmartLight getInstalledBulb() {
        return installedBulb;
    }

    public void setInstalledBulb(SmartLight installedBulb) {
        this.installedBulb = installedBulb;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public void setBrightness(int brightnessPercentage) {
        if (installedBulb != null) { // this part is not expected but doing null checking here is a positive
            installedBulb.setBrightnessPercentage(brightnessPercentage);
        } else { // throwing an Exception like IllegalStateException would also be a better solution, but is not expected.
            System.out.println("No SmartLight is installed in the SmartLamp.");
        }
    }
}


public class Oppgave4 {
    public static void main(String[] args) {
        // This main method is not expected to be delivered,
        // but it might be useful to do simple tests like this when coding on the exam
        SmartLamp lamp = new SmartLamp("PrettyFlyForAWifi");
        lamp.setInstalledBulb(new SmartLight(60, false));
        lamp.setBrightness(100);
        lamp.getInstalledBulb().setOn(true);
    }
}
