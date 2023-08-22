package github.poscard8.moretrailsmoretales.custom;

import net.minecraft.util.StringRepresentable;

public enum StatueHeight implements StringRepresentable {
    SHORT(13.25D,"short"),
    NORMAL( 14.0D,"normal"),
    TALL(14.875D,"tall");

    final double height;
    final String stringName;

    StatueHeight(double height, String name) {
        this.height = height;
        this.stringName = name;
    }

    @Override
    public String getSerializedName() { return this.stringName; }

    public double getHeight() { return this.height; }
}
