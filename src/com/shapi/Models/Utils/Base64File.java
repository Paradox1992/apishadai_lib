package com.shapi.Models.Utils;

public class Base64File {

    private String filename;
    private String mime;
    private String base64;

    public Base64File() {
    }

    public Base64File(String filename, String mime, String base64) {
        this.filename = filename;
        this.mime = mime;
        this.base64 = base64;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the mime
     */
    public String getMime() {
        return mime;
    }

    /**
     * @param mime the mime to set
     */
    public void setMime(String mime) {
        this.mime = mime;
    }

    /**
     * @return the base64
     */
    public String getBase64() {
        return base64;
    }

    /**
     * @param base64 the base64 to set
     */
    public void setBase64(String base64) {
        this.base64 = base64;
    }

}
