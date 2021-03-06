package com.teamSuperior.tuiApp.modelLayer;

import java.util.ArrayList;

/**
 * Container of offers.
 */
public class OfferContainer {
    private static OfferContainer ourInstance = new OfferContainer();
    private ArrayList<Offer> offers;

    private OfferContainer() {
        offers = new ArrayList<>();
    }

    public static OfferContainer getInstance() {
        return ourInstance;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<Offer> offers) {
        this.offers = offers;
    }
}
