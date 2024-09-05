package com.example.veriff;

public class SessionRequest {
    
    private Verification verification;

    // Getter and Setter for 'verification'
    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public static class Verification {
        private String callback;
        private String vendorData;

        // Getters and Setters for 'callback' and 'vendorData'
        public String getCallback() {
            return callback;
        }

        public void setCallback(String callback) {
            this.callback = callback;
        }

        public String getVendorData() {
            return vendorData;
        }

        public void setVendorData(String vendorData) {
            this.vendorData = vendorData;
        }
    }
}
