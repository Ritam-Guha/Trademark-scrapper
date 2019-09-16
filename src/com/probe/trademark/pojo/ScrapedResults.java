package com.probe.trademark.pojo;

import java.util.ArrayList;

public class ScrapedResults {

    private Meta metaData;
    private ArrayList<Document> uploadedDoc;
    private ArrayList<Document> referenceDoc;
    private MainPage mainPage;
    private PRDetails prDetails;

    public ScrapedResults(Meta metaData, ArrayList<Document> upload, ArrayList<Document> refDoc, MainPage page, PRDetails pr) {

        this.metaData = metaData;
        this.uploadedDoc = upload;
        this.referenceDoc = refDoc;
        this.mainPage = page;
        this.prDetails = pr;
    }

    public Meta getMeta()    {return metaData;}

    public ArrayList<Document> getUploadedDocuments() {
        return this.uploadedDoc;
    }

    public ArrayList<Document> getReferenceDoc() {
        return this.referenceDoc;
    }

    public MainPage getMainPage() {
        return this.mainPage;
    }

    public PRDetails getPrDetails() { return this.prDetails; }

}
