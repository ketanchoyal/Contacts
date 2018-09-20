package com.ketanchoyal.contacts;

import android.graphics.Bitmap;
import android.net.Uri;

public class ContactModel {

    String Cname, Cnumber;
    Bitmap Cimage;

    public ContactModel(String cname, String cnumber, Bitmap cimage) {
        Cname = cname;
        Cnumber = cnumber;
        Cimage = cimage;
    }
}
