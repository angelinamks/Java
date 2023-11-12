package org.example;

class DVD extends Item {
    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void borrowItem() {
        if (!this.isBorrowed) {
            this.isBorrowed = true;
            System.out.println("DVD borrowed: " + this.title);
        } else {
            System.out.println("DVD is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (this.isBorrowed) {
            this.isBorrowed = false;
            System.out.println("DVD returned: " + this.title);
        } else {
            System.out.println("DVD was not borrowed.");
        }
    }
}