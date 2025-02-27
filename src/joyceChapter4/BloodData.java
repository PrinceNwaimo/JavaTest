package joyceChapter4;

public class BloodData {

        private String bloodType;
        private int rhFactor;

        public BloodData() {
            this.bloodType = "O";
            this.rhFactor = 1;
        }

        public BloodData(String bloodType, int rhFactor) {
            this.bloodType = bloodType;
            this.rhFactor = rhFactor;
        }

        public String getBloodType() {
            return bloodType;
        }

        public void setBloodType(String bloodType) {
            this.bloodType = bloodType;
        }

        public int getRhFactor() {
            return rhFactor;
        }

        public void setRhFactor(int rhFactor) {
            this.rhFactor = rhFactor;
        }
}
