package com.probe.trademark.pojo;

import java.util.Date;

public class Document {
    private String name;
    private Date documentDate;
    private byte[] document;

    public Document(String docName, Date date, byte[] doc) {
        this.name = docName;
        this.documentDate = date;
        this.document = doc;
    }

    public String getName() {return this.name;}

    public Date getDocumentDate() {return this.documentDate;}

    public byte[] getDocument() {return this.document;}
}
